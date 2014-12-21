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

    public void Init(FMLInitializationEvent e) {
    	FMLCommonHandler.instance().bus().register(new PlayerTickHandler());
    }

    public void postInit(FMLPostInitializationEvent e) {

    }

	public void storeEntityData(String name, NBTTagCompound compound) {
		// TODO Auto-generated method stub
		//System.out.println("SHOULD NEVER GET HERE SAVE");
		extendedEntityData.put(name, compound);
		//System.out.println("Save'd to commonproxy"); //debug
	}

	public NBTTagCompound getEntityData(String name) {
		// TODO Auto-generated method stub
		//System.out.println("SHOULD NEVER GET HERE LOAD");
		//System.out.println("load'd from commonproxy"); //debug
		return extendedEntityData.remove(name);
	}

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
