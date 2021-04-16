package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_setmaxhealth implements CommandExecutor{
	
	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player player = null;
		Player toedit = null;
		double leben;
		
		if(sender instanceof Player) {
			player = (Player)sender;
		}
		
		if(command.getName().equalsIgnoreCase("setmaxhealth")) {
			if(player == null) {
				if(args.length<2) {
				}
				else {
					if(isAlphaNumeric(args[0])==true) {
						player = Bukkit.getServer().getPlayer(args[0]);
						if(player != null) {
							if(isNumeric(args[1])){
								leben = Double.parseDouble(args[1]);
								leben = leben * 2;
								if(leben > 0 && leben < 2048) {
									player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(leben);
									player.setHealth(leben);
									sender.sendMessage(vars.prefix +"§aThe maximum health of§b " + player.getDisplayName() + " §ahas been set to§c " + leben/2);
									return true;
								}
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
			} else {
				if(args.length<2) {
				}
				else {
					if(player.isOp() || player.hasPermission("hm.setlives")) {
					if(isAlphaNumeric(args[0])==true) {
						toedit = Bukkit.getServer().getPlayer(args[0]);
						if(toedit != null) {
							if(isNumeric(args[1])){
								leben = Double.parseDouble(args[1]);
								leben = leben * 2;
								if(leben > 0 && leben < 2048) {
									toedit.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(leben);
									toedit.setHealth(leben);
									sender.sendMessage(vars.prefix +"§aThe maximum health of§b " + toedit.getDisplayName() + " §ahas been set to§c " + leben/2);
									return true;
								}
							}
						}
						else {
							sender.sendMessage(vars.prefix +"§cThis Player is not online!");
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
