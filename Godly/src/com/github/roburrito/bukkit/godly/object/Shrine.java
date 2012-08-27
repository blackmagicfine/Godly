package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Location;
import org.bukkit.World;

import Exceptions.EmptyShrineException;

import com.github.roburrito.bukkit.godly.GodlySettings;
import com.github.roburrito.bukkit.util.BukkitTools;
import com.palmergames.bukkit.towny.exceptions.AlreadyRegisteredException;
import com.palmergames.bukkit.towny.exceptions.EmptyTownException;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.exceptions.TownyException;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.Resident;

public class Shrine extends ShrineBlockOwner {

	private static final String ECONOMY_ACCOUNT_PREFIX = "shrine-";

	private List<Worshipper> worshippers = new ArrayList<Worshipper>();
	private List<ShrineBlock> shrineBlocks = new ArrayList<ShrineBlock>();
	private Worshipper abbot;
	private int bonusBlocks, purchasedBlocks;
	private God god;
	private boolean hasUpkeep, isPublic;
	private String shrineBoard = "/shrine set board [msg]";
	private String tag;
	private ShrineBlock homeBlock;
	private Location spawn;
	private GodlyWorld world;
	private int upkeep;

	public Shrine(String name) {
		setName(name);
		tag = "";
		bonusBlocks = 0;
		purchasedBlocks = 0;
		hasUpkeep = true;
		isPublic = GodlySettings.getShrineDefaultPublic();
		upkeep = 0;
		permissions.loadDefault(this);
	}

	public void addShrineBlock(ShrineBlock shrineBlock) throws AlreadyRegisteredException {
		if(shrineBlocks.contains(shrineBlock)) {
			throw new AlreadyRegisteredException();
		} else {
			shrineBlocks.add(shrineBlock);
			if (shrineBlocks.size() == 1 && !hasHomeBlock())
				try {
					setHomeBlock(shrineBlock);
				} catch (TownyException e) {
				}
		}
	}

	public void removeShrineBlock(ShrineBlock shrineBlock) throws NotRegisteredException {
		if(!shrineBlocks.contains(shrineBlock)) {
			throw new NotRegisteredException();
		} else {
			try {
				if (getHomeBlock() == shrineBlock)
					setHomeBlock(null);
			} catch (TownyException e) {
			}
			shrineBlocks.remove(shrineBlock);
		}
	}

	public void setTag(String text) throws TownyException {

		if (text.length() > 4)
			throw new TownyException("Tag too long");
		this.tag = text.toUpperCase();
		if (this.tag.matches(" "))
			this.tag = "";
		setChangedName(true);
	}

	public String getTag() {

		return tag;
	}

	public boolean hasTag() {

		return !tag.isEmpty();
	}

	public void sethasUpkeep(boolean hasUpkeep) {
		this.hasUpkeep = hasUpkeep;
	}

	public boolean hasUpkeep() {
		return hasUpkeep;
	}

	public int getUpkeep() {
		setUpkeep(upkeep);
		return upkeep;
	}

	public void setHasMobs(boolean hasMobs) {

		this.permissions.mobs = hasMobs;
	}

	public boolean hasMobs() {

		return this.permissions.mobs;
	}

	public void setPVP(boolean isPVP) {

		this.permissions.pvp = isPVP;
	}

	public boolean isPVP() {

		return this.permissions.pvp;
	}

	public void setBANG(boolean isBANG) {

		this.permissions.explosion = isBANG;
	}

	public boolean isBANG() {

		return this.permissions.explosion;
	}
	public void setFire(boolean isFire) {

		this.permissions.fire = isFire;
	}

	public boolean isFire() {

		return this.permissions.fire;
	}

	public void setShrineBoard(String shrineBoard) {

		this.shrineBoard = shrineBoard;
	}

	public String getShrineBoard() {

		return shrineBoard;
	}

	public void chooseAbbot() {
		Worshipper candidate = worshippers.get(0);
		for(int i = 0; i < worshippers.size(); i++) {
			if(worshippers.get(i).getFavor(god) > candidate.getFavor(god))
				candidate = worshippers.get(i);
		}
		
		try {
			setAbbot(candidate);
		} catch (TownyException e) {
		}
	}
	
	public void setAbbot(Worshipper worshipper) throws TownyException {
		if(!hasWorshipper(worshipper)) {
			throw new TownyException("Abbot does not belong to shrine!");
		}
		this.abbot = worshipper;
		//GodlyPerms.assignPermissions(abbot, null);
	}

	public Worshipper getAbbot() {

		return abbot;
	}
	
	public boolean hasAbbot() {
		return abbot != null;
	}

	public boolean isAbbot(Worshipper worshipper) {
		return abbot == worshipper;
	}

	public void addWorshipper(Worshipper worshipper) throws AlreadyRegisteredException {
		addWorshipperCheck(worshipper);
		worshippers.add(worshipper);
		worshipper.setShrine(this);
	}

	public void addWorshipperCheck(Worshipper worshipper) throws AlreadyRegisteredException {
		if(hasWorshipper(worshipper))
			throw new AlreadyRegisteredException(String.format(GodlySettings.getLangString("msg_err_already_in_shrine"), worshipper.getName(), getFormattedName()));
		else if(worshipper.hasShrine()) {
			try {
				if(worshipper.getShrine().equals(this))
					throw new AlreadyRegisteredException(String.format(GodlySettings.getLangString("msg_err_already_in_town"), worshipper.getName(), getFormattedName()));
			} catch(NotRegisteredException e) {
				e.printStackTrace();
			}
		}
	}

	public void removeWorshipper(Worshipper worshipper) throws EmptyShrineException, NotRegisteredException {
		if (!hasWorshipper(worshipper))
			throw new NotRegisteredException();
		else {
			remove(worshipper);

			if (getNumWorshippers() == 0)
				throw new EmptyShrineException(this);
		}
	}
	
	private void removeAllWorshippers() {
		for (Worshipper worshipper : new ArrayList<Worshipper>(worshippers))
			remove(worshipper);
	}
	
	private void remove(Worshipper worshipper) {
		worshippers.remove(worshipper);
		if(isAbbot(worshipper)) {
			if(worshippers.size() > 0)
				chooseAbbot();
		}
		
		try {
			worshipper.setShrine(null);
		} catch(AlreadyRegisteredException e) {
		}
	}
	
	public List<Worshipper> getWorshippers() {
		return worshippers;
	}
		
	public boolean hasWorshipper(Worshipper worshipper) {
		if(worshippers.contains(worshipper))
			return true;
		else
			return false;
	}

	public int getNumWorshippers() {
		return worshippers.size();
	}

	public void setBonusBlocks(int bonusBlocks) {

		this.bonusBlocks = bonusBlocks;
	}

	public int getTotalBlocks() {

		return GodlySettings.getMaxShrineBlocks(this);
	}

	public int getBonusBlocks() {

		return bonusBlocks;
	}

	public void addBonusBlocks(int bonusBlocks) {

		this.bonusBlocks += bonusBlocks;
	}

	public void setPurchasedBlocks(int purchasedBlocks) {

		this.purchasedBlocks = purchasedBlocks;
	}

	public int getPurchasedBlocks() {

		return purchasedBlocks;
	}

	public void addPurchasedBlocks(int purchasedBlocks) {

		this.purchasedBlocks += purchasedBlocks;
	}

	public void setUpkeep(int upkeep) {
		this.upkeep = upkeep;
	}

	public boolean setHomeBlock(ShrineBlock shrineBlock) throws TownyException {
		if (shrineBlock == null) {
			this.homeBlock = null;
			return false;
		}
		if (!hasShrineBlock(shrineBlock))
			throw new TownyException("Shrine has no claim over this town block.");
		this.homeBlock = shrineBlock;

		// Set the world as it may have changed
		if (this.world != shrineBlock.getWorld()) {
			if ((world != null) && (world.hasShrine(this)))
				world.removeShrine(this);

			setWorld(shrineBlock.getWorld());
		}

		// Attempt to reset the spawn to make sure it's in the homeblock
		try {
			setSpawn(spawn);
		} catch (TownyException e) {
			// Spawn is not in the homeblock so null.
			spawn = null;
		} catch (NullPointerException e) {
			// In the event that spawn is already null
		}

		return true;
	}

	public ShrineBlock getHomeBlock() throws TownyException {
		if(hasHomeBlock())
			return homeBlock;
		else
			throw new TownyException("Shrine has no home block.");
	}

	public boolean hasHomeBlock() {
		return homeBlock != null;
	}

	public boolean isHomeBlock(ShrineBlock shrineBlock) {
		if(hasHomeBlock())
			return shrineBlock == homeBlock;
		else
			return false;
	}

	public void setSpawn(Location spawn) throws TownyException {
		if (!hasHomeBlock())
			throw new TownyException("Home Block has not been set");
		Coord spawnBlock = Coord.parseCoord(spawn);
		if (homeBlock.getX() == spawnBlock.getX() && homeBlock.getZ() == spawnBlock.getZ()) {
			this.spawn = spawn;
		} else
			throw new TownyException("Spawn is not within the homeBlock.");
	}
	
	public Location getSpawn() throws TownyException {

		if (hasHomeBlock() && spawn != null) {
			return spawn;
		}

		else {
			this.spawn = null;
			throw new TownyException("Shrine has not set a spawn location.");
		}
	}
	
	public boolean hasSpawn() {

		return (hasHomeBlock() && spawn != null);
	}
	
	public List<String> getTreeString(int depth) {

		List<String> out = new ArrayList<String>();
		out.add(getTreeDepth(depth) + "Shrine (" + getName() + ")");
		out.add(getTreeDepth(depth + 1) + "Abbot: " + (hasAbbot() ? getAbbot().getName() : "None"));
		out.add(getTreeDepth(depth + 1) + "Home: " + homeBlock);
		out.add(getTreeDepth(depth + 1) + "Bonus: " + bonusBlocks);
		out.add(getTreeDepth(depth + 1) + "ShrineBlocks (" + getShrineBlocks().size() + "): ");
		
		out.add(getTreeDepth(depth + 1) + "Worshippers (" + getWorshippers().size() + "):");
		for (Worshipper worshipper : getWorshippers())
			out.addAll(worshipper.getTreeString(depth + 2));
		return out;
	}

	public void setPublic(boolean isPublic) {

		this.isPublic = isPublic;
	}

	public boolean isPublic() {

		return isPublic;
	}

	public void setWorld(GodlyWorld world) {
		if (world == null) {
			this.world = null;
			return;
		}
		if (this.world == world)
			return;

		if (hasWorld()) {
			try {
				world.removeShrine(this);
			} catch (NotRegisteredException e) {
			}
		}

		this.world = world;

		try {
			this.world.addShrine(this);
		} catch (AlreadyRegisteredException e) {
		}
	}

	public GodlyWorld getWorld() {
		if(hasWorld())
			return world;
		else
			return GodlyUniverse.getDataSource().getShrineWorld(this.getName());
	}
	
	public boolean hasWorld() {
		return world != null;
	}
	
	public void clear() {
		removeAllWorshippers();
		abbot = null;
		worshippers.clear();
		homeBlock = null;
		
		try {
			if (hasWorld()) {
				world.removeShrineBlocks(getShrineBlocks());
				world.removeShrine(this);
			}
		} catch (NotRegisteredException e) {
		}
	}
	
	 protected World getBukkitWorld() {
	        if (hasWorld()) {
	            return BukkitTools.getWorld(getWorld().getName());
	        } else {
	            return super.getBukkitWorld();
	        }
	    }
}
