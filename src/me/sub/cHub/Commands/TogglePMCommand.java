package me.sub.cHub.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class TogglePMCommand implements CommandExecutor {
	
	Main plugin;
	
	public TogglePMCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("togglepm")) {
			Player p = (Player) sender;
			if (plugin.togglepm_list.contains(p)) {
				plugin.togglepm_list.remove(p);
				p.sendMessage(Utils.chat(HubConfig.get().getString("TogglePMOn")));
			} else {
				plugin.togglepm_list.add(p);
				p.sendMessage(Utils.chat(HubConfig.get().getString("TogglePMOff")));
				
					
				
				
			}
			
		}
		
		return false;
		
		
	}

}
