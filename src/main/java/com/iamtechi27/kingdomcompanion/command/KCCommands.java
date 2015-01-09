/*
 * ClassCommand.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * TODO fix this so command blocks can use it
 */

package com.iamtechi27.kingdomcompanion.command;

import com.iamtechi27.kingdomcompanion.entity.ExtendedPlayer;
import com.iamtechi27.kingdomcompanion.entity.PlayerClass;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;

public class KCCommands extends CommandBase {

	@Override
	public String getCommandName() {
		return "kc";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
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
	
	@Override
	public int getRequiredPermissionLevel() {
		return 2;
	}

}
