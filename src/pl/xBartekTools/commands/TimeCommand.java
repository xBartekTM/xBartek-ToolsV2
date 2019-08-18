package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.*;
import java.util.*;

public class TimeCommand implements CommandExecutor
{
    HashMap<String, Integer> ticksAliases;
    ToolsPlugin plugin;
    
    public TimeCommand(final ToolsPlugin plugin) {
        this.ticksAliases = new HashMap<String, Integer>();
        this.plugin = plugin;
        this.plugin.getCommand("time").setExecutor((CommandExecutor)this);
        this.ticksAliases.put("dawn", 0);
        this.ticksAliases.put("day", 6000);
        this.ticksAliases.put("dusk", 12000);
        this.ticksAliases.put("night", 18000);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (args.length > 0) {
            final String timeFormat = args[0];
            long timeTicks = 0L;
            if (ToolsPlugin.isInteger(timeFormat)) {
                timeTicks = Integer.parseInt(timeFormat);
                if (timeTicks >= 24000L) {
                    timeTicks -= 24000L;
                }
            }
            else {
                if (this.ticksAliases.get(timeFormat) == null) {
                    sender.sendMessage(ChatColor.DARK_RED + "Niepoprawna nazwa czasu!");
                    return false;
                }
                timeTicks = this.ticksAliases.get(timeFormat);
            }
            for (final World world : Bukkit.getWorlds()) {
                world.setTime(timeTicks);
            }
            sender.sendMessage(ChatColor.GOLD + "Pomyslnie ustawiono czas na serwerze.");
            return true;
        }
        if (args.length > 1) {
            final World world2 = Bukkit.getWorld(args[0]);
            if (world2 != null) {
                final String timeFormat2 = args[0];
                long timeTicks2 = 0L;
                if (ToolsPlugin.isInteger(timeFormat2)) {
                    timeTicks2 = Integer.parseInt(timeFormat2);
                    if (timeTicks2 >= 24000L) {
                        timeTicks2 -= 24000L;
                    }
                }
                else {
                    if (this.ticksAliases.get(timeFormat2) == null) {
                        sender.sendMessage(ChatColor.DARK_RED + "Niepoprawna nazwa czasu!");
                        return false;
                    }
                    timeTicks2 = this.ticksAliases.get(timeFormat2);
                }
                world2.setTime(timeTicks2);
                sender.sendMessage(ChatColor.GOLD + "Pomyslnie ustawiono czas w " + ChatColor.RED + world2.getName() + ChatColor.GOLD + ".");
                return true;
            }
            sender.sendMessage(ChatColor.DARK_RED + "Swiat o podanej nazwie nie istnieje!");
        }
        else {
            sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + " /time [swiat] <pora>");
        }
        return false;
    }
}
