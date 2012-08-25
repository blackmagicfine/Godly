package com.github.roburrito.bukkit.godly.object;


import org.bukkit.entity.Player;

import com.github.roburrito.bukkit.godly.Godly;
import com.github.roburrito.bukkit.tasks.OnPlayerLogin;
import com.github.roburrito.bukkit.util.BukkitTools;


public class GodlyUniverse extends GodlyObject {

	private Godly plugin;
	
	
	public void onLogin(Player player) {
		
		if (!player.isOnline())
			return;

		// Test and kick any players with invalid names.
		if ((player.getName().trim() == null) || (player.getName().contains(" "))) {
			player.kickPlayer("Invalid name!");
			return;
		}
		
		// Perform login code in it's own thread to update Towny data.
		//new OnPlayerLogin(plugin, player).start();
		if (BukkitTools.scheduleSyncDelayedTask(new OnPlayerLogin(plugin,player),0L) == -1);
	}
	
}
