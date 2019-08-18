package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import java.util.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.event.inventory.*;
import org.bukkit.event.*;

public class StoneCommand implements CommandExecutor, Listener
{
    ToolsPlugin plugin;
    
    public StoneCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("stone").setExecutor((CommandExecutor)this);
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            final Inventory stoneInventory = Bukkit.createInventory((InventoryHolder)null, 18, this.plugin.color("§c§lDROPY:"));
            final ItemStack diamond = new ItemStack(Material.DIAMOND, 1);
            final ItemMeta diamondMeta = diamond.getItemMeta();
            diamondMeta.setDisplayName(this.plugin.color("&bDiament"));
            diamondMeta.setLore((List)Arrays.asList("§7Szansa: §60.5%§7,", "§7Od poziomu: §620§7,", "§7Kilofy: §6Diamentowy, Zelazny"));
            diamond.setItemMeta(diamondMeta);
            final ItemStack emerald = new ItemStack(Material.EMERALD, 1);
            final ItemMeta emeraldMeta = emerald.getItemMeta();
            emeraldMeta.setDisplayName(this.plugin.color("&2Szmaragd"));
            emeraldMeta.setLore((List)Arrays.asList("§7Szansa: §61.2%§7,", "§7Od poziomu: §630§7,", "§7Kilofy: §6Diamentowy, Zelazny"));
            emerald.setItemMeta(emeraldMeta);
            final ItemStack gold = new ItemStack(Material.GOLD_INGOT, 1);
            final ItemMeta goldMeta = gold.getItemMeta();
            goldMeta.setDisplayName(this.plugin.color("&6Zloto"));
            goldMeta.setLore((List)Arrays.asList("§7Szansa: §61.0%§7,", "§7Od poziomu: §630§7,", "§7Kilofy: §6Diamentowy, Zelazny"));
            gold.setItemMeta(goldMeta);
            final ItemStack iron = new ItemStack(Material.IRON_INGOT, 1);
            final ItemMeta ironMeta = iron.getItemMeta();
            ironMeta.setDisplayName(this.plugin.color("&7Zelazo"));
            ironMeta.setLore((List)Arrays.asList("§7Szansa: §61.5%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            iron.setItemMeta(ironMeta);
            final ItemStack sand = new ItemStack(Material.SAND, 1);
            final ItemMeta sandMeta = sand.getItemMeta();
            sandMeta.setDisplayName(this.plugin.color("&ePiasek"));
            sandMeta.setLore((List)Arrays.asList("§7Szansa: §61.8%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            sand.setItemMeta(sandMeta);
            final ItemStack wegiel = new ItemStack(Material.COAL, 1);
            final ItemMeta wegielMeta = wegiel.getItemMeta();
            wegielMeta.setDisplayName(this.plugin.color("&8Wegiel"));
            wegielMeta.setLore((List)Arrays.asList("§7Szansa: §61.5%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            wegiel.setItemMeta(wegielMeta);
            final ItemStack redstone = new ItemStack(Material.REDSTONE, 1);
            final ItemMeta redstoneMeta = redstone.getItemMeta();
            redstoneMeta.setDisplayName(this.plugin.color("&4Redstone"));
            redstoneMeta.setLore((List)Arrays.asList("§7Szansa: §61.2%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            redstone.setItemMeta(redstoneMeta);
            final ItemStack lapis = new ItemStack(Material.LAPIS_ORE, 1);
            final ItemMeta lapisMeta = lapis.getItemMeta();
            lapisMeta.setDisplayName(this.plugin.color("&9Lapiz Lazuli"));
            lapisMeta.setLore((List)Arrays.asList("§7Szansa: §61.5%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            lapis.setItemMeta(lapisMeta);
            final ItemStack proch = new ItemStack(Material.SULPHUR, 1);
            final ItemMeta prochMeta = proch.getItemMeta();
            prochMeta.setDisplayName(this.plugin.color("&8Proch"));
            prochMeta.setLore((List)Arrays.asList("§7Szansa: §60.65%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            proch.setItemMeta(prochMeta);
            final ItemStack perly = new ItemStack(Material.ENDER_PEARL, 1);
            final ItemMeta perlyMeta = perly.getItemMeta();
            perlyMeta.setDisplayName(this.plugin.color("&3Perla"));
            perlyMeta.setLore((List)Arrays.asList("§7Szansa: §60.1%§7,", "§7Od poziomu: §630§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            perly.setItemMeta(perlyMeta);
            final ItemStack apple = new ItemStack(Material.APPLE, 1);
            final ItemMeta appleMeta = apple.getItemMeta();
            appleMeta.setDisplayName(this.plugin.color("&cJablko"));
            appleMeta.setLore((List)Arrays.asList("§7Szansa: §61.8%§7,", "§7Od poziomu: §664§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            apple.setItemMeta(appleMeta);
            final ItemStack slimeball = new ItemStack(Material.SLIME_BALL, 1);
            final ItemMeta slimeballMeta = slimeball.getItemMeta();
            slimeballMeta.setDisplayName(this.plugin.color("&aSlimeball"));
            slimeballMeta.setLore((List)Arrays.asList("§7Szansa: §60.6%§7,", "§7Od poziomu: §630§7,", "§7Kilofy: §6Diamentowy, Zelazny, Kamienny"));
            slimeball.setItemMeta(slimeballMeta);
            stoneInventory.clear();
            stoneInventory.setItem(0, diamond);
            stoneInventory.setItem(1, emerald);
            stoneInventory.setItem(2, gold);
            stoneInventory.setItem(3, iron);
            stoneInventory.setItem(4, sand);
            stoneInventory.setItem(5, wegiel);
            stoneInventory.setItem(6, redstone);
            stoneInventory.setItem(7, lapis);
            stoneInventory.setItem(8, proch);
            stoneInventory.setItem(9, perly);
            stoneInventory.setItem(10, apple);
            stoneInventory.setItem(11, slimeball);
            player.openInventory(stoneInventory);
        }
        return false;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onInventoryClick(final InventoryClickEvent e) {
        if (e.getInventory().getName().equalsIgnoreCase("§c§lDROPY:")) {
            e.setCancelled(true);
        }
    }
}
