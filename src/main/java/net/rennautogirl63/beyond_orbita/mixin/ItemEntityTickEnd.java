package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.ItemEntityTickEndEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ItemEntity.class)
public class ItemEntityTickEnd {
    @Inject(at = @At(value = "RETURN"), method = "tick")
    private void tick(CallbackInfo info) {
        ItemEntity w = (ItemEntity) ((Object) this);

        MinecraftForge.EVENT_BUS.post(new ItemEntityTickEndEvent(w));
    }
}
