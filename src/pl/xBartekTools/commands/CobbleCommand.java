package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class CobbleCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public CobbleCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("cobble").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.getInventory().contains(Material.COBBLESTONE)) {
                player.getInventory().remove(Material.COBBLESTONE);
                player.sendMessage(this.plugin.color("&aUsunieto cobblestone'a z EQ!"));
            }
            else {
                player.sendMessage(this.plugin.color("&cNie masz cobblestone'a w EQ!"));
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
