package me.sub.cHub.Events;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.sub.cHub.Main;

public class DoubleJump implements Listener {
	
	Main plugin;
	
	public DoubleJump(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	@SuppressWarnings("deprecation")
	public void onPlayerMove(PlayerMoveEvent e) {
		if (plugin.getConfig().getBoolean("doublejump") == true) {
			Player p = e.getPlayer();
			if (p.getGameMode().equals(GameMode.CREATIVE)) {
				return;
			}
			
			if (p.isOnGround()) {
				if (!p.getAllowFlight()) {
					p.setAllowFlight(true);
					
				}
			}
		}
	}

}
