/*
 * ModBlocks.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * This is where all the blocks in this mod get initialized.
 * Called in KingdomCompanion.java
 */

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
