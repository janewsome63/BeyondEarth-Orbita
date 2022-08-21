package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.armormaterials.NetheriteSpaceSuitMaterial;
import net.rennautogirl63.beyond_orbita.armormaterials.SpaceSuitMaterial;
import net.rennautogirl63.beyond_orbita.armors.NetheriteSpaceSuit;
import net.rennautogirl63.beyond_orbita.armors.SpaceSuit;
import net.rennautogirl63.beyond_orbita.globe.GlobeItem;
import net.rennautogirl63.beyond_orbita.itemgroups.ItemGroups;
import net.rennautogirl63.beyond_orbita.items.*;

public class ItemsRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BeyondOrbitaMod.MODID);

    /**
     * Vehicles
     */
    public static final RegistryObject<RoverItem> ROVER_ITEM = ITEMS.register("rover", () -> new RoverItem(new Item.Properties().tab(ItemGroups.tab_normal).stacksTo(1)));
    public static final RegistryObject<Tier1RocketItem> TIER_1_ROCKET_ITEM = ITEMS.register("rocket_t1", () -> new Tier1RocketItem(new Item.Properties().tab(ItemGroups.tab_normal).stacksTo(1)));
    public static final RegistryObject<Tier2RocketItem> TIER_2_ROCKET_ITEM = ITEMS.register("rocket_t2", () -> new Tier2RocketItem(new Item.Properties().tab(ItemGroups.tab_normal).stacksTo(1)));
    public static final RegistryObject<Tier3RocketItem> TIER_3_ROCKET_ITEM = ITEMS.register("rocket_t3", () -> new Tier3RocketItem(new Item.Properties().tab(ItemGroups.tab_normal).stacksTo(1)));
    public static final RegistryObject<Tier4RocketItem> TIER_4_ROCKET_ITEM = ITEMS.register("rocket_t4", () -> new Tier4RocketItem(new Item.Properties().tab(ItemGroups.tab_normal).stacksTo(1)));

    /**
     * Armor
     */
    public static final RegistryObject<Item> OXYGEN_MASK = ITEMS.register("oxygen_mask", () -> new SpaceSuit.OxygenMask(SpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SPACE_SUIT = ITEMS.register("space_suit", () -> new SpaceSuit.Suit(SpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SPACE_PANTS = ITEMS.register("space_pants", () -> new SpaceSuit.Pants(SpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SPACE_BOOTS = ITEMS.register("space_boots", () -> new SpaceSuit.Boots(SpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> NETHERITE_OXYGEN_MASK = ITEMS.register("netherite_oxygen_mask", () -> new NetheriteSpaceSuit.OxygenMask(NetheriteSpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.HEAD, new Item.Properties().tab(ItemGroups.tab_normal).fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SPACE_SUIT = ITEMS.register("netherite_space_suit", () -> new NetheriteSpaceSuit.Suit(NetheriteSpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.CHEST, new Item.Properties().tab(ItemGroups.tab_normal).fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SPACE_PANTS = ITEMS.register("netherite_space_pants", () -> new NetheriteSpaceSuit.Pants(NetheriteSpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.LEGS, new Item.Properties().tab(ItemGroups.tab_normal).fireResistant()));
    public static final RegistryObject<Item> NETHERITE_SPACE_BOOTS = ITEMS.register("netherite_space_boots", () -> new NetheriteSpaceSuit.Boots(NetheriteSpaceSuitMaterial.ARMOR_MATERIAL, EquipmentSlot.FEET, new Item.Properties().tab(ItemGroups.tab_normal).fireResistant()));

    /**
     * Decoration
     */
    public static final RegistryObject<Item> COAL_TORCH_ITEM = ITEMS.register("coal_torch", () -> new CoalTorchItem(BlocksRegistry.COAL_TORCH_BLOCK.get(), BlocksRegistry.WALL_COAL_TORCH_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> COAL_LANTERN_ITEM = ITEMS.register("coal_lantern", () -> new BlockItem(BlocksRegistry.COAL_LANTERN_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> IRON_PLATING_ITEM = ITEMS.register("iron_plating", () -> new BlockItem(BlocksRegistry.IRON_PLATING.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> BLUE_IRON_PLATING_ITEM = ITEMS.register("blue_iron_plating", () -> new BlockItem(BlocksRegistry.BLUE_IRON_PLATING.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> RUSTED_IRON_PLATING_ITEM = ITEMS.register("rusted_iron_plating", () -> new BlockItem(BlocksRegistry.RUSTED_IRON_PLATING.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> RUSTED_IRON_PILLAR_ITEM = ITEMS.register("rusted_iron_pillar", () -> new BlockItem(BlocksRegistry.RUSTED_IRON_PILLAR.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> IRON_MARK_ITEM = ITEMS.register("iron_mark", () -> new BlockItem(BlocksRegistry.IRON_MARK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_ITEM = ITEMS.register("flag", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_BLUE_ITEM = ITEMS.register("flag_blue", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_BLUE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_BROWN_ITEM = ITEMS.register("flag_brown", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_BROWN_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_CYAN_ITEM = ITEMS.register("flag_cyan", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_CYAN_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_GRAY_ITEM = ITEMS.register("flag_gray", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_GRAY_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_GREEN_ITEM = ITEMS.register("flag_green", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_GREEN_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_LIGHT_BLUE_ITEM = ITEMS.register("flag_light_blue", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_LIGHT_BLUE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_LIME_ITEM = ITEMS.register("flag_lime", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_LIME_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_MAGENTA_ITEM = ITEMS.register("flag_magenta", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_MAGENTA_BLOCk.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_ORANGE_ITEM = ITEMS.register("flag_orange", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_ORANGE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_PINK_ITEM = ITEMS.register("flag_pink", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_PINK_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_PURPLE_ITEM = ITEMS.register("flag_purple", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_PURPLE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_RED_ITEM = ITEMS.register("flag_red", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_RED_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FLAG_YELLOW_ITEM = ITEMS.register("flag_yellow", () -> new DoubleHighBlockItem(BlocksRegistry.FLAG_YELLOW_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Machinery
     */
    public static final RegistryObject<BlockItem> OXYGEN_LOADER_ITEM = ITEMS.register("oxygen_loader", () -> new BlockItem(BlocksRegistry.OXYGEN_LOADER_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> OXYGEN_BUBBLE_DISTRIBUTOR_ITEM = ITEMS.register("oxygen_bubble_distributor", () -> new BlockItem(BlocksRegistry.OXYGEN_BUBBLE_DISTRIBUTOR_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SOLAR_PANEL_ITEM = ITEMS.register("solar_panel", () -> new BlockItem(BlocksRegistry.SOLAR_PANEL_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> COAL_GENERATOR_ITEM = ITEMS.register("coal_generator", () -> new BlockItem(BlocksRegistry.COAL_GENERATOR_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> FUEL_REFINERY_ITEM = ITEMS.register("fuel_refinery", () -> new BlockItem(BlocksRegistry.FUEL_REFINERY_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> ROCKET_LAUNCH_PAD_ITEM = ITEMS.register("rocket_launch_pad", () -> new BlockItem(BlocksRegistry.ROCKET_LAUNCH_PAD.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Spawn Eggs
     */
    public static final RegistryObject<ForgeSpawnEggItem> ALIEN_SPAWN_EGG = ITEMS.register("alien_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.ALIEN::get, -13382401, -11650781, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<ForgeSpawnEggItem> STAR_CRAWLER_SPAWN_EGG = ITEMS.register("star_crawler_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.STAR_CRAWLER::get, -13421773, -16724788, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<ForgeSpawnEggItem> PYGRO_SPAWN_EGG = ITEMS.register("pygro_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.PYGRO::get, -3381760, -6750208, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<ForgeSpawnEggItem> PYGRO_BRUTE_SPAWN_EGG = ITEMS.register("pygro_brute_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.PYGRO_BRUTE::get, -3381760, -67208, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<ForgeSpawnEggItem> MOGLER_SPAWN_EGG = ITEMS.register("mogler_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.MOGLER::get, -13312, -3407872, new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<ForgeSpawnEggItem> MARTIAN_RAPTOR_SPAWN_EGG = ITEMS.register("martian_raptor_spawn_egg", () -> new ForgeSpawnEggItem(EntitiesRegistry.MARTIAN_RAPTOR::get, 5349438, -13312, new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Non-Specific
     */
    public static final RegistryObject<Item> OXYGEN_GEAR = ITEMS.register("oxygen_gear", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> OXYGEN_TANK = ITEMS.register("oxygen_tank", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> WHEEL = ITEMS.register("wheel", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ENGINE_FRAME = ITEMS.register("engine_frame", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ENGINE_FAN = ITEMS.register("engine_fan", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ROCKET_NOSE_CONE = ITEMS.register("rocket_nose_cone", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ROCKET_FIN = ITEMS.register("rocket_fin", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> OIL_BUCKET = ITEMS.register("oil_bucket", () -> new BucketItem(FluidsRegistry.OIL_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> FUEL_BUCKET = ITEMS.register("fuel_bucket", () -> new BucketItem(FluidsRegistry.FUEL_STILL, new Item.Properties().craftRemainder(Items.BUCKET).stacksTo(1).tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> OTHERWORLDLY_STAR = ITEMS.register("otherworldly_star", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> WARP_ENGINE = ITEMS.register("warp_engine", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_DUST = ITEMS.register("steel_dust", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_ENGINE = ITEMS.register("steel_engine", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_TANK = ITEMS.register("steel_tank", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> STEEL_HULL = ITEMS.register("steel_hull", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> STEEL_BLOCK_ITEM = ITEMS.register("steel_block", () -> new BlockItem(BlocksRegistry.STEEL_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> STONE_ITEM = ITEMS.register("stone", () -> new BlockItem(BlocksRegistry.STONE.get(), new Item.Properties()));
    public static final RegistryObject<BlockItem> DEEPSLATE_ITEM = ITEMS.register("deepslate", () -> new BlockItem(BlocksRegistry.DEEPSLATE.get(), new Item.Properties()));

    /**
     * Mercury Items
     */
    public static final RegistryObject<BlockItem> MERCURY_GLOBE_ITEM = ITEMS.register("mercury_globe", () -> new GlobeItem(BlocksRegistry.MERCURY_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> POTASSIUM = ITEMS.register("potassium", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SULFUR = ITEMS.register("sulfur", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SULFUR_DUST_ITEM = ITEMS.register("sulfur_dust", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> POTASSIUM_ORE_ITEM = ITEMS.register("potassium_ore", () -> new BlockItem(BlocksRegistry.POTASSIUM_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_POTASSIUM_ORE_ITEM = ITEMS.register("deepslate_potassium_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_POTASSIUM_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> POTASSIUM_BLOCK_ITEM = ITEMS.register("potassium_block", () -> new BlockItem(BlocksRegistry.POTASSIUM_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SULFUR_ORE_ITEM = ITEMS.register("sulfur_ore", () -> new BlockItem(BlocksRegistry.SULFUR_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_SULFUR_ORE_ITEM = ITEMS.register("deepslate_sulfur_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_SULFUR_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SULFUR_BLOCK_ITEM = ITEMS.register("sulfur_block", () -> new BlockItem(BlocksRegistry.SULFUR_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MERCURY_STONE_ITEM = ITEMS.register("mercury_stone", () -> new BlockItem(BlocksRegistry.MERCURY_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MERCURY_STONE_BRICKS_ITEM = ITEMS.register("mercury_stone_bricks", () -> new BlockItem(BlocksRegistry.MERCURY_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_MERCURY_STONE_BRICKS_ITEM = ITEMS.register("cracked_mercury_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_MERCURY_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MERCURY_STONE_BRICK_SLAB_ITEM = ITEMS.register("mercury_stone_brick_slab", () -> new BlockItem(BlocksRegistry.MERCURY_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MERCURY_STONE_BRICK_STAIRS_ITEM = ITEMS.register("mercury_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.MERCURY_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Venus Items
     */
    public static final RegistryObject<BlockItem> VENUS_GLOBE_ITEM = ITEMS.register("venus_globe", () -> new GlobeItem(BlocksRegistry.VENUS_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> INFERNAL_SHARD = ITEMS.register("infernal_shard", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_SAND_ITEM = ITEMS.register("venus_sand", () -> new BlockItem(BlocksRegistry.VENUS_SAND.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> INFERNAL_SPIRE_ITEM = ITEMS.register("infernal_spire", () -> new BlockItem(BlocksRegistry.INFERNAL_SPIRE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_STONE_ITEM = ITEMS.register("venus_stone", () -> new BlockItem(BlocksRegistry.VENUS_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_STONE_BRICKS_ITEM = ITEMS.register("venus_stone_bricks", () -> new BlockItem(BlocksRegistry.VENUS_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_VENUS_STONE_BRICKS_ITEM = ITEMS.register("cracked_venus_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_VENUS_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_STONE_BRICK_SLAB_ITEM = ITEMS.register("venus_stone_brick_slab", () -> new BlockItem(BlocksRegistry.VENUS_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_STONE_BRICK_STAIRS_ITEM = ITEMS.register("venus_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.VENUS_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_SANDSTONE_ITEM = ITEMS.register("venus_sandstone", () -> new BlockItem(BlocksRegistry.VENUS_SANDSTONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_SANDSTONE_BRICKS_ITEM = ITEMS.register("venus_sandstone_bricks", () -> new BlockItem(BlocksRegistry.VENUS_SANDSTONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_VENUS_SANDSTONE_BRICKS_ITEM = ITEMS.register("cracked_venus_sandstone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_VENUS_SANDSTONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_SANDSTONE_BRICK_SLAB_ITEM = ITEMS.register("venus_sandstone_brick_slab", () -> new BlockItem(BlocksRegistry.VENUS_SANDSTONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> VENUS_SANDSTONE_BRICK_STAIRS_ITEM = ITEMS.register("venus_sandstone_brick_stairs", () -> new BlockItem(BlocksRegistry.VENUS_SANDSTONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Moon Items
     */
    public static final RegistryObject<BlockItem> MOON_GLOBE_ITEM = ITEMS.register("moon_globe", () -> new GlobeItem(BlocksRegistry.MOON_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> RAW_BAUXITE = ITEMS.register("raw_bauxite", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_DUST = ITEMS.register("aluminum_dust", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_INGOT = ITEMS.register("aluminum_ingot", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_NUGGET = ITEMS.register("aluminum_nugget", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_PLATE = ITEMS.register("aluminum_plate", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_ENGINE = ITEMS.register("aluminum_engine", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_TANK = ITEMS.register("aluminum_tank", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> ALUMINUM_HULL = ITEMS.register("aluminum_hull", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> BAUXITE_ORE_ITEM = ITEMS.register("bauxite_ore", () -> new BlockItem(BlocksRegistry.BAUXITE_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_BAUXITE_ORE_ITEM = ITEMS.register("deepslate_bauxite_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_BAUXITE_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> QUARTZ_ORE_ITEM = ITEMS.register("quartz_ore", () -> new BlockItem(BlocksRegistry.QUARTZ_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_QUARTZ_ORE_ITEM = ITEMS.register("deepslate_quartz_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_QUARTZ_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> RAW_BAUXITE_BLOCK = ITEMS.register("raw_bauxite_block", () -> new BlockItem(BlocksRegistry.RAW_BAUXITE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> ALUMINUM_BLOCK_ITEM = ITEMS.register("aluminum_block", () -> new BlockItem(BlocksRegistry.ALUMINUM_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MOON_SAND_ITEM = ITEMS.register("moon_sand", () -> new BlockItem(BlocksRegistry.MOON_SAND.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MOON_STONE_ITEM = ITEMS.register("moon_stone", () -> new BlockItem(BlocksRegistry.MOON_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MOON_STONE_BRICKS_ITEM = ITEMS.register("moon_stone_bricks", () -> new BlockItem(BlocksRegistry.MOON_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_MOON_STONE_BRICKS_ITEM = ITEMS.register("cracked_moon_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_MOON_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MOON_STONE_BRICK_SLAB_ITEM = ITEMS.register("moon_stone_brick_slab", () -> new BlockItem(BlocksRegistry.MOON_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MOON_STONE_BRICK_STAIRS_ITEM = ITEMS.register("moon_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.MOON_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Mars Items
     */
    public static final RegistryObject<BlockItem> MARS_GLOBE_ITEM = ITEMS.register("mars_globe", () -> new GlobeItem(BlocksRegistry.MARS_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> RAW_TITANIUM = ITEMS.register("raw_titanium", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_DUST = ITEMS.register("titanium_dust", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_NUGGET = ITEMS.register("titanium_nugget", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_PLATE = ITEMS.register("titanium_plate", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_ENGINE = ITEMS.register("titanium_engine", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_TANK = ITEMS.register("titanium_tank", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> TITANIUM_HULL = ITEMS.register("titanium_hull", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> TITANIUM_ORE_ITEM = ITEMS.register("titanium_ore", () -> new BlockItem(BlocksRegistry.TITANIUM_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_TITANIUM_ORE_ITEM = ITEMS.register("deepslate_titanium_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> RAW_TITANIUM_BLOCK = ITEMS.register("raw_titanium_block", () -> new BlockItem(BlocksRegistry.RAW_TITANIUM_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> TITANIUM_BLOCK_ITEM = ITEMS.register("titanium_block", () -> new BlockItem(BlocksRegistry.TITANIUM_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MARS_SAND_ITEM = ITEMS.register("mars_sand", () -> new BlockItem(BlocksRegistry.MARS_SAND.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MARS_STONE_ITEM = ITEMS.register("mars_stone", () -> new BlockItem(BlocksRegistry.MARS_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MARS_STONE_BRICKS_ITEM = ITEMS.register("mars_stone_bricks", () -> new BlockItem(BlocksRegistry.MARS_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_MARS_STONE_BRICKS_ITEM = ITEMS.register("cracked_mars_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_MARS_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MARS_STONE_BRICK_SLAB_ITEM = ITEMS.register("mars_stone_brick_slab", () -> new BlockItem(BlocksRegistry.MARS_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> MARS_STONE_BRICK_STAIRS_ITEM = ITEMS.register("mars_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.MARS_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Asteroid Items
     */
    public static final RegistryObject<Item> CARBON_CHUNK = ITEMS.register("carbon_chunk", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> SILICON = ITEMS.register("silicon", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SILICON_ORE_ITEM = ITEMS.register("silicon_ore", () -> new BlockItem(BlocksRegistry.SILICON_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> DEEPSLATE_SILICON_ORE_ITEM = ITEMS.register("deepslate_silicon_ore", () -> new BlockItem(BlocksRegistry.DEEPSLATE_SILICON_ORE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SILICON_BLOCK_ITEM = ITEMS.register("silicon_block", () -> new BlockItem(BlocksRegistry.SILICON_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CARBON_ITEM = ITEMS.register("carbon", () -> new BlockItem(BlocksRegistry.CARBON.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> SKY_STONE_ITEM = ITEMS.register("sky_stone", () -> new BlockItem(BlocksRegistry.SKY_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Glacio Items
     */
    public static final RegistryObject<BlockItem> GLACIO_GLOBE_ITEM = ITEMS.register("glacio_globe", () -> new GlobeItem(BlocksRegistry.GLACIO_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<BlockItem> GLACIO_STONE_ITEM = ITEMS.register("glacio_stone", () -> new BlockItem(BlocksRegistry.GLACIO_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> GLACIO_STONE_BRICKS_ITEM = ITEMS.register("glacio_stone_bricks", () -> new BlockItem(BlocksRegistry.GLACIO_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_GLACIO_STONE_BRICKS_ITEM = ITEMS.register("cracked_glacio_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_GLACIO_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> GLACIO_STONE_BRICK_SLAB_ITEM = ITEMS.register("glacio_stone_brick_slab", () -> new BlockItem(BlocksRegistry.GLACIO_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> GLACIO_STONE_BRICK_STAIRS_ITEM = ITEMS.register("glacio_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.GLACIO_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

    /**
     * Pluto Items
     */
    public static final RegistryObject<BlockItem> PLUTO_GLOBE_ITEM = ITEMS.register("pluto_globe", () -> new GlobeItem(BlocksRegistry.PLUTO_GLOBE_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal).rarity(Rarity.EPIC).stacksTo(1)));
    public static final RegistryObject<Item> PERMAFROST_SHARD = ITEMS.register("permafrost_shard", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<Item> CELESTIAL_FRAGMENT = ITEMS.register("celestial_fragment", () -> new Item(new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CELESTIAL_REMNANT_ITEM = ITEMS.register("celestial_remnant", () -> new BlockItem(BlocksRegistry.CELESTIAL_REMNANT.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CELESTIAL_BLOCK_ITEM = ITEMS.register("celestial_block", () -> new BlockItem(BlocksRegistry.CELESTIAL_BLOCK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CELESTIAL_BRICK_ITEM = ITEMS.register("celestial_brick", () -> new BlockItem(BlocksRegistry.CELESTIAL_BRICK.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PERMAFROST_ITEM = ITEMS.register("permafrost", () -> new BlockItem(BlocksRegistry.PERMAFROST.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PLUTO_SAND_ITEM = ITEMS.register("pluto_sand", () -> new BlockItem(BlocksRegistry.PLUTO_SAND.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PLUTO_STONE_ITEM = ITEMS.register("pluto_stone", () -> new BlockItem(BlocksRegistry.PLUTO_STONE.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PLUTO_STONE_BRICKS_ITEM = ITEMS.register("pluto_stone_bricks", () -> new BlockItem(BlocksRegistry.PLUTO_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> CRACKED_PLUTO_STONE_BRICKS_ITEM = ITEMS.register("cracked_pluto_stone_bricks", () -> new BlockItem(BlocksRegistry.CRACKED_PLUTO_STONE_BRICKS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PLUTO_STONE_BRICK_SLAB_ITEM = ITEMS.register("pluto_stone_brick_slab", () -> new BlockItem(BlocksRegistry.PLUTO_STONE_BRICK_SLAB.get(), new Item.Properties().tab(ItemGroups.tab_normal)));
    public static final RegistryObject<BlockItem> PLUTO_STONE_BRICK_STAIRS_ITEM = ITEMS.register("pluto_stone_brick_stairs", () -> new BlockItem(BlocksRegistry.PLUTO_STONE_BRICK_STAIRS.get(), new Item.Properties().tab(ItemGroups.tab_normal)));

}
