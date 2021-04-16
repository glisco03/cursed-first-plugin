package com.glisco03.HealthPlus.events;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.java.JavaPlugin;

import com.glisco03.HealthPlus.main.vars;

public class EventListener implements Listener{
	
	public JavaPlugin pl;
	
	public MetadataValue metadata;
	
	public static double h = 0;
	
	public void onEnable() {	
		}
	
	public EventListener(JavaPlugin plugin) {
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
		pl = plugin;
		onEnable();
	}
	
	 @EventHandler
	 public void onBlazeClick(PlayerInteractEvent e) {
		 if(e.getAction() != Action.RIGHT_CLICK_AIR) {
			 Player p = e.getPlayer();
			if(p.getInventory().getItemInMainHand().equals(vars.blaze)) {
				if(p.hasMetadata("listeningName")) {
					p.sendMessage(vars.prefix +"§cCancelled Monitoring of§b " + p.getMetadata("listeningName").get(0).asString());
					p.removeMetadata("listeningName", pl);
					vars.listening.remove(p);
				} else {
					vars.toquery.add(p);
				}
			} 
		 }
		 
	}
	 @EventHandler
	 public void onChat(AsyncPlayerChatEvent e) {
		 Player p = e.getPlayer();
		 if(vars.parsing.contains(p)) {
			 @SuppressWarnings("deprecation")
			Player test = Bukkit.getPlayer(e.getMessage());
			 if(test != null) {
				 p.setMetadata("listeningName", new FixedMetadataValue(pl, e.getMessage()));
				 p.sendMessage(vars.prefix +"§b" + e.getMessage());
				 p.sendMessage(vars.prefix +"§aStarting Monitoring:");
				 vars.listening.add(p); 
			 } else {
				 p.sendMessage(vars.prefix +"§cThis Player is not online!");
			 }
			 e.setCancelled(true);
			 vars.parsing.remove(p);
		 }
	 }
	@EventHandler
	 public void onCraft(CraftItemEvent e) {
		if(e.getCurrentItem().equals(vars.blaze)) {
			e.getWhoClicked().getInventory().addItem(new ItemStack(Material.IRON_BLOCK, 4));
		}
	 }
	 @EventHandler
	 public void onWorld(PlayerChangedWorldEvent e) {
		 h = e.getPlayer().getHealth();
		 vars.tosethealth.add(e.getPlayer());
		
	 }
}