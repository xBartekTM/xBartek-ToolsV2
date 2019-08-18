package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.help.*;
import org.bukkit.event.*;

public class UnknownCommandListener implements Listener
{
    ToolsPlugin plugin;
    
    public UnknownCommandListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onUnknownCommand(final PlayerCommandPreprocessEvent e) {
        if (!e.isCancelled()) {
            final Player player = e.getPlayer();
            final String msg = e.getMessage().split(" ")[0];
            final HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
            if (topic == null) {
                for (String s : this.plugin.getConfig().getStringList("config.messages.unknowncommand")) {
                    s = s.replace("&", "§");
                    player.sendMessage(s);
                }
                e.setCancelled(true);
            }
        }
    }
}
