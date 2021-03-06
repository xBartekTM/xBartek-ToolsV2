package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TpCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public TpCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("tp").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.tp")) {
                if (args.length == 0 || args.length > 1) {
                    player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/tp <gracz>"));
                    return true;
                }
                if (args.length == 1) {
                    final Player other = Bukkit.getPlayer(args[0]);
                    if (other != null) {
                        final Location otherlocation = other.getLocation();
                        player.teleport(otherlocation);
                        player.sendMessage(this.plugin.color("&2Przeteleportowano do gracza: &6" + other.getName() + "&2!"));
                    }
                    else {
                        player.sendMessage(this.plugin.color("&cGracz o nicku: &7" + args[0] + " &cjest offline."));
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
