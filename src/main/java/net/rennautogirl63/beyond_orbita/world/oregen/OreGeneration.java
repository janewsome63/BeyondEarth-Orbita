package net.rennautogirl63.beyond_orbita.world.oregen;

import com.simibubi.create.AllBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.data.worldgen.placement.OrePlacements;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.registries.BiomesRegistry;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;
import net.rennautogirl63.beyond_orbita.registries.FeatureRegistry;

import java.util.List;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID)
public class OreGeneration {

    /** Non-specific */
    // Definitions
    public static final TagKey<Block> STONE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "stone_ore_replaceables"));
    public static final RuleTest STONE_MATCH = new TagMatchTest(STONE_ORE_REPLACEABLES);
    public static final TagKey<Block> DEEPSLATE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "deepslate_ore_replaceables"));
    public static final RuleTest DEEPSLATE_MATCH = new TagMatchTest(DEEPSLATE_ORE_REPLACEABLES);

    // Copper
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_SMALL_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_small", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_SMALL = FeatureRegistry.PLACED_FEATURES.register("copper_ore_small", () -> new PlacedFeature(COPPER_ORE_SMALL_CONFIGURED.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_LARGE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_large", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 20, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_LARGE = FeatureRegistry.PLACED_FEATURES.register("copper_ore_large", () -> new PlacedFeature(COPPER_ORE_SMALL_CONFIGURED.getHolder().get(), commonOrePlacement(6, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 15, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("copper_ore_high", () -> new PlacedFeature(COPPER_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 7, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("copper_ore_low", () -> new PlacedFeature(COPPER_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));

    // Iron
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_TOP = FeatureRegistry.PLACED_FEATURES.register("iron_ore_top", () -> new PlacedFeature(IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<PlacedFeature> IRON_ORE_CENTER = FeatureRegistry.PLACED_FEATURES.register("iron_ore_center", () -> new PlacedFeature(IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_SMALL_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore_small", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 4, 0.0F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_SMALL = FeatureRegistry.PLACED_FEATURES.register("iron_ore_small", () -> new PlacedFeature(IRON_ORE_SMALL_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(72)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("iron_ore_high", () -> new PlacedFeature(IRON_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(30, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("iron_ore_low", () -> new PlacedFeature(IRON_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(56)))));

    // Gold
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("gold_ore", () -> new PlacedFeature(GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_BURIED_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore_buried", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE_BURIED = FeatureRegistry.PLACED_FEATURES.register("gold_ore_buried", () -> new PlacedFeature(GOLD_ORE_BURIED_CONFIGURED.getHolder().get(), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("gold_ore_high", () -> new PlacedFeature(GOLD_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("gold_ore_low", () -> new PlacedFeature(GOLD_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));

    // Diamond
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_SMALL_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_small", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 4, 0.5F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_SMALL = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_small", () -> new PlacedFeature(DIAMOND_ORE_SMALL_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_LARGE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_large", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 12, 0.7F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_LARGE = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_large", () -> new PlacedFeature(DIAMOND_ORE_LARGE_CONFIGURED.getHolder().get(), rareOrePlacement(9, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_BURIED_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_buried", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 8, 1.0F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_BURIED = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_buried", () -> new PlacedFeature(DIAMOND_ORE_BURIED_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 12, 1.0F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_high", () -> new PlacedFeature(DIAMOND_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 2, 1.0F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_low", () -> new PlacedFeature(DIAMOND_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    
    // Zinc
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, AllBlocks.ZINC_ORE.getDefaultState()), OreConfiguration.target(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState())), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("zinc_ore", () -> new PlacedFeature(ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-63), VerticalAnchor.absolute(70)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, AllBlocks.ZINC_ORE.getDefaultState()), OreConfiguration.target(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState())), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("zinc_ore_high", () -> new PlacedFeature(ZINC_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-63), VerticalAnchor.absolute(70)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, AllBlocks.ZINC_ORE.getDefaultState()), OreConfiguration.target(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("zinc_ore_low", () -> new PlacedFeature(ZINC_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-63), VerticalAnchor.absolute(70)))));

    /** Mercury */
    // Definitions
    public static final TagKey<Block> MERCURY_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mercury_ore_replaceables"));
    public static final RuleTest MERCURY_MATCH = new TagMatchTest(MERCURY_ORE_REPLACEABLES);

    // Potassium
    public static final RegistryObject<ConfiguredFeature<?, ?>> POTASSIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("potassium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.POTASSIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_POTASSIUM_ORE.get().defaultBlockState())), 17, 0.5F)));
    public static final RegistryObject<PlacedFeature> POTASSIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("potassium_ore", () -> new PlacedFeature(POTASSIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));

    // Sulphur
    public static final RegistryObject<ConfiguredFeature<?, ?>> SULFUR_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("sulphur_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.SULFUR_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_SULFUR_ORE.get().defaultBlockState())), 17, 0.5F)));
    public static final RegistryObject<PlacedFeature> SULFUR_ORE = FeatureRegistry.PLACED_FEATURES.register("sulphur_ore", () -> new PlacedFeature(SULFUR_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));
    
    /** Venus */
    // Venus Stone
    public static final TagKey<Block> VENUS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "venus_ore_replaceables"));
    public static final RuleTest VENUS_MATCH = new TagMatchTest(VENUS_ORE_REPLACEABLES);

    /** Moon */
    // Moon Stone
    public static final TagKey<Block> MOON_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "moon_ore_replaceables"));
    public static final RuleTest MOON_MATCH = new TagMatchTest(MOON_ORE_REPLACEABLES);

    // Aluminum
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALUMINUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())), 9, 0.8F)));
    public static final RegistryObject<PlacedFeature> ALUMINUM_ORE = FeatureRegistry.PLACED_FEATURES.register("aluminum_ore", () -> new PlacedFeature(ALUMINUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    
    // Quartz
    public static final RegistryObject<ConfiguredFeature<?, ?>> QUARTZ_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("quartz_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.QUARTZ_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_QUARTZ_ORE.get().defaultBlockState())), 14, 0.0F)));
    public static final RegistryObject<PlacedFeature> QUARTZ_ORE = FeatureRegistry.PLACED_FEATURES.register("quartz_ore", () -> new PlacedFeature(QUARTZ_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    /** Mars */
    // Mars Stone
    public static final TagKey<Block> MARS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mars_ore_replaceables"));
    public static final RuleTest MARS_MATCH = new TagMatchTest(MARS_ORE_REPLACEABLES);

    // Titanium
    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("titanium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.TITANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())), 9, 0.8F)));
    public static final RegistryObject<PlacedFeature> TITANIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("titanium_ore", () -> new PlacedFeature(TITANIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    
    /** Asteroid Belt */
    // Copper
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_COPPER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_copper_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_COPPER_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_copper_ore", () -> new PlacedFeature(ASTEROID_COPPER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Iron
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_iron_ore", () -> new PlacedFeature(ASTEROID_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Gold
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_gold_ore", () -> new PlacedFeature(ASTEROID_GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    
    // Diamond
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 4, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_diamond_ore", () -> new PlacedFeature(ASTEROID_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Emerald
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_EMERALD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_emerald_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 4, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_EMERALD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_emerald_ore", () -> new PlacedFeature(ASTEROID_EMERALD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Zinc
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState(), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_zinc_ore", () -> new PlacedFeature(ASTEROID_ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    
    // Silicon
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_SILICON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_silicon_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_SILICON_ORE.get().defaultBlockState(), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_SILICON_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_silicon_ore", () -> new PlacedFeature(ASTEROID_SILICON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Aluminum
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_ALUMINUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState(), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_ALUMINUM_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_aluminum_ore", () -> new PlacedFeature(ASTEROID_ALUMINUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Titanium
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_TITANIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_titanium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState(), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_TITANIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_titanium_ore", () -> new PlacedFeature(ASTEROID_TITANIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Carbon
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_CARBON_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_carbon", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.CARBON.get().defaultBlockState(), 20, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_CARBON = FeatureRegistry.PLACED_FEATURES.register("asteroid_carbon", () -> new PlacedFeature(ASTEROID_CARBON_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Blue Ice
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_BLUE_ICE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_blue_ice", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.BLUE_ICE.defaultBlockState(), 30, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_BLUE_ICE = FeatureRegistry.PLACED_FEATURES.register("asteroid_blue_ice", () -> new PlacedFeature(ASTEROID_BLUE_ICE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Sky Stone
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_SKY_STONE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_sky_stone", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.SKY_STONE.get().defaultBlockState(), 30, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_SKY_STONE = FeatureRegistry.PLACED_FEATURES.register("asteroid_sky_stone", () -> new PlacedFeature(ASTEROID_SKY_STONE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    /** Pluto */
    // Pluto Stone
    public static final TagKey<Block> PLUTO_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "pluto_ore_replaceables"));
    public static final RuleTest PLUTO_MATCH = new TagMatchTest(PLUTO_ORE_REPLACEABLES);

    // Celestial Remnant
    public static final RegistryObject<ConfiguredFeature<?, ?>> CELESTIAL_REMNANT_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("celestial_remnant", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.CELESTIAL_REMNANT.get().defaultBlockState(), 3, 1.0F)));
    public static final RegistryObject<PlacedFeature> CELESTIAL_REMNANT = FeatureRegistry.PLACED_FEATURES.register("celestial_remnant", () -> new PlacedFeature(CELESTIAL_REMNANT_CONFIGURED.getHolder().get(), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-52)))));

    @SubscribeEvent
    public static void biomesLoading(BiomeLoadingEvent event) {
        ResourceLocation biome = event.getName();

        if (biome.equals(BiomesRegistry.MERCURY)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_HIGH.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(POTASSIUM_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(SULFUR_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.VENUS_DESERT) || biome.equals(BiomesRegistry.INFERNAL_VENUS_BARRENS)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE_HIGH.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.MOON_DESERT)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_TOP.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_CENTER.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ALUMINUM_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(QUARTZ_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.MARS_DESERT) || biome.equals(BiomesRegistry.MARS_ROCKY_PLAINS) || biome.equals(BiomesRegistry.MARS_ICE_SPIKES)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_TOP.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_CENTER.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_SMALL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_LARGE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_BURIED.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE_HIGH.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(TITANIUM_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.ASTEROID_FIELD)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_EMERALD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_SILICON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_ALUMINUM_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_TITANIUM_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_CARBON.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_BLUE_ICE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_SKY_STONE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.PLUTO_DESERT) || biome.equals(BiomesRegistry.PLUTO_TUNDRA)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE_LOW.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(CELESTIAL_REMNANT.getHolder().get());
        }
    }

    /**
     * ORE PLACEMENTS
     */
    private static List<PlacementModifier> orePlacement(PlacementModifier p_195347_, PlacementModifier p_195348_) {
        return List.of(p_195347_, InSquarePlacement.spread(), p_195348_, BiomeFilter.biome());
    }

    private static List<PlacementModifier> commonOrePlacement(int p_195344_, PlacementModifier p_195345_) {
        return orePlacement(CountPlacement.of(p_195344_), p_195345_);
    }

    private static List<PlacementModifier> rareOrePlacement(int p_195350_, PlacementModifier p_195351_) {
        return orePlacement(RarityFilter.onAverageOnceEvery(p_195350_), p_195351_);
    }
}
