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

    public Map<String,Object> getBlocks() {
        return main.getConfig().getConfigurationSection("blocks").getValues(false);
    }

    public boolean isOpAllowed() {
        return main.getConfig().getBoolean("allowOpBreak");
    }

    public boolean isBlockPlaceAllowed() {
        return main.getConfig().getBoolean("allowBlockPlace");
    }

}
