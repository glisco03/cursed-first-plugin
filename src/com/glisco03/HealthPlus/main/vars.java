package com.glisco03.HealthPlus.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class vars {

	public static ItemStack blaze = new ItemStack(Material.BLAZE_ROD);
	public static ItemStack ith = new ItemStack(Material.IRON_HELMET);
	
	public static String prefix = "§1[§4Health§2+§1]§r ";
	
	public static List<Player> toquery = new ArrayList<Player>();
	public static List<Player> listening = new ArrayList<Player>();
	public static List<Player> parsing = new ArrayList<Player>();
	public static List<Player> toremove = new ArrayList<Player>();
	public static List<Player> tosethealth = new ArrayList<Player>();
	public static List<Player> tosetremove = new ArrayList<Player>();
	
	public vars() {
		ItemMeta blazem = blaze.getItemMeta();
		blazem.setDisplayName("§cHealth Checker");
		blazem.setLore(Arrays.asList("§bShows the health", "§bof other Players"));
		blaze.setItemMeta(blazem);
		
		ItemMeta imh = ith.getItemMeta();
		imh.setDisplayName("§aRegeneration Helmet");
		imh.setLore(Arrays.asList("§bGrants 10s of", "§bRegeneration every 30s"));
		ith.setItemMeta(imh);
		
		new recipes();
	}
}
