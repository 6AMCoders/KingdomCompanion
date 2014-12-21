package com.iamtechi27.kingdomcompanion.handler;

import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;

import net.minecraft.client.Minecraft;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;

public class PlayerTickHandler {

	private Minecraft mc;
	
	public PlayerTickHandler() {
		//this.mc = mc;
	}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if(event.side == Side.SERVER) {
			//System.out.println("I'm a server!");
			ExtendedPlayer.get(event.player).regenMana();
		}
	}
	
}
