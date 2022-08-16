package net.rennautogirl63.beyond_orbita.world.oregen;

import com.simibubi.create.AllBlocks;
import net.minecraft.core.Registry;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
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
import net.minecraftforge.fml.ModList;
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
    // Stone
    public static final TagKey<Block> STONE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "stone_ore_replaceables"));
    public static final RuleTest STONE_MATCH = new TagMatchTest(STONE_ORE_REPLACEABLES);
    
            // Copper
    public static final RegistryObject<ConfiguredFeature<?,?>> COPPER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("copper_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.COPPER_ORE.defaultBlockState(), 10)));
    public static final RegistryObject<PlacedFeature> COPPER_ORE = FeatureRegistry.PLACED_FEATURES.register("copper_ore", () -> new PlacedFeature(COPPER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(112)))));
    
            // Iron
    public static final RegistryObject<ConfiguredFeature<?,?>> IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState(), 9)));
    public static final RegistryObject<PlacedFeature> IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("iron_ore", () -> new PlacedFeature(IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(90, HeightRangePlacement.triangle(VerticalAnchor.absolute(80), VerticalAnchor.absolute(384)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> LOW_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("low_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> LOW_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("low_iron_ore", () -> new PlacedFeature(LOW_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(56)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> LOWEST_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("lowest_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.IRON_ORE.defaultBlockState(), 4)));
    public static final RegistryObject<PlacedFeature> LOWEST_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("lowest_iron_ore", () -> new PlacedFeature(LOWEST_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(72)))));
    
            // Gold
    public static final RegistryObject<ConfiguredFeature<?,?>> GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.GOLD_ORE.defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("gold_ore", () -> new PlacedFeature(GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)))));
            
            // Redstone
    public static final RegistryObject<ConfiguredFeature<?,?>> REDSTONE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("redstone_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.REDSTONE_ORE.defaultBlockState(), 4)));
    public static final RegistryObject<PlacedFeature> REDSTONE_ORE = FeatureRegistry.PLACED_FEATURES.register("redstone_ore", () -> new PlacedFeature(REDSTONE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(15)))));
    
            // Diamond
    public static final RegistryObject<ConfiguredFeature<?,?>> DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState(), 4, 0.5F)));
    public static final RegistryObject<PlacedFeature> DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("diamond_ore", () -> new PlacedFeature(DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(16)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> RARE_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("rare_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState(), 8, 1.0F)));
    public static final RegistryObject<PlacedFeature> RARE_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("rare_diamond_ore", () -> new PlacedFeature(RARE_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(16)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> RAREST_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("rarest_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.DIAMOND_ORE.defaultBlockState(), 12, 0.7F)));
    public static final RegistryObject<PlacedFeature> RAREST_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("rarest_diamond_ore", () -> new PlacedFeature(RAREST_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(1/9, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(16)))));

            // Zinc
    public static final RegistryObject<ConfiguredFeature<?,?>> ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, AllBlocks.ZINC_ORE.getDefaultState(), 12)));
    public static final RegistryObject<PlacedFeature> ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("zinc_ore", () -> new PlacedFeature(ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(70)))));

    // Deepslate
    public static final TagKey<Block> DEEPSLATE_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "deepslate_ore_replaceables"));
    public static final RuleTest DEEPSLATE_MATCH = new TagMatchTest(DEEPSLATE_ORE_REPLACEABLES);
    
            // Copper
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_COPPER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_copper_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), 10)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_COPPER_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_copper_ore", () -> new PlacedFeature(DEEPSLATE_COPPER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.triangle(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(0)))));
     
            // Iron
    public static final RegistryObject<ConfiguredFeature<?,?>> LOW_DEEPSLATE_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("low_deepslate_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 9)));
    public static final RegistryObject<PlacedFeature> LOW_DEEPSLATE_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("low_deepslate_iron_ore", () -> new PlacedFeature(LOW_DEEPSLATE_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.triangle(VerticalAnchor.absolute(-24), VerticalAnchor.absolute(0)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> LOWEST_DEEPSLATE_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("lowest_deepslate_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 4)));
    public static final RegistryObject<PlacedFeature> LOWEST_DEEPSLATE_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("lowest_deepslate_iron_ore", () -> new PlacedFeature(LOWEST_DEEPSLATE_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));
    
            // Gold
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_gold_ore", () -> new PlacedFeature(DEEPSLATE_GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(1/2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-48)))));

            // Redstone
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_REDSTONE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_redstone_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), 4)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_REDSTONE_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_redstone_ore", () -> new PlacedFeature(DEEPSLATE_REDSTONE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> LOW_DEEPSLATE_REDSTONE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("low_deepslate_redstone_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), 8)));
    public static final RegistryObject<PlacedFeature> LOW_DEEPSLATE_REDSTONE_ORE = FeatureRegistry.PLACED_FEATURES.register("low_deepslate_redstone_ore", () -> new PlacedFeature(LOW_DEEPSLATE_REDSTONE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-96), VerticalAnchor.absolute(-32)))));

            // Diamond
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 4, 0.5F)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_diamond_ore", () -> new PlacedFeature(DEEPSLATE_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.triangle(VerticalAnchor.absolute(-144), VerticalAnchor.absolute(0)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> RARE_DEEPSLATE_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("rare_deepslate_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 8, 1.0F)));
    public static final RegistryObject<PlacedFeature> RARE_DEEPSLATE_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("rare_deepslate_diamond_ore", () -> new PlacedFeature(RARE_DEEPSLATE_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(4, HeightRangePlacement.triangle(VerticalAnchor.absolute(-144), VerticalAnchor.absolute(0)))));
    public static final RegistryObject<ConfiguredFeature<?,?>> RAREST_DEEPSLATE_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("rarest_deepslate_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 12, 0.7F)));
    public static final RegistryObject<PlacedFeature> RAREST_DEEPSLATE_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("rarest_deepslate_diamond_ore", () -> new PlacedFeature(RAREST_DEEPSLATE_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(1/9, HeightRangePlacement.triangle(VerticalAnchor.absolute(-144), VerticalAnchor.absolute(0)))));

            // Zinc
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState(), 12)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_zinc_ore", () -> new PlacedFeature(DEEPSLATE_ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));

    /** Mercury Specific: */
    // Mercury Stone
    public static final TagKey<Block> MERCURY_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mercury_ore_replaceables"));
    public static final RuleTest MERCURY_MATCH = new TagMatchTest(MERCURY_ORE_REPLACEABLES);

    // Stone
            // Potassium
    public static final RegistryObject<ConfiguredFeature<?,?>> POTASSIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("potassium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, BlocksRegistry.POTASSIUM_ORE.get().defaultBlockState(), 17)));
    public static final RegistryObject<PlacedFeature> POTASSIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("potassium_ore", () -> new PlacedFeature(POTASSIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));

    /** Venus Specific: */
    // Venus Stone
    public static final TagKey<Block> VENUS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "venus_ore_replaceables"));
    public static final RuleTest VENUS_MATCH = new TagMatchTest(VENUS_ORE_REPLACEABLES);

    // Stone
            // Sulphur
    public static final RegistryObject<ConfiguredFeature<?,?>> SULPHUR_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("sulphur_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, BlocksRegistry.SULPHUR_ORE.get().defaultBlockState(), 17)));
    public static final RegistryObject<PlacedFeature> SULPHUR_ORE = FeatureRegistry.PLACED_FEATURES.register("sulphur_ore", () -> new PlacedFeature(SULPHUR_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(192)))));

    /** Moon Specific: */
    // Moon Stone
    public static final TagKey<Block> MOON_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "moon_ore_replaceables"));
    public static final RuleTest MOON_MATCH = new TagMatchTest(MOON_ORE_REPLACEABLES);

    // Stone
            // Chromium
    public static final RegistryObject<ConfiguredFeature<?,?>> CHROMITE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("chromite_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, BlocksRegistry.CHROMITE_ORE.get().defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> CHROMITE_ORE = FeatureRegistry.PLACED_FEATURES.register("chromite_ore", () -> new PlacedFeature(CHROMITE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)))));

    // Deepslate
            // Chromium
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_CHROMITE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_chromite_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_CHROMITE_ORE.get().defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_CHROMITE_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_chromite_ore", () -> new PlacedFeature(DEEPSLATE_CHROMITE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));

    // Other
            // Soul Sand
    public static final RegistryObject<ConfiguredFeature<?,?>> MOON_SOUL_SOIL_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("moon_soul_soil", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(MOON_MATCH, Blocks.SOUL_SOIL.defaultBlockState(), 60)));
    public static final RegistryObject<PlacedFeature> MOON_SOUL_SOIL = FeatureRegistry.PLACED_FEATURES.register("moon_soul_soil", () -> new PlacedFeature(MOON_SOUL_SOIL_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));

    /** Mars Specific: */
    // Mars Stone
    public static final TagKey<Block> MARS_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mars_ore_replaceables"));
    public static final RuleTest MARS_MATCH = new TagMatchTest(MARS_ORE_REPLACEABLES);

    // Stone
            // Aluminum
    public static final RegistryObject<ConfiguredFeature<?,?>> BAUXITE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(STONE_MATCH, BlocksRegistry.BAUXITE_ORE.get().defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> BAUXITE_ORE = FeatureRegistry.PLACED_FEATURES.register("bauxite_ore", () -> new PlacedFeature(BAUXITE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(32)))));

    // Deepslate
            // Aluminum
    public static final RegistryObject<ConfiguredFeature<?,?>> DEEPSLATE_BAUXITE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("deepslate_aluminum_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_BAUXITE_ORE.get().defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> DEEPSLATE_BAUXITE_ORE = FeatureRegistry.PLACED_FEATURES.register("deepslate_bauxite_ore", () -> new PlacedFeature(DEEPSLATE_BAUXITE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.triangle(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(0)))));

    /** Glacio Specific: */
    // Glacio Stone
    public static final TagKey<Block> GLACIO_ORE_REPLACEABLES = TagKey.create(Registry.BLOCK_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "glacio_ore_replaceables"));
    public static final RuleTest GLACIO_MATCH = new TagMatchTest(GLACIO_ORE_REPLACEABLES);

    // Other
            // Nitrogen Ice
    public static final RegistryObject<ConfiguredFeature<?,?>> NITROGEN_ICE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("nitrogen_ice", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(GLACIO_MATCH, BlocksRegistry.NITROGEN_ICE.get().defaultBlockState(), 60)));
    public static final RegistryObject<PlacedFeature> NITROGEN_ICE_ORE = FeatureRegistry.PLACED_FEATURES.register("nitrogen_ice", () -> new PlacedFeature(NITROGEN_ICE_CONFIGURED.getHolder().get(), commonOrePlacement(20, HeightRangePlacement.triangle(VerticalAnchor.absolute(0), VerticalAnchor.absolute(100)))));


    /** Asteroid Specific */
    // Deepslate
            // Copper
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_COPPER_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_copper_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_COPPER_ORE.defaultBlockState(), 10)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_COPPER_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_copper_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_COPPER_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Iron
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_IRON_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_iron_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_IRON_ORE.defaultBlockState(), 9)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_IRON_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_iron_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_IRON_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(90, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Gold
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_GOLD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_gold_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_GOLD_ORE.defaultBlockState(), 9)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_GOLD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_gold_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_GOLD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(50, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Redstone
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_REDSTONE_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_redstone_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_REDSTONE_ORE.defaultBlockState(), 8)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_REDSTONE_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_redstone_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_REDSTONE_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Diamond
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_DIAMOND_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_diamond_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_DIAMOND_ORE.defaultBlockState(), 4)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_DIAMOND_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_diamond_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_DIAMOND_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Emerald
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_EMERALD_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_emerald_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.DEEPSLATE_EMERALD_ORE.defaultBlockState(), 2)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_EMERALD_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_emerald_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_EMERALD_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(7/2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Zinc
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_ZINC_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_zinc_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, AllBlocks.DEEPSLATE_ZINC_ORE.getDefaultState(), 12)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_ZINC_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_zinc_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_ZINC_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Titanium
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_DEEPSLATE_TITANIUM_ORE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_deepslate_titanium_ore", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get().defaultBlockState(), 9, 0.5F)));
    public static final RegistryObject<PlacedFeature> ASTEROID_DEEPSLATE_TITANIUM_ORE = FeatureRegistry.PLACED_FEATURES.register("asteroid_deepslate_titanium_ore", () -> new PlacedFeature(ASTEROID_DEEPSLATE_TITANIUM_ORE_CONFIGURED.getHolder().get(), commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    // Other
            // Carbon
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_CARBON_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("carbon", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.CARBON.get().defaultBlockState(), 20)));
    public static final RegistryObject<PlacedFeature> ASTEROID_CARBON = FeatureRegistry.PLACED_FEATURES.register("carbon", () -> new PlacedFeature(ASTEROID_CARBON_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Blue Ice
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_BLUE_ICE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_blue_ice", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, Blocks.BLUE_ICE.defaultBlockState(), 30)));
    public static final RegistryObject<PlacedFeature> ASTEROID_BLUE_ICE = FeatureRegistry.PLACED_FEATURES.register("asteroid_blue_ice", () -> new PlacedFeature(ASTEROID_BLUE_ICE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

            // Sky Stone
    public static final RegistryObject<ConfiguredFeature<?,?>> ASTEROID_SKY_STONE_CONFIGURED = FeatureRegistry.CONFIGURED_FEATURES.register("asteroid_sky_stone", () -> new ConfiguredFeature(Feature.ORE, new OreConfiguration(DEEPSLATE_MATCH, BlocksRegistry.SKY_STONE.get().defaultBlockState(), 30)));
    public static final RegistryObject<PlacedFeature> ASTEROID_SKY_STONE = FeatureRegistry.PLACED_FEATURES.register("asteroid_sky_stone", () -> new PlacedFeature(ASTEROID_SKY_STONE_CONFIGURED.getHolder().get(), commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(384)))));

    @SubscribeEvent
    public static void biomesLoading(BiomeLoadingEvent event) {
        ResourceLocation biome = event.getName();

        if (biome.equals(BiomesRegistry.MOON_DESERT)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(MOON_SOUL_SOIL.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(CHROMITE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_CHROMITE_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.MARS_DESERT) || biome.equals(BiomesRegistry.MARS_ROCKY_PLAINS) || biome.equals(BiomesRegistry.MARS_ICE_SPIKES)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(BAUXITE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_BAUXITE_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.MERCURY)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(POTASSIUM_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.VENUS_DESERT) || biome.equals(BiomesRegistry.INFERNAL_VENUS_BARRENS)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(SULPHUR_ORE.getHolder().get());
        }

        if (biome.equals(BiomesRegistry.GLACIO) || biome.equals(BiomesRegistry.GLACIO_ICE_SPIKES)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOWEST_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(LOW_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RARE_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(RAREST_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(DEEPSLATE_ZINC_ORE.getHolder().get());
        }
        if (biome.equals(BiomesRegistry.ASTEROID_FIELD)) {
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_COPPER_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_IRON_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_GOLD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_REDSTONE_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_DIAMOND_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_EMERALD_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_ZINC_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_DEEPSLATE_TITANIUM_ORE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_CARBON.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_BLUE_ICE.getHolder().get());
            event.getGeneration().getFeatures(GenerationStep.Decoration.UNDERGROUND_ORES).add(ASTEROID_SKY_STONE.getHolder().get());
        }
    }

    /** ORE PLACEMENTS */
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
