package me.sub.cHub.Commands;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class replyCommand implements CommandExecutor {
	
	Main plugin;
	
	public replyCommand(Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("reply")) {
			if (args.length > 0) {
				if (sender instanceof Player) {
					if (plugin.mM.getReplyTargrt(p) == null) {
						p.sendMessage(Utils.chat(HubConfig.get().getString("NoOneReplyTo")));
						return false;
					}
					Player reciever = plugin.mM.getReplyTargrt(p);
					String vaultrank = PlaceholderAPI.setPlaceholders(reciever, "%vault_rankprefix_" + reciever + "%");
					String vaultrank2 = PlaceholderAPI.setPlaceholders(p, "%vault_rankprefix_" + p + "%");
					String message = "";
					for(int i = 0; i < args.length; i++) {
						message += " " + args[i];
						
					}
					p.sendMessage(Utils.chat("&7(To &r" + vaultrank + reciever.getName() + "&7)&r" + message));
					reciever.sendMessage(Utils.chat("&7(From &r" + vaultrank2 + p.getName() + "&7)&r" + message));				
					
					if (plugin.togglesound_list.contains(reciever)) {
						return false;
					} else {
						p.playSound(p.getLocation(), Sound.NOTE_PLING, 10f, 10f);
					}
					
					
					return true;
				}
			} else {
				p.sendMessage(Utils.chat("&cUsage: /reply <message>"));
			}
		}
		return false;
	}
	

}
