package net.mrscauthd.beyond_earth.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.mrscauthd.beyond_earth.events.forge.ItemGravityEvent;

import java.util.Arrays;

public class ItemGravity {

    /**
     * GRAVITIES
     */
    public static final float MERCURY_GRAVITY = 0.030F;
    public static final float MERCURY_DRAG = 1.00F;
    public static final float VENUS_GRAVITY = 0.072F;
    public static final float VENUS_DRAG = 0.97F;
    public static final float EARTH_GRAVITY = 0.080F;
    public static final float EARTH_DRAG = 0.98F;
    public static final float MOON_GRAVITY = 0.013F;
    public static final float MOON_DRAG = 1.00F;
    public static final float MARS_GRAVITY = 0.030F;
    public static final float MARS_DRAG = 0.99F;
    public static final float GLACIO_GRAVITY = 0.043F;
    public static final float GLACIO_DRAG = 0.980F;
    public static final float SPACE_GRAVITY = 0.060F;
    public static final float SPACE_DRAG = 1.00F;

    public static void gravity(ItemEntity itemEntity, Level level) {
        if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(itemEntity, MERCURY_GRAVITY, MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(itemEntity, VENUS_GRAVITY, VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(itemEntity, EARTH_GRAVITY, EARTH_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(itemEntity, MOON_GRAVITY, MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(itemEntity, MARS_GRAVITY, MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.glacio)) {
            gravitySystem(itemEntity, GLACIO_GRAVITY, GLACIO_DRAG);
        } else if (Methods.isNoGravWorld(level)) {
            gravitySystem(itemEntity, SPACE_GRAVITY, SPACE_DRAG);
        }
    }

    public static void gravitySystem(ItemEntity entity, double gravity, double drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new ItemGravityEvent(entity, gravity))) {
            return;
        }

        if (Methods.noGravWorlds.contains(entity.level.dimension()) || entity.getY() >= 590 && Methods.planetoidWorlds.contains(entity.level.dimension())) {

            if (!entity.isNoGravity()) {
                entity.setNoGravity(true);
            }
        } else {
            entity.setDeltaMovement(entity.getDeltaMovement().x, ((entity.getDeltaMovement().y / 0.98) + 0.08 - gravity) * drag, entity.getDeltaMovement().z);
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
        }
    }

    /** GRAVITY CHECK */
    private static boolean getCondition(ItemEntity entity) {
        return !entity.isInWater() && !entity.isInLava();
    }
}
