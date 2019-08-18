package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.*;
import org.bukkit.event.player.*;

public class SilentJoinLeaveListener implements Listener
{
    ToolsPlugin plugin;
    
    public SilentJoinLeaveListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        if (this.plugin.configManager.silentJoinLeave) {
            event.setJoinMessage((String)null);
        }
    }
    
    @EventHandler
    public void onPlayerLeave(final PlayerQuitEvent event) {
        if (this.plugin.configManager.silentJoinLeave) {
            event.setQuitMessage((String)null);
        }
    }
    
    @EventHandler
    public void onPlayerKick(final PlayerKickEvent event) {
        if (this.plugin.configManager.silentJoinLeave) {
            event.setLeaveMessage((String)null);
        }
    }
}
