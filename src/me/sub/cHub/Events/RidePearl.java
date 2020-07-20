package me.sub.cHub.Events;

import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import me.sub.cHub.Main;

public class RidePearl implements Listener {
	
	Main plugin;
	
	public RidePearl(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if (plugin.getConfig().getBoolean("enderbutts") == true) {
		
			if (p.getInventory().getItemInHand() != null && p.getInventory().getItemInHand().getType() == Material.ENDER_PEARL) {
				if (a == Action.RIGHT_CLICK_AIR || a == Action.RIGHT_CLICK_BLOCK) {
					
					EnderPearl pe = p.launchProjectile(EnderPearl.class);
					
					pe.setVelocity(p.getLocation().getDirection());
					pe.setPassenger(p);
					
	
					PlayerInventory inventory = p.getInventory();
					inventory.addItem(new ItemStack(Material.ENDER_PEARL));
				}
			}
		} 
	}

}
