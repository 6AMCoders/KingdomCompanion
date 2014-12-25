/*
 * GuiManaBar.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * Mana bar for players to see.
 */

package com.iamtechi27.kingdomcompanion.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiManaBar extends Gui {

	private Minecraft mc;
	private static final ResourceLocation texturepath = new ResourceLocation(Constants.MODID, "textures/gui/manabar.png");
	
	public GuiManaBar(Minecraft mc) {
		super();
		this.mc = mc;
	}
	
	// listener for the game overlay render event thingy. Then we render our thing.
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderGameOverlay(RenderGameOverlayEvent event) {
		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		
		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);
		
		// we don't display a mana bar if the player doesn't have mana.
		// this will be useful when I make warrior classes not have mana as to not clutter the screen
		if (props == null || props.getMaxMana() == 0) {
			return;
		}
		
		// positions the bar at the end of the player's hotbar
		int xPos = ((event.resolution.getScaledWidth() / 2) + 91);
		int yPos = (event.resolution.getScaledHeight() - 22);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.getTextureManager().bindTexture(texturepath);
		this.drawTexturedModalRect(xPos, yPos, 0, 0, 63, 22);
		int manabarwidth = (int)(((float) props.getCurrentMana() / props.getMaxMana()) * 56);
		// where the actual rendering happens. just look long enough, you'll figure it out.
		this.drawTexturedModalRect(xPos + 3, yPos + 3, 0, 22, manabarwidth, 16);
		GL11.glPopMatrix();
	}
	
}
