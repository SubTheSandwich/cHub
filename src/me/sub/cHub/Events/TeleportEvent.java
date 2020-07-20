package me.sub.cHub.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.player.PlayerTeleportEvent.TeleportCause;

public class TeleportEvent implements Listener{
	
    @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent event) {
       
        if(event.getCause() == TeleportCause.ENDER_PEARL) {
            event.setCancelled(true);
        }
    }
}
