package com.bo0tzz.breaklimiter;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

import java.util.HashMap;

/**
 * Created by boet on 6/13/15.
 */
public class EventManager implements Listener {

    HashMap allowedBlocks;

    public EventManager(HashMap blockTimeouts) {
        allowedBlocks = blockTimeouts;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Material block = event.getBlock().getType();
        Integer timeout = (Integer) allowedBlocks.get(block);
        if(timeout != null) {

        }
    }
}
