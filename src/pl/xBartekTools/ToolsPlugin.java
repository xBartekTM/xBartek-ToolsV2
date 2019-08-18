package pl.xBartekTools;

import org.bukkit.plugin.java.*;
import java.util.*;
import org.bukkit.entity.*;
import pl.xBartekTools.listeners.*;
import pl.xBartekTools.commands.*;
import org.bukkit.*;

public class ToolsPlugin extends JavaPlugin
{
    public static boolean chat;
    public HashMap<Player, Player> lastMessageSender;
    ListCommand listcommand;
    ChatCommand chatcommand;
    ToolsReloadCommand toolsreloadcommand;
    PomocCommand pomocommand;
    BroadcastCommand broadcastcommand;
    ClearInventoryCommand clearinventorycommand;
    TimeCommand daycommand;
    EnderChestCommand enderchestcommand;
    InvSeeCommand invseecommand;
    EnderSeeCommand enderseecommand;
    EnderClearCommand enderclearcommand;
    FlyCommand flycommand;
    GamemodeCommand gamemodecommand;
    HatCommand hatcommand;
    HealCommand healcommand;
    TellCommand tellcommand;
    ReplyCommand replycommand;
    CobbleCommand cobblecommand;
    TpCommand tpcommand;
    TphereCommand tpherecommand;
    StoneCommand stonecommand;
    SklepsmsCommand sklepsmscommand;
    ItemCommand itemCommand;
    EnchantCommand enchantCommand;
    Enchantments enchantments;
    UnknownCommandListener unknowncommandlistener;
    SocialListener socialListener;
    PlayerJoinListener playerjoinlistener;
    ServerListPingListener serverlistpinglistener;
    public ConfigManager configManager;
    PlayerLoginListener playerloginlistener;
    AsyncPlayerChatListener asyncplayerchatlistener;
    AnvilsManager anvilsManager;
    TpposCommand tpposCommand;
    WeatherCommand weatherCommand;
    TimeCommand timeCommand;
    SilentJoinLeaveListener silentJoinLeaveListener;
    ProtectPluginsListener protectPluginsListener;
    RepairCommand repairCommand;
    PlayerDeathListener playerdeathlistener;
    SignColourListener signcolourlistener;
    BorderMapListener bordermaplistener;
    AppleDropListener appledroplistener;
    SpeedCommand speedCommand;
    AutoMessageScheduler automessagescheduler;
    ClearDropsScheduler cleardropsscheduler;
    public Object data;
    
    static {
        ToolsPlugin.chat = false;
    }
    
    public ToolsPlugin() {
        this.lastMessageSender = new HashMap<Player, Player>();
    }
    
    public void onEnable() {
        this.saveDefaultConfig();
        this.listcommand = new ListCommand(this);
        this.chatcommand = new ChatCommand(this);
        this.toolsreloadcommand = new ToolsReloadCommand(this);
        this.pomocommand = new PomocCommand(this);
        this.broadcastcommand = new BroadcastCommand(this);
        this.clearinventorycommand = new ClearInventoryCommand(this);
        this.daycommand = new TimeCommand(this);
        this.enderchestcommand = new EnderChestCommand(this);
        this.invseecommand = new InvSeeCommand(this);
        this.enderseecommand = new EnderSeeCommand(this);
        this.enderclearcommand = new EnderClearCommand(this);
        this.flycommand = new FlyCommand(this);
        this.gamemodecommand = new GamemodeCommand(this);
        this.configManager = new ConfigManager(this);
        this.hatcommand = new HatCommand(this);
        this.healcommand = new HealCommand(this);
        this.tellcommand = new TellCommand(this);
        this.anvilsManager = new AnvilsManager(this);
        this.weatherCommand = new WeatherCommand(this);
        this.tpposCommand = new TpposCommand(this);
        this.timeCommand = new TimeCommand(this);
        this.speedCommand = new SpeedCommand(this);
        this.silentJoinLeaveListener = new SilentJoinLeaveListener(this);
        this.protectPluginsListener = new ProtectPluginsListener(this);
        this.repairCommand = new RepairCommand(this);
        this.itemCommand = new ItemCommand(this);
        this.enchantCommand = new EnchantCommand(this);
        this.enchantments = new Enchantments(this);
        this.replycommand = new ReplyCommand(this);
        this.cobblecommand = new CobbleCommand(this);
        this.tpcommand = new TpCommand(this);
        this.tpherecommand = new TphereCommand(this);
        this.stonecommand = new StoneCommand(this);
        this.sklepsmscommand = new SklepsmsCommand(this);
        this.unknowncommandlistener = new UnknownCommandListener(this);
        this.playerjoinlistener = new PlayerJoinListener(this);
        this.serverlistpinglistener = new ServerListPingListener(this);
        this.socialListener = new SocialListener(this);
        this.playerloginlistener = new PlayerLoginListener(this);
        this.asyncplayerchatlistener = new AsyncPlayerChatListener(this);
        this.playerdeathlistener = new PlayerDeathListener(this);
        this.signcolourlistener = new SignColourListener(this);
        this.bordermaplistener = new BorderMapListener(this);
        this.appledroplistener = new AppleDropListener(this);
        this.automessagescheduler = new AutoMessageScheduler(this);
        this.cleardropsscheduler = new ClearDropsScheduler(this);
    }
    
    public void onDisable() {
    }
    
    public String color(final String string) {
        return string.replaceAll("&([0-9a-z])", "§$1");
    }
    
    public static boolean containsIgnoreCase(final String[] pluginCommands, final String string) {
        return false;
    }
    
    public static void teleportPlayerWithDelay(final Player player, final int delayTime, final Location location, final String string, final Object object) {
    }
    
    public static Material getMaterial(final String string) {
        return null;
    }
    
    public static boolean isFloat(final String string) {
        return false;
    }
    
    public static boolean isInteger(final String string) {
        return false;
    }
}
