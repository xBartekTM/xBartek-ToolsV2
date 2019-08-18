package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class FlyCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public FlyCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("fly").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.fly")) {
                if (args.length == 0) {
                    if (!player.getAllowFlight()) {
                        player.setAllowFlight(true);
                        player.sendMessage(this.plugin.color("&6Wlaczyles tryb latania!"));
                    }
                    else {
                        player.setAllowFlight(false);
                        player.sendMessage(this.plugin.color("&6Wylaczyles tryb latania!"));
                    }
                }
                else if (args.length >= 1) {
                    if (player.hasPermission("tools.fly.others")) {
                        final Player other = Bukkit.getPlayer(args[0]);
                        if (other != null) {
                            if (!other.getAllowFlight()) {
                                other.setAllowFlight(true);
                                player.sendMessage(this.plugin.color("&6Wlaczyles graczowi: &2" + other.getName() + " &6tryb latania!"));
                                other.sendMessage(this.plugin.color("&6Tryb latania zostal Ci wlaczony przez administratora!"));
                            }
                            else {
                                other.setAllowFlight(false);
                                player.sendMessage(this.plugin.color("&6Wylaczyles graczowi: &2" + other.getName() + " &6tryb latania!"));
                                other.sendMessage(this.plugin.color("&6Tryb latania zostal Ci wylaczony przez administratora!"));
                            }
                        }
                        else {
                            player.sendMessage(this.plugin.color("&cGracz o nicku: &7" + args[0] + " &cjest offline."));
                        }
                    }
                    else {
                        player.sendMessage(this.plugin.color("&cNie masz do tego praw!"));
                    }
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
