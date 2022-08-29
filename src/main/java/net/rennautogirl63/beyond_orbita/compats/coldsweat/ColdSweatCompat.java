package net.rennautogirl63.beyond_orbita.compats.coldsweat;

import dev.momostudios.coldsweat.api.event.core.TempModifierRegisterEvent;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rennautogirl63.beyond_orbita.compats.CompatibleMod;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.init.RegisterModifiers;

public class ColdSweatCompat extends CompatibleMod {

    public static final String MODID = "cold_sweat";

    public static ResourceLocation rl(String path) {
        return new ResourceLocation(MODID, path);
    }

    @Override
    public String getModID() {
        return MODID;
    }

    @Override
    protected void onLoad() {
    }

}
