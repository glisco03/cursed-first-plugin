package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_setfood implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		

		Player player = null;
		Player toedit = null;
		double hunger;
		int hungerint;
		
		if(sender instanceof Player) {
			player = (Player)sender;
		}
		
		
		if(command.getName().equalsIgnoreCase("setfood")) {
			if(player == null) {
				if(args.length<2) {
				}
				else {
					if(isAlphaNumeric(args[0])==true) {
						player = Bukkit.getServer().getPlayer(args[0]);
						//sender.sendMessage("§b[Debug] Player: " + player);
						if(player != null) {
							if(isNumeric(args[1])){
								hunger = Double.parseDouble(args[1]);
								hunger = hunger * 2;
								hungerint = (int)hunger;
								if(hunger >= 0 && hunger <= 20) {
								player.setFoodLevel(hungerint);
								sender.sendMessage(vars.prefix +"§aThe hunger of§b " + player.getDisplayName() + " §ahas been set to§c " + hunger/2);
								return true;
								}
							}
							else if(args[1].equalsIgnoreCase("max")) {
								player.setFoodLevel(20);
								sender.sendMessage(vars.prefix +"§aThe hunger of§b " + player.getDisplayName() + " §ahas been set to §c10.0");
								return true;
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis Player is not online!");
							return true;
						}
					}
				}
				
				//sender.sendMessage(ChatColor.RED + "Not implemented  yet");
				return false;
			} 
			else {
				if(args.length<2) {
				}
				else {
					if(player.isOp() || player.hasPermission("hm.setfood")) {
					if(isAlphaNumeric(args[0])==true) {
						toedit = Bukkit.getServer().getPlayer(args[0]);
						//sender.sendMessage("§b[Debug] Player: " + player);
						if(toedit != null) {
							if(isNumeric(args[1])){
								hunger = Double.parseDouble(args[1]);
								hunger = hunger * 2;
								hungerint = (int)hunger;
								if(hunger >= 0 && hunger <= 20) {
								toedit.setFoodLevel(hungerint);
								sender.sendMessage(vars.prefix +"§aThe hunger of§b " + toedit.getDisplayName() + " §ahas been set to§c " + hunger/2);
								return true;
								}
							}
							else if(args[1].equalsIgnoreCase("max")) {
								toedit.setFoodLevel(20);
								sender.sendMessage(vars.prefix +"§aThe hunger of§b " + toedit.getDisplayName() + " §ahas been set to §c10.0");
								return true;
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis Player is not online!!");
							return true;
						}
					}
				} else {
					player.sendMessage(vars.prefix +"§cYou don't have permission!");
					return true;
					}
				}
				
			}
		}
		return false;

	}

	public boolean isAlphaNumeric(String s){
	    String pattern= "^[a-zA-Z0-9]*$";
	    return s.matches(pattern);
	}

	public boolean isNumeric(String s){
	    String pattern= "^[0-9.]*$";
	    return s.matches(pattern);
	}
}
