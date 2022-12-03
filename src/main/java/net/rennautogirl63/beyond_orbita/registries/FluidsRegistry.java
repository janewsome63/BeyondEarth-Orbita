package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

public class FluidsRegistry {

    public static final DeferredRegister<Fluid> FLUIDS
            = DeferredRegister.create(ForgeRegistries.FLUIDS, BeyondOrbitaMod.MODID);

    public static final ResourceLocation WATER_STILL_RL = new ResourceLocation("block/water_still");
    public static final ResourceLocation WATER_FLOW_RL = new ResourceLocation("block/water_flow");
    public static final ResourceLocation WATER_OVERLAY_RL = new ResourceLocation("block/water_overlay");

    /** Oil */
    public static final ResourceLocation OIL_STILL_RL = new ResourceLocation(BeyondOrbitaMod.MODID,"fluids/oil_still");
    public static final ResourceLocation OIL_FLOW_RL = new ResourceLocation(BeyondOrbitaMod.MODID,"fluids/oil_flow");
    public static final ResourceLocation OIL_OVERLAY_RL = new ResourceLocation(BeyondOrbitaMod.MODID,"fluids/oil_overlay");

    public static final RegistryObject<FlowingFluid> OIL_STILL
            = FLUIDS.register("oil", () -> new ForgeFlowingFluid.Source(FluidsRegistry.OIL_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_OIL
            = FLUIDS.register("oil_flowing", () -> new ForgeFlowingFluid.Flowing(FluidsRegistry.OIL_PROPERTIES));

    public static final ForgeFlowingFluid.Properties OIL_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> OIL_STILL.get(), () -> FLOWING_OIL.get(), FluidAttributes.builder(OIL_STILL_RL, OIL_FLOW_RL)
            .overlay(OIL_OVERLAY_RL)
            .sound(SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_FILL))
            .tickRate(20)
            .explosionResistance(1)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(3)
            .block(() -> FluidsRegistry.OIL_BLOCK.get()).bucket(() -> ItemsRegistry.OIL_BUCKET.get());

    public static final RegistryObject<LiquidBlock> OIL_BLOCK = BlocksRegistry.BLOCKS.register("oil",
            () -> new LiquidBlock(() -> FluidsRegistry.OIL_STILL.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    /** Kerosene */
    public static final RegistryObject<FlowingFluid> KEROSENE_STILL
            = FLUIDS.register("kerosene", () -> new ForgeFlowingFluid.Source(FluidsRegistry.KEROSENE_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_KEROSENE
            = FLUIDS.register("kerosene_flowing", () -> new ForgeFlowingFluid.Flowing(FluidsRegistry.KEROSENE_PROPERTIES));

    public static final ForgeFlowingFluid.Properties KEROSENE_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> KEROSENE_STILL.get(), () -> FLOWING_KEROSENE.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOW_RL)
            .overlay(WATER_OVERLAY_RL)
            .color(0xA0FF6959)
            .sound(SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_FILL))
            .tickRate(5)
            .explosionResistance(1)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(() -> FluidsRegistry.KEROSENE_BLOCK.get()).bucket(() -> ItemsRegistry.KEROSENE_BUCKET.get());

    public static final RegistryObject<LiquidBlock> KEROSENE_BLOCK = BlocksRegistry.BLOCKS.register("kerosene",
            () -> new LiquidBlock(() -> FluidsRegistry.KEROSENE_STILL.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    /** Propellant */
    public static final RegistryObject<FlowingFluid> PROPELLANT_STILL
            = FLUIDS.register("propellant", () -> new ForgeFlowingFluid.Source(FluidsRegistry.PROPELLANT_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FLOWING_PROPELLANT
            = FLUIDS.register("propellant_flowing", () -> new ForgeFlowingFluid.Flowing(FluidsRegistry.PROPELLANT_PROPERTIES));

    public static final ForgeFlowingFluid.Properties PROPELLANT_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> PROPELLANT_STILL.get(), () -> FLOWING_PROPELLANT.get(), FluidAttributes.builder(WATER_STILL_RL, WATER_FLOW_RL)
            .overlay(WATER_OVERLAY_RL)
            .color(0xA0BFFFFF)
            .sound(SoundEvents.BUCKET_EMPTY, SoundEvents.BUCKET_FILL))
            .tickRate(6)
            .explosionResistance(1)
            .slopeFindDistance(2)
            .levelDecreasePerBlock(1)
            .block(() -> FluidsRegistry.PROPELLANT_BLOCK.get()).bucket(() -> ItemsRegistry.PROPELLANT_BUCKET.get());

    public static final RegistryObject<LiquidBlock> PROPELLANT_BLOCK = BlocksRegistry.BLOCKS.register("propellant",
            () -> new LiquidBlock(() -> FluidsRegistry.PROPELLANT_STILL.get(), BlockBehaviour.Properties.of(Material.WATER).noCollission().strength(100f).noDrops()));

    public static void register(IEventBus eventBus) {
        FLUIDS.register(eventBus);
    }
}