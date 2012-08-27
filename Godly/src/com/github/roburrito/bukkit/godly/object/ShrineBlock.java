package com.github.roburrito.bukkit.godly.object;

import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.WorldCoord;

public class ShrineBlock {

	private Shrine shrine;
	private GodlyWorld world;
	private int x, z;
	
	private GodlyPermission permissions = new GodlyPermission();
	private boolean isChanged;
	
	public ShrineBlock (int x, int z, GodlyWorld world) {
		this.x = x;
		this.z = z;
		this.world = world;
		isChanged = false;
	}
	
	public void setShrine(Shrine shrine) {
		try {
			if(hasShrine()) {
				this.shrine.removeShrineBlock(this);
			}
		} catch (NotRegisteredException e) {	
		}
		this.shrine = shrine;
		try {
			shrine.addShrineBlock(this);
		} catch (AlreadyRegisteredException e) {
		} catch (NullPointerException e) {
		}
		
	}
	
	public Shrine getShrine() throws NotRegisteredException {
		if(!hasShrine()) {
			throw new NotRegisteredException(String.format("The ShrineBlock at (%s, %d, %d) is not registered to a town.", world.getName(), x, z));
		}
		return shrine;
	}
	
	public boolean hasShrine(){
		return shrine != null;
	}
	
	public boolean isOwner(ShrineBlockOwner owner) {
		try {
			if (owner == getShrine())
				return true;
		} catch (NotRegisteredException e) {
		}
		
		return false;
	}
	
	public void setPermissions(String line) {
		permissions.load(line);
	}
	
	public GodlyPermission getPermissions() {

		return permissions;
	}
	
	/**
	 * Have the permissions been manually changed.
	 * 
	 * @return the isChanged
	 */
	public boolean isChanged() {

		return isChanged;
	}

	/**
	 * Flag the permissions as changed.
	 * 
	 * @param isChanged the isChanged to set
	 */
	public void setChanged(boolean isChanged) {

		this.isChanged = isChanged;
	}
	
	public boolean isHomeBlock() {

		try {
			return getShrine().isHomeBlock(this);
		} catch (NotRegisteredException e) {
			return false;
		}
	}
	
	public void setX(int x) {

		this.x = x;
	}

	public int getX() {

		return x;
	}

	public void setZ(int z) {

		this.z = z;
	}

	public int getZ() {

		return z;
	}

	public Coord getCoord() {

		return new Coord(x, z);
	}

	public WorldCoord getWorldCoord() {

		return new WorldCoord(world.getName(), x, z);
	}
	
	public void setWorld(GodlyWorld world) {
		this.world = world;
	}
	
	public GodlyWorld getWorld() {
		return world;
	}
	
	public boolean equals(Object obj) {

		if (obj == this)
			return true;
		if (!(obj instanceof ShrineBlock))
			return false;

		ShrineBlock o = (ShrineBlock) obj;
		return this.getX() == o.getX() && this.getZ() == o.getZ() && this.getWorld() == o.getWorld();
	}
	
	public void clear() {

		setShrine(null);
		setWorld(null);
	}

	@Override
	public String toString() {

		return getWorld().getName() + " (" + getCoord() + ")";
	}
}
