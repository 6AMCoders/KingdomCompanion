/*
 * BlockSpikes.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion.blocks;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;
import com.iamtechi27.kingdomcompanion.util.SpikeDamage;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class BlockSpikes extends Block {

	private String name = "spikes";
	
	// constructor. called in ModBlocks.java
	public BlockSpikes() {
		super(Material.rock);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		this.setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerBlock(this, name);
	}
	
	// this is where the magic happens. when the player falls on it, it checks to see if the entity is living, then applies it's max health in damage.
	@Override
	public void onFallenUpon(World par1World, int par2, int par3, int par4, Entity entity, float par6) {
		
		if (entity instanceof EntityLivingBase)
		entity.attackEntityFrom(new SpikeDamage(), ((EntityLivingBase)entity).getMaxHealth());
	}
	
	// applies a little damage when the player touches the block
	@Override
	public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
		entity.attackEntityFrom(new SpikeDamage(), 1.0F);
	}
	
	// bounding box or something. without this, I can't do damage to players standing next to the block.
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z)
    {
        float f = 0.0625F;
        return AxisAlignedBB.getBoundingBox((double)((float)x + f), (double)y, (double)((float)z + f), (double)((float)(x + 1) - f), (double)((float)(y + 1) - f), (double)((float)(z + 1) - f));
    }
	
	// uses same render type as sugar cane etc
	@Override
	public int getRenderType()
    {
        return 1;
    }
	
	// returning false causes adjacent sides of other blocks to render. otherwise you can see through the world
	@Override
	public boolean isOpaqueCube()
    {
        return false;
    }
	
}
