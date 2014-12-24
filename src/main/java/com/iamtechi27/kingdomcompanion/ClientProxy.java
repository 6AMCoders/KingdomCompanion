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
		MinecraftForge.EVENT_BUS.register(new GuiManaBar(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new GuiBuffBar(Minecraft.getMinecraft()));
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		// TODO Auto-generated method stub
		super.postInit(e);
	}

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
