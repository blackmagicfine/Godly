package com.github.roburrito.bukkit.godly;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.roburrito.bukkit.godly.object.GodlyUniverse;

public class Godly extends JavaPlugin {

	private String version = "0.1";
	
	private GodlyUniverse universe = null;
	
	private boolean error = false;
	
	public void onEnable() {
		version = this.getDescription().getVersion();
		
		//setup classes
		//setup bukkit commands
		
		registerEvents();
		
	}
	
	private void registerEvents() {
		PluginManager pluginmanager = getServer().getPluginManager();
	}
	
	public void onDisable() {
		
	}
	
	public boolean isError() {

		return error;
	}
	
	public GodlyUniverse getGodlyUniverse() {
		return universe;
	}
}
