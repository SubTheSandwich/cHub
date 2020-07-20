package me.sub.cHub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class SettingEvents implements Listener {
	
	@SuppressWarnings("incomplete-switch")
	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		
		if (e.getClickedInventory().getTitle().equalsIgnoreCase(Utils.chat(HubConfig.get().getString("SettingsText")))) {
			switch(e.getCurrentItem().getType()) {
			case WOOL:
				p.performCommand("togglepm");
				p.closeInventory();
				return;
			case NOTE_BLOCK:
				p.performCommand("togglesounds");
				p.closeInventory();
				return;
				
				
				
			}
		
		}
	}

}
