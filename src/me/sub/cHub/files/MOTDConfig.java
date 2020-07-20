package me.sub.cHub.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class MOTDConfig {

private static File file;
	
	private static FileConfiguration motdConfig;
	
	public static void setup() {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("cHub").getDataFolder(), "motd.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		motdConfig = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public static FileConfiguration get() {
		return motdConfig;
	}
	
	public static void save() {
		try {
			motdConfig.save(file);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void reload() {
		motdConfig = YamlConfiguration.loadConfiguration(file);
	}


}
