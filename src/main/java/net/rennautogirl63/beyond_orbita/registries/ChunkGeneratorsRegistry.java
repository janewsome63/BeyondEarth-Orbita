package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.world.chunkgen.PlanetChunkGenerator;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ChunkGeneratorsRegistry {

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            /** PLANET CHUNK GENERATOR */
            Registry.register(Registry.CHUNK_GENERATOR, new ResourceLocation(BeyondOrbitaMod.MODID, "planet_noise"), PlanetChunkGenerator.CODEC);
        });
    }
}
