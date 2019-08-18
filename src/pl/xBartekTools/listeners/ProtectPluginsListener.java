package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class ProtectPluginsListener implements Listener
{
    ToolsPlugin plugin;
    
    public ProtectPluginsListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        final Player player = event.getPlayer();
        if (!player.hasPermission("tools.plugins")) {
            final String message = event.getMessage();
            final String[] splittedMessage = message.split(" ");
            final String[] pluginCommands = { "/pl", "/plugins", "/?", "/help", "/bukkit:?", "/bukkit:pl", "/ver", "/bukkit:ver", "/bukkit:plugins" };
            if (ToolsPlugin.containsIgnoreCase(pluginCommands, splittedMessage[0])) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.GRAY + "[" + ChatColor.BLUE + "*" + ChatColor.GRAY + "] Posiadamy wlasne (autorskie) pluginy oraz wlasny silnik, pisany przez naszych programistow.");
            }
        }
    }
}
