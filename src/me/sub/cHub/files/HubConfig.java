package me.sub.cHub.files;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

public class HubConfig {
	
	private static File file;
	
	private static FileConfiguration hubConfig;
	
	public static void setup() {
		file = new File(Bukkit.getServer().getPluginManager().getPlugin("cHub").getDataFolder(), "messages.yml");
		
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println(e);
			}
		}
		hubConfig = YamlConfiguration.loadConfiguration(file);
		
	}
	
	public static FileConfiguration get() {
		return hubConfig;
	}
	
	public static void save() {
		try {
			hubConfig.save(file);
		} catch (IOException e) {
			System.out.println(e);
		}
	}
	
	public static void reload() {
		hubConfig = YamlConfiguration.loadConfiguration(file);
	}

}
