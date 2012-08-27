package com.github.roburrito.bukkit.godly.object;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Observable;
import java.util.Random;

import com.github.roburrito.bukkit.godly.GodlyFormatter;

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
	
	public String getFormattedName() {

		return GodlyFormatter.getFormattedName(this);
	}
	
	public List<String> getTreeString(int depth) {

		return new ArrayList<String>();
	}

	public String getTreeDepth(int depth) {

		char[] fill = new char[depth * 4];
		Arrays.fill(fill, ' ');
		if (depth > 0) {
			fill[0] = '|';
			int offset = (depth - 1) * 4;
			fill[offset] = '+';
			fill[offset + 1] = '-';
			fill[offset + 2] = '-';
		}
		return new String(fill);
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
