package me.sub.cHub.Events;


import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import me.tigerhix.lib.scoreboard.common.EntryBuilder;
import me.tigerhix.lib.scoreboard.type.Entry;
import me.tigerhix.lib.scoreboard.type.Scoreboard;
import me.tigerhix.lib.scoreboard.type.ScoreboardHandler;


public class JoinScoreboardEvent implements Listener {
	
	Main plugin;
	
	public JoinScoreboardEvent(Main plugin) {
		this.plugin = plugin;
	}	
	
	public void scoreboard() {
		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
		    Scoreboard scoreboard = ScoreboardLib.createScoreboard(player)
		        .setHandler(new ScoreboardHandler() {
		        	

		            @Override
		            public String getTitle(Player player) {
		                return null;
		            }


		            @Override
		            public List<Entry> getEntries(Player player) {
		            	String replaced = PlaceholderAPI.setPlaceholders(player, "%bungee_total%");
		            	String vaultrank1 = PlaceholderAPI.setPlaceholders(player, "%vault_rank%");
		            	String vaultrank2 = PlaceholderAPI.setPlaceholders(player, "%vault_prefix_color%");
		                return new EntryBuilder()
			                    .next("       " + plugin.getConfig().getString("Scoreboard.maincolor") + "&l" +  plugin.getConfig().getString("Scoreboard.title") + " &7┃ &r" + plugin.getConfig().getString("Scoreboard.lobby-name"))
			                    .next("&7&m----------------------")
			                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Rank")
			                    .next(vaultrank2 + vaultrank1)
			                    .blank()
			                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Online")
			                    .next("&f" + replaced)
			                    .blank()
			                    .next("&7&o" + plugin.getConfig().getString("Scoreboard.server-url"))
			                    .next("&7&m----------------------")
			                    .build();
		                	
		            }

		       })
		       .setUpdateInterval(2l);
		    scoreboard.deactivate();
		    scoreboard.activate();
		    
		}
	}
	
	
	
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		scoreboard();
		
	}
	
 
}
