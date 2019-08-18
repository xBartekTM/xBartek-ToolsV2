package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;
import org.bukkit.*;
import me.confuser.barapi.*;
import org.bukkit.entity.*;

public class SklepsmsCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public SklepsmsCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("sklepsms").setExecutor((CommandExecutor)this);
    }
    
    @SuppressWarnings("deprecation")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender.hasPermission("xBartek.tools.sklepsms")) {
            if (args.length == 0) {
                sender.sendMessage(this.plugin.color("&cPoprawne uzycie: &7/sklepsms <nick>"));
                return true;
            }
            if (args.length > 0) {
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player onlineplayers = onlinePlayers[i];
                    if (BarAPI.hasBar(onlineplayers)) {
                        BarAPI.removeBar(onlineplayers);
                    }
                    BarAPI.setMessage(onlineplayers, this.plugin.color("&6Gracz &7" + args[0] + " &6zakupil range &7VIP. &cDziekujemy!"), 5);
                }
            }
        }
        return false;
    }
}
