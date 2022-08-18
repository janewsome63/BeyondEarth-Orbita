package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.resources.ResourceLocation;

import java.util.LinkedHashMap;

public class PowerSystemRegistry extends LinkedHashMap<ResourceLocation, PowerSystem> {

    private static final long serialVersionUID = 1L;

    public PowerSystemRegistry() {

    }

    public void put(PowerSystem powerSystem) {
        this.put(powerSystem.getName(), powerSystem);
    }

}
