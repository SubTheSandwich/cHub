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

public class SettingsCommand implements CommandExecutor {

	Main plugin;
	
	public SettingsCommand(Main plugin) {
		this.plugin = plugin;
	}
	
	@Override
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("settings")) {
			
			Inventory gui = Bukkit.createInventory(p, 27, Utils.chat(HubConfig.get().getString("SettingsText")));
			
			ItemStack togglepms = new ItemStack(Material.WOOL);
			ItemStack togglesounds = new ItemStack(Material.NOTE_BLOCK);
			ItemStack air = new ItemStack(Material.AIR);
			
			ItemMeta togglepms_meta = togglepms.getItemMeta();
			togglepms_meta.setDisplayName(Utils.chat(HubConfig.get().getString("ToggleDirectMessagesTitle")));
			ArrayList<String> togglepms_lore = new ArrayList<>();
			togglepms_lore.add(Utils.chat(HubConfig.get().getString("ToggleDirectMessagesText")));
			togglepms_meta.setLore(togglepms_lore);
			togglepms.setItemMeta(togglepms_meta);
			
			ItemMeta togglesounds_meta = togglesounds.getItemMeta();
			togglesounds_meta.setDisplayName(Utils.chat(HubConfig.get().getString("ToggleSoundsTitle")));
			ArrayList<String> togglesounds_lore = new ArrayList<>();
			togglesounds_lore.add(Utils.chat(HubConfig.get().getString("ToggleSoundsText")));
			togglesounds_meta.setLore(togglesounds_lore);
			togglesounds.setItemMeta(togglesounds_meta);
			
			ItemStack[] menu_items = {air, air, air, air, air, air, air, air, air, air, air, togglepms, air,air,air, togglesounds};
			gui.setContents(menu_items);
			
			p.openInventory(gui);
		
			
		}
		return false;
	}
	
}
