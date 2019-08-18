package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class WeatherCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    String[] sun;
    String[] rain;
    String[] thunder;
    
    public WeatherCommand(final ToolsPlugin plugin) {
        this.sun = new String[] { "sky", "sun", "clear" };
        this.rain = new String[] { "rain", "storm" };
        this.thunder = new String[] { "thunder", "thundering", "lightning" };
        this.plugin = plugin;
        this.plugin.getCommand("weather").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 1) {
                final World world = Bukkit.getWorld(args[0]);
                if (world != null) {
                    final String weather = args[1];
                    if (ToolsPlugin.containsIgnoreCase(this.sun, weather)) {
                        world.setStorm(false);
                        world.setThundering(false);
                        player.sendMessage(ChatColor.GOLD + "Ustawiles sloneczna pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                    }
                    else if (ToolsPlugin.containsIgnoreCase(this.rain, weather)) {
                        world.setStorm(true);
                        player.sendMessage(ChatColor.GOLD + "Ustawiles desczowa pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                    }
                    else if (ToolsPlugin.containsIgnoreCase(this.thunder, weather)) {
                        int time = 300;
                        if (args.length > 2) {
                            time = Integer.parseInt(args[2]);
                        }
                        world.setThunderDuration(time);
                        player.sendMessage(ChatColor.GOLD + "Ustawiles burzliwa pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                    }
                    else {
                        player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/weather [swiat] <pogoda> [czas]");
                    }
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "Swiat o podanej nazwie nie istnieje!");
                }
            }
            else if (args.length == 1) {
                final World world = player.getWorld();
                final String weather = args[0];
                if (ToolsPlugin.containsIgnoreCase(this.sun, weather)) {
                    world.setStorm(false);
                    world.setThundering(false);
                    player.sendMessage(ChatColor.GOLD + "Ustawiles sloneczna pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                }
                else if (ToolsPlugin.containsIgnoreCase(this.rain, weather)) {
                    world.setStorm(true);
                    player.sendMessage(ChatColor.GOLD + "Ustawiles deszczowa pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                }
                else if (ToolsPlugin.containsIgnoreCase(this.thunder, weather)) {
                    int time = 300;
                    if (args.length > 2) {
                        time = Integer.parseInt(args[2]);
                    }
                    world.setThunderDuration(time);
                    player.sendMessage(ChatColor.GOLD + "Ustawiles burzliwa pogode w " + ChatColor.RED + world.getName() + ChatColor.GOLD + ".");
                }
                else {
                    player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/weather [swiat] <pogoda> [czas]");
                }
            }
        }
        else if (args.length > 1) {
            final World world2 = Bukkit.getWorld(args[0]);
            if (world2 != null) {
                final String weather2 = args[1];
                if (ToolsPlugin.containsIgnoreCase(this.sun, weather2)) {
                    world2.setStorm(false);
                    world2.setThundering(false);
                    sender.sendMessage(ChatColor.GOLD + "Ustawiles sloneczna pogode w " + ChatColor.RED + world2.getName() + ChatColor.GOLD + ".");
                }
                else if (ToolsPlugin.containsIgnoreCase(this.rain, weather2)) {
                    world2.setStorm(true);
                    sender.sendMessage(ChatColor.GOLD + "Ustawiles deszczowa pogode w " + ChatColor.RED + world2.getName() + ChatColor.GOLD + ".");
                }
                else if (ToolsPlugin.containsIgnoreCase(this.thunder, weather2)) {
                    int time2 = 300;
                    if (args.length > 2) {
                        time2 = Integer.parseInt(args[2]);
                    }
                    world2.setThunderDuration(time2);
                    sender.sendMessage(ChatColor.GOLD + "Ustawiles burzliwa pogode w " + ChatColor.RED + world2.getName() + ChatColor.GOLD + ".");
                }
                else {
                    sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/weather [swiat] <pogoda> [czas]");
                }
            }
            else {
                sender.sendMessage(ChatColor.DARK_RED + "Swiat o podanej nazwie nie istnieje!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/weather <swiat> <pogoda> [czas]");
        }
        return false;
    }
}
