package com.matthewcash.network;

import net.md_5.bungee.api.plugin.Plugin;

public class PingHandler extends Plugin {
    private static PingHandler plugin;

    public static PingHandler getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        getProxy().getPluginManager().registerListener(this, new PingEvent());

        getLogger().info("Enabled PingHandler!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled PingHandler!");
    }
}
