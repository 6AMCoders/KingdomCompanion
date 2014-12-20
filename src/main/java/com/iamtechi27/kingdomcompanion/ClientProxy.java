package com.iamtechi27.kingdomcompanion;

import com.iamtechi27.kingdomcompanion.handler.RenderRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		// TODO Auto-generated method stub
		super.preInit(e);
		RenderRegistry.init();
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		// TODO Auto-generated method stub
		super.Init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}

}
