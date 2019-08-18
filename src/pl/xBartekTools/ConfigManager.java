package pl.xBartekTools;

public class ConfigManager
{
    ToolsPlugin plugin;
    public boolean silentJoinLeave;
    public boolean canSpawnWither;
    public String[] socialCommands;
    
    public ConfigManager(final ToolsPlugin plugin) {
        this.plugin = plugin;
    }
    
    public void load() {
        this.silentJoinLeave = this.plugin.getConfig().getBoolean("config.silentjoinleave");
        this.canSpawnWither = this.plugin.getConfig().getBoolean("config.canspawnwither");
    }
    
    public void save() {
        this.plugin.getConfig().set("config.silentjoinleave", (Object)this.silentJoinLeave);
        this.plugin.getConfig().set("config.socialcommands", (Object)this.socialCommands);
        this.plugin.getConfig().set("config.canspawnwither", (Object)this.canSpawnWither);
        this.plugin.saveConfig();
    }
    
    public void reload() {
        this.load();
    }
}
