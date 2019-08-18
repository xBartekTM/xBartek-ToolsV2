package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.*;

public class ReplyCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ReplyCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("reply").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            if (args.length > 0) {
                if (this.plugin.lastMessageSender.get(player) != null) {
                    final Player other = Bukkit.getPlayer(this.plugin.lastMessageSender.get(player).getName());
                    if (other != null) {
                        this.plugin.lastMessageSender.put(other, player);
                        final StringBuilder sb = new StringBuilder();
                        for (int i = 0; i < args.length; ++i) {
                            sb.append(args[i]).append(" ");
                        }
                        final String message = sb.toString();
                        other.sendMessage(this.plugin.color("&8[&3" + player.getDisplayName() + " -> ja&8]: &7" + message));
                        player.sendMessage(this.plugin.color("&8[&3ja -> " + other.getDisplayName() + "&8]: &7" + message));
                        return true;
                    }
                    player.sendMessage(this.plugin.color("&cPodany gracz nie jest online!"));
                }
                else {
                    player.sendMessage(this.plugin.color("&cNie masz komu odpisac!"));
                }
            }
            else {
                player.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/reply <wiadomosc>"));
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
