package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;

public class SkyRenderHelper {

    public static float getStarBrightness(Level level, double time) {
        float f = TimeSetter.timeSystem(level, time);
        float f1 = 1.0F - (Mth.cos(f * ((float)Math.PI * 2F)) * 2.0F + 0.25F);
        f1 = Mth.clamp(f1, 0.0F, 1.0F);
        return f1 * f1 * 0.5F;
    }
}

