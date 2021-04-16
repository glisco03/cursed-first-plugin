package com.glisco03.HealthPlus.main;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

import com.glisco03.HealthPlus.Timers.Timer1L;
import com.glisco03.HealthPlus.Timers.Timer20L;
import com.glisco03.HealthPlus.Timers.Timer600L;
import com.glisco03.HealthPlus.commands.command_addhealth;
import com.glisco03.HealthPlus.commands.command_heal;
import com.glisco03.HealthPlus.commands.command_hstatus;
import com.glisco03.HealthPlus.commands.command_removehealth;
import com.glisco03.HealthPlus.commands.command_setfood;
import com.glisco03.HealthPlus.commands.command_sethealth;
import com.glisco03.HealthPlus.commands.command_setmaxhealth;
import com.glisco03.HealthPlus.commands.command_setsaturation;
import com.glisco03.HealthPlus.events.EventListener;

public class main extends JavaPlugin implements Listener{
	
	Logger log;
	
	public static String prefix = "§1[§4Health§2Manager§1]§r ";
	
	public static JavaPlugin hmplugin;
	
	public static NamespacedKey key(String name) {
		return new NamespacedKey(hmplugin, name);
	}

	@Override
	public void onEnable() {
		super.onEnable();
		hmplugin = this;
		new EventListener(this);
		new vars();
		Logger.getLogger("l");
		getCommand("sethealth").setExecutor(new command_sethealth());
		getCommand("setmaxhealth").setExecutor(new command_setmaxhealth());
		getCommand("setsaturation").setExecutor(new command_setsaturation());
		getCommand("setfood").setExecutor(new command_setfood());
		getCommand("hstatus").setExecutor(new command_hstatus());
		getCommand("heal").setExecutor(new command_heal());
		getCommand("addhealth").setExecutor(new command_addhealth());
		getCommand("removehealth").setExecutor(new command_removehealth());
		
		Bukkit.getScheduler().runTaskTimer(this, new Timer1L(), 1L, 1L);
		Bukkit.getScheduler().runTaskTimer(this, new Timer20L(), 20L, 20L);
		Bukkit.getScheduler().runTaskTimer(this, new Timer600L(), 1L, 600L);
	}
}