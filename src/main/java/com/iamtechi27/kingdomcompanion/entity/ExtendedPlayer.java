package com.iamtechi27.kingdomcompanion.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;

public class ExtendedPlayer implements IExtendedEntityProperties {

	public final static String EXT_PROP_NAME = "PlayerClass";
	private final EntityPlayer player;
	
	private PlayerClass playerClass;
	
	public ExtendedPlayer(EntityPlayer player) {
		this.player = player;
	}
	
	public static final void register(EntityPlayer player) {
		player.registerExtendedProperties(ExtendedPlayer.EXT_PROP_NAME, new ExtendedPlayer(player));
		//TODO you know what
	}
	
	public static final ExtendedPlayer get(EntityPlayer player) {
		return (ExtendedPlayer) player.getExtendedProperties(EXT_PROP_NAME);
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = new NBTTagCompound();
		properties.setString("PlayerClass", this.playerClass.name());
		compound.setTag(EXT_PROP_NAME, properties);
		//System.out.println("[KC PROPS] Saved player class:" + this.playerClass.name()); //debug

	}

	@Override
	public void loadNBTData(NBTTagCompound compound) {
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		this.playerClass = PlayerClass.valueOf(properties.getString("PlayerClass"));
		System.out.println("[KC PROPS] Class from NBT: " + this.playerClass.name());

	}

	@Override
	public void init(Entity entity, World world) {
		if (this.playerClass == null && !world.isRemote) {
			this.playerClass = PlayerClass.NONE;
			System.out.println("[KC PROPS] Initialized player class.");
		}

	}
	
	public PlayerClass getPlayerClass() {
		return this.playerClass;
	}

	public void setPlayerClass(PlayerClass playerClass) {
		this.playerClass = playerClass;
		
	}

}
