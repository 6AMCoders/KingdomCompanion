package com.iamtechi27.kingdomcompanion.network;

import com.iamtechi27.kingdomcompanion.KingdomCompanion;
import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;

import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MaxManaMessage implements IMessage {

	private int mana;
	
	public MaxManaMessage(){}
	
	public MaxManaMessage(int mana) {
		this.mana = mana;
	}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		this.mana = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.mana);
	}
	
	public static class Handler implements IMessageHandler<MaxManaMessage, IMessage> {
		
		@Override
		public IMessage onMessage(MaxManaMessage message, MessageContext ctx) {
			//System.out.println("Got max mana from server"); // debug message
			ExtendedPlayer.get(KingdomCompanion.proxy.getPlayerFromMessageContext(ctx)).setMaxMana(message.mana);
			return null;
		}

	}
}
