package me.sub.cHub.Events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.sub.cHub.utils.Utils;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import me.tigerhix.lib.scoreboard.common.EntryBuilder;
import me.tigerhix.lib.scoreboard.type.Entry;
import me.tigerhix.lib.scoreboard.type.Scoreboard;
import me.tigerhix.lib.scoreboard.type.ScoreboardHandler;

public class LeaveQueueEvent implements Listener {
	
	Main plugin;
	
	public LeaveQueueEvent(Main plugin) {
		this.plugin = plugin;
	}	
	
	public void scoreboardServer2() {
		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
			if (plugin.queueserver2_list.contains(player)) {
				plugin.queueserver2_list.remove(player);
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
	}
	
	public void scoreboardServer1() {
		for (Player player: Bukkit.getServer().getOnlinePlayers()) {
			if (plugin.queueserver1_list.contains(player)) {
				plugin.queueserver1_list.remove(player);
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
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		if (p.getInventory().getItemInHand() != null && p.getInventory().getItemInHand().getType() == Material.LEVER) {
			ItemStack air = new ItemStack(Material.AIR);
			p.getInventory().setItem(6, air);
			p.performCommand("leavequeue");
			p.sendMessage(Utils.chat("&eYou have left your current queue."));
			if (plugin.queueserver1_list.contains(p)) {
				scoreboardServer1();
				return;
			} else 	if (plugin.queueserver2_list.contains(p)) {
				scoreboardServer2();
				return;
			}
		}
		
	}

}
