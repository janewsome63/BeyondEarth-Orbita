package net.rennautogirl63.beyond_orbita.compats.coldsweat;

import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.compats.CompatibleMod;

public class ColdSweatCompat extends CompatibleMod {

	public static final String MODID = "cold_sweat";

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
