package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.registries.ForgeRegistries;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;

import java.util.Arrays;

public class BlockGravity {

    public static void gravity(Entity entity, Level level) {
        if (Methods.isNoGravWorld(level) || entity.getY() >= 590 && Methods.isPlanetoidWorld(level)) {
            gravitySystem(entity, Methods.SPACE_GRAVITY, Methods.SPACE_DRAG);
        } else if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(entity, Methods.MERCURY_GRAVITY, Methods.MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(entity, Methods.VENUS_GRAVITY, Methods.VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(entity, Methods.EARTH_GRAVITY, Methods.EARTH_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(entity, Methods.MOON_GRAVITY, Methods.MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(entity, Methods.MARS_GRAVITY, Methods.MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            gravitySystem(entity, Methods.PLUTO_GRAVITY, Methods.PLUTO_DRAG);
        } else if (Methods.isWorld(level, Methods.relictus)) {
            gravitySystem(entity, Methods.RELICTUS_GRAVITY, Methods.RELICTUS_DRAG);
        } else if (Methods.isWorld(level, Methods.caeruleum)) {
            gravitySystem(entity, Methods.CAERULEUM_GRAVITY, Methods.CAERULEUM_DRAG);
        } else if (Methods.isWorld(level, Methods.avium)) {
            gravitySystem(entity, Methods.AVIUM_GRAVITY, Methods.AVIUM_DRAG);
        } else if (Methods.isWorld(level, Methods.discors)) {
            gravitySystem(entity, Methods.DISCORS_GRAVITY, Methods.DISCORS_DRAG);
        } else if (Methods.isWorld(level, Methods.petra)) {
            gravitySystem(entity, Methods.PETRA_GRAVITY, Methods.PETRA_DRAG);
        }
    }

    public static void gravitySystem(Entity entity, float gravity, float drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new EntityGravityEvent(entity, gravity))) {
            return;
        }

        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        float grav_coeff = 0.04F;
        float drag_coeff = 0.98F;

        gravity = gravity * grav_coeff;
        drag = 1.0F - drag;

        if (gravity == 0.0F) {
            if (!entity.isNoGravity()) {
                entity.setNoGravity(true);
            }
            entity.setDeltaMovement((xv / drag_coeff) * drag, (yv / drag_coeff) * drag, (zv / drag_coeff) * drag);
        } else {
            entity.setDeltaMovement((xv / drag_coeff) * drag, ((yv / drag_coeff) + grav_coeff - gravity) * drag, (zv / drag_coeff) * drag);
        }
    }

    /**
     * MAIN GRAVITY CHECK
     */
    private static boolean getCondition(Entity entity) {
        return getEntityCondition(entity);
    }

    /**
     * ENTITY GRAVITY CHECK
     */
    private static boolean getEntityCondition(Entity entity) {
        return !entity.isInWater() && !entity.isInLava();
    }
}