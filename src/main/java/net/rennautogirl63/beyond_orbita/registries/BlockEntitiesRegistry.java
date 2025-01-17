package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.flag.FlagTileEntity;
import net.rennautogirl63.beyond_orbita.globe.GlobeTileEntity;
import net.rennautogirl63.beyond_orbita.machines.tile.*;

public class BlockEntitiesRegistry {

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, BeyondOrbitaMod.MODID);

    /**
     * BLOCK ENTITIES (Machines)
     */
    public static final RegistryObject<BlockEntityType<?>> FLUID_OXIDIZER_BLOCK_ENTITY = BLOCK_ENTITIES.register("fluid_oxidizer", () -> BlockEntityType.Builder.of(FluidOxidizerBlockEntity::new, BlocksRegistry.FLUID_OXIDIZER_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> COAL_GENERATOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("coal_generator", () -> BlockEntityType.Builder.of(CoalGeneratorBlockEntity::new, BlocksRegistry.COAL_GENERATOR_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> OXYGEN_LOADER_BLOCK_ENTITY = BLOCK_ENTITIES.register("oxygen_loader", () -> BlockEntityType.Builder.of(OxygenLoaderBlockEntity::new, BlocksRegistry.OXYGEN_LOADER_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> SOLAR_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("solar_panel", () -> BlockEntityType.Builder.of(SolarPanelBlockEntity::new, BlocksRegistry.SOLAR_PANEL_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> ADVANCED_SOLAR_PANEL_BLOCK_ENTITY = BLOCK_ENTITIES.register("advanced_solar_panel", () -> BlockEntityType.Builder.of(AdvancedSolarPanelBlockEntity::new, BlocksRegistry.ADVANCED_SOLAR_PANEL_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<OxygenBubbleDistributorBlockEntity>> OXYGEN_BUBBLE_DISTRIBUTOR_BLOCK_ENTITY = BLOCK_ENTITIES.register("oxygen_bubble_distributor", () -> BlockEntityType.Builder.of(OxygenBubbleDistributorBlockEntity::new, BlocksRegistry.OXYGEN_BUBBLE_DISTRIBUTOR_BLOCK.get()).build(null));

    /**
     * BLOCK ENTITIES (Globes)
     */
    public static final RegistryObject<BlockEntityType<GlobeTileEntity>> GLOBE_BLOCK_ENTITY = BLOCK_ENTITIES.register("globe", () -> BlockEntityType.Builder.of(GlobeTileEntity::new, BlocksRegistry.MOON_GLOBE_BLOCK.get(), BlocksRegistry.MARS_GLOBE_BLOCK.get(), BlocksRegistry.MERCURY_GLOBE_BLOCK.get(), BlocksRegistry.VENUS_GLOBE_BLOCK.get(), BlocksRegistry.PLUTO_GLOBE_BLOCK.get()).build(null));

    /**
     * BLOCK ENTITIES (Flags)
     */
    public static final RegistryObject<BlockEntityType<FlagTileEntity>> FLAG_BLOCK_ENTITY = BLOCK_ENTITIES.register("flag", () -> BlockEntityType.Builder.of(FlagTileEntity::new, BlocksRegistry.FLAG_BLOCK.get(), BlocksRegistry.FLAG_BLUE_BLOCK.get(), BlocksRegistry.FLAG_BROWN_BLOCK.get(), BlocksRegistry.FLAG_CYAN_BLOCK.get(), BlocksRegistry.FLAG_GRAY_BLOCK.get(), BlocksRegistry.FLAG_GRAY_BLOCK.get(), BlocksRegistry.FLAG_GREEN_BLOCK.get(), BlocksRegistry.FLAG_LIGHT_BLUE_BLOCK.get(), BlocksRegistry.FLAG_LIME_BLOCK.get(), BlocksRegistry.FLAG_MAGENTA_BLOCk.get(), BlocksRegistry.FLAG_ORANGE_BLOCK.get(), BlocksRegistry.FLAG_PINK_BLOCK.get(), BlocksRegistry.FLAG_PURPLE_BLOCK.get(), BlocksRegistry.FLAG_RED_BLOCK.get(), BlocksRegistry.FLAG_YELLOW_BLOCK.get()).build(null));
}
