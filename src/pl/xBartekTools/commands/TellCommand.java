package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class TellCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public TellCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("tell").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 1) {
                final Player other = Bukkit.getPlayer(args[0]);
                if (other != null) {
                    if (!other.hasPermission("tools.tell.nomessage") || (other.hasPermission("tools.tell.nomessage") && player.hasPermission("tools.tell.nomessage"))) {
                        this.plugin.lastMessageSender.put(other, player);
                        this.plugin.lastMessageSender.put(player, other);
                        final StringBuilder sb = new StringBuilder();
                        for (int i = 1; i < args.length; ++i) {
                            sb.append(args[i]).append(" ");
                        }
                        final String message = sb.toString();
                        other.sendMessage(this.plugin.color("&8[&3" + player.getDisplayName() + " -> ja&8]: &7" + message));
                        player.sendMessage(this.plugin.color("&8[&3ja -> " + other.getDisplayName() + "&8]: &7" + message));
                        return true;
                    }
                    player.sendMessage(this.plugin.color("&cNie mozesz wyslac do tego gracza wiadomosci!"));
                }
                else {
                    player.sendMessage(this.plugin.color("&cGracz o nicku: &7" + args[0] + " &cjest offline."));
                }
            }
            else {
                player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/tell <nick> <wiadomosc>"));
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
