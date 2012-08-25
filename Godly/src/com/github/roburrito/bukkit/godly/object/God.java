package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Location;

public class God extends GodlyObject {

	private List<Worshipper> worshippers = new ArrayList<Worshipper>();
	private List<Location> temples = new ArrayList<Location>();
	private Worshipper champion;
	private Location spawn;
	
	public God (String name) {
		
	}
}
