package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;

public class RepairCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    Material[] canRepair;
    
    public RepairCommand(final ToolsPlugin plugin) {
        this.canRepair = new Material[] { Material.DIAMOND_PICKAXE, Material.DIAMOND_SWORD, Material.DIAMOND_SPADE, Material.DIAMOND_AXE, Material.DIAMOND_HOE, Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS, Material.IRON_PICKAXE, Material.IRON_SWORD, Material.IRON_SPADE, Material.IRON_AXE, Material.IRON_HOE, Material.IRON_HELMET, Material.IRON_CHESTPLATE, Material.IRON_LEGGINGS, Material.IRON_BOOTS, Material.GOLD_PICKAXE, Material.GOLD_SWORD, Material.GOLD_SPADE, Material.GOLD_AXE, Material.GOLD_HOE, Material.GOLD_HELMET, Material.GOLD_CHESTPLATE, Material.GOLD_LEGGINGS, Material.GOLD_BOOTS, Material.STONE_PICKAXE, Material.STONE_SWORD, Material.STONE_SPADE, Material.STONE_AXE, Material.STONE_HOE, Material.CHAINMAIL_HELMET, Material.CHAINMAIL_CHESTPLATE, Material.CHAINMAIL_LEGGINGS, Material.CHAINMAIL_BOOTS, Material.WOOD_PICKAXE, Material.WOOD_SWORD, Material.WOOD_SPADE, Material.WOOD_AXE, Material.WOOD_HOE, Material.LEATHER_HELMET, Material.LEATHER_CHESTPLATE, Material.LEATHER_LEGGINGS, Material.LEATHER_BOOTS, Material.FLINT_AND_STEEL, Material.SHEARS, Material.BOW, Material.FISHING_ROD, Material.ANVIL };
        this.plugin = plugin;
        this.plugin.getCommand("repair").setExecutor((CommandExecutor)this);
    }
    
    public boolean containsIgnoreCase(final Material[] board, final Material material) {
        for (final Material othermaterial : board) {
            if (material.equals((Object)othermaterial)) {
                return true;
            }
        }
        return false;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 0) {
                if (args[0].equalsIgnoreCase("all")) {
                    ItemStack[] contents;
                    for (int length = (contents = player.getInventory().getContents()).length, i = 0; i < length; ++i) {
                        final ItemStack item = contents[i];
                        if (item != null) {
                            if (this.containsIgnoreCase(this.canRepair, item.getType())) {
                                final short durability = 0;
                                item.setDurability(durability);
                            }
                        }
                    }
                    ItemStack[] armorContents;
                    for (int length2 = (armorContents = player.getInventory().getArmorContents()).length, j = 0; j < length2; ++j) {
                        final ItemStack item = armorContents[j];
                        if (item != null) {
                            if (this.containsIgnoreCase(this.canRepair, item.getType())) {
                                final short durability = 0;
                                item.setDurability(durability);
                            }
                        }
                    }
                    player.updateInventory();
                    player.sendMessage(ChatColor.GOLD + "Pomyslnie naprawiono caly ekwipunek.");
                }
                else if (args[0].equalsIgnoreCase("armor")) {
                    ItemStack[] armorContents2;
                    for (int length3 = (armorContents2 = player.getInventory().getArmorContents()).length, k = 0; k < length3; ++k) {
                        final ItemStack item = armorContents2[k];
                        if (item != null) {
                            if (this.containsIgnoreCase(this.canRepair, item.getType())) {
                                final short durability = 0;
                                item.setDurability(durability);
                            }
                        }
                    }
                    player.updateInventory();
                    player.sendMessage(ChatColor.GOLD + "Pomyslnie naprawiono cala zbroje.");
                }
                else {
                    player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/repair [all/armor]");
                }
            }
            else {
                final ItemStack item = player.getItemInHand();
                final short durability2 = 0;
                item.setDurability(durability2);
                player.updateInventory();
                player.sendMessage(ChatColor.GOLD + "Pomyslnie naprawiono przedmiot, ktory trzymasz w rece.");
            }
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "To polecenie nie moze byc wykonane z konsoli!");
        }
        return false;
    }
}
