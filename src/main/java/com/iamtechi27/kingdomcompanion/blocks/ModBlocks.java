package com.iamtechi27.kingdomcompanion.blocks;

import net.minecraft.block.Block;

public final class ModBlocks {

	public static Block bonePile;
	public static Block chains;
	
	public static void init(){
		
		bonePile = new BonePile();
		chains = new BlockChains();
		
	}
	
}
