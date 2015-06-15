package com.bo0tzz.breaklimiter;

import org.bukkit.plugin.Plugin;

import java.util.Map;

/**
 * Created by bo0tzz
 */
public class ConfigManager {
    private Plugin main;

    public ConfigManager (Plugin plugin) {
        main = plugin;
        main.saveDefaultConfig();
    }

    public Map<String,Object> getHashMap() {
        return main.getConfig().getConfigurationSection("blocks").getValues(false);
    }

}
