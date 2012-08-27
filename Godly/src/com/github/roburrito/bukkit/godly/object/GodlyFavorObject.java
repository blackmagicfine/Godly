package com.github.roburrito.bukkit.godly.object;

import org.bukkit.World;

import com.github.roburrito.bukkit.godly.GodlyFavorHandler;
import com.github.roburrito.bukkit.godly.GodlyLogger;
import com.github.roburrito.bukkit.godly.exceptions.FavorException;
import com.github.roburrito.bukkit.util.BukkitTools;

public class GodlyFavorObject extends GodlyObject {

	public boolean transfer(God god, int amount, String reason) throws FavorException {
		boolean transferred = _transfer(god, amount);
		if(transferred)
			GodlyLogger.logFavorTransaction(this, god, amount, null, reason);
		return transferred;
	}
	
	public boolean transfer(God god, int amount) throws FavorException {
		return transfer(god, amount, null);
	}
	
	private boolean _transfer(God god, int amount) throws FavorException {
		if(canAfford(god, amount)) {
			if(GodlyFavorHandler.isActive()) {
				return GodlyFavorHandler.subtract(getFavorName(), god, amount, getBukkitWorld());
			}
		}
		return false;
	}
	
	public boolean canAfford(God god, int amount) throws FavorException {
		return GodlyFavorHandler.hasEnough(getFavorName(), god, amount, getBukkitWorld());
	}
	
	public void collect(God god, int amount, String reason) throws FavorException {
		GodlyFavorHandler.add(getFavorName(), god, amount, getBukkitWorld());
		GodlyLogger.logFavorTransaction(null, god, amount, this, reason);
	}
	
	public void collect(God god, int amount) throws FavorException {
		collect(god, amount, null);
	}
	
	public boolean transferTo(God god, int amount, GodlyFavorObject collector, String reason) throws FavorException {
		boolean transferred = _transferTo(god, amount, collector);
		if(transferred)
			GodlyLogger.logFavorTransaction(this, god, amount, collector, reason);
		return transferred;
	}
	
	public boolean transferTo(God god, int amount, GodlyFavorObject collector) throws FavorException {
		return transferTo(god, amount, collector, null);
	}
	
	public boolean _transferTo(God god, int amount, GodlyFavorObject collector) throws FavorException{
		if (_transfer(god, amount)) {
			collector.collect(god, amount);
			return true;
		} else {
			return false;
		}
	}
	
	public void setFavor(God god, int amount, String reason) {
		setFavor(god, amount);
		GodlyLogger.logFavorTransaction(null, god, amount, this, reason);
	}
	
	public void setFavor(God god, int amount) {
		GodlyFavorHandler.setFavor(getFavorName(), god, amount, getBukkitWorld());
	}
	
	public int getFavorBalance(God god) throws FavorException {
		try {
			return GodlyFavorHandler.getFavor(getFavorName(), god, getBukkitWorld());
		} catch (NoClassDefFoundError e) {
			e.printStackTrace();
			throw new FavorException("Favor exception getting balance for " + getFavorName());
		}
	}
	
	public String getFavorFormattedBalance(God god) {
		try {
			return GodlyFavorHandler.getFormattedBalance(getFavorName(), god);
		} catch(FavorException e) {
			return "Error accessing favor account";
		}
	}
	
	protected World getBukkitWorld() {

		return BukkitTools.getWorlds().get(0);
	}
	
	public String getFavorName() {
		return getName();
	}
	
	public void removeAccount() {
		GodlyFavorHandler.removeAccount(getFavorName());
	}
}
