package pl.xBartekTools.commands;

import org.bukkit.command.*;
import org.bukkit.entity.*;
import pl.xBartekTools.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.enchantments.*;

public class EnchantCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public EnchantCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("enchant").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 0) {
                final ItemStack item = player.getItemInHand();
                final String enchantmentName = args[0];
                final Enchantment enchant = Enchantments.getEnchantment(enchantmentName);
                if (enchant != null) {
                    int level = enchant.getMaxLevel();
                    if (args.length > 1) {
                        level = Integer.parseInt(args[1]);
                    }
                    item.addUnsafeEnchantment(enchant, level);
                    player.sendMessage(ChatColor.GOLD + "Zaklecie " + ChatColor.RED + enchant.getName() + ChatColor.GOLD + " zostal nalozony na przedmiot w rece.");
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "Nie znaleziono podanego enchantu!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/enchant <enchant> [poziom]");
            }
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "To polecenie nie moze byc wywolane z konsoli!");
        }
        return false;
    }
}
