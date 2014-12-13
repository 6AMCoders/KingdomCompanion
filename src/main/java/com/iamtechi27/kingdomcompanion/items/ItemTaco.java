package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemTaco extends ItemFood {

	private String name = "itemtaco";
	
	public ItemTaco(String type, int heal, float saturation, boolean wolfMeat) {
		
		super(heal, saturation, wolfMeat);
		setUnlocalizedName(Constants.MODID + "_" + name + type);
		setTextureName(Constants.MODID + ":" + name + type);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		GameRegistry.registerItem(this, name + type);
	}
	
}
