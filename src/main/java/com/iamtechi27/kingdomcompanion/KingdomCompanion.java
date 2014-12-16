package com.iamtechi27.kingdomcompanion;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.iamtechi27.kingdomcompanion.blocks.ModBlocks;
import com.iamtechi27.kingdomcompanion.client.GuiHandler;
import com.iamtechi27.kingdomcompanion.crafting.ModCrafting;
import com.iamtechi27.kingdomcompanion.handler.RenderRegistry;
import com.iamtechi27.kingdomcompanion.items.ModItems;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Constants.MODID, name = Constants.MODNAME, version = Constants.VERSION)

public class KingdomCompanion {

	@Mod.Instance(Constants.MODID)
	public static KingdomCompanion instance;
	
	@SidedProxy(clientSide="com.iamtechi27.kingdomcompanion.ClientProxy", serverSide="com.iamtechi27.kingdomcompanion.ServerProxy")
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		
		ModItems.init();
		ModBlocks.init();
		ModCrafting.init();
		this.proxy.preInit(event);
		}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		//NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	
	public static CreativeTabs tabKingdomCompanion = new CreativeTabs("kingdomcompanion"){
		@Override
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem(){
			return ModItems.itemtacobeef;
		}
	};
		
	@EventHandler
	public void serverLoad(FMLServerStartingEvent event)
	{
		//event.registerServerCommand(new GodCommand());
	}
}