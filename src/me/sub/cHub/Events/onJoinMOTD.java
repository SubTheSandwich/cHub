package me.sub.cHub.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import me.sub.cHub.Main;
import me.sub.cHub.files.MOTDConfig;
import me.sub.cHub.utils.Utils;

public class onJoinMOTD implements Listener {
	Main plugin;
	
	public onJoinMOTD(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayer(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		System.out.println(plugin);
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line")));
		p.sendMessage("");
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line1")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line2")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line3")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line4")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line5")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line6")));
		p.sendMessage(Utils.chat(MOTDConfig.get().getString("Line")));
		if (plugin.getConfig().getBoolean("joinMessage") == true) {
			e.setJoinMessage(null);
		} else if (plugin.getConfig().getBoolean("joinMessage") == false) {
			
		}
	
	}
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent e) {
		if (plugin.getConfig().getBoolean("joinMessage") == true) {
			e.setQuitMessage(null);
		}
	}
	

		
	

}
