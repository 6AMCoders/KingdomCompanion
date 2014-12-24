package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.entity.projectile.EntityStaffFireball;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemFireStaff extends Item {

	public ItemFireStaff() {
		super();
		this.setUnlocalizedName("staffwood");
		this.setTextureName(Constants.MODID + ":itemstaffwood");
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		GameRegistry.registerItem(this, "staffwood");
	}
	
	@Override public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (!world.isRemote) {
			ExtendedPlayer props = ExtendedPlayer.get(player);
			if(player.capabilities.isCreativeMode || props.consumeMana(5)) {
				Vec3 v3 = player.getLook(1);
				EntityStaffFireball fireball = new EntityStaffFireball(world, player.posX, player.posY + player.eyeHeight, player.posZ, v3.xCoord, v3.yCoord, v3.zCoord);
				player.worldObj.playSoundAtEntity(player, "mob.ghast.fireball", 1.0F, 1.0F);
				fireball.shootingEntity = player;
				player.worldObj.spawnEntityInWorld(fireball);
			} else {
				//System.out.println("[MANA ITEM] Player ran out of mana");
			}
		}
		return stack;
	}
	
}
