package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AsyncPlayerChatListener implements Listener
{
    ToolsPlugin plugin;
    
    public AsyncPlayerChatListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onChat(final AsyncPlayerChatEvent e) {
        final Player player = e.getPlayer();
        if (ToolsPlugin.chat) {
            if (!player.hasPermission("xBartek.tools.pisanie")) {
                e.setCancelled(true);
                player.sendMessage(this.plugin.color("&cChat jest aktualnie wylaczony!"));
            }
            else {
                e.setCancelled(false);
            }
        }
    }
}
