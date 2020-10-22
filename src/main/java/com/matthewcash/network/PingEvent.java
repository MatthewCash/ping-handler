package com.matthewcash.network;

import java.net.SocketAddress;

import net.md_5.bungee.api.event.ProxyPingEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.PluginLogger;
import net.md_5.bungee.event.EventHandler;

public class PingEvent implements Listener {

    @EventHandler
    public void onPing(ProxyPingEvent event) {
        SocketAddress address = event.getConnection().getSocketAddress();
        String ipAddress = address.toString().substring(1, address.toString().indexOf(":"));
        String port = address.toString().substring(address.toString().indexOf(":") + 1);

        if (ipAddress.equals("172.18.0.1")) {
            // Hide pings from other containers
            return;
        }

        PluginLogger.getLogger("PingHandler").info(ipAddress + " has pinged from port " + port + "!");
    }
}
