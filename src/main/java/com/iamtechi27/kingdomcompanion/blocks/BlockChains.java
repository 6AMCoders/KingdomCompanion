/*
 * BlockChains.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 */

package com.iamtechi27.kingdomcompanion.blocks;

import java.util.List;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.lib.Constants;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChains extends Block {

	private String name = "chains";
	
	// constructor. called in ModBlocks.java
	protected BlockChains() {
		super(Material.web);
		this.setCreativeTab(KingdomCompanion.tabKingdomCompanion);
		this.setBlockName(Constants.MODID + "_" + name);
		setBlockTextureName(Constants.MODID + ":" + name);
		GameRegistry.registerBlock(this, name);
	}

    // collision box. I need to tweak this a little.
	// TODO tweak this
	public void addCollisionBoxesToList(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
    	this.setBlockBounds(0.375F, 0.0F, 0.375F, 0.625F, 1.0F, 0.625F);
    }

    // makes it so that the blocks next to this one render, as this isn't a full block
    public boolean isOpaqueCube()
    {
        return false;
    }

    /**
     * If this block doesn't render as an ordinary block it will return False (examples: signs, buttons, stairs, etc)
     */
    public boolean renderAsNormalBlock()
    {
        return true;
    }
    
    /**
     * The type of render function that is called for this block
     * uses same rendering as sugar cane etc
     */
    public int getRenderType()
    {
        return 1;
    }
    
    /**
     * This method was written by Luppii for his "Luppii's Ladders" mod.
     * Copy/pasted from his github at http://goo.gl/xUcaXR.
     * Check out his mod, as it's quite neat.
     * 
     * TODO rewrite this in a way that better suits my needs
     */
    @Override
    @SideOnly(Side.CLIENT)
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity) {
    // Check to see if it is a player as we are only interested in manipulating them
    if (entity instanceof EntityPlayer) {
    // Cast to EntityPlayer to make it more strict
    EntityPlayer player = (EntityPlayer) entity;
    int direction = world.getBlockMetadata(x, y, z) & 3;
    boolean player_close = false;
    // Look at placement position and calculate if the player is close enough to ladder to "climb"
    switch (direction) {
    // SOUTH
    case 0:
    if (player.posZ - z >= 0.8D)
    player_close = true;
    break;
    // WEST
    case 1:
    if (player.posX - x <= 0.2D)
    player_close = true;
    break;
    // NORTH
    case 2:
    if (player.posZ - z <= 0.2D)
    player_close = true;
    break;
    // EAST
    case 3:
    if (player.posX - x >= 0.8D)
    player_close = true;
    break;
    default:
    player_close = false;
    }
    if (player.posY - 1.0D >= y && player_close) {
    player.moveForward = 0.0F;
    // If player is moving down, move slowly down.
    if (player.motionY < -0.15D)
    player.motionY = -0.15D;
    // check if we want to climb up
    if (GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindForward)
    || GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindBack)
    || GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindLeft)
    || GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindRight)) {
    if (player.motionY < 0.2D)
    player.motionY = 0.2D;
    }
    }
    // Check if we are sneaking and want to climb up, or just want to sneak "stand still" on the ladder
    if (GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak)
    && (GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindForward)
    || GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindBack)
    || GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindLeft) || GameSettings
    .isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindRight))) {
    player.motionY = 0.2D;
    player.fallDistance = 0.0F;
    }
    else if (GameSettings.isKeyDown(Minecraft.getMinecraft().gameSettings.keyBindSneak)) {
    player.setVelocity(0.0D, 0.08D, 0.0D); // Found this by experimenting. An upward velocity of 0.08 negates gravity fall
    player.fallDistance = 0.0F;
    }
    }
    }
    
    // more collision box stuff, I think
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		
    	AxisAlignedBB box = AxisAlignedBB.getBoundingBox(0.365F, 0.0F, 0.365F, 0.635F, 1.0F, 0.635F);
    	
    	return box;
    	
    }
}
