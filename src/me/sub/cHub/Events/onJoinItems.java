package me.sub.cHub.Events;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class onJoinItems implements Listener{
	
	Main plugin;
	
	public onJoinItems(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayer(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		p.getInventory().clear();
		
		if (plugin.getConfig().getBoolean("enderbutts") == true) {
			ItemStack ender = new ItemStack(Material.ENDER_PEARL, 1);
			p.getInventory().setItem(0, ender);
		}
		
		ItemStack clock = new ItemStack(Material.WATCH);
		ItemMeta cd = clock.getItemMeta();
		cd.setDisplayName(Utils.chat(HubConfig.get().getString("ServerSelectorText")));
		clock.setItemMeta(cd);
		p.getInventory().setItem(4, clock);
		
		ItemStack redstone = new ItemStack(Material.REDSTONE);
		ItemMeta rd = clock.getItemMeta();
		rd.setDisplayName(Utils.chat(HubConfig.get().getString("SettingsText")));
		redstone.setItemMeta(rd);
		p.getInventory().setItem(2, redstone);
		
		ItemStack torch = new ItemStack(Material.TORCH);
		ItemMeta th = torch.getItemMeta();
		th.setDisplayName(Utils.chat(HubConfig.get().getString("HideAllText")));
		torch.setItemMeta(th);
		p.getInventory().setItem(8, torch);
		p.setGameMode(GameMode.SURVIVAL);
		
		p.setHealth(20);
		p.setFoodLevel(20);
		
	}

}
