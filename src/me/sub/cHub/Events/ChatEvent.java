package me.sub.cHub.Events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.sub.cHub.utils.Utils;

public class ChatEvent implements Listener {
	
	Main plugin;
	
	public ChatEvent(Main plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		String vaultrank = PlaceholderAPI.setPlaceholders(p, "%vault_rankprefix%");
		if (plugin.getConfig().getBoolean("disablechat") == true) {
			if (p.hasPermission("hub.chat.bypass")) {
				e.setCancelled(true);
				String message = e.getMessage();
				for (Player vPlayer : Bukkit.getOnlinePlayers()) {
					vPlayer.sendMessage(Utils.chat(vaultrank + p.getName() + "&r: " + message));
				}
			} else {
				e.setCancelled(true);
				p.sendMessage(Utils.chat("&cYou cannot chat in this region."));
			}
		}
	}

}
