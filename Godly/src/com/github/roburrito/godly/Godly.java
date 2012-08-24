package com.github.roburrito.godly;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Godly extends JavaPlugin {

	private String version = "0.1";
	
	public void onEnable() {
		version = this.getDescription().getVersion();
		
		//setup classes
		//setup bukkit commands
		
	}
	
	private void registerEvents() {
		PluginManager pluginmanager = getServer().getPluginManager();
	}
}
