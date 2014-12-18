package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.lib.Constants;
import com.iamtechi27.kingdomcompanion.util.PlayerUtils;
import com.iamtechi27.kingdomcompanion.util.WeaponClass;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModSword extends ItemSword {

	private int tickCount = 200;
	private int attackSpeed = 0;
	private static boolean thing = false;
	private WeaponClass weaponclass;
	private boolean isUnique;
	
	public ItemModSword(String name, WeaponClass c, ToolMaterial material, int s) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_" + name);
		setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this,  name);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		attackSpeed = s;
		this.weaponclass = c;
	}
	
	public ItemModSword(String mat, WeaponClass c, ToolMaterial material) {
		super(material);
		setUnlocalizedName(Constants.MODID + "_item" + c.toString().toLowerCase() + mat);
		setTextureName(Constants.MODID + ":item" + c.toString().toLowerCase() + mat);
		GameRegistry.registerItem(this, "item" + c.toString().toLowerCase() + mat);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		switch(c) {
		case SWORD:
		case SCYTHE:
			this.attackSpeed = 40;
			break;
		case DAGGER:
			this.attackSpeed = 20;
			break;
		case AXE:
			this.attackSpeed = 50;
			break;
		case HAMMER:
			this.attackSpeed = 70;
			break;
		default:
			break;
		}
		this.weaponclass = c;
	}
	
	public void renderInit(){
		
		
	}
	
	public void onUpdate(ItemStack p_77663_1_, World p_77663_2_, Entity p_77663_3_, int p_77663_4_, boolean p_77663_5_) {
		
		tickCount++;
	}
	
	public boolean onLeftClickEntity(ItemStack stack, EntityPlayer player, Entity entity)
    {
        boolean fuckingThing;
        ExtendedPlayer props = ExtendedPlayer.get(player);
        
        if ((tickCount >= attackSpeed || thing == true) && (PlayerUtils.canPlayerUseItem(player, weaponclass) || this.isUnique)) {
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
		
		return fuckingThing;
    }
	
	
	
}
