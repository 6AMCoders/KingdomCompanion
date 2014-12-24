package com.iamtechi27.kingdomcompanion.util;

import net.minecraft.util.DamageSource;

public class KillMeDamage extends DamageSource {

	public KillMeDamage() {
		super("killme");
		this.setDamageIsAbsolute();
		this.setDamageBypassesArmor();
		this.setDamageAllowedInCreativeMode();
	}

}
