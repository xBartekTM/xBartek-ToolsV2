package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;

public class PomocCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public PomocCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("pomoc").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player) {
            final Player player = (Player)sender;
            for (String s : this.plugin.getConfig().getStringList("config.messages.helpmessage")) {
                s = s.replace("&", "§");
                player.sendMessage(s);
            }
        }
        else {
            sender.sendMessage(this.plugin.color("&4To polecenie nie moze byc wykonane z konsoli."));
        }
        return false;
    }
}
