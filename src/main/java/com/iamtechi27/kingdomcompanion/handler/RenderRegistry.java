package com.iamtechi27.kingdomcompanion.handler;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.iamtechi27.kingdomcompanion.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class RenderRegistry {

	public static void init(){
		//if(world.isRemote){
		/*
		 * It's been a long fucking week of coding. Anyway, heres the values for each rendering type.
		 * 
		 * 0 = Axe, Scythe, and Hammers
		 * 1 = Bows
		 * 2 = Hand of God
		 */
		
		MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolaxe, new RenderBigItem(0, ModItems.whitewoolaxe));
		MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolscythe, new RenderBigItem(0, ModItems.whitewoolscythe));
		MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolhammer, new RenderBigItem(0, ModItems.whitewoolhammer));
		
		MinecraftForgeClient.registerItemRenderer(ModItems.boneaxe, new RenderBigItem(0, ModItems.boneaxe));
		MinecraftForgeClient.registerItemRenderer(ModItems.bonescythe, new RenderBigItem(0, ModItems.bonescythe));
		MinecraftForgeClient.registerItemRenderer(ModItems.bonehammer, new RenderBigItem(0, ModItems.bonehammer));
		
		MinecraftForgeClient.registerItemRenderer(ModItems.enderiumaxe, new RenderBigItem(0, ModItems.enderiumaxe));
		MinecraftForgeClient.registerItemRenderer(ModItems.enderiumscythe, new RenderBigItem(0, ModItems.enderiumscythe));
		MinecraftForgeClient.registerItemRenderer(ModItems.enderiumhammer, new RenderBigItem(0, ModItems.enderiumhammer));
		
		MinecraftForgeClient.registerItemRenderer(ModItems.rapier, new RenderBigItem(2, ModItems.rapier));
		
		//TODO finish bow rendering
		//MinecraftForgeClient.registerItemRenderer(ModItems.itembowtwig, new RenderBigItem(1, ModItems.itembowtwig));
		//}
	}
}
