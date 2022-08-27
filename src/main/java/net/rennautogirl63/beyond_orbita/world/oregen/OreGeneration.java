package net.rennautogirl63.beyond_orbita.world.oregen;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllItems;
import com.simibubi.create.AllTags;
import com.simibubi.create.content.palettes.AllPaletteBlocks;
import com.simibubi.create.content.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.worldgen.AllFeatures;
import com.simibubi.create.foundation.worldgen.AllLayerPatterns;
import com.simibubi.create.foundation.worldgen.AllOreFeatureConfigEntries;
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
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.registries.BiomesRegistry;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;
import net.rennautogirl63.beyond_orbita.registries.FeatureRegistry;

import java.util.List;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID)
public class OreGeneration {
    /** Definitions */
    public static final TagKey<Block> STONE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("stone_ore_replaceables"));
    public static final RuleTest STONE_MATCH = new TagMatchTest(STONE_ORE_REPLACEABLES);
    public static final TagKey<Block> DEEPSLATE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation("deepslate_ore_replaceables"));
    public static final RuleTest DEEPSLATE_MATCH = new TagMatchTest(DEEPSLATE_ORE_REPLACEABLES);
    public static final TagKey<Block> MERCURY_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mercury_ore_replaceables"));
    public static final RuleTest MERCURY_MATCH = new TagMatchTest(MERCURY_ORE_REPLACEABLES);
    public static final TagKey<Block> VENUS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "venus_ore_replaceables"));
    public static final RuleTest VENUS_MATCH = new TagMatchTest(VENUS_ORE_REPLACEABLES);
    public static final TagKey<Block> MOON_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "moon_ore_replaceables"));
    public static final RuleTest MOON_MATCH = new TagMatchTest(MOON_ORE_REPLACEABLES);
    public static final TagKey<Block> MARS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mars_ore_replaceables"));
    public static final RuleTest MARS_MATCH = new TagMatchTest(MARS_ORE_REPLACEABLES);
    public static final TagKey<Block> PLUTO_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "pluto_ore_replaceables"));
    public static final RuleTest PLUTO_MATCH = new TagMatchTest(PLUTO_ORE_REPLACEABLES);

    /** Ores */
    public static final RegistryObject<ConfiguredFeature<?, ?>> ALUMINUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.ALUMINUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState())), 9, 0.8F)));
    public static final RegistryObject<PlacedFeature> ALUMINUM_ORE = FeatureRegistry.PLACED_FEATURES.register("aluminum_ore", () -> new PlacedFeature(ALUMINUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> TITANIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("titanium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.TITANIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState())), 9, 0.8F)));
    public static final RegistryObject<PlacedFeature> TITANIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("titanium_ore", () -> new PlacedFeature(TITANIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> QUARTZ_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("quartz_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.QUARTZ_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_QUARTZ_ORE.get().defaultBlockState())), 14, 0.0F)));
    public static final RegistryObject<PlacedFeature> QUARTZ_ORE = FeatureRegistry.PLACED_FEATURES.register("quartz_ore", () -> new PlacedFeature(QUARTZ_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> POTASSIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("potassium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.POTASSIUM_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_POTASSIUM_ORE.get().defaultBlockState())), 17, 0.5F)));
    public static final RegistryObject<PlacedFeature> POTASSIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("potassium_ore", () -> new PlacedFeature(POTASSIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SULFUR_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("sulfur_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.SULFUR_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_SULFUR_ORE.get().defaultBlockState())), 17, 0.5F)));
    public static final RegistryObject<PlacedFeature> SULFUR_ORE = FeatureRegistry.PLACED_FEATURES.register("sulfur_ore", () -> new PlacedFeature(SULFUR_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SILICON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("silicon_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.SILICON_ORE.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_SILICON_ORE.get().defaultBlockState())), 17, 0.5F)));
    public static final RegistryObject<PlacedFeature> SILICON_ORE = FeatureRegistry.PLACED_FEATURES.register("silicon_ore", () -> new PlacedFeature(SILICON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CELESTIAL_REMNANT_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("celestial_remnant", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.CELESTIAL_REMNANT.get().defaultBlockState(), 3, 1.0F)));
    public static final RegistryObject<PlacedFeature> CELESTIAL_REMNANT = FeatureRegistry.PLACED_FEATURES.register("celestial_remnant", () -> new PlacedFeature(CELESTIAL_REMNANT_CONFIGURED.getHolder().get(), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-52)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("iron_ore_high", () -> new PlacedFeature(IRON_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(30, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> IRON_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> IRON_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("iron_ore_low", () -> new PlacedFeature(IRON_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("gold_ore_high", () -> new PlacedFeature(GOLD_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GOLD_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("gold_ore_low", () -> new PlacedFeature(GOLD_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 12, 1.0F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_high", () -> new PlacedFeature(DIAMOND_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIAMOND_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState())), 2, 1.0F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("diamond_ore_low", () -> new PlacedFeature(DIAMOND_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EMERALD_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("emerald_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.EMERALD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState())), 12, 1.0F)));
    public static final RegistryObject<PlacedFeature> EMERALD_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("emerald_ore_high", () -> new PlacedFeature(EMERALD_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(12, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> EMERALD_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("emerald_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.EMERALD_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState())), 2, 1.0F)));
    public static final RegistryObject<PlacedFeature> EMERALD_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("emerald_ore_low", () -> new PlacedFeature(EMERALD_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(3, HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 15, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("copper_ore_high", () -> new PlacedFeature(COPPER_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> COPPER_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState())), 7, 0.0F)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("copper_ore_low", () -> new PlacedFeature(COPPER_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(112)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ANCIENT_DEBRIS_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("ancient_debris", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.ANCIENT_DEBRIS.defaultBlockState(), 3, 1.0F)));
    public static final RegistryObject<PlacedFeature> ANCIENT_DEBRIS = FeatureRegistry.PLACED_FEATURES.register("ancient_debris", () -> new PlacedFeature(ANCIENT_DEBRIS_CONFIGURED.getHolder().get(), orePlacement(CountPlacement.of(UniformInt.of(0, 1)), HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-52)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_HIGH_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore_high", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:zinc_ore")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:deepslate_zinc_ore")).defaultBlockState())), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_HIGH = FeatureRegistry.PLACED_FEATURES.register("zinc_ore_high", () -> new PlacedFeature(ZINC_ORE_HIGH_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-63), VerticalAnchor.absolute(70)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ZINC_ORE_LOW_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore_low", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:zinc_ore")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:deepslate_zinc_ore")).defaultBlockState())), 6, 0.5F)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE_LOW = FeatureRegistry.PLACED_FEATURES.register("zinc_ore_low", () -> new PlacedFeature(ZINC_ORE_LOW_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-63), VerticalAnchor.absolute(70)))));

    /** Other */
    public static final RegistryObject<ConfiguredFeature<?, ?>> PERMAFROST_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("permafrost", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, BlocksRegistry.PERMAFROST.get().defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, BlocksRegistry.PERMAFROST.get().defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> PERMAFROST = FeatureRegistry.PLACED_FEATURES.register("permafrost", () -> new PlacedFeature(PERMAFROST_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> GRANITE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("granite", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.GRANITE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.GRANITE.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> GRANITE = FeatureRegistry.PLACED_FEATURES.register("granite", () -> new PlacedFeature(GRANITE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> DIORITE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diorite", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.DIORITE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.DIORITE.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> DIORITE = FeatureRegistry.PLACED_FEATURES.register("diorite", () -> new PlacedFeature(DIORITE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ANDESITE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("andesite", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.ANDESITE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.ANDESITE.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> ANDESITE = FeatureRegistry.PLACED_FEATURES.register("andesite", () -> new PlacedFeature(ANDESITE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SOUL_SOIL_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("soul_soil", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(MOON_MATCH, Blocks.SOUL_SOIL.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> SOUL_SOIL = FeatureRegistry.PLACED_FEATURES.register("soul_soil", () -> new PlacedFeature(SOUL_SOIL_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> BLACKSTONE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("blackstone", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.BLACKSTONE.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.BLACKSTONE.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> BLACKSTONE = FeatureRegistry.PLACED_FEATURES.register("blackstone", () -> new PlacedFeature(BLACKSTONE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SMOOTH_BASALT_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("smooth_basalt", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, Blocks.SMOOTH_BASALT.defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, Blocks.SMOOTH_BASALT.defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> SMOOTH_BASALT = FeatureRegistry.PLACED_FEATURES.register("smooth_basalt", () -> new PlacedFeature(SMOOTH_BASALT_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> CRIMSITE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("crimsite", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:crimsite")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:crimsite")).defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> CRIMSITE = FeatureRegistry.PLACED_FEATURES.register("crimsite", () -> new PlacedFeature(CRIMSITE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASURINE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asurine", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:asurine")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:asurine")).defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASURINE = FeatureRegistry.PLACED_FEATURES.register("asurine", () -> new PlacedFeature(ASURINE_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> VERIDIUM_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("veridium", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:veridium")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:veridium")).defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> VERIDIUM = FeatureRegistry.PLACED_FEATURES.register("veridium", () -> new PlacedFeature(VERIDIUM_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCORIA_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("scoria", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:scoria")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:scoria")).defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> SCORIA = FeatureRegistry.PLACED_FEATURES.register("scoria", () -> new PlacedFeature(SCORIA_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> SCORCHIA_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("scorchia", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(STONE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:scorchia")).defaultBlockState()), OreConfiguration.target(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:scorchia")).defaultBlockState())), 64, 0.0F)));
    public static final RegistryObject<PlacedFeature> SCORCHIA = FeatureRegistry.PLACED_FEATURES.register("scorchia", () -> new PlacedFeature(SCORCHIA_CONFIGURED.getHolder().get(), commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(60)))));

    /** Asteroid Ores */
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_ALUMINUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_ALUMINUM_ORE.get().defaultBlockState(), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_ALUMINUM_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_aluminum_ore", () -> new PlacedFeature(ASTEROID_ALUMINUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_TITANIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_titanium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState(), 9, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_TITANIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_titanium_ore", () -> new PlacedFeature(ASTEROID_TITANIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_SILICON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_silicon_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_SILICON_ORE.get().defaultBlockState(), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_SILICON_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_silicon_ore", () -> new PlacedFeature(ASTEROID_SILICON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_iron_ore", () -> new PlacedFeature(ASTEROID_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_gold_ore", () -> new PlacedFeature(ASTEROID_GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 4, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_diamond_ore", () -> new PlacedFeature(ASTEROID_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_EMERALD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_emerald_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 4, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_EMERALD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_emerald_ore", () -> new PlacedFeature(ASTEROID_EMERALD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_COPPER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_copper_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), 10, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_COPPER_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_copper_ore", () -> new PlacedFeature(ASTEROID_COPPER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, ForgeRegistries.BLOCKS.getValue(new ResourceLocation("create:deepslate_zinc_ore")).defaultBlockState(), 12, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_zinc_ore", () -> new PlacedFeature(ASTEROID_ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    /** Asteroid Other */
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_CARBON_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_carbon", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.CARBON.get().defaultBlockState(), 20, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_CARBON = FeatureRegistry.PLACED_FEATURES.register("asteroid_carbon", () -> new PlacedFeature(ASTEROID_CARBON_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_BLUE_ICE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_blue_ice", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.BLUE_ICE.defaultBlockState(), 30, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_BLUE_ICE = FeatureRegistry.PLACED_FEATURES.register("asteroid_blue_ice", () -> new PlacedFeature(ASTEROID_BLUE_ICE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?, ?>> ASTEROID_SKY_STONE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_sky_stone", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.SKY_STONE.get().defaultBlockState(), 30, 0.0F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_SKY_STONE = FeatureRegistry.PLACED_FEATURES.register("asteroid_sky_stone", () -> new PlacedFeature(ASTEROID_SKY_STONE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    /** Ore Placements */
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