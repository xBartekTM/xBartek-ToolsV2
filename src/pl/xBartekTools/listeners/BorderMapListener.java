package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class BorderMapListener implements Listener
{
    ToolsPlugin plugin;
    
    public BorderMapListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void BorderMap(final PlayerMoveEvent e) {
        final Player player = e.getPlayer();
        if (e.getTo().getBlockX() > 5000 || e.getTo().getBlockX() < -5000 || e.getTo().getBlockZ() > 5000 || e.getTo().getBlockZ() < -5000) {
            player.teleport(e.getFrom());
            player.sendMessage(this.plugin.color("&cOsiagnales granice swiata! &7(5000)"));
            player.playSound(e.getPlayer().getLocation(), Sound.ENDERMAN_TELEPORT, 10.0f, 1.0f);
        }
    }
}
