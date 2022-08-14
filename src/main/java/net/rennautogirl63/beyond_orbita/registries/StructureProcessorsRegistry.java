package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureProcessorType;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.world.processors.StructureVoidProcessor;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class StructureProcessorsRegistry {

    /** STRUCTURE VOID PROCESSOR */
    public static final StructureProcessorType<StructureVoidProcessor> STRUCTURE_VOID_PROCESSOR = () -> StructureVoidProcessor.CODEC;

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

            /** STRUCTURE VOID PROCESSOR */
            Registry.register(Registry.STRUCTURE_PROCESSOR, new ResourceLocation(BeyondOrbitaMod.MODID, "structure_void_processor"), STRUCTURE_VOID_PROCESSOR);
        });
    }
}
