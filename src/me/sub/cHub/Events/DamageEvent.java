package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

public class DamageEvent implements Listener {
	
	@EventHandler
	public void playerDamage(EntityDamageEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void playerDamagePlayer(EntityDamageByEntityEvent e) {
		e.setCancelled(true);
	}

}
