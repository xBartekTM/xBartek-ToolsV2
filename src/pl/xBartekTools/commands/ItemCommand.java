package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.*;
import org.bukkit.*;

public class ItemCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ItemCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("item").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 1) {
                final String[] idAndData = args[0].split(":");
                final Material material = ToolsPlugin.getMaterial(idAndData[0]);
                if (material != null) {
                    Short data = 0;
                    if (idAndData.length > 1) {
                        data = Short.valueOf(idAndData[1]);
                    }
                    final int amount = Integer.parseInt(args[1]);
                    final ItemStack item = new ItemStack(material, amount, (short)data);
                    if (player.getInventory().firstEmpty() >= 0) {
                        player.getInventory().addItem(new ItemStack[] { item });
                        player.updateInventory();
                        player.sendMessage(ChatColor.GOLD + "Otrzymales " + material.name() + ":" + data + " (" + amount + ").");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Nie masz miejsca w swoim ekwipunku!");
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "Nie rozpoznano nazwy przedmiotu!");
                }
            }
            else if (args.length > 0) {
                final String[] idAndData = args[0].split(":");
                final Material material = ToolsPlugin.getMaterial(idAndData[0]);
                if (material != null) {
                    Short data = 0;
                    if (idAndData.length > 1) {
                        data = Short.valueOf(idAndData[1]);
                    }
                    final ItemStack item2 = new ItemStack(material, material.getMaxStackSize(), (short)data);
                    if (player.getInventory().firstEmpty() >= 0) {
                        player.getInventory().addItem(new ItemStack[] { item2 });
                        player.updateInventory();
                        player.sendMessage(ChatColor.GOLD + "Otrzymales " + material.name() + " (" + item2.getAmount() + ").");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Nie masz miejsca w swoim ekwipunku!");
                    }
                }
                else {
                    player.sendMessage(ChatColor.RED + "Nie rozpoznano nazwy przedmiotu!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/item <id> [ilosc]");
            }
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "Ta komenda nie moze byc wywolana z konsoli!");
        }
        return false;
    }
}
