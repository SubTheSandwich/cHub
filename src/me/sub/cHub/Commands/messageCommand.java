package me.sub.cHub.Commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class messageCommand implements CommandExecutor {
	Main plugin;
	
	public messageCommand(Main main) {
		plugin = main;
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("msg")) {
			Player p = (Player) sender;
			if (sender instanceof Player && args.length > 0) {
				Player reciever = Bukkit.getPlayer(args[0]);
				String vaultrank = PlaceholderAPI.setPlaceholders(reciever, "%vault_rankprefix_" + reciever + "%");
				String vaultrank2 = PlaceholderAPI.setPlaceholders(p, "%vault_rankprefix_" + p + "%");
				if (reciever != null) {
					if (reciever != p) {
						if (args.length > 1) {
							if (!plugin.togglepm_list.contains(reciever)) {
							plugin.mM.setReplyTarget(p, reciever);
								args[0] = "";
								String message = "";
								for(int i = 0; i < args.length; i++) {
									message += "" + args[i];
								}
								p.sendMessage(Utils.chat("&7(To &r" + vaultrank + reciever.getName() + "&7) &r" + message));
								reciever.sendMessage(Utils.chat("&7(From &r" + vaultrank2 + p.getName() + "&7) &r" + message));
								if (plugin.togglesound_list.contains(reciever)) {
									return false;
								} else {
									p.playSound(p.getLocation(), Sound.NOTE_PLING, 10f, 10f);
								}
									
							} else {
								p.sendMessage(Utils.chat("&cYou cannot message " + reciever.getName() + "&c because they have their messages off."));
							}
						} else {
							p.sendMessage(Utils.chat("&cUsage: /msg <player> <message>"));
						}
					} else {
						p.sendMessage(Utils.chat(HubConfig.get().getString("MessageYourself")));
					}
				} else {
					p.sendMessage(Utils.chat("&cUsage: /msg <player> <message>"));
				}
				
			} else {
				p.sendMessage(Utils.chat("&cUsage: /msg <player> <message>"));
			}
		}
		return false;
	}

}
