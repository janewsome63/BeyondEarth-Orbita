package net.rennautogirl63.beyond_orbita.compats.tinkers;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import slimeknights.mantle.registration.ModelFluidAttributes;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

public class TinkersBeyondEarthFluids {

    protected static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(BeyondOrbitaMod.MODID);

    public static final FluidObject<ForgeFlowingFluid> MOLTEN_DESH = FLUIDS.register("molten_desh", hotBuilder().temperature(800), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_OSTRUM = FLUIDS.register("molten_ostrum", hotBuilder().temperature(800), Material.LAVA, 12);
    public static final FluidObject<ForgeFlowingFluid> MOLTEN_CALORITE = FLUIDS.register("molten_calorite", hotBuilder().temperature(800), Material.LAVA, 12);

    //Creates a builder for a hot fluid
    private static FluidAttributes.Builder hotBuilder() {
        return ModelFluidAttributes.builder().density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA);
    }
}
