package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class ClearInventoryCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ClearInventoryCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("clearinventory").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.clearinventory")) {
                if (args.length == 0) {
                    player.sendMessage(this.plugin.color("&2Czyszczenie ekwipunku..."));
                    player.getInventory().clear();
                    player.getInventory().setHelmet((ItemStack)null);
                    player.getInventory().setChestplate((ItemStack)null);
                    player.getInventory().setLeggings((ItemStack)null);
                    player.getInventory().setBoots((ItemStack)null);
                    player.getInventory().setHeldItemSlot(0);
                    player.sendMessage(this.plugin.color("&2Ekwipunek zostal wyczyszczony!"));
                    return true;
                }
                if (args.length > 0) {
                    final Player other = Bukkit.getPlayer(args[0]);
                    if (other != null) {
                        player.sendMessage(this.plugin.color("&2Czyszczenie ekwipunku gracza: &6" + other.getName() + "&2..."));
                        other.sendMessage(this.plugin.color("&2Czyszczenie ekwipunku..."));
                        other.getInventory().clear();
                        other.getInventory().setHelmet((ItemStack)null);
                        other.getInventory().setChestplate((ItemStack)null);
                        other.getInventory().setLeggings((ItemStack)null);
                        other.getInventory().setBoots((ItemStack)null);
                        other.getInventory().setHeldItemSlot(0);
                        player.sendMessage(this.plugin.color("&2Ekwipunek gracza: &6" + other.getName() + " &2zostal wyczyszczony!"));
                        other.sendMessage(this.plugin.color("&2Twoj ekwipunek zostal wyczyszczony!"));
                        return true;
                    }
                    player.sendMessage(this.plugin.color("&cGracz o nicku: &7" + args[0] + " &cjest offline."));
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
