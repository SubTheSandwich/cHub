package me.sub.cHub.Events;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.clip.placeholderapi.PlaceholderAPI;
import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;
import me.tigerhix.lib.scoreboard.ScoreboardLib;
import me.tigerhix.lib.scoreboard.common.EntryBuilder;
import me.tigerhix.lib.scoreboard.type.Entry;
import me.tigerhix.lib.scoreboard.type.Scoreboard;
import me.tigerhix.lib.scoreboard.type.ScoreboardHandler;

public class ServerSelectEvents implements Listener {
	
	
	
	@SuppressWarnings("incomplete-switch")
	@EventHandler
	public void clickEvent(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		if (e.getClickedInventory().getTitle().equalsIgnoreCase(Utils.chat("&eServer Selector"))) {
			switch(e.getCurrentItem().getType()) {
			case DIAMOND_SWORD:
				p.closeInventory();
				p.performCommand("play " + plugin.getConfig().getString("Servers.Server1.Server1-server-queue-name"));
				p.sendMessage(Utils.chat("&eYou have queued for &b" + plugin.getConfig().getString("Servers.Server1.Server1-server-queue-name") + "&e."));
				if (plugin.queueserver2_list.contains(p)) {
					plugin.queueserver2_list.remove(p);
				} 
				plugin.queueserver1_list.add(p);
				ezqueueScoreboardhcf();
				
				ItemStack lever = new ItemStack(Material.LEVER);
				ItemMeta lh = lever.getItemMeta();
				lh.setDisplayName(Utils.chat(HubConfig.get().getString("LeaveQueueText")));
				
				lever.setItemMeta(lh);
				p.getInventory().setItem(6, lever);
				return;
			case DIAMOND_AXE:
				p.closeInventory();
				p.performCommand("play " + plugin.getConfig().getString("Servers.Server2.Server2-server-queue-name"));
				p.sendMessage(Utils.chat("&eYou have queued for &b" + plugin.getConfig().getString("Servers.Server2.Server2-server-queue-name") + "&e."));
				if (plugin.queueserver1_list.contains(p)) {
					plugin.queueserver1_list.remove(p);
				} 
				plugin.queueserver2_list.add(p);
				ezqueueScoreboardpractice();
				
				ItemStack lever1 = new ItemStack(Material.LEVER);
				ItemMeta lh1 = lever1.getItemMeta();
				lh1.setDisplayName(Utils.chat(HubConfig.get().getString("LeaveQueueText")));
				
				lever1.setItemMeta(lh1);
				p.getInventory().setItem(6, lever1);	
				return;
				
				
				
				
			}
			
			e.setCancelled(true);
			
		} 
		
	}

	
	public void ezqueueScoreboardpractice() {
		for (Player vPlayer: Bukkit.getServer().getOnlinePlayers()) {
			if (plugin.queueserver2_list.contains(vPlayer)) {
			    Scoreboard scoreboard = ScoreboardLib.createScoreboard(vPlayer)
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
			            	String serverbungee = PlaceholderAPI.setPlaceholders(player, "%bungee_" + plugin.getConfig().getString("Servers.Server2.Server2-server-queue-name") + "%");
			                return new EntryBuilder()
			                		.next("       " + plugin.getConfig().getString("Scoreboard.maincolor") + "&l" +  plugin.getConfig().getString("Scoreboard.title") + " &7┃ &r" + plugin.getConfig().getString("Scoreboard.lobby-name"))
			                		.next("&7&m----------------------")
			                		.next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Rank")
				                    .next(vaultrank2 + vaultrank1)
				                    .blank()
				                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Online")
				                    .next("&f" + replaced)
				                    .blank()
				                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Queue")
				                    .next("  " + plugin.getConfig().getString("Scoreboard.secondarycolor") + "Server: &r" + plugin.getConfig().getString("Servers.Server2.Server2-server-queue-name"))
				                    .next("  " + plugin.getConfig().getString("Scoreboard.secondarycolor") + "Player Count: &r" + serverbungee )
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
	public void ezqueueScoreboardhcf() {
		for (Player vPlayer: Bukkit.getServer().getOnlinePlayers()) {
			if (plugin.queueserver1_list.contains(vPlayer)) {
			    Scoreboard scoreboard = ScoreboardLib.createScoreboard(vPlayer)
			        .setHandler(new ScoreboardHandler() {
			        	
	
			            @Override
			            public String getTitle(Player player) {
			                return null;
			            }
			            
			            
	
	
			            @Override
			            public List<Entry> getEntries(Player vPlayer) {
			            	String replaced = PlaceholderAPI.setPlaceholders(vPlayer, "%bungee_total%");
			            	String vaultrank1 = PlaceholderAPI.setPlaceholders(vPlayer, "%vault_rank%");
			            	String vaultrank2 = PlaceholderAPI.setPlaceholders(vPlayer, "%vault_prefix_color%");
			            	String serverbungee2 = PlaceholderAPI.setPlaceholders(vPlayer, "%bungee_" + plugin.getConfig().getString("Servers.Server1.Server1-server-queue-name") + "%");
			                return new EntryBuilder()
			                		.next("       " + plugin.getConfig().getString("Scoreboard.maincolor") + "&l" +  plugin.getConfig().getString("Scoreboard.title") + " &7┃ &r" + plugin.getConfig().getString("Scoreboard.lobby-name"))
				                    .next("&7&m----------------------")
				                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Rank")
				                    .next(vaultrank2 + vaultrank1)
				                    .blank()
				                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Online")
				                    .next("&f" + replaced)
				                    .blank()
				                    .next(plugin.getConfig().getString("Scoreboard.maincolor") + "&l" + "Queue")
				                    .next("  " + plugin.getConfig().getString("Scoreboard.secondarycolor") + "Server: &r" + plugin.getConfig().getString("Servers.Server1.Server1-server-queue-name"))
				                    .next("  " + plugin.getConfig().getString("Scoreboard.secondarycolor") + "Player Count: &r" + serverbungee2 )
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
	
	Main plugin;
	
	public ServerSelectEvents(Main plugin) {
		this.plugin = plugin;
	}
	

}
