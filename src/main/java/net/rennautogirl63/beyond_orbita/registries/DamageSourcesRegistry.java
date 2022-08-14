package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.damagesource.DamageSource;

public class DamageSourcesRegistry {
    public static final DamageSource DAMAGE_SOURCE_OXYGEN = new DamageSource("oxygen").bypassArmor();
    public static final DamageSource DAMAGE_SOURCE_ACID_RAIN = new DamageSource("venus.acid").bypassArmor();
}
