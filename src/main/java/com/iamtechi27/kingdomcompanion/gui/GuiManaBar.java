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
	
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public void onRenderExperienceBar(RenderGameOverlayEvent event) {
		
		if (event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		
		ExtendedPlayer props = ExtendedPlayer.get(this.mc.thePlayer);
		
		if (props == null || props.getMaxMana() == 0) {
			return;
		}
		
		int xPos = ((event.resolution.getScaledWidth() / 2) + 91);
		int yPos = (event.resolution.getScaledHeight() - 22);
		GL11.glPushMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		GL11.glDisable(GL11.GL_LIGHTING);
		this.mc.getTextureManager().bindTexture(texturepath);
		this.drawTexturedModalRect(xPos, yPos, 0, 0, 63, 22);
		int manabarwidth = (int)(((float) props.getCurrentMana() / props.getMaxMana()) * 56);
		this.drawTexturedModalRect(xPos + 3, yPos + 3, 0, 22, manabarwidth, 16);
		GL11.glPopMatrix();
	}
	
}
