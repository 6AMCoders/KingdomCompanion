package com.iamtechi27.kingdomcompanion.items;

import com.iamtechi27.kingdomcompanion.handler.RenderBigItem;
import com.iamtechi27.kingdomcompanion.util.WeaponClass;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.util.EnumHelper;

public final class ModItems {

	public static int swordtime = 40;
	public static int daggertime = 20;
	public static int axetime = 50;
	public static int hammertime = 70;
	
	public static Item rapier;
	public static Item haseoblade;
	
	public static Item woolsword;
	public static Item wooldagger;
	public static Item woolaxe;
	public static Item woolscythe;
	public static Item woolhammer;
	
	public static Item woodsword;
	public static Item wooddagger;
	public static Item woodaxe;
	public static Item woodscythe;
	public static Item woodhammer;
	
	public static Item bonesword;
	public static Item bonedagger;
	public static Item boneaxe;
	public static Item bonescythe;
	public static Item bonehammer;
	
	public static Item enderiumsword;
	public static Item enderiumdagger;
	public static Item enderiumaxe;
	public static Item enderiumscythe;
	public static Item enderiumhammer;
	
	public static Item itemtacobeef;
	public static Item itemtacofish;
	public static Item itembowtwig;
	public static Item itembowwood;
	public static Item itembowbone;
	public static Item itembowenderium;
	
	public static ToolMaterial RAPIER = EnumHelper.addToolMaterial("RAPIER", 0, 250, 0.0F, Float.MAX_VALUE, 14);
	public static ToolMaterial HASEO = EnumHelper.addToolMaterial("HASEO", 0, 750, 0.0F, 5.0F, 22);
	
	public static ToolMaterial WOOLSWORD = EnumHelper.addToolMaterial("WOOLSWORD", 0, 200, 0.0F, -3.0F, 22);
	public static ToolMaterial WOOLDAGGER = EnumHelper.addToolMaterial("WOOLDAGGER", 0, 200, 0.0F, -3.0F, 22);
	public static ToolMaterial WOOLAXE = EnumHelper.addToolMaterial("WOOLAXE", 0, 200, 0.0F, -2.0F, 22);
	public static ToolMaterial WOOLHAMMER = EnumHelper.addToolMaterial("WOOLHAMMER", 0, 200, 0.0F, -1.0F, 22);
	
	public static ToolMaterial WOODSWORD = EnumHelper.addToolMaterial("WOODSWORD", 0, 225, 0.0F, -1.0F, 22);
	public static ToolMaterial WOODDAGGER = EnumHelper.addToolMaterial("WOODDAGGER", 0, 225, 0.0F, -2.0F, 22);
	public static ToolMaterial WOODAXE = EnumHelper.addToolMaterial("WOODAXE", 0, 225, 0.0F, 0.0F, 22);
	public static ToolMaterial WOODHAMMER = EnumHelper.addToolMaterial("WOODHAMMER", 0, 225, 0.0F, 2.0F, 22);
	
	public static ToolMaterial BONESWORD = EnumHelper.addToolMaterial("BONESWORD", 0, 250, 0.0F, 2.0F, 14);
	public static ToolMaterial BONEDAGGER = EnumHelper.addToolMaterial("BONEDAGGER", 0, 250, 0.0F, 0.0F, 14);
	public static ToolMaterial BONEAXE = EnumHelper.addToolMaterial("BONEAXE", 0, 250, 0.0F, 3.0F, 14);
	public static ToolMaterial BONEHAMMER = EnumHelper.addToolMaterial("BONEHAMMER", 0, 250, 0.0F, 5.0F, 14);
	
	public static ToolMaterial ENDERIUMSWORD = EnumHelper.addToolMaterial("ENDERIUMSWORD", 0, 750, 0.0F, 4.0F, 22);
	public static ToolMaterial ENDERIUMDAGGER = EnumHelper.addToolMaterial("ENDERIUMDAGGER", 0, 750, 0.0F, 1.0F, 22);
	public static ToolMaterial ENDERIUMAXE = EnumHelper.addToolMaterial("ENDERIUMAXE", 0, 750, 0.0F, 5.0F, 22);
	public static ToolMaterial ENDERIUMHAMMER = EnumHelper.addToolMaterial("ENDERIUMSWORD", 0, 750, 0.0F, 8.0F, 22);
	
	public static void init() {
		
		rapier = new ItemRapier(RAPIER);
		haseoblade = new ItemModSword("itembladehaseo", WeaponClass.SWORD, HASEO, 20);
		
		woolsword = new ItemModSword("wool", WeaponClass.SWORD, WOOLSWORD);
		wooldagger = new ItemModSword("wool", WeaponClass.DAGGER, WOOLDAGGER);
		woolaxe = new ItemModSword("wool", WeaponClass.AXE, WOOLAXE);
		woolscythe = new ItemModSword("wool", WeaponClass.SCYTHE, WOOLAXE);
		woolhammer = new ItemModSword("wool", WeaponClass.HAMMER, WOOLHAMMER);
		
		woodsword = new ItemModSword("wood", WeaponClass.SWORD, WOODSWORD);
		wooddagger = new ItemModSword("wood", WeaponClass.DAGGER, WOODDAGGER);
		woodaxe = new ItemModSword("wood", WeaponClass.AXE, WOODAXE);
		woodscythe = new ItemModSword("wood", WeaponClass.SCYTHE, WOODAXE);
		woodhammer = new ItemModSword("wood", WeaponClass.HAMMER, WOODHAMMER);
		
		bonesword = new ItemModSword("bone", WeaponClass.SWORD, BONESWORD);
		bonedagger = new ItemModSword("bone", WeaponClass.DAGGER, BONEDAGGER);
		boneaxe = new ItemModSword("bone", WeaponClass.AXE, BONEAXE);
		bonescythe = new ItemModSword("bone", WeaponClass.SCYTHE, BONEAXE);
		bonehammer = new ItemModSword("bone", WeaponClass.HAMMER, BONEHAMMER);
		
		enderiumsword = new ItemModSword("enderium", WeaponClass.SWORD, ENDERIUMSWORD);
		enderiumdagger = new ItemModSword("enderium", WeaponClass.DAGGER, ENDERIUMDAGGER);
		enderiumaxe = new ItemModSword("enderium", WeaponClass.AXE, ENDERIUMAXE);
		enderiumscythe = new ItemModSword("enderium", WeaponClass.SCYTHE, ENDERIUMAXE);
		enderiumhammer = new ItemModSword("enderium", WeaponClass.HAMMER, ENDERIUMHAMMER);
		
		itemtacobeef = new ItemTaco("beef", 9, 12.8F, false);
		itemtacofish = new ItemTaco("fish", 12, 19.2F, false);
		
		itembowtwig = new ItemModBow("twig", 0.5D);
		itembowwood = new ItemModBow("wood", 1.05D);
		itembowbone = new ItemModBow("bone", 1.65D);
		itembowenderium = new ItemModBow("enderium", 1.7D);
		
		
	}
	
}
