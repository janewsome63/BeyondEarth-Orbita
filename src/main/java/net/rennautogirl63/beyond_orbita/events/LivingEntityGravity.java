package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.world.NoteBlockEvent;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;

import java.util.Arrays;

public class LivingEntityGravity {

    public static void gravity(LivingEntity entity, Level level) {
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

    public static void gravitySystem(LivingEntity entity, float gravity, float drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new EntityGravityEvent(entity, gravity))) {
            return;
        }

        // Default gravity for living entities is v - 0.08 per tick
        gravity = gravity * 0.08F;
        // Default drag per tick is v * 0.98
        drag = 1.0F - drag;

        Level level = entity.getLevel();
        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        String[] exempt_mobs = {"minecraft:bat", "minecraft:bee", "minecraft:blaze", "minecraft:chicken", "minecraft:ender_dragon", "minecraft:ghast", "minecraft:parrot", "minecraft:phantom", "minecraft:shulker", "minecraft:vex", "minecraft:wither"};

        if (gravity == 0.0F) {
            Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
            if (!entity.isOnGround() && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 1.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 2.5, z))).getBlock())) {
                if (entity instanceof Player player) {
                    if (!player.getAbilities().flying) {
                        player.getAbilities().flying = (true);
                        player.onUpdateAbilities();
                    }
                    if (!player.isCreative()) {
                        entity.setDeltaMovement((xv / 1.25), (yv / 1.3), (zv / 1.25));
                    }
                } else {
                    if (!entity.isNoGravity()) {
                        entity.setNoGravity(true);
                    }
                    entity.setDeltaMovement((xv / 0.98) * drag, (yv / 0.98) * drag, (zv / 0.98) * drag);
                }
            } else {
                if (entity instanceof Player player) {
                    if (player.getAbilities().flying) {
                        player.getAbilities().flying = (false);
                        player.onUpdateAbilities();
                    }
                }
                if (entity.isNoGravity()) {
                    entity.setNoGravity(false);
                }
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.08 - (Methods.MAGBOOT_STRENGTH * 0.08)) * drag, (zv / 0.98) * drag);
            }
        } else if (entity.isFallFlying()) {
            if (y > 320 && y < 590) {
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) * drag) * 0.75, (zv / 0.98) * drag);
            }
        } else {
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
            if (entity instanceof Player player) {
                if (player.getAbilities().flying && player.isCreative()) {
                    return;
                }else if (player.getAbilities().flying) {
                    player.getAbilities().flying = (false);
                    player.onUpdateAbilities();
                }
            }
            if (y > 320 && y < 590) {
                gravity = gravity / 4;
            }
            if (Arrays.asList(exempt_mobs).contains("" + entity.getType().getRegistryName())) {
                entity.setDeltaMovement((xv / 0.98) * drag, (yv / 0.98) * drag, (zv / 0.98) * drag);
            } else {
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.08 - gravity) * drag, (zv / 0.98) * drag);
            }
        }
    }

    /**
     * MAIN GRAVITY CHECK
     */
    private static boolean getCondition(LivingEntity entity) {
        if (entity instanceof Player) {
            return getPlayerEntityCondition((Player) entity);
        } else {
            return getLivingEntityCondition(entity);
        }
    }

    /**
     * PLAYER GRAVITY CHECK
     */
    private static boolean getPlayerEntityCondition(Player player) {
        return getLivingEntityCondition(player) && !player.isSpectator();
    }

    /**
     * LIVING ENTITY GRAVITY CHECK
     */
    private static boolean getLivingEntityCondition(LivingEntity entity) {
        return getEntityCondition(entity) && !entity.hasEffect(MobEffects.SLOW_FALLING) && !entity.hasEffect(MobEffects.LEVITATION) && !entity.onClimbable() && !entity.isPassenger();
    }

    /**
     * ENTITY GRAVITY CHECK
     */
    private static boolean getEntityCondition(Entity entity) {
        return !entity.isInWater() && !entity.isInLava();
    }
}