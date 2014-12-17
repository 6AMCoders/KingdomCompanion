package com.iamtechi27.kingdomcompanion.util;

import net.minecraft.util.DamageSource;

public class SpikeDamage extends DamageSource {

	public SpikeDamage() {
		super("spike");
		this.setDamageIsAbsolute();
		this.setDamageBypassesArmor();
	}
	
}
