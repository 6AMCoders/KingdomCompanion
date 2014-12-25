/*
 * BonePile.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * The first block we added to our mod :')
 */

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
	
	// simple. when an entity lands on this block, it sets their fall distance to 0. no more fall damage :D
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity par5Entity, float par6){
		par5Entity.fallDistance = 0.0F;
	}
	
}
