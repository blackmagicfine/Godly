package com.github.roburrito.bukkit.godly;

import org.bukkit.World;

import com.github.roburrito.bukkit.godly.exceptions.FavorException;
import com.github.roburrito.bukkit.godly.object.God;

public class GodlyFavorHandler {

	private static Godly plugin = null;
	
	
	
	public static void initilize(Godly plugin) {
		GodlyFavorHandler.plugin = plugin;
	}

	public static boolean isActive() {
		return true;
	}

	public static boolean setupFavor() {
		return true;
	}
	
	public static boolean subtract(String string, God god, int amount, World bukkitWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void add(String favorName, God god, int amount,
			World bukkitWorld) {
		// TODO Auto-generated method stub
		
	}

	public static void setFavor(String favorName, God god, int amount,
			World bukkitWorld) {
		// TODO Auto-generated method stub
		
	}

	public static int getFavor(String favorName, God god, World bukkitWorld) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static boolean hasEnough(String favorName, God god, int amount,
			World bukkitWorld) {
		// TODO Auto-generated method stub
		return false;
	}

	public static String getFormattedBalance(String favorName, God god) throws FavorException{
		// TODO Auto-generated method stub
		return null;
	}

	public static void removeAccount(String favorName) {
		// TODO Auto-generated method stub
		
	}
	
	
}
