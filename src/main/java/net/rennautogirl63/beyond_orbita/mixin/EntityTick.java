package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.world.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.EntityTickEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Entity.class)
public abstract class EntityTick {

    @Inject(at = @At(value = "HEAD"), method = "tick")
    private void tick(CallbackInfo info) {
        Entity w = (Entity) ((Object) this);

        MinecraftForge.EVENT_BUS.post(new EntityTickEvent(w));
    }
}