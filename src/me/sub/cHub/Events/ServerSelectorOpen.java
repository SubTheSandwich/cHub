package me.sub.cHub.Events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ServerSelectorOpen implements Listener {
	

	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e) {
		
		Player p = e.getPlayer();
		Action a = e.getAction();
		if (p.getItemInHand().getType() == Material.WATCH) {
			if (a == Action.RIGHT_CLICK_AIR) {
				p.performCommand("servergui");
			} else if (a == Action.RIGHT_CLICK_BLOCK) {
				p.performCommand("servergui");

			}
		} else if (p.getItemInHand().getType() == Material.REDSTONE) {
			if (a == Action.RIGHT_CLICK_AIR) {
				p.performCommand("settings");
			} else if (a == Action.RIGHT_CLICK_BLOCK) {
				p.performCommand("settings");

			}
			
			
		
		}
	}
	

}
