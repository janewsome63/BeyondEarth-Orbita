package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

public class SoundsRegistry {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, BeyondOrbitaMod.MODID);

    /** SOUNDS */
    public static final RegistryObject<SoundEvent> ROCKET_SOUND = SOUNDS.register("rocket_fly",() -> new SoundEvent(new ResourceLocation(BeyondOrbitaMod.MODID, "rocket_fly")));
}
