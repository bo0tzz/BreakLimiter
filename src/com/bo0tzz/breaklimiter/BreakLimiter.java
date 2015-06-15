package com.bo0tzz.breaklimiter;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by boet on 6/13/15.
 */
public class BreakLimiter extends JavaPlugin {
    @Override
    public void onEnable() {
        //this.getLogger().info("Starting load");

        HashMap blockTimeouts = (HashMap) new ConfigManager(this).getHashMap();

        //this.getLogger().info("Block map loaded!");

        getServer().getPluginManager().registerEvents(new EventManager(blockTimeouts, this), this);
        //this.getLogger().info("Loaded!");
    }

    @Override
    public void onDisable() {

    }
}
