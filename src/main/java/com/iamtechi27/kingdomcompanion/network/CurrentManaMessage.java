package com.iamtechi27.kingdomcompanion.network;

import net.minecraft.client.Minecraft;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class CurrentManaMessage implements IMessage {

	private int mana;
	
	public CurrentManaMessage(){}
	
	public CurrentManaMessage(int mana) {
		this.mana = mana;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		this.mana = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		// TODO Auto-generated method stub
		buf.writeInt(this.mana);
	}
	
	public static class Handler implements IMessageHandler<CurrentManaMessage, IMessage> {
		
		@Override
		public IMessage onMessage(CurrentManaMessage message, MessageContext ctx) {
			//System.out.println("reciev'd"); // debug message
			ExtendedPlayer.get(KingdomCompanion.proxy.getPlayerFromMessageContext(ctx)).setCurrentMana(message.mana);
			return null;
		}
	}

}
