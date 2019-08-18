package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.block.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class SignColourListener implements Listener
{
    ToolsPlugin plugin;
    
    public SignColourListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onSignColour(final SignChangeEvent e) {
        final Player player = e.getPlayer();
        if (player.hasPermission("tools.signcolour")) {
            for (int i = 0; i <= 3; ++i) {
                final String string = e.getLine(i);
                e.setLine(i, string.replaceAll("&", "§"));
            }
        }
    }
}
