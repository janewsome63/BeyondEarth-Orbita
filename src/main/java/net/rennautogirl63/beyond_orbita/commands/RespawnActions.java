package net.rennautogirl63.beyond_orbita.commands;

import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class RespawnActions {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof LivingEntity _entity)
            _entity.hurt(new DamageSource("respawn").bypassArmor(), 9999);
    }
}
