package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.TownyEconomyObject;

public class God extends TownyEconomyObject {

	private List<Worshipper> worshippers = new ArrayList<Worshipper>();
	private List<Location> temples = new ArrayList<Location>();
	private Worshipper champion;
	private Location spawn;
	
	public God (String name) {
		
	}
	
	public boolean isChampion(Worshipper worshipper) {
		if(champion == worshipper) {
			return true;
		}
		
		return false;
	}
	
	public void removeWorshipper(Worshipper worshipper) throws NotRegisteredException {
		
	}
}
