package com.iamtechi27.kingdomcompanion.util;

import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.entity.PlayerClass;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class PlayerUtils {

	public static boolean hasItem(EntityPlayer player, Item item) {
		for (ItemStack stack :  player.inventory.mainInventory) {
			if (stack != null && stack.getItem() == item) {
				return true;
			}
		}
		return false;
	}

	public static boolean hasItem(EntityPlayer player, ItemStack itemstack) {
		return hasItem(player, itemstack.getItem());
	}

	public static boolean consumeInventoryItem(EntityPlayer player,
			ItemStack itemStack, int required) {
		return consumeInventoryItem(player, itemStack.getItem(), required);
	}
	/*
	 * Copy/pasted from coolAlias's "Zelda Sword Skills" mod at http://goo.gl/RcFeCx
	 * modified a bit for my uses
	 */
	public static boolean consumeInventoryItem(EntityPlayer player, Item item, int required) {
		int consumed = required;
		for (int i = 0; i < player.inventory.getSizeInventory() && consumed > 0; ++i) {
			ItemStack invStack = player.inventory.getStackInSlot(i);
			if (invStack != null && invStack.getItem() == item) {
				if (invStack.stackSize <= consumed) {
					consumed -= invStack.stackSize;
					player.inventory.setInventorySlotContents(i, null);
				} else {
					player.inventory.setInventorySlotContents(i, invStack.splitStack(invStack.stackSize - consumed));
					consumed = 0;
					break;
				}
			}
		}
		if (consumed > 0) {
			player.inventory.addItemStackToInventory(new ItemStack(item, required - consumed));
		}
		return consumed == 0;
	}
	
	public static boolean canPlayerUseItem(EntityPlayer player, WeaponClass weaponclass) {
		
		PlayerClass pc = ExtendedPlayer.get(player).getPlayerClass();
		switch (weaponclass) {
		case SWORD:
			if (pc == PlayerClass.NONE || pc == PlayerClass.WARRIOR || pc == PlayerClass.KNIGHT || pc == PlayerClass.SPELLBLADE || pc == PlayerClass.REAPER)
				return true;
			return false;
		case DAGGER:
			if (pc == PlayerClass.NONE || pc == PlayerClass.RANGER || pc == PlayerClass.MARKSMAN || pc == PlayerClass.ROGUE || pc == PlayerClass.ARCANE_RANGER || pc == PlayerClass.HUNTER)
				return true;
			return false;
		case AXE:
			if (pc == PlayerClass.NONE || pc == PlayerClass.WARRIOR || pc == PlayerClass.KNIGHT || pc == PlayerClass.SPELLBLADE || pc == PlayerClass.ROGUE || pc == PlayerClass.REAPER)
				return true;
			return false;
		case SCYTHE:
			if (pc == PlayerClass.NONE || pc == PlayerClass.CLERIC || pc == PlayerClass.PALADIN || pc == PlayerClass.WHITE_MAGE || pc == PlayerClass.HUNTER || pc == PlayerClass.REAPER)
				return true;
			return false;
		case HAMMER:
			if (pc == PlayerClass.NONE || pc == PlayerClass.WARRIOR || pc == PlayerClass.KNIGHT || pc == PlayerClass.PALADIN || pc == PlayerClass.SPELLBLADE || pc == PlayerClass.REAPER)
				return true;
			return false;
		case BOW:
			if (pc ==  PlayerClass.NONE || pc == PlayerClass.RANGER || pc == PlayerClass.MARKSMAN || pc == PlayerClass.ROGUE || pc == PlayerClass.ARCANE_RANGER || pc == PlayerClass.HUNTER)
				return true;
			return false;
		default:
			return false;
		}
	}
	
}
