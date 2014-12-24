package com.iamtechi27.kingdomcompanion.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityStaffFireball extends EntitySmallFireball {

	public EntityStaffFireball(World p_i1771_1_, EntityLivingBase p_i1771_2_,
			double p_i1771_3_, double p_i1771_5_, double p_i1771_7_) {
		super(p_i1771_1_, p_i1771_2_, p_i1771_3_, p_i1771_5_, p_i1771_7_);
		
	}
	
	public EntityStaffFireball(World world, double posX, double d, double posZ,
			double xCoord, double yCoord, double zCoord) {
		super(world, posX, d, posZ, xCoord, yCoord, zCoord);
	}

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
