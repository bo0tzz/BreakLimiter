package com.bo0tzz.breaklimiter;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

/**
 * Created by bo0tzz
 */
public class BreakLimiter extends JavaPlugin {

    ConfigManager config = new ConfigManager(this);

    @Override
    public void onEnable() {
        Map<String,Object> blockTimeouts =  config.getBlocks();

        getServer().getPluginManager().registerEvents(new EventManager(blockTimeouts, this), this);
    }

    @Override
    public void onDisable() {

    }

    public ConfigManager getConfigManager() {
        return config;
    }

}
