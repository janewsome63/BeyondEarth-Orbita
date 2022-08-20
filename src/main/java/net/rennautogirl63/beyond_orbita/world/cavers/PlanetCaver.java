package net.rennautogirl63.beyond_orbita.world.cavers;

import com.google.common.collect.ImmutableSet;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.carver.WorldCarver;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;

import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class PlanetCaver {

    protected static final Supplier<Set<Block>> replaceableBlocks = () -> ImmutableSet.of(
            BlocksRegistry.MOON_STONE.get(),
            BlocksRegistry.MARS_STONE.get(),
            BlocksRegistry.MERCURY_STONE.get(),
            BlocksRegistry.VENUS_STONE.get(), BlocksRegistry.VENUS_SANDSTONE.get(),
            BlocksRegistry.GLACIO_STONE.get(),
            BlocksRegistry.PLUTO_STONE.get(), BlocksRegistry.PERMAFROST.get());

    @SubscribeEvent
    public static void init(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            WorldCarver.CAVE.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CAVE.replaceableBlocks).addAll(replaceableBlocks.get()).build();
            WorldCarver.CANYON.replaceableBlocks = new ImmutableSet.Builder<Block>().addAll(WorldCarver.CANYON.replaceableBlocks).addAll(replaceableBlocks.get()).build();
        });
    }
}