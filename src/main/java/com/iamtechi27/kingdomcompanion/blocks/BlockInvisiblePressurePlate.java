/*
 * BlockInvisiblePressurePlate.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion.blocks;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.BlockPressurePlate;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class BlockInvisiblePressurePlate extends BlockPressurePlate {

	private static String name = "invisiblepressureplate";
	
	// constructor. called in ModBlocks.java
	public BlockInvisiblePressurePlate() {
		// calls super constructor. tells it the name of this block, material, and the sensitivity
		// this pressure plate can only be set off by players.
		super(name, Material.rock, Sensitivity.players);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		this.setBlockName(Constants.MODID + "_" + name);
		GameRegistry.registerBlock(this, name);
	}
	
	// returning -1 means the block doesn't render. this is how the block is invisible.
	@Override
	public int getRenderType() {
		return -1;
	}
	
	// I pull the texture from glass. you never see it unless you hold the item though
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
         this.blockIcon = Blocks.glass.getBlockTextureFromSide(1);
	}
}
