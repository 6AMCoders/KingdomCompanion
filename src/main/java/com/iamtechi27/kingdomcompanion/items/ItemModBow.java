package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemModBow extends Item {

	private String name = "modbow";
	private float thing = 2.0F;
	
	public ItemModBow(){
		setUnlocalizedName(Constants.MODID + "_" + name);
		//setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
	}
	
	public ItemStack onItemRightClick(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer par3EntityPlayer)
    {
        if (par3EntityPlayer.capabilities.isCreativeMode || par3EntityPlayer.inventory.consumeInventoryItem(Items.arrow))
        {
        	p_77659_2_.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));

        	if (!p_77659_2_.isRemote)
        	{
        		p_77659_2_.spawnEntityInWorld(new EntityArrow(p_77659_2_, par3EntityPlayer, thing));
        	}
        }
        return p_77659_1_;
    }
	
}
