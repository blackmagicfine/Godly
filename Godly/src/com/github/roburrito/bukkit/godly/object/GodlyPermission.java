package com.github.roburrito.bukkit.godly.object;

import com.github.roburrito.bukkit.godly.GodlySettings;
import com.palmergames.bukkit.util.Colors;

public class GodlyPermission {

	public boolean respectedBuild, respectedDestroy, respectedSwitch, respectedItemUse, respectedEnter,
	favoredBuild, favoredDestroy, favoredSwitch, favoredItemUse, favoredEnter,
	ignoredBuild, ignoredDestroy, ignoredSwitch, ignoredItemUse, ignoredEnter,
	unfavoredBuild, unfavoredDestroy, unfavoredSwitch, unfavoredItemUse, unfavoredEnter,
	despisedBuild, despisedDestroy, despisedSwitch, despisedItemUse, despisedEnter;
	public boolean pvp, fire, explosion, mobs;

	public enum ActionType {
		BUILD, DESTROY, SWITCH, ITEM_USE, ENTER;

		@Override
		public String toString() {

			return super.toString().toLowerCase();
		}
	}
	
	public enum PermLevel {
		RESPECTED, FAVORED, IGNORED, UNFAVORED, DESPISED;

		@Override
		public String toString() {

			return super.toString().toLowerCase();
		}
	}
	
	public GodlyPermission() {
		reset();
	}

	public void reset() {
		setAll(false);
	}

	public void setAll(boolean b) {
		respectedBuild = b;
		respectedDestroy = b;
		respectedSwitch = b;
		respectedItemUse = b;
		respectedEnter = b;
		favoredBuild = b;
		favoredDestroy = b;
		favoredSwitch = b;
		favoredItemUse = b;
		favoredEnter = b;
		ignoredBuild = b;
		ignoredDestroy = b;
		ignoredSwitch = b;
		ignoredItemUse = b;
		ignoredEnter = b;
		unfavoredBuild = b;
		unfavoredDestroy = b;
		unfavoredSwitch = b;
		unfavoredItemUse = b;
		unfavoredEnter = b;
		despisedBuild = b;
		despisedDestroy = b;
		despisedSwitch = b;
		despisedItemUse = b;
		despisedEnter = b;


		pvp = b;
		fire = b;
		explosion = b;
		mobs = b;
	}

	public void set(String s, boolean b) {
		
		if(s.equalsIgnoreCase("denyAll"))
			reset();
		
		if(s.equalsIgnoreCase("allowAll"))
			setAll(true);
		
		if(s.equalsIgnoreCase("respectedBuild"))
			respectedBuild = b;
		
		if(s.equalsIgnoreCase("respectedDestroy"))
			respectedDestroy = b;
		
		if(s.equalsIgnoreCase("respectedSwitch"))
			respectedSwitch = b;
		
		if(s.equalsIgnoreCase("respectedItemUse"))
			respectedItemUse = b;
		
		if(s.equalsIgnoreCase("respectedEnter"))
			respectedEnter = b;
		
		if(s.equalsIgnoreCase("favoredBuild"))
			favoredBuild = b;
		
		if(s.equalsIgnoreCase("favoredDestroy"))
			favoredDestroy = b;
		
		if(s.equalsIgnoreCase("favoredSwitch"))
			favoredSwitch = b;
		
		if(s.equalsIgnoreCase("favoredItemUse"))
			favoredItemUse = b;
		
		if(s.equalsIgnoreCase("favoredEnter"))
			favoredEnter = b;
		
		if(s.equalsIgnoreCase("ignoredBuild"))
			ignoredBuild = b;
		
		if(s.equalsIgnoreCase("ignoredDestroy"))
			ignoredDestroy = b;
		
		if(s.equalsIgnoreCase("ignoredSwitch"))
			ignoredSwitch = b;
		
		if(s.equalsIgnoreCase("ignoredItemUse"))
			ignoredItemUse = b;
		
		if(s.equalsIgnoreCase("ignoredEnter"))
			ignoredEnter = b;
		
		if(s.equalsIgnoreCase("unfavoredBuild"))
			unfavoredBuild = b;
		
		if(s.equalsIgnoreCase("unfavoredDestroy"))
			unfavoredDestroy = b;
		
		if(s.equalsIgnoreCase("unfavoredSwitch"))
			unfavoredSwitch = b;
		
		if(s.equalsIgnoreCase("unfavoredItemUse"))
			unfavoredItemUse = b;
		
		if(s.equalsIgnoreCase("unfavoredEnter"))
			unfavoredEnter = b;
		
		if(s.equalsIgnoreCase("despisedBuild"))
			despisedBuild = b;
		
		if(s.equalsIgnoreCase("despisedDestroy"))
			despisedDestroy = b;
		
		if(s.equalsIgnoreCase("despisedSwitch"))
			despisedSwitch = b;
		
		if(s.equalsIgnoreCase("despisedItemUse"))
			despisedItemUse = b;
		
		if(s.equalsIgnoreCase("despisedEnter"))
			despisedEnter = b;

		if(s.equalsIgnoreCase("pvp")) {
			pvp = b;
		}
		if(s.equalsIgnoreCase("fire")) {
			fire = b;
		}
		if(s.equalsIgnoreCase("explosion")) {
			explosion = b;
		}
		if(s.equalsIgnoreCase("mobs")) {
			mobs = b;
		}
	}
	
	public void load(String s) {

		setAll(false);
		String[] tokens = s.split(",");
		for (String token : tokens)
			set(token, true);
	}

	public String toString() {
		String out = "";
		if (respectedBuild)
			out += "respectedBuild";
		if (respectedDestroy)
			out += (out.length() > 0 ? "," : "") + "respectedDestroy";
		if (respectedItemUse)
			out += (out.length() > 0 ? "," : "") + "respectedSwitch";
		if (respectedItemUse)
			out += (out.length() > 0 ? "," : "") + "respectedItemUse";
		if (respectedEnter)
			out += (out.length() > 0 ? "," : "") + "respectedEnter";
		if (favoredBuild)
			out += (out.length() > 0 ? "," : "") + "favoredBuild";
		if (favoredDestroy)
			out += (out.length() > 0 ? "," : "") + "favoredDestroy";
		if (favoredItemUse)
			out += (out.length() > 0 ? "," : "") + "favoredSwitch";
		if (favoredItemUse)
			out += (out.length() > 0 ? "," : "") + "favoredItemUse";
		if (favoredEnter)
			out += (out.length() > 0 ? "," : "") + "favoredEnter";
		if (ignoredBuild)
			out += (out.length() > 0 ? "," : "") + "ignoredBuild";
		if (ignoredDestroy)
			out += (out.length() > 0 ? "," : "") + "ignoredDestroy";
		if (ignoredItemUse)
			out += (out.length() > 0 ? "," : "") + "ignoredSwitch";
		if (ignoredItemUse)
			out += (out.length() > 0 ? "," : "") + "ignoredItemUse";
		if (ignoredEnter)
			out += (out.length() > 0 ? "," : "") + "ignoredEnter";
		if (unfavoredBuild)
			out += (out.length() > 0 ? "," : "") + "unfavoredBuild";
		if (unfavoredDestroy)
			out += (out.length() > 0 ? "," : "") + "unfavoredDestroy";
		if (unfavoredItemUse)
			out += (out.length() > 0 ? "," : "") + "unfavoredSwitch";
		if (unfavoredItemUse)
			out += (out.length() > 0 ? "," : "") + "unfavoredItemUse";
		if (unfavoredEnter)
			out += (out.length() > 0 ? "," : "") + "unfavoredEnter";
		if (despisedBuild)
			out += (out.length() > 0 ? "," : "") + "despisedBuild";
		if (despisedDestroy)
			out += (out.length() > 0 ? "," : "") + "despisedDestroy";
		if (despisedItemUse)
			out += (out.length() > 0 ? "," : "") + "despisedSwitch";
		if (despisedItemUse)
			out += (out.length() > 0 ? "," : "") + "despisedItemUse";
		if (despisedEnter)
			out += (out.length() > 0 ? "," : "") + "despisedEnter";
		if (pvp)
			out += (out.length() > 0 ? "," : "") + "pvp";
		if (fire)
			out += (out.length() > 0 ? "," : "") + "fire";
		if (explosion)
			out += (out.length() > 0 ? "," : "") + "explosion";
		if (mobs)
			out += (out.length() > 0 ? "," : "") + "mobs";
		if (out.length() == 0)
			out += "denyAll"; // Make the token not empty
		return out;
	}
	
	public boolean getRespectedPerm(ActionType type) {

		switch (type) {
		case BUILD:
			return respectedBuild;
		case DESTROY:
			return respectedDestroy;
		case SWITCH:
			return respectedSwitch;
		case ITEM_USE:
			return respectedItemUse;
		case ENTER:
			return respectedEnter;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public boolean getFavoredPerm(ActionType type) {

		switch (type) {
		case BUILD:
			return favoredBuild;
		case DESTROY:
			return favoredDestroy;
		case SWITCH:
			return favoredSwitch;
		case ITEM_USE:
			return favoredItemUse;
		case ENTER:
			return favoredEnter;
		default:
			throw new UnsupportedOperationException();
		}
	}

	public boolean getIgnoredPerm(ActionType type) {

		switch (type) {
		case BUILD:
			return ignoredBuild;
		case DESTROY:
			return ignoredDestroy;
		case SWITCH:
			return ignoredSwitch;
		case ITEM_USE:
			return ignoredItemUse;
		case ENTER:
			return ignoredEnter;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public boolean getUnfavoredPerm(ActionType type) {

		switch (type) {
		case BUILD:
			return unfavoredBuild;
		case DESTROY:
			return unfavoredDestroy;
		case SWITCH:
			return unfavoredSwitch;
		case ITEM_USE:
			return unfavoredItemUse;
		case ENTER:
			return unfavoredEnter;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public boolean getDespisedPerm(ActionType type) {

		switch (type) {
		case BUILD:
			return despisedBuild;
		case DESTROY:
			return despisedDestroy;
		case SWITCH:
			return despisedSwitch;
		case ITEM_USE:
			return despisedItemUse;
		case ENTER:
			return despisedEnter;
		default:
			throw new UnsupportedOperationException();
		}
	}
	
	public String getColourString() {

		return Colors.LightGreen + "Build = " + Colors.LightGray + (respectedBuild ? "r" : "-") + (favoredBuild ? "f" : "-") + (ignoredBuild ? "i" : "-") + (unfavoredBuild ? "u" : "-") + (despisedBuild ? "d" : "-")
				+ Colors.LightGreen + " Destroy = " + Colors.LightGray + (respectedDestroy ? "r" : "-") + (favoredDestroy ? "f" : "-") + (ignoredDestroy ? "i" : "-") + (unfavoredDestroy ? "u" : "-") + (despisedDestroy ? "d" : "-")
				+ Colors.LightGreen + " Switch = " + Colors.LightGray + (respectedSwitch ? "r" : "-") + (favoredSwitch ? "f" : "-") + (ignoredSwitch ? "i" : "-") + (unfavoredSwitch ? "u" : "-") + (despisedSwitch ? "d" : "-")
				+ Colors.LightGreen + " Item = " + Colors.LightGray + (respectedItemUse ? "r" : "-") + (favoredItemUse ? "f" : "-") + (ignoredItemUse ? "i" : "-") + (unfavoredItemUse ? "u" : "-") + (despisedItemUse ? "d" : "-")
				+ Colors.LightGreen + " Item = " + Colors.LightGray + (respectedEnter ? "r" : "-") + (favoredEnter ? "f" : "-") + (ignoredEnter ? "i" : "-") + (unfavoredEnter ? "u" : "-") + (despisedEnter ? "d" : "-");
	}
	
	public void loadDefault(ShrineBlockOwner owner) {
		respectedBuild = GodlySettings.getDefaultPermission(owner, PermLevel.RESPECTED, ActionType.BUILD);
		respectedDestroy = GodlySettings.getDefaultPermission(owner, PermLevel.RESPECTED, ActionType.DESTROY);
		respectedSwitch = GodlySettings.getDefaultPermission(owner, PermLevel.RESPECTED, ActionType.SWITCH);
		respectedItemUse = GodlySettings.getDefaultPermission(owner, PermLevel.RESPECTED, ActionType.ITEM_USE);
		respectedEnter = GodlySettings.getDefaultPermission(owner, PermLevel.RESPECTED, ActionType.ENTER);
		favoredBuild = GodlySettings.getDefaultPermission(owner, PermLevel.FAVORED, ActionType.BUILD);
		favoredDestroy = GodlySettings.getDefaultPermission(owner, PermLevel.FAVORED, ActionType.DESTROY);
		favoredSwitch = GodlySettings.getDefaultPermission(owner, PermLevel.FAVORED, ActionType.SWITCH);
		favoredItemUse = GodlySettings.getDefaultPermission(owner, PermLevel.FAVORED, ActionType.ITEM_USE);
		favoredEnter = GodlySettings.getDefaultPermission(owner, PermLevel.FAVORED, ActionType.ENTER);
		ignoredBuild = GodlySettings.getDefaultPermission(owner, PermLevel.IGNORED, ActionType.BUILD);
		ignoredDestroy = GodlySettings.getDefaultPermission(owner, PermLevel.IGNORED, ActionType.DESTROY);
		ignoredSwitch = GodlySettings.getDefaultPermission(owner, PermLevel.IGNORED, ActionType.SWITCH);
		ignoredItemUse = GodlySettings.getDefaultPermission(owner, PermLevel.IGNORED, ActionType.ITEM_USE);
		ignoredEnter = GodlySettings.getDefaultPermission(owner, PermLevel.IGNORED, ActionType.ENTER);
		unfavoredBuild = GodlySettings.getDefaultPermission(owner, PermLevel.UNFAVORED, ActionType.BUILD);
		unfavoredDestroy = GodlySettings.getDefaultPermission(owner, PermLevel.UNFAVORED, ActionType.DESTROY);
		unfavoredSwitch = GodlySettings.getDefaultPermission(owner, PermLevel.UNFAVORED, ActionType.SWITCH);
		unfavoredItemUse = GodlySettings.getDefaultPermission(owner, PermLevel.UNFAVORED, ActionType.ITEM_USE);
		unfavoredEnter = GodlySettings.getDefaultPermission(owner, PermLevel.UNFAVORED, ActionType.ENTER);
		despisedBuild = GodlySettings.getDefaultPermission(owner, PermLevel.DESPISED, ActionType.BUILD);
		despisedDestroy = GodlySettings.getDefaultPermission(owner, PermLevel.DESPISED, ActionType.DESTROY);
		despisedSwitch = GodlySettings.getDefaultPermission(owner, PermLevel.DESPISED, ActionType.SWITCH);
		despisedItemUse = GodlySettings.getDefaultPermission(owner, PermLevel.DESPISED, ActionType.ITEM_USE);
		despisedEnter = GodlySettings.getDefaultPermission(owner, PermLevel.DESPISED, ActionType.ENTER);
		
		if(owner instanceof Shrine) {
			pvp = GodlySettings.getPermFlag_Town_Default_PVP();
			fire = GodlySettings.getPermFlag_Town_Default_FIRE();
			explosion = GodlySettings.getPermFlag_Town_Default_Explosion();
			mobs = GodlySettings.getPermFlag_Town_Default_Mobs();
		} else {
			pvp = owner.getPermissions().pvp;
			fire = owner.getPermissions().fire;
			explosion = owner.getPermissions().explosion;
			mobs = owner.getPermissions().mobs;
		}
	}
}
