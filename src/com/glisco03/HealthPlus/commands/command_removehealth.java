package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_removehealth implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		

		Player player = null;
		Player toedit = null;
		double toremove;
		double leben;
		AttributeInstance attrib;
		
		if(sender instanceof Player) {
			player = (Player)sender;
		}
		
		
		if(command.getName().equalsIgnoreCase("removehealth")) {
			if(player == null) {
				if(args.length<2) {
				}
				else {
					if(isAlphaNumeric(args[0])==true) {
						player = Bukkit.getServer().getPlayer(args[0]);
						if(player != null) {
							attrib = player.getAttribute(Attribute.GENERIC_MAX_HEALTH);
							if(isNumeric(args[1])){
								toremove = Double.parseDouble(args[1]);
								toremove = toremove * 2;
								leben = attrib.getBaseValue();
								if(toremove > 0 && leben-toremove > 0) {
									attrib.setBaseValue(leben-toremove);
									sender.sendMessage(vars.prefix +"§c" + toremove/2 + " hearts §ahave been substracted from the maximum health of§b " + player.getDisplayName());
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
					if(player.isOp() || player.hasPermission("hm.removehealth")) {
						if(isAlphaNumeric(args[0])==true) {
							toedit = Bukkit.getServer().getPlayer(args[0]);
							if(toedit != null) {
								attrib = toedit.getAttribute(Attribute.GENERIC_MAX_HEALTH);
								if(isNumeric(args[1])){
									toremove = Double.parseDouble(args[1]);
									toremove = toremove * 2;
									leben = attrib.getBaseValue();
									if(toremove > 0 && leben-toremove > 0) {
										attrib.setBaseValue(leben-toremove);
										sender.sendMessage(vars.prefix +"§c" + toremove/2 + " hearts §ahave been substracted from the maximum health of§b " + player.getDisplayName());
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
