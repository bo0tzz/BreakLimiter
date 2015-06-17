package com.bo0tzz.breaklimiter;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Map;

/**
 * Created by bo0tzz
 */
public class EventManager implements Listener {

    private Map<String, Object> allowedBlocks;
    private Plugin main;
    private ConfigManager config;
    
    public EventManager(Plugin plugin) {
        main = plugin;
        config = ((BreakLimiter)main).getConfigManager();
        allowedBlocks = config.getBlocks();
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        Material blockType = block.getType();
        Material type;

        if (blockType == Material.GLOWING_REDSTONE_ORE) {
            type = Material.REDSTONE_ORE;
        } else {
            type = blockType;
        }

        Integer timeout = (Integer) allowedBlocks.get(type.toString().toLowerCase());

        if(timeout != null) {
            int ticks = timeout * 1200;
            if (ticks != 0)
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        if (block.isEmpty()) {
                            block.setType(type);
                        }
                    }
                }.runTaskLater(main, ticks);
        } else {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (config.isBlockPlaceAllowed() && !event.getPlayer().isOp()) {
            event.setCancelled(true);
        }
    }
}
