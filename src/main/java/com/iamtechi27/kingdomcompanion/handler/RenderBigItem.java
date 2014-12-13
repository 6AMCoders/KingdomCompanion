package com.iamtechi27.kingdomcompanion.handler;

import org.lwjgl.opengl.GL11;

import com.iamtechi27.kingdomcompanion.items.ModItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;

public class RenderBigItem implements IItemRenderer {

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		
		return type == ItemRenderType.EQUIPPED || type == ItemRenderType.EQUIPPED_FIRST_PERSON;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item,
			ItemRendererHelper helper) {
		switch (type) {
		case ENTITY: {
		return (helper == ItemRendererHelper.ENTITY_BOBBING ||
		helper == ItemRendererHelper.ENTITY_ROTATION
		); // not helper == ItemRendererHelper.BLOCK_3D
		}
		case EQUIPPED: {
		return false;
		// not (helper == ItemRendererHelper.BLOCK_3D || helper == ItemRendererHelper.EQUIPPED_BLOCK);
		}
		case EQUIPPED_FIRST_PERSON: {
		return false;
		// not (helper == ItemRendererHelper.EQUIPPED_BLOCK);
		}
		case INVENTORY: {
		return false;
		// not (helper == ItemRendererHelper.INVENTORY_BLOCK);
		}
		default: {
		return false;
		}
		}
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {

		switch (type) {
		// data[1] is the entity holding the item; it could be null in cases other than equipped
		case EQUIPPED_FIRST_PERSON:
			 // using a custom method to flag if it's first or third person:
			 renderEquippedItem(item, (EntityLivingBase) data[1], true);
			 break;
		case EQUIPPED:
			 renderEquippedItem(item, (EntityLivingBase) data[1], false);
			 break;
		default:
		}
		}
	
	private void renderEquippedItem(ItemStack stack, EntityLivingBase entity, boolean firstPerson) {
		
		Item item = stack.getItem();
		IIcon icon = item.getIcon(stack, 0);
		
		if (item == ModItems.rapier){
			
			GL11.glPushMatrix();
			GL11.glScaled(10.0D, 10.0D, 10.0D);
			//GL11.glRotated(180, 1.0D, 0.0D, 0.0D);
			//GL11.glRotated(100, 0.0D, 1.0D, 0.0D);
			GL11.glRotated(20, 0.0D, 0.0D, 1.0D);
			GL11.glTranslated(-1.1D, -0.15D, 0.0D);
			ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), 255, 255, 0.0625F);
			GL11.glPopMatrix();
		}else{
		
		GL11.glPushMatrix();

		// whatever render code you want
		//Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation("kingdomcompanion:textures/items/itemhammerbone.png"));
		
		GL11.glScaled(1.7D, 1.7D, 1.7D);

		GL11.glTranslated(-0.4D, -0.1D, 0.0D);
		
		ItemRenderer.renderItemIn2D(Tessellator.instance, icon.getMaxU(), icon.getMinV(), icon.getMinU(), icon.getMaxV(), 255, 255, 0.0625F);
		GL11.glPopMatrix();
		}
	}

	
	
}
