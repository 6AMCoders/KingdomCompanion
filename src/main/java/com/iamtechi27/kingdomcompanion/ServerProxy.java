/*
 * ServerProxy.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ServerProxy extends CommonProxy {

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
	}

	@Override
	public void Init(FMLInitializationEvent e) {
		super.Init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}
	
	// useless. commonproxy variant gets called instead
	public void storeEntityData(String name, NBTTagCompound compound) {
		
		extendedEntityData.put(name, compound);
		System.out.println("Save'd");
		
	}
	
	// see above comment
	public NBTTagCompound getEntityData(String name) {
		System.out.println("load'd");
		return extendedEntityData.remove(name);
	}

}
