package com.bo0tzz.breaklimiter;

import org.bukkit.Material;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

/**
 * Created by boet on 6/13/15.
 */
public class BreakLimiter extends JavaPlugin {
    @Override
    public void onEnable() {
        //this.getLogger().info("Starting load");

        HashMap blockTimeouts = new HashMap<Material,Integer>() {{
            put(Material.COAL_ORE,30);
            put(Material.IRON_ORE,35);
            put(Material.GOLD_ORE,45);
            put(Material.REDSTONE_ORE,50);
            put(Material.EMERALD_ORE,60);
            put(Material.LAPIS_ORE,50);
            put(Material.DIAMOND_ORE,90);
            put(Material.LOG,0);
        }};

        //this.getLogger().info("Block map loaded!");

        getServer().getPluginManager().registerEvents(new EventManager(blockTimeouts, this), this);
        this.getLogger().info("Loaded!");
    }

    @Override
    public void onDisable() {

    }
}
