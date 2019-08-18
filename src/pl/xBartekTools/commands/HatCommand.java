package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;

public class HatCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public HatCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("hat").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            final ItemStack item = player.getItemInHand();
            if (player.hasPermission("tools.hat")) {
                player.setItemInHand((ItemStack)null);
                if (player.getInventory().getHelmet() != null) {
                    final ItemStack helmet = player.getInventory().getHelmet();
                    player.setItemInHand(helmet);
                }
                player.getInventory().setHelmet(item);
                player.sendMessage(this.plugin.color("&6Nowa czapka zostala wlozona!"));
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
