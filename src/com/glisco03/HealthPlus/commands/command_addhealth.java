package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_addhealth implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		

		Player player = null;
		Player toedit = null;
		double toadd;
		double leben;
		AttributeInstance attrib;
		
		if(sender instanceof Player) {
			player = (Player)sender;
		}
		
		
		if(command.getName().equalsIgnoreCase("addhealth")) {
			if(player == null) {
				if(args.length<2) {
				}
				else {
					if(isAlphaNumeric(args[0])==true) {
						player = Bukkit.getServer().getPlayer(args[0]);
						if(player != null) {
							attrib = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
							if(isNumeric(args[1])){
								toadd = Double.parseDouble(args[1]);
								toadd = toadd * 2;
								leben = attrib.getBaseValue();
								if(toadd > 0 && toadd+leben < 2048) {
									attrib.setBaseValue(leben+toadd);
									player.setHealth(attrib.getBaseValue());
									sender.sendMessage(vars.prefix +"§c" + toadd/2 + " hearts §ahave been added to the maximum health of§b " + player.getDisplayName());
									return true;
								}
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis player is not online!");
							return true;
						}
					}
				}
				return false;
			} 
			else{
				if(args.length<2) {
				}
				else {
					if(player.isOp() || player.hasPermission("hm.addhealth")) {
						if(isAlphaNumeric(args[0])==true) {
							toedit = Bukkit.getServer().getPlayer(args[0]);
							if(toedit != null) {
								attrib = toedit.getAttribute(Attribute.GENERIC_MAX_HEALTH);
								if(isNumeric(args[1])){
									toadd = Double.parseDouble(args[1]);
									toadd = toadd * 2;
									leben = attrib.getBaseValue();
									if(toadd > 0 && toadd+leben < 2048) {
										attrib.setBaseValue(leben+toadd);
										toedit.setHealth(attrib.getBaseValue());
										sender.sendMessage(vars.prefix +"§c" + toadd/2 + " hearts §ahave been added to the maximum health of§b " + toedit.getDisplayName());
										return true;
									}
								}
							}
							else {
								sender.sendMessage(vars.prefix +"§cThis player is not online!");
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
