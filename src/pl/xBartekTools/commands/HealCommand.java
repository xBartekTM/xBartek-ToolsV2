package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.potion.*;
import org.bukkit.*;

public class HealCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public HealCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("heal").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.heal")) {
                if (args.length == 0) {
                    player.setHealth(20.0);
                    player.setFoodLevel(20);
                    for (final PotionEffect potioneffect : player.getActivePotionEffects()) {
                        player.removePotionEffect(potioneffect.getType());
                    }
                    player.setFireTicks(0);
                    player.sendMessage(this.plugin.color("&6Zostales uleczony!"));
                    return true;
                }
                if (args.length > 0) {
                    if (player.hasPermission("tools.fly.others")) {
                        final Player other = Bukkit.getPlayer(args[0]);
                        if (other != null) {
                            other.setHealth(20.0);
                            other.setFoodLevel(20);
                            for (final PotionEffect potioneffect2 : player.getActivePotionEffects()) {
                                other.removePotionEffect(potioneffect2.getType());
                            }
                            player.setFireTicks(0);
                            player.sendMessage(this.plugin.color("&6Uleczyles gracza: &2" + other.getName() + "&6!"));
                            other.sendMessage(this.plugin.color("&6Zostales uleczony przez administratora!"));
                        }
                        else {
                            player.sendMessage(this.plugin.color("&cGracz o nicku: &7" + args[0] + " &cjest offline."));
                        }
                    }
                    else {
                        player.sendMessage(this.plugin.color("&cNie masz do tego praw!"));
                    }
                }
            }
            else {
                player.sendMessage(this.plugin.color("&cNie masz do tego praw!"));
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
