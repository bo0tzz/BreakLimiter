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
 * Created by bo0tzz
 */
public class EventManager implements Listener {

    private HashMap allowedBlocks;
    private Plugin main;
    private ConfigManager config;

    public EventManager(HashMap blockTimeouts, Plugin plugin) {
        allowedBlocks = blockTimeouts;
        main = plugin;
        if (main instanceof BreakLimiter) config = ((BreakLimiter) main).getConfigManager();
        //main.getLogger().info("EventManager class instantiated");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        //main.getLogger().info("BlockBreakEvent triggered");
        Block block = event.getBlock();
        Material blockType = block.getType();
        Material type;
        if (blockType == Material.GLOWING_REDSTONE_ORE) type = Material.REDSTONE_ORE; else type = blockType;
        //Player p = event.getPlayer();
        //p.sendMessage("Block was broken. Type: " + type.name());

        Integer timeout = (Integer) allowedBlocks.get(type.toString().toLowerCase());

        //p.sendMessage("The timeout found was: " + timeout);

        if(timeout != null) {
            //main.getLogger().info("Allowed block detected");
            //p.sendMessage("if-block triggered");
            int ticks = timeout * 1200;
            if (ticks != 0)
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        //p.sendMessage("Runnable running");
                        //main.getLogger().info("Runnable is running");
                        if (block.isEmpty()) block.setType(type);
                        //main.getLogger().info("Block was set");
                    }
                }.runTaskLater(main, ticks);
        } else event.setCancelled(true);
    }
}
