package com.iamtechi27.kingdomcompanion.items;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;

public class ItemNetherOrb extends Item {

	public IIcon[] icons = new IIcon[6];
	private String name;
	
	public ItemNetherOrb(String unlocalizedName) {
		super();
		this.name = unlocalizedName;
		this.setUnlocalizedName(Constants.MODID + "_" + name);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		GameRegistry.registerItem(this, name);
	}
	
	@Override
	public void registerIcons(IIconRegister reg) {
		for (int i = 0; i < 6; i++) {
			this.icons[i] = reg.registerIcon(Constants.MODID + ":" + "itemnetherorb" + (i+1));
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int meta) {
		if (meta > 5)
			meta = 0;
		return this.icons[meta];
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (int i = 0; i < 6; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		switch (stack.getItemDamage()) {
		case 0:
			return this.getUnlocalizedName() + "_enderium";
		case 1:
			return this.getUnlocalizedName() + "_topaz";
		case 2:
			return this.getUnlocalizedName() + "_mithram";
		case 3:
			return this.getUnlocalizedName() + "_thalassium";
		case 4:
			return this.getUnlocalizedName() + "_demonglass";
		case 5:
			return this.getUnlocalizedName() + "_flourite";
		default:
			return this.getUnlocalizedName();
		}
	}
}
