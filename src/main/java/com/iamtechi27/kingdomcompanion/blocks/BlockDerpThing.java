package com.iamtechi27.kingdomcompanion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDerpThing extends Block implements ITileEntityProvider {

	private String name = "derpthing";
	
	public BlockDerpThing() {
		super(Material.rock);
		setBlockName(name);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		// TODO Auto-generated method stub
		return new TileEntityDerp();
	}

	
	
}
