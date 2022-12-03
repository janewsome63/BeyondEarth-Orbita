package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
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

    private static String effects;

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
        effects = (effectsLocation() + "");
        double length = multiplier * 24000.0D;
        double d0 = Mth.frac((double) this.fixedTime.orElse(p_63905_) / length - 0.25D);
        double d1 = 0.5D - Math.cos(d0 * Math.PI) / 2.0D;
        return (float) (d0 * 2.0D + d1) / 3.0F;
    }

    /**
     * @author rennautogirl63
     * @reason Making each dimension have a configurable max brightness.
     */
    @Overwrite
    private static float[] fillBrightnessRamp(float p_63901_) {
        float[] afloat = new float[16];
        int maxLight;
        if (effects == null) {
            effects = "temp";
        }
        if (effects.equals("beyond_orbita:mars")) {
            maxLight = 13;
        } else if (effects.equals("beyond_orbita:pluto") || effects.equals("beyond_orbita:petra")) {
            maxLight = 1;
            BeyondOrbitaMod.LOGGER.info("yup");
        } else if (effects.equals("beyond_orbita:relictus")) {
            maxLight = 11;
        } else {
            maxLight = 15;
        }
        for(int i = 0; i <= 15; ++i) {
            float f = (float)i / maxLight;
            float f1 = f / (4.0F - 3.0F * f);
            afloat[i] = Mth.lerp(p_63901_, f1, 1.0F);
        }
        return afloat;
    }
}
