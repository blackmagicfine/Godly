package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;


import com.github.roburrito.bukkit.godly.exceptions.EmptyShrineException;
import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.EmptyTownException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

public class Worshipper extends ShrineBlockOwner {

	
	private List<Object[][][]> regenUndo = new ArrayList<Object[][][]>();
	private List<String> modes = new ArrayList<String>();
	private List<String> shrineRanks = new ArrayList<String>();
	private List<String> godRanks = new ArrayList<String>();
	private Shrine shrine;
	private God god;

	public Worshipper(String name) {
		setName(name);
		permissions.loadDefault(this);
	}

	public boolean isChampion() {
		if(hasGod()) {
			return god.isChampion(this);
		}

		return false;
	}

	public boolean hasGod() {
		if(god != null) {
			return true;
		}

		return false;
	}

	public God getGod() throws NotRegisteredException {
		if(hasGod()) {
			return god;
		} else {
			throw new NotRegisteredException("Worshipper has no god!");
		}
	}

	public boolean hasShrine() {
		if(shrine != null) {
			return true;
		}

		return false;
	}

	public Shrine getShrine() throws NotRegisteredException {
		if(hasShrine()) {
			return shrine;
		} else {
			throw new NotRegisteredException("Worshipper has no shrine!");
		}
	}

	public void setShrine(Shrine shrine) throws AlreadyRegisteredException {
		if(!hasShrine()) {
			this.shrine = shrine;
		} else {
			throw new AlreadyRegisteredException("Worshipper already has a shrine!");
		}
	}

	public void clear() throws EmptyShrineException {
		if(hasGod()) {
			try {
				god.removeWorshipper(this);
			} catch (NotRegisteredException e) {
			}
		}

		if(hasShrine()) {
			try {
				shrine.removeWorshipper(this);
			} catch (NotRegisteredException e) {
			}
		}
	}

	public int getFavor(God god) {
		// TODO Auto-generated method stub
		return 0;
	}
}