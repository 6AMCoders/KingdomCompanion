package com.iamtechi27.kingdomcompanion.handler;

import net.minecraft.server.MinecraftServer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.iamtechi27.kingdomcompanion.items.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;


public class RenderRegistry {

	public static void init(){
		//if(world.isRemote){
			MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolaxe, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolscythe, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.whitewoolhammer, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.boneaxe, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.bonescythe, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.bonehammer, new RenderBigItem());
			MinecraftForgeClient.registerItemRenderer(ModItems.rapier, new RenderBigItem());
		//}
	}
}
