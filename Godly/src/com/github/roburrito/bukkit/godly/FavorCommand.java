package com.github.roburrito.bukkit.godly;

/*TODO: FIX IMPORT LIST*/
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.roburrito.bukkit.godly.Godly;
import com.github.roburrito.bukkit.util.FavorMetadataMethods;
import com.palmergames.bukkit.util.Colors;

/*This class handles all commands beginning with "/favor"*/
public class FavorCommand implements CommandExecutor {
 
	/*variable and constructor only necessary if methods are used from the main class*/
	private final Godly plugin;
	private FavorMetadataMethods favorMethods;
	private String godlyNames[] = favorMethods.godlyNames;
 
	public FavorCommand(Godly plugin) {
		this.plugin = plugin;
	}
 
	/*TODO: add all commands listed here in Plugin.yml for Godly!!!*/
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player player = null;
		if(sender instanceof Player) {
			player = (Player)sender;
			
			if(args.length == 0) {
				printPlayersFavors(player);
				return true;
			}
			else if(args.length == 1) {
				for(String gName : godlyNames) {
					if(args[0].equalsIgnoreCase(gName))
						printGodsPowers(player, gName);
						return true;
				}
			} else {
				player.sendMessage(Colors.Rose + "Invalid command!");
				return false;
			}
		}
		/*Are there favor-based commands that servers can ask?*/
		if(player == null) { 
			sender.sendMessage(Colors.Rose + "Only players can asketh thy Gods for favors!");
			return false;
		}

		sender.sendMessage(Colors.Rose + "Invalid command!");
		return false;
	}
	
	/*Lists the favor levels that the player has for each God and Goddess*/
	public void printPlayersFavors(Player player) {
		int rank, i = 0;
		
		player.sendMessage("This is what each God/Goddess thinks of you:");
		for(String gName : godlyNames){
			rank = favorMethods.getRank(player, gName);
			
			switch(rank) {
				case -4: player.sendMessage(godlyNames[i] + " despises you!");
					break;
				case -3: player.sendMessage(godlyNames[i] + " dislikes you.");
					break;
				case -2: player.sendMessage(godlyNames[i] + " is annoyed by you.");
					break;
				case -1: player.sendMessage(godlyNames[i] + " is pestered by you.");
					break;
				case 0: player.sendMessage(godlyNames[i] + " does not notice you.");
					break;
				case 1: player.sendMessage(godlyNames[i] + " recognizes you.");
					break;
				case 2: player.sendMessage(godlyNames[i] + " considers you to be a follower of their cause.");
					break;
				case 3: player.sendMessage(godlyNames[i] + " considers you to be devouted to their cause.");
					break;
				case 4: player.sendMessage(godlyNames[i] + " has declared you to be a champion of their cause!");
					break;
				default: player.sendMessage(Colors.Rose + "404 ERROR: Your favor with " + godlyNames[i] + 
						" does not exist! Please contact a moderator or admin as soon as possible!");
					break;
			}
			i++;
		}
		player.sendMessage("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); /*Probably the incorrect amount. Adjust later.*/
		player.sendMessage("To see what a particular god has granted you, type /favor <god>");
	}
	
	/*Very much still in the works. Will finish when we have a better idea of what each command does.
	 * Specifically the negative rank punishments and how to handle the champion paragon paths in the code.*/
	public void printGodsPowers(Player player, String god) {
		int rank = favorMethods.getRank(player, god);
		
		if(rank == -3)
			player.sendMessage(god + " will punish you in areas of his influence.");
		if(rank == -2)
			player.sendMessage(god + " is annoyed by you, and it will be hard for you to regain their favor.");
		if(rank == -1)
			player.sendMessage(god + " is pestered by you.");
		if(rank == 0)
			player.sendMessage(god + " cares not of your existence.");
		if(rank == 1)
			player.sendMessage(god + " has recognized you.");
		else if((rank < -4) || (rank > 4))
			player.sendMessage(Colors.Rose + "404 ERROR: Your favor with " + god + 
					" does not exist! Please contact a moderator or admin as soon as possible!");
		else if(god.equalsIgnoreCase("Arcamorde")) { 
			switch(rank) {
			case -4: player.sendMessage("Arcamorde has given you a RADIUS EFFECT most foul! He will also punish you in areas of his influence.");
				break;
			case 2: player.sendMessage("Follower of Arcamorde: Arcamorde has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge doubleDrop' at his shrines to momentarily increase the chances of getting more spoils.");
				break;
			case 3: player.sendMessage("Devout of Arcamorde: Once per day, you may use '/charge investor' to add a 1% interest to your /money account.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		} else if(god.equalsIgnoreCase("Terra")) { 
			switch(rank) {
			case -4: player.sendMessage("Terra has given you a RADIUS EFFECT most foul! She will also punish you in areas of her influence.");
				break;
			case 2: player.sendMessage("Follower of Terra: Terra has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge cropGrowth' at her shrines to momentarily increase the rate at which crops grow.");
				break;
			case 3: player.sendMessage("Devout of Terra: Once per day, you may use '/charge wrathbringer' to have lightning strike five times in your general vicinity.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		} else if(god.equalsIgnoreCase("Aegis")) { 
			switch(rank) {
			case -4: player.sendMessage("Aegis has given you a RADIUS EFFECT most foul! He will also punish you in areas of his influence.");
				break;
			case 2: player.sendMessage("Follower of Aegis: Aegis has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge protection' at his shrines to momentarily provide yourself with protection.");
				break;
			case 3: player.sendMessage("Devout of Aegis: Once per day, you may use '/charge guardian' to manifest an iron golem to protect you.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		} else if(god.equalsIgnoreCase("Zi")) { 
			switch(rank) {
			case -4: player.sendMessage("Zi has given you a RADIUS EFFECT most foul! He will also punish you in areas of his influence.");
				break;
			case 2: player.sendMessage("Follower of Zi: Zi has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge strength' at his shrines to momentarily increase your strength.");
				break;
			case 3: player.sendMessage("Devout of Zi: Once per day, you may use '/charge pyromancy' to add fire damage to your weapons for thirty seconds.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		} else if(god.equalsIgnoreCase("Raz")) { 
			switch(rank) {
			case -4: player.sendMessage("Raz has given you a RADIUS EFFECT most foul! He will also punish you in areas of his influence.");
				break;
			case 2: player.sendMessage("Follower of Raz: Raz has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge bowDamage' at his shrines to momentarily increase the strength of your bow.");
				break;
			case 3: player.sendMessage("Devout of Raz: Once per day, you may use '/charge multishot' to double the amount of arrows fired for thirty seconds.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		} else { /*Meta*/
			switch(rank) {
			case -4: player.sendMessage("Meta has given you a RADIUS EFFECT most foul! He will also punish you in areas of his influence.");
				break;
			case 2: player.sendMessage("Follower of Meta: Meta has granted your shrine protection from all destruction." +
					" Once per day, you may use '/charge brewing' at his shrines to momentarily increase the chance of getting a better potion when brewing.");
				break;
			case 3: player.sendMessage("Devout of Meta: Once per day, you may use '/charge meditation' to grant ten extra levels for enchanting.");
				break;
			case 4: player.sendMessage("");
				break;
			}
		}
	}
	
}