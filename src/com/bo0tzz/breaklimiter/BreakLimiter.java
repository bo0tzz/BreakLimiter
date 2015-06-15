package com.bo0tzz.breaklimiter;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by bo0tzz
 */
public class BreakLimiter extends JavaPlugin {

    ConfigManager config = new ConfigManager(this);

    @Override
    public void onEnable() {
        //this.getLogger().info("Starting load");

        HashMap blockTimeouts = (HashMap) config.getHashMap();

        //this.getLogger().info("Block map loaded!");

        getServer().getPluginManager().registerEvents(new EventManager(blockTimeouts, this), this);
        //this.getLogger().info("Loaded!");
    }

    @Override
    public void onDisable() {

    }

    public ConfigManager getConfigManager() {
        return config;
    }

}
