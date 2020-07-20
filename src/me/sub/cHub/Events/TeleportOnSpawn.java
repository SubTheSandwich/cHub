package me.sub.cHub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.sub.cHub.Main;

public class TeleportOnSpawn implements Listener {
	
	Main plugin;
	
	public TeleportOnSpawn(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		p.performCommand("stuck");
	}

}
