package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;

import java.util.Arrays;

public class EntityGravity {

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

        // Default drag per tick is v * 0.98
        drag = 1.0F - drag;

        Level level = entity.getLevel();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;

        if (gravity == 0.0F) {
            if (!entity.isNoGravity()) {
                entity.setNoGravity(true);
            }
            if (("" + entity.getType().getRegistryName()).contains("minecraft:boat")) {
                Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
                if (!entity.isOnGround() && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 1.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 2.5, z))).getBlock())) {
                    entity.setDeltaMovement(0, (yv / 0.98) * drag, 0);
                } else {
                    if (entity.isNoGravity()) {
                        entity.setNoGravity(false);
                    }
                    entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.04 - (Methods.MAGBOOT_STRENGTH * 0.04)) * drag, (zv / 0.98) * drag);
                }
            } else {
                entity.setDeltaMovement((xv / 0.98) * drag, (yv / 0.98) * drag, (zv / 0.98) * drag);
            }
        } else {
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
            String[] low = {"minecraft:ender_pearl", "minecraft:snowball", "minecraft:egg"};
            String[] med = {"minecraft:arrow", "minecraft:spectral_arrow", "minecraft:potion", "minecraft:trident"};
            if (Arrays.asList(low).contains("" + entity.getType().getRegistryName())) {
                double coefficient = 3.0 / 99.0;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            } else if (Arrays.asList(med).contains("" + entity.getType().getRegistryName())) {
                double coefficient = 5.0 / 99.0;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            } else if (("" + entity.getType().getRegistryName()).contains("minecraft:llama_spit")) {
                double coefficient = 6.0 / 99.0;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            } else if (("" + entity.getType().getRegistryName()).contains("minecraft:experience_bottle")) {
                double coefficient = 7.0 / 99.0;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            } else if (("" + entity.getType().getRegistryName()).contains("minecraft:experience_orb")) {
                double coefficient = 0.03;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            } else if (("" + entity.getType().getRegistryName()).contains("minecraft:boat")) {
                double coefficient = 0.04;
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + coefficient - (gravity * coefficient)) * drag, (zv / 0.98) * drag);
            }
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