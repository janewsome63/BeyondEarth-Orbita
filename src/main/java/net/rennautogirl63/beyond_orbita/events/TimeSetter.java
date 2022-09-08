package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.world.level.Level;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

public class TimeSetter {
    public static float timeSystem(Level level, double multiplier) {
        long length = Math.round(multiplier * 24000);
        float days = (float) level.getDayTime() / length;
        return (float) (days - Math.floor(days));
    }

    public static float getSunAngle(Level level, double time) {
        float a = TimeSetter.timeSystem(level, time);
        return a * ((float)Math.PI * 2F);
    }
}
