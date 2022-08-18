package net.rennautogirl63.beyond_orbita.compats.simpleplanes;

import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.compats.CompatibleMod;

public class SimplePlanesCompat extends CompatibleMod {

    public static final String MODID = "simpleplanes";

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
