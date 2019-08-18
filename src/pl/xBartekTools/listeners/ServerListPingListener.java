package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.server.*;
import org.bukkit.event.*;

public class ServerListPingListener implements Listener
{
    ToolsPlugin plugin;
    
    public ServerListPingListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onServerListPing(final ServerListPingEvent e) {
        e.setMotd(this.plugin.getConfig().getString("config.messages.motd_serverlist").replace("&", "§"));
    }
}
