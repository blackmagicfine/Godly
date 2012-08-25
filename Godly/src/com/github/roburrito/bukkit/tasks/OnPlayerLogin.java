package com.github.roburrito.bukkit.tasks;

import org.bukkit.entity.Player;

import com.github.roburrito.bukkit.godly.Godly;
import com.github.roburrito.bukkit.godly.object.GodlyUniverse;

public class OnPlayerLogin implements Runnable{

	Godly plugin;
	GodlyUniverse universe;
	volatile Player player;
	
	public OnPlayerLogin(Godly plugin, Player player) {
		
		this.plugin = plugin;
		this.universe = plugin.getGodlyUniverse();
		this.player = player;
		
	}
	
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
