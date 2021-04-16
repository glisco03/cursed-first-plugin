package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_hstatus implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = null;
		double satt;
		
		if(command.getName().equalsIgnoreCase("hstatus")) {
			if(args.length<1) {
			} else {
				if(sender.isOp() || sender.hasPermission("hm.hstatus")) {
				p = Bukkit.getServer().getPlayer(args[0]);
				if(p!=null) {
					sender.sendMessage("§0---- §9Health Status of§a " + p.getDisplayName() + " §0----");
					sender.sendMessage("§6Health§f:§7 " + roundToHalf(p.getHealth()/2));
					sender.sendMessage("§6Max. Health§f:§7 " + p.getMaxHealth()/2);
					satt = (double) p.getFoodLevel();
					sender.sendMessage("§6Hunger§f:§7 " + satt/2);
					sender.sendMessage("§6Saturation§f:§7 " + p.getSaturation()/2);
					sender.sendMessage("§0---- §9Health Status of§a " + p.getDisplayName() + " §0----");
					
					return true;
				} else {
					sender.sendMessage(vars.prefix +"§cThis Player is not online!");
					return true;
				}
			} else {
				sender.sendMessage(vars.prefix +"§cYou don't have permission!");
				return true;
			}
				
			}
		}
		return false;
	}
	public static double roundToHalf(double d) {
	    return Math.round(d * 2) / 2.0;
	}
}
