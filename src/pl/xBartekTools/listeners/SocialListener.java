package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class SocialListener implements Listener
{
    ToolsPlugin plugin;
    
    public SocialListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler(priority = EventPriority.LOWEST, ignoreCancelled = true)
    public void onPlayerCommandPreprocess(final PlayerCommandPreprocessEvent event) {
        final String cmd = event.getMessage().split(" ")[0].substring(1);
        if (ToolsPlugin.containsIgnoreCase(this.plugin.configManager.socialCommands, cmd)) {
            final String social = ChatColor.GRAY + event.getPlayer().getName() + ": " + event.getMessage();
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = this.plugin.getServer().getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player player = onlinePlayers[i];
                if (player.hasPermission("tools.socialspy")) {
                    player.sendMessage(social);
                }
            }
        }
    }
}
