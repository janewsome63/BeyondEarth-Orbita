package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.effects.OxygenEffect;

public class EffectsRegistry {

    public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, BeyondOrbitaMod.MODID);

    /** EFFECTS */
    public static final RegistryObject<MobEffect> OXYGEN_EFFECT = EFFECTS.register("oxygen_bubble_effect", () -> new OxygenEffect(MobEffectCategory.BENEFICIAL,3035801));
}
