package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.List;

import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;

public class ShrineBlockOwner extends GodlyFavorObject{

	protected List<ShrineBlock> shrineBlocks = new ArrayList<ShrineBlock>();
	protected GodlyPermission permissions;
	
	public void setShrineBlocks(List<ShrineBlock> shrineBlocks) {
		this.shrineBlocks = shrineBlocks;
	}
	
	public List<ShrineBlock> getShrineBlocks() {
		return shrineBlocks;
	}
	
	public boolean hasShrineBlock(ShrineBlock shrineBlock) {
		return shrineBlocks.contains(shrineBlock);
	}
	
	public void addShrineBlock(ShrineBlock shrineBlock) throws AlreadyRegisteredException {
		if(hasShrineBlock(shrineBlock))
			throw new AlreadyRegisteredException();
		else
			shrineBlocks.add(shrineBlock);
	}
	
	public void removeShrineBlock(ShrineBlock shrineBlock) throws NotRegisteredException {
		if(!hasShrineBlock(shrineBlock))
			throw new NotRegisteredException();
		else
			shrineBlocks.remove(shrineBlock);
	}
	
	public void setPermissions(String line) {
		permissions.load(line);
	}
	
	public GodlyPermission getPermissions() {
		return permissions;
	}
}
