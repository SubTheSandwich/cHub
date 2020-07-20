package me.sub.cHub.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class StuckCommand implements CommandExecutor {
	
	
	Main plugin;
	
	public StuckCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("stuck")) {
			if (sender instanceof Player) {
				if (plugin.getConfig().getConfigurationSection("hubspawn") == null) {
					p.sendMessage(Utils.chat(HubConfig.get().getString("StuckNotTeleported")));
				} else {
					World w = Bukkit.getServer().getWorld(plugin.getConfig().getString("defaultWorld"));
					double x = plugin.getConfig().getDouble("hubspawn.x");
					double y = plugin.getConfig().getDouble("hubspawn.y");
					double z = plugin.getConfig().getDouble("hubspawn.z");
					p.teleport(new Location(w, x, y, z));
						
					
				}
				
			} else {
				p.sendMessage("You are not a player.");
				return true;
			}
		}
		
		
		return false;
		
	
	}

}
