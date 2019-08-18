package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class SpeedCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public SpeedCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("speed").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 1) {
                final Player other = Bukkit.getPlayer(args[0]);
                if (ToolsPlugin.isFloat(args[1])) {
                    final float speed = Float.parseFloat(args[1]);
                    if (other != null) {
                        if (other.isFlying()) {
                            other.setFlySpeed(speed);
                            other.sendMessage(ChatColor.GOLD + "Ustawiono predkosc latania na " + ChatColor.RED + speed + ChatColor.GOLD + " przez " + ChatColor.RED + player.getDisplayName() + ChatColor.GOLD + ".");
                            player.sendMessage(ChatColor.GOLD + "Ustawiono predkosc latania " + ChatColor.RED + other.getDisplayName() + ChatColor.GOLD + " na " + speed + ".");
                        }
                        else {
                            other.setWalkSpeed(speed);
                            other.sendMessage(ChatColor.GOLD + "Ustawiono predkosc chodzenia na " + ChatColor.RED + speed + ChatColor.GOLD + " przez " + ChatColor.RED + player.getDisplayName() + ChatColor.GOLD + ".");
                            player.sendMessage(ChatColor.GOLD + "Ustawiono predkosc chodzenia " + ChatColor.RED + other.getDisplayName() + ChatColor.GOLD + " na " + speed + ".");
                        }
                    }
                    else {
                        player.sendMessage(ChatColor.DARK_RED + "Podany gracz nie jest online!");
                    }
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "Podany argument nie jest liczba!");
                }
            }
            else if (args.length > 0) {
                if (ToolsPlugin.isFloat(args[0])) {
                    final float speed2 = Float.parseFloat(args[0]);
                    if (player.isFlying()) {
                        player.setFlySpeed(speed2);
                        player.sendMessage(ChatColor.GOLD + "Ustawiono predkosc latania na " + ChatColor.RED + speed2 + ChatColor.GOLD + ".");
                    }
                    else {
                        player.setWalkSpeed(speed2);
                        player.sendMessage(ChatColor.GOLD + "Ustawiono predkosc chodzenia na " + ChatColor.RED + speed2 + ChatColor.GOLD + ".");
                    }
                }
                else {
                    player.sendMessage(ChatColor.DARK_RED + "Podany argument nie jest liczba!");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/speed [gracz] <predkosc>");
            }
        }
        else if (args.length > 1) {
            final Player other2 = Bukkit.getPlayer(args[0]);
            if (ToolsPlugin.isInteger(args[1])) {
                final float speed2 = Float.parseFloat(args[1]);
                if (other2 != null) {
                    if (other2.isFlying()) {
                        other2.setFlySpeed(speed2);
                        sender.sendMessage(ChatColor.GOLD + "Ustawiono predkosc latania " + ChatColor.RED + other2.getDisplayName() + ChatColor.GOLD + " na " + speed2 + ".");
                    }
                    else {
                        other2.setWalkSpeed(speed2);
                        sender.sendMessage(ChatColor.GOLD + "Ustawiono predkosc chodzenia " + ChatColor.RED + other2.getDisplayName() + ChatColor.GOLD + " na " + speed2 + ".");
                    }
                }
                else {
                    sender.sendMessage(ChatColor.DARK_RED + "Podany gracz nie jest online!");
                }
            }
            else {
                sender.sendMessage(ChatColor.DARK_RED + "Podany argument nie jest liczba!");
            }
        }
        else {
            sender.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/speed <gracz> <predkosc>");
        }
        return false;
    }
}
