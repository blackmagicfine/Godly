package com.github.roburrito.bukkit.godly;

import java.util.Locale;

import com.github.roburrito.bukkit.godly.object.GodlyPermission.ActionType;
import com.github.roburrito.bukkit.godly.object.GodlyPermission.PermLevel;
import com.github.roburrito.bukkit.godly.object.Shrine;
import com.github.roburrito.bukkit.godly.object.ShrineBlockOwner;

public class GodlySettings {

	public static boolean getDefaultPermission(ShrineBlockOwner owner,
			PermLevel perm, ActionType action) {
		return false;
	}

	public static boolean getPermFlag_Town_Default_FIRE() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getPermFlag_Town_Default_PVP() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getPermFlag_Town_Default_Mobs() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getPermFlag_Town_Default_Explosion() {
		// TODO Auto-generated method stub
		return false;
	}

	public static boolean getShrineDefaultPublic() {
		// TODO Auto-generated method stub
		return false;
	}

	public static Locale getLangString(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static int getMaxShrineBlocks(Shrine shrine) {
		// TODO Auto-generated method stub
		return 0;
	}

}
