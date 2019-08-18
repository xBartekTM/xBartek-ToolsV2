package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class BroadcastCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public BroadcastCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("broadcast").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.broadcast")) {
                if (args.length == 0) {
                    player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/broadcast <wiadomosc>"));
                    return true;
                }
                if (args.length >= 1) {
                    final String prefix = "&8** &aOgloszenie &8** &6";
                    String broadcastMessage = "";
                    for (int i = 0; i < args.length; ++i) {
                        broadcastMessage = String.valueOf(broadcastMessage) + args[i] + " ";
                    }
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', String.valueOf(prefix) + broadcastMessage));
                }
            }
            else {
                player.sendMessage(this.plugin.color("&cNie masz do tego praw!"));
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
