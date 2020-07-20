package me.sub.cHub.Commands;




import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;


public class HubCommand implements CommandExecutor {

	Main plugin;
	
	public HubCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p =  (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("hub")) {
			if (p.hasPermission("hub.admin")) {
				if (args.length == 0) {
					p.sendMessage(Utils.chat("&cUsage: /hub help"));
				} else if (args.length == 1 && args[0].equalsIgnoreCase("help")) {
					p.sendMessage(Utils.chat("&6/hub setspawn"));
				} else if (args.length == 1 && args[0].equalsIgnoreCase("setspawn")) {
					if (sender instanceof Player) {
						if (plugin.getConfig().getConfigurationSection("hubspawn") == null) {
							p.sendMessage(Utils.chat(HubConfig.get().getString("HubSetSpawn")));	
							plugin.getConfig().set("hubspawn.x", p.getLocation().getX());
							plugin.getConfig().set("hubspawn.y", p.getLocation().getY());
							plugin.getConfig().set("hubspawn.z", p.getLocation().getZ());
							plugin.saveConfig();
						} else {
							p.sendMessage(Utils.chat(HubConfig.get().getString("HubSetSpawnAlreadySet")));
							
						}
						
					}
						
				} 
			}
		}
		return false;
	}
	
	

}
