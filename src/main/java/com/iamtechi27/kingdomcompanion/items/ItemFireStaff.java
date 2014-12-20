package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemFireStaff extends Item {

	public ItemFireStaff() {
		super();
		this.setUnlocalizedName("thing");
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		GameRegistry.registerItem(this, "thing");
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if(props.consumeMana(5)) {
				System.out.println("[MANA ITEM Player had enough mana");
			} else {
				System.out.println("[MANA ITEM] Player ran out of mana");
			}
		}
		return stack;
	}
	
}
