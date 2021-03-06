/*
 * GuiBuffBar.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

/*
 * this entire class was stolen from a tutorial.
 * for the record, I think this code is shit.
 * TODO rewrite this.
 */


package com.iamtechi27.kingdomcompanion.gui;

import java.util.Collection;
import java.util.Iterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;

import org.lwjgl.opengl.GL11;

import com.iamtechi27.kingdomcompanion.items.ModItems;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class GuiBuffBar extends Gui {

	private Minecraft mc;
	
	public GuiBuffBar(Minecraft mc) {
		super();
		this.mc = mc;
	}
	
	private static final int BUFF_ICON_SIZE = 18;
	private static final int BUFF_ICON_SPACING = BUFF_ICON_SIZE + 2; // 2 pixels between buff icons
	private static final int BUFF_ICON_BASE_U_OFFSET = 0;
	private static final int BUFF_ICON_BASE_V_OFFSET = 198;
	private static final int BUFF_ICONS_PER_ROW = 8;
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperiencebar(RenderGameOverlayEvent event) {
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		int xPos = 2;
		int yPos = event.resolution.getScaledHeight() - 20;
		Collection collection = this.mc.thePlayer.getActivePotionEffects();
		if (!collection.isEmpty()) {
			GL11.glPushMatrix();
			GL11.glColor4f(1.0F,  1.0F,  1.0F,  1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			this.mc.renderEngine.bindTexture(new ResourceLocation("textures/gui/container/inventory.png"));
			
			for (Iterator iterator = this.mc.thePlayer.getActivePotionEffects().iterator(); iterator.hasNext(); xPos += BUFF_ICON_SPACING) {
				PotionEffect potioneffect = (PotionEffect) iterator.next();
				Potion potion = Potion.potionTypes[potioneffect.getPotionID()];
				
				if (potion.hasStatusIcon()) {
					int iconIndex = potion.getStatusIconIndex();
					this.drawTexturedModalRect(xPos, yPos,
					BUFF_ICON_BASE_U_OFFSET + iconIndex % BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE, BUFF_ICON_BASE_V_OFFSET +
					iconIndex / BUFF_ICONS_PER_ROW * BUFF_ICON_SIZE,
					BUFF_ICON_SIZE, BUFF_ICON_SIZE);
				}
			}
			GL11.glPopMatrix();
		}
	}
	
}
