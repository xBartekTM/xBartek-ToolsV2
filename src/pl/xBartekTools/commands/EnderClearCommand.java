package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class EnderClearCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public EnderClearCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("enderclear").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.enderclear")) {
                if (args.length == 0) {
                    player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/enderclear <gracz>"));
                    return true;
                }
                if (args.length > 0) {
                    final Player other = Bukkit.getPlayer(args[0]);
                    if (other != null) {
                        other.getEnderChest().clear();
                        player.sendMessage(this.plugin.color("&2Wyczysciles enderchest gracza: &6" + other.getName() + "&2!"));
                        other.sendMessage(this.plugin.color("&cTwoj enderchest zostal wyczyszczony przez administratora!"));
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
