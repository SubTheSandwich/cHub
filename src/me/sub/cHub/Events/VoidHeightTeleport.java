package me.sub.cHub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class VoidHeightTeleport implements Listener {
	
	Main plugin;
	
	public VoidHeightTeleport(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		if (p.getLocation().getBlockY() > plugin.getConfig().getDouble("height-teleport")) {
			System.out.println(plugin.getConfig().getDouble("height-teleport"));
			if (plugin.getConfig().getConfigurationSection("hubspawn") == null) {
				return;
			} else {
				p.performCommand("stuck");
				p.sendMessage(Utils.chat(HubConfig.get().getString("SafetyTeleportMessage")));
			}
		} else if (p.getLocation().getBlockY() <= plugin.getConfig().getDouble("void-teleport")) {
			System.out.println(plugin.getConfig().getDouble("void-teleport"));
			if (plugin.getConfig().getConfigurationSection("hubspawn") == null) {
				return;
			} else {
				p.performCommand("stuck");
				p.sendMessage(Utils.chat(HubConfig.get().getString("SafetyTeleportMessage")));
			}
		}
	}

}
