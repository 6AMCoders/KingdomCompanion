package com.iamtechi27.kingdomcompanion.handler;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.world.WorldSettings.GameType;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.entity.PlayerClass;
import com.iamtechi27.kingdomcompanion.util.KillMeDamage;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class KCEventHandler {

	@SubscribeEvent
	public void onEntityConstructing(EntityConstructing event) {
		if (event.entity instanceof EntityPlayer && ExtendedPlayer.get((EntityPlayer) event.entity) == null){
			ExtendedPlayer.register((EntityPlayer) event.entity);
			ExtendedPlayer props = ExtendedPlayer.get((EntityPlayer) event.entity);
			if (props.getPlayerClass() == null) {
				props.setPlayerClass(PlayerClass.NONE);
			}
			if (props.getMaxMana() == 0) {
				props.setMaxMana(20);
			}
		}
	}
	
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = KingdomCompanion.proxy.getEntityData(((EntityPlayer) event.entity).getDisplayName() + ExtendedPlayer.EXT_PROP_NAME);
			if (playerData != null) {
				((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).loadNBTData(playerData);
				ExtendedPlayer.get((EntityPlayer)event.entity).instantMana(ExtendedPlayer.get((EntityPlayer)event.entity).getMaxMana());
				//System.out.println(playerData.toString()); //debug
			}
			//((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).syncExtendedProperties();
		}
			
		
	}
	
	@SubscribeEvent
	public void onLivingDeathEvent(LivingDeathEvent event) {
		if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer) {
			NBTTagCompound playerData = new NBTTagCompound();
			((ExtendedPlayer)(event.entity.getExtendedProperties(ExtendedPlayer.EXT_PROP_NAME))).saveNBTData(playerData);
			KingdomCompanion.proxy.storeEntityData(((EntityPlayer) event.entity).getDisplayName() + ExtendedPlayer.EXT_PROP_NAME, playerData);
			//System.out.println("Should've saved..."); //debug
		}
	}
	
	@SubscribeEvent
	public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
		if (event.side == Side.CLIENT) {
			System.out.println("I'm a server!");
		}
	}
	
	@SubscribeEvent
	public void onBreakBlock(BreakEvent event) {
		if(((EntityPlayerMP) event.getPlayer()).theItemInWorldManager.getGameType() == GameType.ADVENTURE) {
			event.setCanceled(true);
		}
	}
	
	@SubscribeEvent
	public void onServerChat(ServerChatEvent event) {
		if (event.message.toLowerCase().equals("can you read my mind?")) {
			List<EntityPlayerMP> players = MinecraftServer.getServer().worldServers[0].playerEntities;
			for (int t = 0; t < players.size(); t++)
			{
				players.get(t).addChatMessage(new ChatComponentText("<iamtechi27> Yes, " + event.username + ", I can read your mind."));
			}
		}
		if (event.message.toLowerCase().contains("kill me")) {
			List<EntityPlayerMP> players = MinecraftServer.getServer().worldServers[0].playerEntities;
			for (int t = 0; t < players.size(); t++) {
				players.get(t).addChatMessage(new ChatComponentText("<" + event.username + "> " + event.message));
			}
			event.player.attackEntityFrom(new KillMeDamage(), 100.0F);
			event.setCanceled(true);
		}
		if (event.message.equalsIgnoreCase("speed")) {
			event.player.addPotionEffect(new PotionEffect(1, 12000, 9, false));
		}
	}
	
}
