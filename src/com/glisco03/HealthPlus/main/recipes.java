package com.glisco03.HealthPlus.main;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

public class recipes {

	public recipes() {		
		ShapedRecipe blazerecp = new ShapedRecipe(main.key("blaze"),vars.blaze).shape("ibi", "bsb", "ibi");
		blazerecp.setIngredient('b', Material.BLAZE_POWDER);
		blazerecp.setIngredient('i', Material.IRON_BLOCK);
		blazerecp.setIngredient('s', Material.STICK);
		Bukkit.addRecipe(blazerecp);
		
		ShapedRecipe helmetrecp = new ShapedRecipe(main.key("ith"), vars.ith).shape(" d ", "bib", " r ");
		helmetrecp.setIngredient('d', Material.DIAMOND);
		helmetrecp.setIngredient('b', Material.BLAZE_POWDER);
		helmetrecp.setIngredient('i', Material.IRON_HELMET);
		helmetrecp.setIngredient('r', Material.MAGMA_CREAM);
		Bukkit.addRecipe(helmetrecp);
	}
}
