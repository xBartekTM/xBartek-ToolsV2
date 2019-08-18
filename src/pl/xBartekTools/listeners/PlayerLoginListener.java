package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerLoginListener implements Listener
{
    ToolsPlugin plugin;
    
    public PlayerLoginListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onPlayerLogin(final PlayerLoginEvent e) {
        final Player player = e.getPlayer();
        @SuppressWarnings("deprecation")
		final int onlineplayers = Bukkit.getOnlinePlayers().length;
        final int maxplayers = Bukkit.getMaxPlayers();
        if (onlineplayers >= maxplayers && player.hasPermission("tools.slot")) {
            player.kickPlayer(this.plugin.color("&cSerwer jest pelen, kup range VIP! Wiecej na stronie: www.ishc.pl"));
        }
        if (e.getResult() == PlayerLoginEvent.Result.KICK_WHITELIST) {
            e.setKickMessage(this.plugin.getConfig().getString("config.messages.whitelist)".replace("&", "§")));
        }
    }
}
