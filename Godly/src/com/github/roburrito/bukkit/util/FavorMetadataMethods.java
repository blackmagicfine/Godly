package com.github.roburrito.bukkit.util;
/*TODO: FIX IMPORT LIST*/
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;

import com.github.roburrito.bukkit.godly.Godly;

public class FavorMetadataMethods {
	
	/*Primarily used when printing messages.*/
	public final String godlyNames[] = {"Arcamorde", "Terra", "Aegis", "Zi", "Raz", "Meta"}; 
	/*Array of metadata keys for obtaining a player's favor with a particular god.*/
	public final String godlyFavors[] = {"Arcamorde_Favor", "Terra_Favor", "Aegis_Favor", "Zi_Favor", "Raz_Favor", "Meta_Favor"}; 
	public final int NullFavor = Integer.MIN_VALUE;
	private final Godly plugin;
	
	public FavorMetadataMethods(Godly plugin) {
		this.plugin = plugin;
	}
	
	/*This method is for ease of access, so we don't have to constantly deal with large numbers.
	 * NOTE: Strings following the format from either godlyNames[] or godlyFavors[] will work for this method.*/
	public int getRank(Player player, String god) {
		int exp;
		String key;
		
		if(!god.endsWith("_Favor"))
			key = god.concat("_Favor");
		else
			key = god;
		exp = getMetadata(player, key);

		if(exp == NullFavor)
			return -5; /*The player's favor for a god does not exist, and they should contact a moderator/admin immediately!*/
		else if(exp <= -2000)
			return -4;
		else if((exp > -2000) && (exp <= -1500))
			return -3;
		else if((exp > -1500) && (exp <= -1000))
			return -2;
		else if((exp > -1000) && (exp <= -500))
			return -1;
		else if((exp > -500) && (exp < 500))
			return 0;
		else if((exp >= 500) && (exp < 1000))
			return 1;
		else if((exp >= 1000) && (exp < 1500))
			return 2;
		else if((exp >= 1500) && (exp < 2000))
			return 3;
		else 
			return 4;
	}
	
	/*This method is for ease of access, so we don't have to constantly deal with large numbers.
	 * NOTE: Strings following the format from either godlyNames[] or godlyFavors[] will work for this method.*/
	public void changeFavor(Player player, String god, int favorDifference) {
		String key;
		int currentFavor, newFavor;
		
		if(!god.endsWith("_Favor"))
			key = god.concat("_Favor");
		else
			key = god;
		
		currentFavor = getMetadata(player, key);
		newFavor = currentFavor + favorDifference;
		setMetadata(player, key, newFavor);
	}
	
	/*Refrain from using this outside this class when possible (except when initializing data).*/
	public void setMetadata(Player player, String key, int value) {
		player.setMetadata(key, new FixedMetadataValue(plugin, value));
	}
		
	/*Refrain from using this outside this class when possible (except when initializing data).*/
	public int getMetadata(Player player, String key) {
		/*The list is here because there may be multiple plugins that use the same key*/
		List<MetadataValue> values = player.getMetadata(key);  
		for(MetadataValue value : values){
			if(value.getOwningPlugin().getDescription().getName().equals(plugin.getDescription().getName())){
				return value.asInt();
			}
		}
		/*This should only occur if the player does not have the corresponding favor.*/
		return NullFavor;
	}

}
