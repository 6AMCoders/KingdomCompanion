package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModSword extends ItemSword {

	//private String name = "itemwoolsword";
	private int tickCount = 200;
	private int attackSpeed = 0;
	private static boolean thing = false;
	
	public ItemModSword(String mat, String name, ToolMaterial material, int s) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name + mat);
		setTextureName(Constants.MODID + ":" + name + mat);
		GameRegistry.registerItem(this,  name + mat);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		attackSpeed = s;
	}
	
	public void renderInit(){
		
		
	}
	
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		
		tickCount++;
		//System.out.println(tickCount);	//debug thing
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        boolean fuckingThing;
		if (tickCount >= attackSpeed || thing == true) {
        	tickCount = 0;
        	fuckingThing = false;
        	if (thing == true){
        		thing = false;
        	}else
        		thing = true;
        }else{
        	fuckingThing = true;
        	thing = false;
        }
		
		//System.out.println(fuckingThing);	//other debug thing
		return fuckingThing;
    }
	
}
