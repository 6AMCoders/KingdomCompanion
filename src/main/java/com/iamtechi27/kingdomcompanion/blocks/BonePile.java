package com.iamtechi27.kingdomcompanion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class BonePile extends Block {

	private String name="bonePile";
	
	public BonePile(){
		
		super(Material.rock);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		this.setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerBlock(this, name);
	}
	
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6){
		par5Entity.fallDistance = 0.0F;
	}
	
}
