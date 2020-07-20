package me.sub.cHub.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.sub.cHub.Main;
import me.sub.cHub.utils.Utils;

public class ToggleSoundCommand implements CommandExecutor {
	
	Main plugin;
	
	public ToggleSoundCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("togglesound")) {
			Player p = (Player) sender;
			if (plugin.togglesound_list.contains(p)) {
				plugin.togglesound_list.remove(p);
				p.sendMessage(Utils.chat("&eYou have turned &aon &emessage sounds."));
			} else {
				plugin.togglesound_list.add(p);
				p.sendMessage(Utils.chat("&eYou have turned &coff &emessage sounds."));
				
			}
			
		}
		
		return false;
		
		
	}

}
