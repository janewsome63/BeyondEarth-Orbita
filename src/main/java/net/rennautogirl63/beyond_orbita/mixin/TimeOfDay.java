package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.events.Methods;
import org.spongepowered.asm.mixin.*;

import java.util.OptionalLong;

@Mixin(DimensionType.class)
public abstract class TimeOfDay {
    @Mutable
    @Final
    @Shadow
    private final OptionalLong fixedTime;

    @Shadow public abstract ResourceLocation effectsLocation();

    public TimeOfDay(OptionalLong fixedTime) {
        this.fixedTime = fixedTime;
    }

    /**
     * @author rennautogirl63
     * @reason Making each dimension have a configurable day length.
     */
    @Overwrite
    public float timeOfDay(long p_63905_) {
        double multiplier;
        if ((effectsLocation() + "").equals("beyond_orbita:mercury")) {
            multiplier = Methods.MERCURY_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:venus")) {
            multiplier = Methods.VENUS_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:moon")) {
            multiplier = Methods.MOON_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:mars")) {
            multiplier = Methods.MARS_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:pluto")) {
            multiplier = Methods.PLUTO_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:relictus")) {
            multiplier = Methods.RELICTUS_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:caeruleum")) {
            multiplier = Methods.CAERULEUM_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:avium")) {
            multiplier = Methods.AVIUM_DAY;
        } else if ((effectsLocation() + "").equals("beyond_orbita:petra")) {
            multiplier = Methods.PETRA_DAY;
        } else {
            multiplier = Methods.EARTH_DAY;
        }
        double length = multiplier * 24000.0D;
        double d0 = Mth.frac((double) this.fixedTime.orElse(p_63905_) / length - 0.25D);
        double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
        return (float) (d0 * 2.0D + d1) / 3.0F;
    }
}
