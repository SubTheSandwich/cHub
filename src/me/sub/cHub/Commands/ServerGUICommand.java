package me.sub.cHub.Commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.sub.cHub.Main;
import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class ServerGUICommand implements CommandExecutor {

	Main plugin;
	
	public ServerGUICommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (sender instanceof Player) {
			
			Inventory gui = Bukkit.createInventory(p, 27, Utils.chat(HubConfig.get().getString("ServerSelectorText")));
			
			ItemStack hcf = new ItemStack(Material.DIAMOND_SWORD);
			ItemStack air = new ItemStack(Material.AIR);
			ItemStack practice = new ItemStack(Material.DIAMOND_AXE);
			
			ItemMeta hcf_meta = hcf.getItemMeta();
			hcf_meta.setDisplayName(Utils.chat(plugin.getConfig().getString("Scoreboard.maincolor") + plugin.getConfig().getString("Servers.Server1.Server1-server-selector-name")));
			ArrayList<String> hcf_lore = new ArrayList<>();
			hcf_lore.add(Utils.chat(plugin.getConfig().getString("Scoreboard.secondarycolor") + plugin.getConfig().getString("Servers.Server1.Server1-server-lore")));
			hcf_meta.setLore(hcf_lore);
			hcf.setItemMeta(hcf_meta);
			
			
			
			ItemMeta practice_meta = practice.getItemMeta();
			practice_meta.setDisplayName(Utils.chat(plugin.getConfig().getString("Scoreboard.maincolor") + plugin.getConfig().getString("Servers.Server2.Server2-server-selector-name")));
			ArrayList<String> practice_lore = new ArrayList<>();
			practice_lore.add(Utils.chat(plugin.getConfig().getString("Scoreboard.secondarycolor") + plugin.getConfig().getString("Servers.Server2.Server2-server-lore")));
			practice_meta.setLore(practice_lore);
			practice.setItemMeta(practice_meta);
			
			ItemStack[] menu_items = {air, air, air, air, air, air, air, air, air, air, air, hcf,air,air,air,practice};
			gui.setContents(menu_items);
			p.openInventory(gui);
		}
		
		
		
		
		return false;
		
		
	}
}
