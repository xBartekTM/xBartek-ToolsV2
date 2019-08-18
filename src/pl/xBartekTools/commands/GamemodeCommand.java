package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class GamemodeCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public GamemodeCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("gamemode").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (player.hasPermission("tools.gamemode")) {
                if (args.length == 0) {
                    if (player.getGameMode() == GameMode.SURVIVAL) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(this.plugin.color("&6Zmieniles tryb gry na kreatywny!"));
                    }
                    else if (player.getGameMode() == GameMode.CREATIVE) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(this.plugin.color("&6Zmieniles tryb gry na przetrwanie!"));
                    }
                }
                else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(this.plugin.color("&6Zmieniles tryb gry na przetrwanie!"));
                    }
                    else if (args[0].equalsIgnoreCase("1")) {
                        player.setGameMode(GameMode.CREATIVE);
                        player.sendMessage(this.plugin.color("&6Zmieniles tryb gry na kreatywny!"));
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
