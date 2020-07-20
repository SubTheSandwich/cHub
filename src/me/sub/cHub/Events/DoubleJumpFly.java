package me.sub.cHub.Events;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import me.sub.cHub.Main;

public class DoubleJumpFly implements Listener {
	
	Main plugin;
	
	public DoubleJumpFly(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerToggleFly(PlayerToggleFlightEvent e) {
		if (plugin.getConfig().getBoolean("doublejump") == true) {
			Player p = e.getPlayer();
			if (p.getGameMode().equals(GameMode.CREATIVE)) {
				return;
			}
			
			e.setCancelled(true);
			p.setFlying(false);
			p.setAllowFlight(false);
			Location loc = p.getLocation();
			Vector v = loc.getDirection().multiply(2.2);
			p.setVelocity(v);
			loc.getWorld().playSound(loc, Sound.FIREWORK_BLAST, 1, 0.2f);
		}
		
	}

}
