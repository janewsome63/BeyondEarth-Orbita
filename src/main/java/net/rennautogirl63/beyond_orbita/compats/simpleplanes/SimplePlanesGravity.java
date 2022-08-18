package net.rennautogirl63.beyond_orbita.compats.simpleplanes;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;

import java.util.Arrays;

import static java.lang.Math.abs;

public class SimplePlanesGravity {
    /**
     * Ref ratios:
     * Mercury = 0.377
     * Venus = 0.904
     * Earth = 1
     * Moon = 0.165
     * Mars = 0.379
     * Pluto = 0.063
     * Glacio = 0.533
     */
    public static final float MERCURY_GRAVITY = 0.009048F;
    public static final float MERCURY_DRAG = 1.00F;
    public static final float VENUS_GRAVITY = 0.021696F;
    public static final float VENUS_DRAG = 0.96F;
    public static final float EARTH_GRAVITY = 0.024F;
    public static final float EARTH_DRAG = 0.98F;
    public static final float SPACE_GRAVITY = 0.00F;
    public static final float SPACE_DRAG = 1.0F;
    public static final float MOON_GRAVITY = 0.00396F;
    public static final float MOON_DRAG = 1.0F;
    public static final float MARS_GRAVITY = 0.009096F;
    public static final float MARS_DRAG = 0.98F;
    public static final float PLUTO_GRAVITY = 0.001512F;
    public static final float PLUTO_DRAG = 0.98F;
    public static final float GLACIO_GRAVITY = 0.012792F;
    public static final float GLACIO_DRAG = 0.98F;

    public static void gravity(Entity entity, Level level) {
        if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(entity, MERCURY_GRAVITY, MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(entity, VENUS_GRAVITY, VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(entity, EARTH_GRAVITY, EARTH_DRAG);
        } else if (Methods.isWorld(level, Methods.glacio)) {
            gravitySystem(entity, GLACIO_GRAVITY, GLACIO_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(entity, MOON_GRAVITY, MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(entity, MARS_GRAVITY, MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            gravitySystem(entity, PLUTO_GRAVITY, PLUTO_DRAG);
        } else if (Methods.isWorld(level, Methods.glacio)) {
            gravitySystem(entity, GLACIO_GRAVITY, GLACIO_DRAG);
        } else if (Methods.isNoGravWorld(level)) {
            gravitySystem(entity, SPACE_GRAVITY, SPACE_DRAG);
        }
    }

    public static void gravitySystem(Entity entity, float gravity, float drag) {
        if (MinecraftForge.EVENT_BUS.post(new EntityGravityEvent(entity, gravity))) {
            return;
        }

        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        if (Methods.noGravWorlds.contains(entity.level.dimension())) {
            Level level = entity.getLevel();
            Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
            if (!entity.isOnGround() && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 1.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 2.5, z))).getBlock())) {
                if (!entity.isNoGravity()) {
                    entity.setNoGravity(true);
                }
            } else {
                if (entity.isNoGravity()) {
                    entity.setNoGravity(false);
                }
            }
            entity.setDeltaMovement(xv / 5, (yv / 0.98) * drag, zv / 5);
        } else if (y >= 590 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            entity.setDeltaMovement(((xv / 0.98) * drag) * 0.9, abs(((yv / 0.98) + 0.024 - (gravity * 4) * drag)) * -1, ((zv / 0.98) * drag) * 0.9);
        } else if (y > 320 && y < 590 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            entity.setDeltaMovement(((xv / 0.98) * drag) * 0.95, ((yv / 0.98) + 0.024 - gravity) * drag * 0.95, ((zv / 0.98) * drag) * 0.95);
        } else if (Methods.noAtmoWorlds.contains(entity.level.dimension())) {
            entity.setDeltaMovement(xv / 5, abs(((yv / 0.98) + 0.024 - gravity) * drag) * -1, zv / 5);
        } else {
            entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.024 - gravity) * drag, (zv / 0.98) * drag);
        }
    }
}