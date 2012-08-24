package com.github.roburrito.godly.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.roburrito.godly.Godly;

public class GodlyPlayerListener implements Listener {
	
	private final Godly plugin;
	
	public GodlyPlayerListener (Godly instance) {
		plugin = instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		
		if(plugin.isError()) {
			player.sendMessage("[Godly Error] Locked in safe mode!");
			return;
		}
		
		
	}
}
