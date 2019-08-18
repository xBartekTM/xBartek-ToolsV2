package pl.xBartekTools;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.plugin.*;

public class ClearDropsScheduler
{
    ToolsPlugin plugin;
    
    public ClearDropsScheduler(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getScheduler().runTaskTimer((Plugin)this.plugin, (Runnable)new Runnable() {
            @Override
            public void run() {
                Bukkit.broadcastMessage(plugin.color("&aCzyszczenie pamieci Ram ..."));
                Bukkit.dispatchCommand((CommandSender)Bukkit.getConsoleSender(), "remove drops 999999999");
                Bukkit.broadcastMessage(plugin.color("&aPamiec Ram zostala wyczyszczona!"));
            }
        }, 25000L, 25000L);
    }
}
