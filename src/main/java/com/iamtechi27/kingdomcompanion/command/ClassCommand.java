package com.iamtechi27.kingdomcompanion.command;

import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.entity.PlayerClass;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class ClassCommand extends CommandBase {

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "kc";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return "kc";
	}

	@Override
	public void processCommand(ICommandSender sender, String[] arguments) {
		if (arguments[0].equals("class")) {
			EntityPlayerMP entityplayermp = arguments.length == 0 ? getCommandSenderAsPlayer(sender) : getPlayer(sender, arguments[1]);
			if (entityplayermp == null){
				entityplayermp = getCommandSenderAsPlayer(sender);
				ExtendedPlayer.get(entityplayermp).setPlayerClass(PlayerClass.valueOf(arguments[1].toUpperCase()));
			}else{			
			ExtendedPlayer.get(entityplayermp).setPlayerClass(PlayerClass.valueOf(arguments[2].toUpperCase()));
			}
		} else if(arguments[0].equals("maxmana")) {
			EntityPlayerMP entityplayermp = arguments.length == 0 ? getCommandSenderAsPlayer(sender) : getPlayer(sender, arguments[1]);
			if (entityplayermp == null) {
				entityplayermp = getCommandSenderAsPlayer(sender);
				ExtendedPlayer.get(entityplayermp).setMaxMana(Integer.parseInt(arguments[1]));
			} else {
				ExtendedPlayer.get(entityplayermp).setMaxMana(Integer.parseInt(arguments[2]));
			}
		}
	}

}
