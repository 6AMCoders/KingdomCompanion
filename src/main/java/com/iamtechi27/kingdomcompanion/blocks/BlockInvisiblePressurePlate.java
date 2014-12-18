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
	
	public BlockInvisiblePressurePlate() {
		super(name, Material.rock, Sensitivity.players);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		this.setBlockName(Constants.MODID + "_" + name);
		//setBlockTextureName();
		GameRegistry.registerBlock(this, name);
	}
	
	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
         this.blockIcon = Blocks.glass.getBlockTextureFromSide(1);
	}
}
