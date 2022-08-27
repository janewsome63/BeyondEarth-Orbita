package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.ItemGravityEvent;

public class ItemGravity {
    /**
     * Ref ratios:
     * Mercury = 0.377
     * Venus = 0.904
     * Earth = 1
     * Moon = 0.165
     * Mars = 0.379
     * Pluto = 0.063
     * Overworld gravity for items is 0.04
     */
    public static final float MERCURY_GRAVITY = 0.01508F;
    public static final float MERCURY_DRAG = 0.98F;
    public static final float VENUS_GRAVITY = 0.03616F;
    public static final float VENUS_DRAG = 0.98F;
    public static final float EARTH_GRAVITY = 0.046F;
    public static final float EARTH_DRAG = 0.98F;
    public static final float SPACE_GRAVITY = 0.000F;
    public static final float SPACE_DRAG = 0.98F;
    public static final float MOON_GRAVITY = 0.0066F;
    public static final float MOON_DRAG = 0.98F;
    public static final float MARS_GRAVITY = 0.01516F;
    public static final float MARS_DRAG = 0.98F;
    public static final float PLUTO_GRAVITY = 0.00252F;
    public static final float PLUTO_DRAG = 0.98F;

    public static void gravity(ItemEntity itemEntity, Level level) {
        if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(itemEntity, MERCURY_GRAVITY, MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(itemEntity, VENUS_GRAVITY, VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(itemEntity, EARTH_GRAVITY, EARTH_DRAG);
        } else if (Methods.isNoGravWorld(level)) {
            gravitySystem(itemEntity, SPACE_GRAVITY, SPACE_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(itemEntity, MOON_GRAVITY, MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(itemEntity, MARS_GRAVITY, MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            gravitySystem(itemEntity, PLUTO_GRAVITY, PLUTO_DRAG);
        } else if (Methods.isNoGravWorld(level)) {
            gravitySystem(itemEntity, SPACE_GRAVITY, SPACE_DRAG);
        }
    }

    public static void gravitySystem(ItemEntity entity, float gravity, float drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new ItemGravityEvent(entity, gravity))) {
            return;
        }

        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        if (Methods.noGravWorlds.contains(entity.level.dimension()) || y >= 590 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            if (!entity.isNoGravity()) {
                entity.setNoGravity(true);
            }
            entity.setDeltaMovement((xv / 0.98) * drag, (yv / 0.98) * drag, (zv / 0.98) * drag);
        } else {
            if (y > 320 && y < 590) {
                gravity = gravity / 4;
            }
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
            entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.04 - gravity) * drag, (zv / 0.98) * drag);
        }
    }

    /**
     * MAIN GRAVITY CHECK
     */
    private static boolean getCondition(ItemEntity entity) {
        return !entity.isInWater() && !entity.isInLava();
    }
}
