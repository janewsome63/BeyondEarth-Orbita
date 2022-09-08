package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.ItemGravityEvent;

public class ItemGravity {

    public static void gravity(ItemEntity itemEntity, Level level) {
        if (Methods.isNoGravWorld(level) || itemEntity.getY() >= 590 && Methods.isPlanetoidWorld(level)) {
            gravitySystem(itemEntity, Methods.SPACE_GRAVITY, Methods.SPACE_DRAG);
        } else if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(itemEntity, Methods.MERCURY_GRAVITY, Methods.MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(itemEntity, Methods.VENUS_GRAVITY, Methods.VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(itemEntity, Methods.EARTH_GRAVITY, Methods.EARTH_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(itemEntity, Methods.MOON_GRAVITY, Methods.MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(itemEntity, Methods.MARS_GRAVITY, Methods.MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            gravitySystem(itemEntity, Methods.PLUTO_GRAVITY, Methods.PLUTO_DRAG);
        } else if (Methods.isWorld(level, Methods.relictus)) {
            gravitySystem(itemEntity, Methods.RELICTUS_GRAVITY, Methods.RELICTUS_DRAG);
        } else if (Methods.isWorld(level, Methods.caeruleum)) {
            gravitySystem(itemEntity, Methods.CAERULEUM_GRAVITY, Methods.CAERULEUM_DRAG);
        } else if (Methods.isWorld(level, Methods.avium)) {
            gravitySystem(itemEntity, Methods.AVIUM_GRAVITY, Methods.AVIUM_DRAG);
        } else if (Methods.isWorld(level, Methods.discors)) {
            gravitySystem(itemEntity, Methods.DISCORS_GRAVITY, Methods.DISCORS_DRAG);
        } else if (Methods.isWorld(level, Methods.petra)) {
            gravitySystem(itemEntity, Methods.PETRA_GRAVITY, Methods.PETRA_DRAG);
        }
    }

    public static void gravitySystem(ItemEntity entity, float gravity, float drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new ItemGravityEvent(entity, gravity))) {
            return;
        }

        // Default gravity for item entities is v - 0.04 per tick
        gravity = gravity * 0.04F;
        // Default drag per tick is v * 0.98
        drag = 1.0F - drag;

        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;

        if (gravity == 0.0F) {
            if (!entity.isNoGravity()) {
                entity.setNoGravity(true);
            }
            entity.setDeltaMovement((xv / 0.98) * drag, (yv / 0.98) * drag, (zv / 0.98) * drag);
        } else {
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
