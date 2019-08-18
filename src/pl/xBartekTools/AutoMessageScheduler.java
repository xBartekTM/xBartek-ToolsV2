package pl.xBartekTools;

import org.bukkit.*;
import org.bukkit.plugin.*;

public class AutoMessageScheduler
{
    ToolsPlugin plugin;
    
    public AutoMessageScheduler(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg1").replace("&", "§"));
            }
        }, 900L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg2").replace("&", "§"));
            }
        }, 1800L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg3").replace("&", "§"));
            }
        }, 2700L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg4").replace("&", "§"));
            }
        }, 3600L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg5").replace("&", "§"));
            }
        }, 4500L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg6").replace("&", "§"));
            }
        }, 5400L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg7").replace("&", "§"));
            }
        }, 6500L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg8").replace("&", "§"));
            }
        }, 7400L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg9").replace("&", "§"));
            }
        }, 8500L, 9400L);
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.getConfig().getString("config.messages.automessages.automsg10").replace("&", "§"));
            }
        }, 9400L, 9400L);
    }
}
