package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.List;

import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.TownyWorld;

public class GodlyWorld extends TownyWorld {

	private List<Shrine> shrines = new ArrayList<Shrine>();
	
	public GodlyWorld(String name) {
		super(name);
		
	}
	
	public List<Shrine> getShrines() {
		return shrines;
	}

	public boolean hasShrine(Shrine shrine) {
		// TODO Auto-generated method stub
		return false;
	}

	public void removeShrine(Shrine shrine) throws NotRegisteredException{
		// TODO Auto-generated method stub
		
	}

	public void addShrine(Shrine shrine) throws AlreadyRegisteredException{
		// TODO Auto-generated method stub
		
	}

	public void removeShrineBlocks(List<ShrineBlock> shrineBlocks) throws NotRegisteredException {
		
	}
}
