package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class DropEvent implements Listener {
	
	@EventHandler 
	public void onDropEvent(PlayerDropItemEvent e) {
		e.setCancelled(true);
	}

}
