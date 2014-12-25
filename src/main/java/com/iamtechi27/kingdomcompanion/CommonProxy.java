/*
 * CommonProxy.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.iamtechi27.kingdomcompanion.handler.PlayerTickHandler;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy {

	private static final Map<String, NBTTagCompound> extendedEntityData = new HashMap<String, NBTTagCompound>();
	
	public void preInit(FMLPreInitializationEvent e) {

    }

    //registers the PlayerTickHandler, which is used for mana regen.
	public void Init(FMLInitializationEvent e) {
    	FMLCommonHandler.instance().bus().register(new PlayerTickHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

	//this is here because it was getting called in commonproxy for some reason,
    //even though it should've been using the server proxy. whatever.
    //stores entity data (player class and mana) on death
    public void storeEntityData(String name, NBTTagCompound compound) {
		extendedEntityData.put(name, compound);
		//System.out.println("Save'd to commonproxy"); //debug
	}

	//see above comment, except this one loads after death
    public NBTTagCompound getEntityData(String name) {
		//System.out.println("load'd from commonproxy"); //debug
		return extendedEntityData.remove(name);
	}

	//I don't remember why I put this here. Useless for now.
    public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		switch (ctx.side) {
		case CLIENT: 
			assert false: "Message for CLIENT received on dedicated server";
			return null;
		case SERVER:
			EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
			return entityPlayerMP;
		default:
			assert false : "Invalid side in TestMsgHandler: " + ctx.side;
			return null;
		}
		
	}
	
	
	
}
