package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryMoveItemEvent;
import org.bukkit.event.inventory.InventoryType;


public class InventoryMoveEvent implements Listener {
	
	@EventHandler
	public void onPlayerInventoryMove(InventoryMoveItemEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerDragMove(InventoryDragEvent e) {
		e.setCancelled(true);
	}
	
	@EventHandler
	public void onPlayerInventoryClick(InventoryClickEvent e) {
		if (e.getClickedInventory().getType() == InventoryType.PLAYER) {
			e.setCancelled(true);
			
		}
	}

}
