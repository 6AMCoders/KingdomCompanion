/*
 * ExtendedPlayer.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * A few things are taken care of here. Mainly mana and player classes.
 * Everything here is pretty straightforward. Just have a look around.
 */

package com.iamtechi27.kingdomcompanion.entity;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.network.CurrentManaMessage;
import com.iamtechi27.kingdomcompanion.network.MaxManaMessage;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "PlayerClass";
	private final EntityPlayer player;
	private int currentMana, maxMana = 0, tickCount = 0;
	
	private PlayerClass playerClass;
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
		//TODO fix data not persisting
	}
	
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setString("PlayerClass", this.playerClass.name());
		properties.setInteger("MaxMana", maxMana);
		compound.setTag(EXT_PROP_NAME, properties);
		//System.out.println("[KC PROPS] Saved player class:" + this.playerClass.name()); //debug

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.playerClass = PlayerClass.valueOf(properties.getString("PlayerClass"));
		this.maxMana = properties.getInteger("MaxMana");
		System.out.println("[KC PROPS] Class from NBT: " + this.playerClass.name());

	}

	@Override
	public void init(Entity entity, World world) {
		
	}
	
	public PlayerClass getPlayerClass() {
		return this.playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
		
	}
	
	public int getMaxMana() {
		return this.maxMana;
	}
	
	public void setMaxMana(int mana) {
		this.maxMana = mana;
		if(!player.worldObj.isRemote)
		KingdomCompanion.MAXMANANETWORK.sendTo(new MaxManaMessage(this.maxMana), (EntityPlayerMP) player);
	}
	
	public boolean consumeMana(int amount) {
		boolean sufficient = amount <= this.currentMana;
		this.currentMana -= (amount < this.currentMana ? amount : this.currentMana);
		if(!player.worldObj.isRemote)
		KingdomCompanion.CURRENTMANANETWORK.sendTo(new CurrentManaMessage(this.currentMana), (EntityPlayerMP) player);
		return sufficient;
	}
	
	/*
	 * This bit I actually will explain.
	 * Basically the PlayerTickHandler I have set up calls this.
	 * Increases the tick count. Every 40 ticks (1 second),
	 * it increases the player's current mana by a percentage of their max mana
	 */
	public void regenMana() {
		tickCount++;
		if (tickCount >= 40) {
			this.currentMana += (this.maxMana < (this.currentMana + this.maxMana/20) ? (this.maxMana - this.currentMana) : this.maxMana/20);
			tickCount = 0;
			//System.out.println("[Extended Player] Mana: " + currentMana); //debug
			if (!player.worldObj.isRemote) {
				KingdomCompanion.CURRENTMANANETWORK.sendTo(new CurrentManaMessage(this.currentMana), (EntityPlayerMP) player);
			}
		}
	}
	
	public void instantMana(int amount) {
		this.currentMana += (this.maxMana < (this.currentMana + amount) ? (this.maxMana - this.currentMana) : amount);
		if(!player.worldObj.isRemote)
		KingdomCompanion.CURRENTMANANETWORK.sendTo(new CurrentManaMessage(this.currentMana), (EntityPlayerMP) player);
	}

	public int getCurrentMana() {
		return this.currentMana;
	}
	
	public void setCurrentMana(int amount) {
		this.currentMana = amount;
	}

}
