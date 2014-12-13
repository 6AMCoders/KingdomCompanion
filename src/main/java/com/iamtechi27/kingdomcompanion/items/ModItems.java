package com.iamtechi27.kingdomcompanion.items;

import com.iamtechi27.kingdomcompanion.handler.RenderBigItem;

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
	public static Item whitewoolsword;
	public static Item whitewooldagger;
	public static Item whitewoolaxe;
	public static Item whitewoolscythe;
	public static Item whitewoolhammer;
	
	public static Item bonesword;
	public static Item bonedagger;
	public static Item boneaxe;
	public static Item bonescythe;
	public static Item bonehammer;
	
	public static Item itemtacobeef;
	public static Item itemtacofish;
	public static Item modbow;
	
	public static ToolMaterial RAPIER = EnumHelper.addToolMaterial("RAPIER", 0, 250, 0.0F, Float.MAX_VALUE, 14);
	public static ToolMaterial WOOLSWORD = EnumHelper.addToolMaterial("WOOLSWORD", 0, 200, 0.0F, -3.0F, 22);
	public static ToolMaterial WOOLDAGGER = EnumHelper.addToolMaterial("WOOLDAGGER", 0, 200, 0.0F, -3.0F, 22);
	public static ToolMaterial WOOLAXE = EnumHelper.addToolMaterial("WOOLAXE", 0, 200, 0.0F, -2.0F, 22);
	public static ToolMaterial WOOLHAMMER = EnumHelper.addToolMaterial("WOOLHAMMER", 0, 200, 0.0F, -1.0F, 22);
	public static ToolMaterial BONESWORD = EnumHelper.addToolMaterial("BONESWORD", 0, 250, 0.0F, 2.0F, 14);
	public static ToolMaterial BONEDAGGER = EnumHelper.addToolMaterial("BONEDAGGER", 0, 250, 0.0F, 0.0F, 14);
	public static ToolMaterial BONEAXE = EnumHelper.addToolMaterial("BONEAXE", 0, 250, 0.0F, 3.0F, 14);
	public static ToolMaterial BONEHAMMER = EnumHelper.addToolMaterial("BONEHAMMER", 0, 250, 0.0F, 5.0F, 14);
	
	
	public static void init() {
		
		rapier = new ItemRapier(RAPIER);
		whitewoolsword = new ItemModSword("white", "itemwoolsword", WOOLSWORD, swordtime);
		whitewooldagger = new ItemModSword("white", "itemwooldagger", WOOLDAGGER, daggertime);
		whitewoolaxe = new ItemModSword("white", "itemwoolaxe", WOOLAXE, axetime);
		whitewoolscythe = new ItemModSword("white", "itemwoolscythe", WOOLAXE, swordtime);
		whitewoolhammer = new ItemModSword("white", "itemwoolhammer", WOOLHAMMER, hammertime);
		
		bonesword = new ItemModSword("bone", "itemsword", BONESWORD, swordtime);
		bonedagger = new ItemModSword("bone", "itemdagger", BONEDAGGER, daggertime);
		boneaxe = new ItemModSword("bone", "itemaxe", BONEAXE, axetime);
		bonescythe = new ItemModSword("bone", "itemscythe", BONEAXE, swordtime);
		bonehammer = new ItemModSword("bone", "itemhammer", BONEHAMMER, hammertime);
		
		
		
		itemtacobeef = new ItemTaco("beef", 9, 12.8F, false);
		itemtacofish = new ItemTaco("fish", 12, 19.2F, false);
		modbow = new ItemModBow();
		
	}
	
}
