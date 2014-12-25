/*
 * ClientProxy.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;

import com.iamtechi27.kingdomcompanion.gui.GuiBuffBar;
import com.iamtechi27.kingdomcompanion.gui.GuiManaBar;
import com.iamtechi27.kingdomcompanion.handler.RenderRegistry;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class ClientProxy extends CommonProxy {

	//registers the render code used for axes, hammers, and scythes
	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		RenderRegistry.init();
	}

	//registers the event listeners that render my mana bar and the potion status bar
	@Override
	public void Init(FMLInitializationEvent e) {
		super.Init(e);
		MinecraftForge.EVENT_BUS.register(new GuiManaBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiBuffBar(Minecraft.getMinecraft()));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

	//little tool used to get a player from a message
	//used in networking so I can figure out the player's username
	@Override
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
		switch (ctx.side) {
		case CLIENT: 
			EntityPlayer entityClientPlayerMP = Minecraft.getMinecraft().thePlayer;
			return entityClientPlayerMP;
		case SERVER:
			EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
			return entityPlayerMP;
		default:
			assert false : "Invalid side in TestMsgHandler: " + ctx.side;
			return null;
		}
	}
}
