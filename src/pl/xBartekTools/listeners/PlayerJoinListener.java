package pl.xBartekTools.listeners;

import pl.xBartekTools.*;
import org.bukkit.plugin.*;
import org.bukkit.event.player.*;
import org.bukkit.inventory.*;
import org.bukkit.entity.*;
import org.bukkit.*;
import org.bukkit.event.*;

public class PlayerJoinListener implements Listener
{
    ToolsPlugin plugin;
    
    public PlayerJoinListener(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents((Listener)this, (Plugin)plugin);
    }
    
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        final Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            final ItemStack stonepickaxe = new ItemStack(Material.STONE_PICKAXE);
            final ItemStack cookedbeef = new ItemStack(Material.COOKED_BEEF, 128);
            final ItemStack torch = new ItemStack(Material.TORCH, 16);
            final ItemStack sapling = new ItemStack(Material.SAPLING);
            final ItemStack enderchest = new ItemStack(Material.ENDER_CHEST);
            player.getEnderChest().addItem(new ItemStack[] { stonepickaxe });
            player.getEnderChest().addItem(new ItemStack[] { cookedbeef });
            player.getEnderChest().addItem(new ItemStack[] { torch });
            player.getEnderChest().addItem(new ItemStack[] { sapling });
            player.getEnderChest().addItem(new ItemStack[] { enderchest });
            Bukkit.broadcastMessage(this.plugin.getConfig().getString("config.messages.newplayer").replace("&", "§").replace("%PLAYER%", player.getName()));
            final World world = Bukkit.getWorld("world");
            player.teleport(world.getSpawnLocation());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)this.plugin, (Runnable)new Runnable() {
                @Override
                public void run() {
                    player.sendMessage(PlayerJoinListener.this.plugin.color("&7[&c*&7] &7Nie zapomnij o startowych itemach w enderchest!"));
                }
            }, 200L);
        }
        if (player.hasPermission("tools.adminjoinmsg")) {
            Bukkit.broadcastMessage(this.plugin.getConfig().getString("config.messages.adminjoin").replace("&", "§").replace("%PLAYER%", player.getName()));
        }
        final int players = Bukkit.getOnlinePlayers().length;
        int licznik = 0;
        int offline = 0;
        int online = 0;
        offline = Bukkit.getOfflinePlayers().length;
        online = Bukkit.getOnlinePlayers().length;
        licznik = offline + online;
        player.sendMessage(this.plugin.color(" §3|------------| §7IS&cHC.PL §3|------------|"));
        player.sendMessage(this.plugin.color(" §f> §7Witaj: §9" + player.getName()));
        player.sendMessage(this.plugin.color(" §f> §7Graczy online: §9" + players + "/" + Bukkit.getMaxPlayers()));
        player.sendMessage(this.plugin.color(" §f> §7Ten serwer odwiedzilo juz: §9" + licznik + " §7graczy"));
        player.sendMessage(this.plugin.color(" §f> §7Facebook: §9fb.com/xbartek.yt.5"));
        player.sendMessage(this.plugin.color(" §3|---------------------------------|"));
    }
}
