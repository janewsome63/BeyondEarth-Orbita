package net.rennautogirl63.beyond_orbita.compats.tinkers;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rennautogirl63.beyond_orbita.compats.CompatibleMod;

public class TinkersCompat extends CompatibleMod {

	public static final String MODID = "tconstruct";

	public static ResourceLocation rl(String path) {
		return new ResourceLocation(MODID, path);
	}

	@Override
	public String getModID() {
		return MODID;
	}

	@Override
	protected void onLoad() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		TinkersBeyondEarthFluids.FLUIDS.register(bus);
	}
}
