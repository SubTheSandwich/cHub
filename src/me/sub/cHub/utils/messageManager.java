package me.sub.cHub.utils;

import java.util.HashMap;

import org.bukkit.entity.Player;

import me.sub.cHub.Main;

public class messageManager {
	Main plugin;
	
	HashMap<Player,Player> conversations = new HashMap<Player,Player>();
	
	
	public messageManager(Main main) {
		plugin = main;
	}
	
	
	public void setReplyTarget(Player messanger, Player reciever) {
		conversations.put(messanger, reciever);
		conversations.put(reciever, messanger);
	}
	
	public Player getReplyTargrt(Player messanger) {
		return conversations.get(messanger);
	}

}
