package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.BlockStateConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.ColumnFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.*;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.features.MarsBlockBlobFeature;
import net.rennautogirl63.beyond_orbita.features.VenusDeltas;

import java.util.List;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID)
public class FeatureRegistry {

    public static final DeferredRegister<Feature<?>> FEATURES = DeferredRegister.create(ForgeRegistries.FEATURES, BeyondOrbitaMod.MODID);
    public static final DeferredRegister<ConfiguredFeature<?,?>> CONFIGURED_FEATURES = DeferredRegister.create(Registry.CONFIGURED_FEATURE_REGISTRY, BeyondOrbitaMod.MODID);
    public static final DeferredRegister<PlacedFeature> PLACED_FEATURES = DeferredRegister.create(Registry.PLACED_FEATURE_REGISTRY, BeyondOrbitaMod.MODID);

    /** MARS ROCK */
    public static final RegistryObject<MarsBlockBlobFeature> MARS_ROCK_FEATURE = FEATURES.register("mars_rock", () -> new MarsBlockBlobFeature(BlockStateConfiguration.CODEC));

    public static final RegistryObject<ConfiguredFeature<?,?>> MARS_ROCK_CONFIGURED_FEATURE = CONFIGURED_FEATURES.register("mars_rock", () -> new ConfiguredFeature<>(MARS_ROCK_FEATURE.get(), new BlockStateConfiguration(Blocks.POLISHED_GRANITE.defaultBlockState())));
    public static final RegistryObject<PlacedFeature> MARS_ROCK = PLACED_FEATURES.register("mars_rock", () -> new PlacedFeature(Holder.direct(MARS_ROCK_CONFIGURED_FEATURE.get()), List.of(CountPlacement.of(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome())));

    /** VENUS DELTAS */
    public static final RegistryObject<VenusDeltas> VENUS_DELTAS_FEATURE = FEATURES.register("venus_deltas", () -> new VenusDeltas(ColumnFeatureConfiguration.CODEC));

    //SMALL
    public static final RegistryObject<ConfiguredFeature<?,?>> VENUS_DELTAS_SMALL_CONFIGURED_FEATURE = CONFIGURED_FEATURES.register("venus_deltas_small", () -> new ConfiguredFeature<>(VENUS_DELTAS_FEATURE.get(), new ColumnFeatureConfiguration(ConstantInt.of(1), UniformInt.of(1, 4))));
    public static final RegistryObject<PlacedFeature> VENUS_DELTAS_SMALL = PLACED_FEATURES.register("venus_deltas_small", () -> new PlacedFeature(Holder.direct(VENUS_DELTAS_SMALL_CONFIGURED_FEATURE.get()), List.of(CountOnEveryLayerPlacement.of(4), BiomeFilter.biome())));

    //LARGE
    public static final RegistryObject<ConfiguredFeature<?,?>> VENUS_DELTAS_LARGE_CONFIGURED_FEATURE = CONFIGURED_FEATURES.register("venus_deltas_large", () -> new ConfiguredFeature<>(VENUS_DELTAS_FEATURE.get(), new ColumnFeatureConfiguration(UniformInt.of(2, 3), UniformInt.of(5, 10))));
    public static final RegistryObject<PlacedFeature> VENUS_DELTAS_LARGE = PLACED_FEATURES.register("venus_deltas_large", () -> new PlacedFeature(Holder.direct(VENUS_DELTAS_LARGE_CONFIGURED_FEATURE.get()), List.of(CountOnEveryLayerPlacement.of(2), BiomeFilter.biome())));

    @SubscribeEvent
    public static void biomesLoading(BiomeLoadingEvent event) {
        ResourceLocation name = event.getName();

        /** MARS ROCK */
        if (name.equals(BiomesRegistry.MARS_ROCKY_PLAINS)) {
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, MARS_ROCK.getHolder().get());
        }

        /** VENUS DELTAS */
        if (name.equals(BiomesRegistry.INFERNAL_VENUS_BARRENS)) {
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, VENUS_DELTAS_SMALL.getHolder().get());
            event.getGeneration().addFeature(GenerationStep.Decoration.SURFACE_STRUCTURES, VENUS_DELTAS_LARGE.getHolder().get());
        }
    }
}