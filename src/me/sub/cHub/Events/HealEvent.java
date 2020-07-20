package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.FoodLevelChangeEvent;

public class HealEvent implements Listener {
	
	@EventHandler
	public void loseHunger(FoodLevelChangeEvent e) {
		e.setCancelled(true);
	}

}
