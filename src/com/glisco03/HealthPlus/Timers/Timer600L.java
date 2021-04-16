package com.glisco03.HealthPlus.Timers;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.glisco03.HealthPlus.main.vars;

public class Timer600L implements Runnable{

	public void run() {
		for(Player player : Bukkit.getOnlinePlayers()) {
			if(player.getInventory().getHelmet() != null) {
				if(player.getInventory().getHelmet().equals(vars.ith)){
					player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 200, 2));
				}
			}
		}
	}
}
