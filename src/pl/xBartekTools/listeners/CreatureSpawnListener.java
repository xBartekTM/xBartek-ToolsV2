package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.entity.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;

public class CreatureSpawnListener implements Listener
{
    ToolsPlugin plugin;
    
    public CreatureSpawnListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)this.plugin);
    }
    
    @EventHandler
    public void onCreatureSpawn(final CreatureSpawnEvent event) {
        if (event.getEntityType().equals((Object)EntityType.WITHER) && !this.plugin.configManager.canSpawnWither) {
            event.setCancelled(true);
        }
    }
}
