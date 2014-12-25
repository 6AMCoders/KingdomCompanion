/*
 * ModCrafting.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * All crafting recipes in the mod are added here
 */

package com.iamtechi27.kingdomcompanion.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.iamtechi27.kingdomcompanion.blocks.ModBlocks;
import com.iamtechi27.kingdomcompanion.items.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModCrafting {

	public static void init() {
		GameRegistry.addRecipe(new ItemStack(ModItems.itemtacobeef), new Object[] {"#I#", '#', Items.bread, 'I', Items.cooked_beef});
		GameRegistry.addRecipe(new ItemStack(ModItems.itemtacofish), new Object[] {"#I#", '#', Items.bread, 'I', Items.cooked_fished});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.bonePile), "###", "###", "###", '#', Items.bone);
	}
	
}
