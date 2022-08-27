package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;

import java.util.Arrays;

public class EntityGravity {
    /**
     * Ref ratios:
     * Mercury = 0.377
     * Venus = 0.904
     * Earth = 1
     * Moon = 0.165
     * Mars = 0.379
     * Pluto = 0.063
     * Overworld gravity for planes is 0.08
     */
    public static final float MERCURY_GRAVITY = 0.03016F;
    public static final float MERCURY_DRAG = 1.0F;
    public static final float VENUS_GRAVITY = 0.07232F;
    public static final float VENUS_DRAG = 0.96F;
    public static final float EARTH_GRAVITY = 0.080F;
    public static final float EARTH_DRAG = 0.98F;
    public static final float SPACE_GRAVITY = 0.0267F;
    public static final float SPACE_DRAG = 1.0F;
    public static final float MOON_GRAVITY = 0.0132F;
    public static final float MOON_DRAG = 1.0F;
    public static final float MARS_GRAVITY = 0.03032F;
    public static final float MARS_DRAG = 0.98F;
    public static final float PLUTO_GRAVITY = 0.00504F;
    public static final float PLUTO_DRAG = 0.98F;

    public static void gravity(LivingEntity entity, Level level) {
        if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(entity, MERCURY_GRAVITY, MERCURY_DRAG);
        } else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(entity, VENUS_GRAVITY, VENUS_DRAG);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(entity, EARTH_GRAVITY, EARTH_DRAG);
        } else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(entity, MOON_GRAVITY, MOON_DRAG);
        } else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(entity, MARS_GRAVITY, MARS_DRAG);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            gravitySystem(entity, PLUTO_GRAVITY, PLUTO_DRAG);
        } else if (Methods.isNoGravWorld(level)) {
            gravitySystem(entity, SPACE_GRAVITY, SPACE_DRAG);
        }
    }

    public static void gravitySystem(LivingEntity entity, float gravity, float drag) {
        if (!getCondition(entity)) {
            return;
        }

        if (MinecraftForge.EVENT_BUS.post(new EntityGravityEvent(entity, gravity))) {
            return;
        }

        double x = entity.getX();
        double y = entity.getY();
        double z = entity.getZ();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        if (Methods.noGravWorlds.contains(entity.level.dimension()) || y >= 590 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            Level level = entity.getLevel();
            Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
            /** if (Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z - 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z - 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z - 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z + 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z + 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z + 1))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z))).getBlock())
             && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock())) { */
            if (!entity.isOnGround() && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 1.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 2.5, z))).getBlock())) {
                if (!entity.isNoGravity()) {
                    entity.setNoGravity(true);
                }
                if (entity instanceof Player player) {
                    if (!player.getAbilities().flying) {
                        player.getAbilities().flying = (true);
                        player.onUpdateAbilities();
                    } else if (player.getAbilities().flying) {
                        entity.setDeltaMovement((xv / 1.25), (yv / 1.3), (zv / 1.25));
                    }
                }
            } else {
                if (entity.isNoGravity()) {
                    entity.setNoGravity(false);
                }
                if (entity instanceof Player player) {
                    if (player.getAbilities().flying) {
                        player.getAbilities().flying = (false);
                        player.onUpdateAbilities();
                    }
                }
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.08 - gravity) * drag, (zv / 0.98) * drag);
                entity.resetFallDistance();
            }
        } else {
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
            if (entity instanceof Player player) {
                if (player.getAbilities().flying) {
                    player.getAbilities().flying = (false);
                    player.onUpdateAbilities();
                }
            }
            if (y > 320 && y < 590) {
                gravity = gravity / 4;
            }
            if (!entity.isFallFlying()) {
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.08 - gravity) * drag, (zv / 0.98) * drag);
            } else if (y > 320 && y < 590 && entity.isFallFlying()) {
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) * drag) * 0.75, (zv / 0.98) * drag);
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
        return getLivingEntityCondition(player) && !player.isSpectator() && !player.isCreative();
    }

    /**
     * LIVING ENTITY GRAVITY CHECK
     */
    private static boolean getLivingEntityCondition(LivingEntity entity) {
        return getEntityCondition(entity) && !entity.hasEffect(MobEffects.SLOW_FALLING) && !entity.hasEffect(MobEffects.LEVITATION) && !entity.onClimbable();
    }

    /**
     * ENTITY GRAVITY CHECK
     */
    private static boolean getEntityCondition(Entity entity) {
        return !entity.isInWater() && !entity.isInLava();
    }
}