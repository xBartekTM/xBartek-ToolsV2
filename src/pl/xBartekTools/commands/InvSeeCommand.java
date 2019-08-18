package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class InvSeeCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public InvSeeCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("invsee").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.invsee")) {
                if (args.length == 0) {
                    player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/invsee <gracz>"));
                    return true;
                }
                if (args.length > 0) {
                    final Player other = Bukkit.getPlayer(args[0]);
                    if (other != null) {
                        player.openInventory((Inventory)other.getInventory());
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
