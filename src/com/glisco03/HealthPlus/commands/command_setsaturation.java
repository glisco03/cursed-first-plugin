package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_setsaturation implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		

		Player player = null;
		Player toedit = null;
		double saturation;
		int saturationint;
		
		if(sender instanceof Player) {
			player = (Player)sender;
		}
		
		
		if(command.getName().equalsIgnoreCase("setsaturation")) {
			if(player == null) {
				if(args.length<2) {
				}
				else {
					if(isAlphaNumeric(args[0])==true) {
						player = Bukkit.getServer().getPlayer(args[0]);
						if(player != null) {
							if(isNumeric(args[1])){
								saturation = Double.parseDouble(args[1]);
								saturation = saturation * 2;
								saturationint = (int)saturation;
								if(saturation >= 0 && saturation <= 20) {
								player.setSaturation(saturationint);
								sender.sendMessage(vars.prefix +"§aThe saturation of§b " + player.getDisplayName() + " §ahas been set to§c " + saturationint/2);
							    return true;
								}
							}
							else if(args[1].equalsIgnoreCase("max")) {
								player.setSaturation(20);
								sender.sendMessage(vars.prefix +"§aThe saturation of§b " + player.getDisplayName() + " §ahas been set to §c10.0");
								return true;
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis Player is not online!");
							return true;
						}
					}
				}
				
				return false;
			} 
			else {
				if(args.length<2) {
				}
				else {
					if(player.isOp() || player.hasPermission("hm.setsaturation")) {
					if(isAlphaNumeric(args[0])==true) {
						toedit = Bukkit.getServer().getPlayer(args[0]);
						if(toedit != null) {
							if(isNumeric(args[1])){
								saturation = Double.parseDouble(args[1]);
								saturation = saturation * 2;
								saturationint = (int)saturation;
								if(saturation >= 0 && saturation <= 20) {
								toedit.setSaturation(saturationint);
								sender.sendMessage(vars.prefix +"§aThe saturation of§b " + toedit.getDisplayName() + " §ahas been set to§c " + saturationint/2);

							    return true;
								}
							}
							else if(args[1].equalsIgnoreCase("max")) {
								toedit.setSaturation(20);
								sender.sendMessage(vars.prefix +"§aThe saturation of§b " + toedit.getDisplayName() + " §ahas been set to §c10.0");
								return true;
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis Player is not online!");
							return true;
						}
					}
				} else {
					sender.sendMessage(vars.prefix +"§cYou don't have permission!");
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
