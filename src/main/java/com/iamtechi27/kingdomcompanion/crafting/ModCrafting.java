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
