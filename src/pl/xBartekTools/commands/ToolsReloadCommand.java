package pl.xBartekTools.commands;

import pl.xBartekTools.*;
import org.bukkit.command.*;

public class ToolsReloadCommand implements CommandExecutor
{
    ToolsPlugin plugin;
    
    public ToolsReloadCommand(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getCommand("toolsreload").setExecutor((CommandExecutor)this);
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender.hasPermission("xBartek.tools.toolsreload")) {
            this.plugin.reloadConfig();
            sender.sendMessage(this.plugin.color("&aPrzeladowano plugin!"));
        }
        else {
            sender.sendMessage(this.plugin.color("&cNie masz do tego praw!"));
        }
        return false;
    }
}
