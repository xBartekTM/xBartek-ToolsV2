package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import java.util.*;
import org.bukkit.plugin.*;
import org.bukkit.event.block.*;
import org.bukkit.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class AppleDropListener implements Listener
{
    ToolsPlugin plugin;
    Random random;
    int szansa;
    double szansaNaJablko;
    
    public AppleDropListener(final ToolsPlugin plugin) {
        this.random = new Random();
        this.szansa = 100;
        this.szansaNaJablko = 0.4;
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @EventHandler
    public void onBreak(final BlockBreakEvent e) {
        final Player player = e.getPlayer();
        if (e.getBlock().getType() == Material.STONE) {
            final double szansaNaDrop = this.random.nextInt(this.szansa);
            if (szansaNaDrop <= this.szansaNaJablko) {
                final ItemStack apple = new ItemStack(Material.APPLE, 1);
                player.getInventory().addItem(new ItemStack[] { apple });
            }
        }
    }
}
