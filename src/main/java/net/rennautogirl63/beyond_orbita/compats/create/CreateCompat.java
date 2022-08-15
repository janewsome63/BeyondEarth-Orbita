package net.rennautogirl63.beyond_orbita.compats.create;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import net.minecraft.data.worldgen.features.OreFeatures;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.compats.CompatibleMod;
import net.rennautogirl63.beyond_orbita.compats.tinkers.TinkersBeyondEarthFluids;
import net.rennautogirl63.beyond_orbita.registries.FeatureRegistry;

public class CreateCompat extends CompatibleMod {

	public static final String MODID = "create";

	public static ResourceLocation rl(String path) {
		return new ResourceLocation(MODID, path);
	}

	@Override
	public String getModID() {
		return MODID;
	}

	@Override
	protected void onLoad() {

	}

}
