/*
 * KingdomCompanion.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import com.iamtechi27.kingdomcompanion.blocks.ModBlocks;
import com.iamtechi27.kingdomcompanion.client.GuiHandler;
import com.iamtechi27.kingdomcompanion.command.ClassCommand;
import com.iamtechi27.kingdomcompanion.crafting.ModCrafting;
import com.iamtechi27.kingdomcompanion.gui.GuiBuffBar;
import com.iamtechi27.kingdomcompanion.handler.KCEventHandler;
import com.iamtechi27.kingdomcompanion.handler.RenderRegistry;
import com.iamtechi27.kingdomcompanion.items.ModItems;
import com.iamtechi27.kingdomcompanion.lib.Constants;
import com.iamtechi27.kingdomcompanion.network.CurrentManaMessage;
import com.iamtechi27.kingdomcompanion.network.MaxManaMessage;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//declaring stuff for forge
@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)

public class KingdomCompanion {

	//declaring networking stuff
	public static final SimpleNetworkWrapper CURRENTMANANETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("currentmana");
	public static final SimpleNetworkWrapper MAXMANANETWORK = NetworkRegistry.INSTANCE.newSimpleChannel("maxmana");
	
	//I don't really remember what this is used for...
	@Mod.Instance(Constants.MODID)
	public static KingdomCompanion instance;
	
	//setup for sided proxy
	@SidedProxy(clientSide="com.iamtechi27.kingdomcompanion.ClientProxy", serverSide="com.iamtechi27.kingdomcompanion.ServerProxy")
	public static CommonProxy proxy;
	
	/*
	 * setting up all items, blocks, and crafting
	 * also calls preInit() in appropriate proxy
	 */
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ModItems.init();
		ModBlocks.init();
		ModCrafting.init();
		this.proxy.preInit(event);
		}
	
	/*
	 * setting up networking for syncing data
	 * data used in displaying mana bar
	 * also calls init() in the appropriate proxy
	 */
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		CURRENTMANANETWORK.registerMessage(CurrentManaMessage.Handler.class, CurrentManaMessage.class, 0, Side.CLIENT);
		MAXMANANETWORK.registerMessage(MaxManaMessage.Handler.class, MaxManaMessage.class, 1, Side.CLIENT);
		this.proxy.Init(event);
	}
	
	/*
	 * setup for the KC event handler
	 */
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
		MinecraftForge.EVENT_BUS.register(new KCEventHandler());
		
	}
	
	/*
	 * Creative tab for this mod. All items for this mod get added to this tab.
	 */
	public static CreativeTabs tabKingdomCompanion = new CreativeTabs("kingdomcompanion"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ModItems.itemtacobeef;
		}
	};
		
	/*
	 * loading the server. Really just used to set up commands.
	 */
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		//event.registerServerCommand(new GodCommand());
		event.registerServerCommand(new ClassCommand());
	}
}