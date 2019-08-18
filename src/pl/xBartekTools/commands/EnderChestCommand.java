package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class EnderChestCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public EnderChestCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("enderchest").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.enderchest")) {
                player.openInventory(player.getEnderChest());
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
