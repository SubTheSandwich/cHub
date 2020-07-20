package me.sub.cHub.Events;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.sub.cHub.files.HubConfig;
import me.sub.cHub.utils.Utils;

public class HidePlayerEvents implements Listener {
	
	@EventHandler
	public void onPlayerUse(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		Action a = e.getAction();
		if (a == Action.RIGHT_CLICK_AIR) {
			if (p.getItemInHand().getType() == Material.TORCH) {
				for (Player vPlayer : Bukkit.getServer().getOnlinePlayers()) {
					p.hidePlayer(vPlayer);
				}
				ItemStack redtorch = new ItemStack(Material.REDSTONE_TORCH_ON);
				ItemMeta rth = redtorch.getItemMeta();
				rth.setDisplayName(Utils.chat(HubConfig.get().getString("ShowAllText")));
				redtorch.setItemMeta(rth);
				p.getInventory().setItem(8, redtorch);
				p.sendMessage(Utils.chat(HubConfig.get().getString("HideAll")));
			} else if (p.getItemInHand().getType() == Material.REDSTONE_TORCH_ON) {
				for (Player vPlayer : Bukkit.getServer().getOnlinePlayers()) {
					p.showPlayer(vPlayer);
				}
				p.sendMessage(Utils.chat((HubConfig.get().getString("ShowAll"))));
				ItemStack torch = new ItemStack(Material.TORCH);
				ItemMeta th = torch.getItemMeta();
				th.setDisplayName(Utils.chat(HubConfig.get().getString("HideAllText")));
				torch.setItemMeta(th);
				p.getInventory().setItem(8, torch);
			}
		}
	}

}
