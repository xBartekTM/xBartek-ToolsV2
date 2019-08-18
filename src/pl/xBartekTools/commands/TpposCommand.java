package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TpposCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public TpposCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("tppos").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length == 2) {
                final int x = Integer.parseInt(args[0]);
                final int z = Integer.parseInt(args[1]);
                final int y = player.getWorld().getHighestBlockYAt(x, z);
                final Location location = new Location(player.getWorld(), x + 0.5, (double)y, z + 0.5);
                final int delayTime = 20;
                if (!player.hasPermission("tools.tppos.nodelay")) {
                    ToolsPlugin.teleportPlayerWithDelay(player, delayTime, location, ChatColor.GOLD + "Przeteleportowano na koordynaty " + ChatColor.RED + "x:" + ChatColor.GOLD + x + ChatColor.RED + " y:" + ChatColor.GOLD + y + ChatColor.RED + " z:" + ChatColor.GOLD + z + ".", null);
                }
                else {
                    player.teleport(location);
                    player.sendMessage(ChatColor.GOLD + "Przeteleportowano na koordynaty " + ChatColor.RED + "x:" + ChatColor.GOLD + x + ChatColor.RED + " y:" + ChatColor.GOLD + y + ChatColor.RED + " z:" + ChatColor.GOLD + z + ".");
                }
            }
            else if (args.length > 2) {
                final int x = Integer.parseInt(args[0]);
                final int z = Integer.parseInt(args[2]);
                final int y = Integer.parseInt(args[1]);
                final Location location = new Location(player.getWorld(), x + 0.5, (double)y, z + 0.5);
                final int delayTime = 20;
                if (!player.hasPermission("tools.tppos.nodelay")) {
                    ToolsPlugin.teleportPlayerWithDelay(player, delayTime, location, ChatColor.GOLD + "Przeteleportowano na koordynaty " + ChatColor.RED + "x:" + ChatColor.GOLD + x + ChatColor.RED + " y:" + ChatColor.GOLD + y + ChatColor.RED + " z:" + ChatColor.GOLD + z + ".", null);
                }
                else {
                    player.teleport(location);
                    player.sendMessage(ChatColor.GOLD + "Przeteleportowano na koordynaty " + ChatColor.RED + "x:" + ChatColor.GOLD + x + ChatColor.RED + " y:" + ChatColor.GOLD + y + ChatColor.RED + " z:" + ChatColor.GOLD + z + ".");
                }
            }
            else {
                player.sendMessage(ChatColor.RED + "Poprawne uzycie: " + ChatColor.GRAY + "/tppos <x> [y] <z>");
            }
        }
        else {
            sender.sendMessage(ChatColor.DARK_RED + "To polecenie nie moze byc wywolane z konsoli!");
        }
        return false;
    }
}
