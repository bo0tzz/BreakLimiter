package com.bo0tzz.breaklimiter;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;

/**
 * Created by boet on 6/13/15.
 */
public class EventManager implements Listener {

    HashMap allowedBlocks;
    Plugin main;

    public EventManager(HashMap blockTimeouts, Plugin plugin) {
        allowedBlocks = blockTimeouts;
        main = plugin;
        //main.getLogger().info("EventManager class instantiated");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        //main.getLogger().info("BlockBreakEvent triggered");
        Block block = event.getBlock();
        Material type = block.getType();
        Integer timeout = (Integer) allowedBlocks.get(type.toString().toLowerCase());

        if(timeout != null) {
            //main.getLogger().info("Allowed block detected");
            int ticks = timeout * 1200;
            if (ticks != 0)
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        //main.getLogger().info("Runnable is running");
                        if (block.isEmpty()) block.setType(type);
                        //main.getLogger().info("Block was set");
                    }
                }.runTaskLater(main, ticks);
        } else event.setCancelled(true);
    }
}
