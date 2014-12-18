package com.iamtechi27.kingdomcompanion.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public final class ModBlocks {

	public static Block bonePile;
	public static Block chains;
	public static Block spikes;
	public static Block invisiblepressureplate;
	
	public static void init(){
		
		bonePile = new BonePile();
		chains = new BlockChains();
		spikes = new BlockSpikes();
		invisiblepressureplate = new BlockInvisiblePressurePlate();
		
	}
	
}
