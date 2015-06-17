package com.bo0tzz.breaklimiter;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by bo0tzz
 */
public class BreakLimiter extends JavaPlugin {

    ConfigManager config = new ConfigManager(this);

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new EventManager(this), this);
    }

    @Override
    public void onDisable() {

    }

    public ConfigManager getConfigManager() {
        return config;
    }

}
