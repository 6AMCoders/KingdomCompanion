package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemRapier extends ItemSword {

	private String name = "itemrapier";
	
	public ItemRapier(ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this,  name);
		setCreativeTab(null);
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {		
		if(entity instanceof EntityPlayer && ((EntityPlayer) entity).capabilities.isCreativeMode)
			entity.setDead();
		return false;
    }
}
