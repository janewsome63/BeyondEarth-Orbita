package net.rennautogirl63.beyond_orbita.mixin;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.dimension.DimensionType;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.events.Methods;
import org.spongepowered.asm.mixin.*;

import java.util.OptionalLong;

@Mixin(Level.class)
public abstract class SkyBrightness {
    @Shadow
    private int skyDarken;

    /**
     * @author rennautogirl63
     * @reason Making each dimension have a configurable day length.
     */
    @Overwrite
    public void updateSkyBrightness() {
        Level level = (Level) ((Object) this);

        double offset = 0.0D;
        if (Methods.isDarkWorld(level)) {
            offset = 6.0D;
        }

        double d0 = 1.0D - (double)(level.getRainLevel(1.0F) * 5.0F) / 16.0D;
        double d1 = 1.0D - (double)(level.getThunderLevel(1.0F) * 5.0F) / 16.0D;
        double d2 = 0.5D + 2.0D * Mth.clamp((double)Mth.cos(level.getTimeOfDay(1.0F) * ((float)Math.PI * 2F)), -0.25D, 0.25D);
        this.skyDarken = (int)(((1.0D - d2 * d0 * d1) * 11.0D) + offset);
    }
}
