package pl.xBartekTools;

import java.io.*;
import org.bukkit.configuration.file.*;
import java.util.*;
import org.bukkit.*;

public class AnvilsManager
{
    ToolsPlugin plugin;
    FileConfiguration data;
    
    public AnvilsManager(final ToolsPlugin plugin) {
        this.plugin = plugin;
        this.data = (FileConfiguration)YamlConfiguration.loadConfiguration(new File(this.plugin.getDataFolder(), "anvils.yml"));
        this.setup();
    }
    
    public void saveData() {
        try {
            this.data.save(new File(this.plugin.getDataFolder(), "anvils.yml"));
        }
        catch (Exception e) {
            System.out.println("Wystapil blad podczas zapisu pliku anvils.yml");
        }
    }
    
    public void setup() {
        if (!this.data.isList("anvils")) {
            final List<?> anvils = new ArrayList<Object>();
            this.data.set("anvils", (Object)anvils);
            this.saveData();
        }
    }
    
    public void addAnvil(final Location location) {
        location.getWorld().getName();
        location.getBlockX();
        location.getBlockY();
        location.getBlockZ();
        final List<?> anvils = this.data.getStringList("anvils");
        this.data.set("anvils", (Object)anvils);
        this.saveData();
    }
    
    public void deleteAnvil(final Location location) {
        final String worldName = location.getWorld().getName();
        final int x = location.getBlockX();
        final int y = location.getBlockY();
        final int z = location.getBlockZ();
        final List<?> anvils = this.data.getStringList("anvils");
        anvils.remove(String.valueOf(worldName) + " " + x + " " + y + " " + z);
        this.data.set("anvils", (Object)anvils);
        this.saveData();
    }
    
    public boolean isAnvil(final Location location) {
        final String worldName = location.getWorld().getName();
        final int x = location.getBlockX();
        final int y = location.getBlockY();
        final int z = location.getBlockZ();
        final List<?> anvils = this.data.getStringList("anvils");
        return anvils.contains(String.valueOf(worldName) + " " + x + " " + y + " " + z);
    }
}
