package net.rennautogirl63.beyond_orbita.crafting;

import net.minecraftforge.registries.ForgeRegistryEntry;

import javax.annotation.Nonnull;

public class RocketPart extends ForgeRegistryEntry<RocketPart> {

    @Nonnull
    public static final RocketPart EMPTY = new RocketPart(0);

    private final int slots;

    public RocketPart(int slots) {
        this.slots = slots;
    }

    public int getSlots() {
        return this.slots;
    }
}
