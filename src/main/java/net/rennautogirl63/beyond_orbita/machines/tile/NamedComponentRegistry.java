package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

import java.util.LinkedHashMap;

public class NamedComponentRegistry<T> extends LinkedHashMap<ResourceLocation, T> {
    public static final ResourceLocation UNNAMED = new ResourceLocation(BeyondOrbitaMod.MODID, "unnmaed");
    private static final long serialVersionUID = 1L;

    public void put(T value) {
        if (this.containsKey(UNNAMED)) {
            throw new IllegalArgumentException("UNNAMED component is already added");
        }

        this.put(UNNAMED, value);
    }
}
