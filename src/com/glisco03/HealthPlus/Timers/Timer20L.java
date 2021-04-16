package com.glisco03.HealthPlus.Timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.main.vars;

public class Timer20L implements Runnable{

	public void run() {
		for(Player p : vars.listening) {
			@SuppressWarnings("deprecation")
			Player toread = Bukkit.getPlayer(p.getMetadata("listeningName").get(0).asString());
			p.sendMessage(vars.prefix +"§aHealth of§b " + toread.getDisplayName() + "§a :§c " + Math.round(toread.getHealth())/2);
		}
	}
}
