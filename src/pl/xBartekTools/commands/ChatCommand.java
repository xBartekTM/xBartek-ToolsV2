package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class ChatCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ChatCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("chat").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (sender.hasPermission("tools.chat")) {
            if (args.length == 0) {
                sender.sendMessage(this.plugin.color("&cDostepne argumenty: &7<on/off/cc>"));
                return true;
            }
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("on")) {
                    ToolsPlugin.chat = false;
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Chat zostal wlaczony przez: " + ChatColor.WHITE + p.getDisplayName());
                }
                else if (args[0].equalsIgnoreCase("off")) {
                    ToolsPlugin.chat = true;
                    Bukkit.broadcastMessage(ChatColor.RED + "Chat zostal wylaczony przez: " + ChatColor.WHITE + p.getDisplayName());
                }
                else if (args[0].equalsIgnoreCase("cc")) {
                    for (int i = 0; i < 100; ++i) {
                        if (i == 95) {
                            Bukkit.broadcastMessage(ChatColor.RED + "                      Chat zostal wyczyszczony!");
                        }
                        else if (i == 94) {
                            Bukkit.broadcastMessage(ChatColor.BOLD + "                            " + "§c§lIS§7§lHC§8§l.PL");
                        }
                        else {
                            Bukkit.broadcastMessage(" ");
                        }
                    }
                }
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&cNie masz do tego praw"));
        }
        return false;
    }
}
