package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.*;

public class ListCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ListCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("list").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        @SuppressWarnings("deprecation")
		final int onlineplayers = Bukkit.getOnlinePlayers().length;
        final int maxplayers = Bukkit.getMaxPlayers();
        sender.sendMessage(this.plugin.color("&7Na serwerze jest: &f" + onlineplayers + " &7graczy online na: &f" + maxplayers + " &7mozliwych."));
        return true;
    }
}
