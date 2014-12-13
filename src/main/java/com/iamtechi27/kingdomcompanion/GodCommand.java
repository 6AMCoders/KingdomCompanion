package com.iamtechi27.kingdomcompanion;

import java.util.List;

import com.iamtechi27.kingdomcompanion.items.ModItems;

import net.minecraft.command.CommandBase;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IChatComponent;

public class GodCommand extends CommandBase implements ICommand {

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getCommandName() {
		// TODO Auto-generated method stub
		return "handofgod";
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		// TODO Auto-generated method stub
		return "handofgod";
	}

	@Override
	public List getCommandAliases() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void processCommand(ICommandSender par1, String[] par2) {
		// TODO Auto-generated method stub
		EntityPlayer entityplayer = ((EntityPlayer)par1);
		EntityItem entityitem = entityplayer.dropPlayerItemWithRandomChoice(new ItemStack(ModItems.rapier), false);
        entityitem.delayBeforeCanPickup = 0;
        //entityitem.func_145797_a(entityplayer.getCommandSenderName());
        func_152373_a(par1, this, "What have you done...", new Object[] {});

	}

	@Override
	public boolean canCommandSenderUseCommand(ICommandSender par1) {
		// TODO Auto-generated method stub
		if(((EntityPlayerMP)par1).mcServer.getOpPermissionLevel() >=2)
			return true;
		return false;
	}

	@Override
	public List addTabCompletionOptions(ICommandSender p_71516_1_,
			String[] p_71516_2_) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
		// TODO Auto-generated method stub
		return false;
	}

}
