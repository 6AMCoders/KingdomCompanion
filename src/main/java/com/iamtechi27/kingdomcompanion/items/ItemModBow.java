package com.iamtechi27.kingdomcompanion.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;
import com.iamtechi27.kingdomcompanion.util.PlayerUtils;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemModBow extends ItemBow {

	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	private String name;
	private double damage;
	private ItemStack stack;
	private EntityPlayer player;
	private ItemStack usingItem;
	private int useRemaining;
	
	public ItemModBow(String n, double d){
		super();
		this.name = n;
		setUnlocalizedName(Constants.MODID + "_itembow" + name);
		setFull3D();
		this.damage = d;
		//setTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerItem(this, name);
		setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		
	}
	
	/*public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
		
		ArrowNockEvent event = new ArrowNockEvent(player, stack);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return event.result;
		}
		return stack;
    }*/
	
	@Override
	public void onPlayerStoppedUsing(ItemStack bow, World world, EntityPlayer player, int ticksRemaining) {
		int ticksInUse = getMaxItemUseDuration(bow) - ticksRemaining;
		ArrowLooseEvent event = new ArrowLooseEvent(player, bow, ticksInUse);
		MinecraftForge.EVENT_BUS.post(event);
		if (event.isCanceled()) {
			return;
		}
		ItemStack arrowStack = getArrowFromInventory(bow, player);
		fireArrow(event, arrowStack, bow, player);
		
	}

	private void fireArrow(ArrowLooseEvent event, ItemStack arrowStack,
			ItemStack bow, EntityPlayer player) {
		
		boolean flag = (player.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, bow) > 0);
		if (flag || PlayerUtils.hasItem(player, arrowStack)) {
			float charge = (float) event.charge / 20.0F;
			charge = Math.min((charge * charge + charge * 2.0F) / 3.0F, 1.0F);
			if ((double) charge < 0.1D) {
				return;
			}
			
			EntityArrow arrowEntity = new EntityArrow(player.worldObj, player, charge * 2.0F);
			if (arrowEntity != null) {
				applyArrowSettings(arrowEntity, event.bow, charge);
				player.worldObj.playSoundAtEntity(player, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + charge * 0.5F);
				if (flag) {
					arrowEntity.canBePickedUp = 2;
				} else {
					PlayerUtils.consumeInventoryItem(player, arrowStack, 1);
				}
				if (!player.worldObj.isRemote) {
					player.worldObj.spawnEntityInWorld(arrowEntity);
				}
			}
		}
		
	}

	/**
	* Copy/pasted from coolAlias's "Zelda Sword Skills" mod at http://goo.gl/RcFeCx
	* Applies vanilla arrow enchantments and sets critical if applicable
	* NOTE: These settings are already added by BattleGear2 when shot from a quiver
	* @param charge should be a value between 0.0F and 1.0F, inclusive
	*/
	public final void applyArrowSettings(EntityArrow arrow, ItemStack bow, float charge) {
		arrow.setDamage(damage);
		if (charge == 1.0F) {
			arrow.setIsCritical(true);
		}
		int k = EnchantmentHelper.getEnchantmentLevel(Enchantment.power.effectId, bow);
		if (k > 0) {
			arrow.setDamage(arrow.getDamage() + (double) k * 0.5D + 0.5D);
		}
		int l = EnchantmentHelper.getEnchantmentLevel(Enchantment.punch.effectId, bow);
		if (l > 0) {
			arrow.setKnockbackStrength(l);
		}
		if (EnchantmentHelper.getEnchantmentLevel(Enchantment.flame.effectId, bow) > 0) {
			arrow.setFire(100);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining) {
		this.stack = stack;
		this.player = player;
		this.usingItem = usingItem;
		this.useRemaining = useRemaining;
		if (usingItem == null) { return itemIcon; }
		int t = stack.getMaxItemUseDuration() - useRemaining;
		return (t > 17 ? iconArray[2] : (t > 13 ? iconArray[1] : (t > 0 ? iconArray[0] : itemIcon)));
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(Constants.MODID + ":itembow" + name + "_standby");
		iconArray = new IIcon[3];
		for (int i = 0; i < iconArray.length; ++i) {
			iconArray[i] = register.registerIcon(Constants.MODID + ":itembow" + name + "_pulling_" + i);
		}
	}
	
	private ItemStack getArrowFromInventory(ItemStack bow, EntityPlayer player) {
		ItemStack arrow = null;
		if (PlayerUtils.hasItem(player, Items.arrow))
			arrow = new ItemStack(Items.arrow);
		
		if (arrow == null && player.capabilities.isCreativeMode) {
			arrow = new ItemStack(Items.arrow);
		}
		return arrow;
	}
	
	public String getIconLocation() {
		
		
		
		return getIcon(stack, 42, player, usingItem, useRemaining).getIconName();
	}
}
