package com.github.roburrito.bukkit.godly.object;

import java.util.Observable;
import java.util.Random;

public class GodlyObject extends Observable {

	private int UID = 0;
	private String name;
	private boolean isChangedName = true;
	
	public void setName(String name) {

		if (getUID() == 0)
			setUID(name.hashCode() + new Random(System.currentTimeMillis()).nextInt());

		setChanged();
		notifyObservers(GodlyObservableType.OBJECT_NAME);
		this.name = name;
		setChangedName(true);

	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return getName();
	}
	
	public void setUID(int UID) {
		this.UID = UID;
	}
	
	public int getUID() {
		return UID;
	}
	
	public void setChangedName(boolean changed) {
		isChangedName = changed;
	}
	
	public boolean isChangedName() {
		return isChangedName;
	}
}
