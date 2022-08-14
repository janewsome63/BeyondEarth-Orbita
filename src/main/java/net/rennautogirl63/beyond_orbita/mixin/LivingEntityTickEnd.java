package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.LivingEntityTickEndEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public class LivingEntityTickEnd {
    @Inject(at = @At(value = "RETURN"), method = "tick")
    private void tick(CallbackInfo info) {
        LivingEntity w = (LivingEntity) ((Object) this);

        MinecraftForge.EVENT_BUS.post(new LivingEntityTickEndEvent(w));
    }
}
