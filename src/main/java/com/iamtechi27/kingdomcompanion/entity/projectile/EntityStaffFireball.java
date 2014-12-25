/*
 * EntityStaffFireball.java by iamtechi27
 * This file is part of the Kingdom Companion mod by iamtechi27
 * Copyright (C) 2014 iamtechi27
 * Released under the GNU GPL v3.0
 * Feel free to do whatever you like with it
 * Citation is requested, but not required, should you copy any of this code.
 * 
 * I got tired of vanilla fireballs getting shot out of my fancy staff and leaving fire blocks everywhere
 * So I made my own fireball
 */

package com.iamtechi27.kingdomcompanion.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffFireball extends EntitySmallFireball {

	// just passes the data on up to the super's constructor
	public EntityStaffFireball(World p_i1771_1_, EntityLivingBase p_i1771_2_,
			double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
		super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
		
	}
	
	// see above. One of these is useless but I forget which one
	// TODO figure out which one is useless
	public EntityStaffFireball(World world, double posX, double d, double posZ,
			double xCoord, double yCoord, double zCoord) {
		super(world, posX, d, posZ, xCoord, yCoord, zCoord);
	}

	// this is literally just the vanilla code with the bit that leaves fire blocks
	// all over the place taken out.
	protected void onImpact(MovingObjectPosition p_70227_1_)
    {
        if (!this.worldObj.isRemote)
        {
            if (p_70227_1_.entityHit != null)
            {
                if (!p_70227_1_.entityHit.isImmuneToFire() && p_70227_1_.entityHit.attackEntityFrom(DamageSource.causeFireballDamage(this, this.shootingEntity), 5.0F))
                {
                    p_70227_1_.entityHit.setFire(5);
                }
            }
            this.setDead();
        }
    }

}
