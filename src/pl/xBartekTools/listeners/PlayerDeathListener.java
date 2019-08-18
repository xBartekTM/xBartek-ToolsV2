package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class PlayerDeathListener implements Listener
{
    ToolsPlugin plugin;
    
    public PlayerDeathListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onPlayerDeath(final PlayerDeathEvent event) {
        final Player player = event.getEntity();
        final ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (short)3);
        final SkullMeta meta = (SkullMeta)item.getItemMeta();
        meta.setOwner(player.getName());
        item.setItemMeta((ItemMeta)meta);
        player.getWorld().dropItemNaturally(player.getLocation(), item);
    }
}
