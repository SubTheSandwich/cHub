package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class DropPickEvent implements Listener {
	
	@EventHandler
	public void onItemPickup(PlayerPickupItemEvent e) {
		e.setCancelled(true);
		
	}

}
