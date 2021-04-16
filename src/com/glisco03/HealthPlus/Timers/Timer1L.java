package com.glisco03.HealthPlus.Timers;

import org.bukkit.entity.Player;

import com.glisco03.HealthPlus.events.EventListener;
import com.glisco03.HealthPlus.main.vars;

public class Timer1L implements Runnable{

	public void run() {
		if(!vars.toquery.isEmpty()) {
			for(Player p : vars.toquery) {
				p.sendMessage(vars.prefix +"§aType Playername into the Chat:");
				vars.parsing.add(p);
				vars.toremove.add(p);
			}
		}
		vars.toquery.removeAll(vars.toremove);
	
		if(!vars.tosethealth.isEmpty()) {
			for(Player p : vars.tosethealth) {
				p.setHealth(EventListener.h);
				vars.tosetremove.add(p);
			}
		}
		vars.tosethealth.removeAll(vars.tosetremove);
	}
}
