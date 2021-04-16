package com.glisco03.HealthPlus.commands;

import org.bukkit.Bukkit;
import org.bukkit.attribute.Attribute;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class command_heal implements CommandExecutor{

	public String prefix = "§1[§4Health§2Manager§1]§r ";
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = null;
		
		if(sender instanceof Player) {
			p = (Player)sender;
		}
		
		if(command.getName().equalsIgnoreCase("heal")) {
			if(args.length<1) {
				
			} else {
				if(sender.isOp() || sender.hasPermission("hm.heal")) {
				p = Bukkit.getServer().getPlayer(args[0]);
				if(p!=null) {
					p.setHealth(p.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue());
					p.setFoodLevel(20);
					p.setSaturation(20);
					sender.sendMessage(vars.prefix +"§aHealed the player§b " + p.getDisplayName());
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
}
