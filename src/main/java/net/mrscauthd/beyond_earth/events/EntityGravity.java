package net.mrscauthd.beyond_earth.events;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.mrscauthd.beyond_earth.events.forge.EntityGravityEvent;

import java.util.Arrays;

import static net.mrscauthd.beyond_earth.events.Methods.orbit;

public class EntityGravity {

    /** GRAVITIES */
    public static final float MERCURY_GRAVITY = 0.030F;
    public static final float MERCURY_DRAG= 1.00F;
    public static final float VENUS_GRAVITY = 0.072F;
    public static final float VENUS_DRAG = 0.97F;
    public static final float EARTH_GRAVITY = 0.080F;
    public static final float EARTH_DRAG = 0.98F;
    public static final float MOON_GRAVITY = 0.013F;
    public static final float MOON_DRAG = 1.00F;
    public static final float MARS_GRAVITY = 0.030F;
    public static final float MARS_DRAG = 0.99F;
    public static final float GLACIO_GRAVITY = 0.043F;
    public static final float GLACIO_DRAG = 0.98F;

    /** "Mag boot" strength */
    public static final float SPACE_GRAVITY = 0.08F;
    public static final float SPACE_DRAG = 1.00F;

    public static void gravity(LivingEntity entity, Level level) {
        if (Methods.isWorld(level, Methods.mercury)) {
            gravitySystem(entity, MERCURY_GRAVITY, MERCURY_DRAG);
        }
        else if (Methods.isWorld(level, Methods.venus)) {
            gravitySystem(entity, VENUS_GRAVITY, VENUS_DRAG);
        }
        else if (Methods.isWorld(level, Methods.overworld)) {
            gravitySystem(entity, EARTH_GRAVITY, EARTH_DRAG);
        }
        else if (Methods.isWorld(level, Methods.moon)) {
            gravitySystem(entity, MOON_GRAVITY, MOON_DRAG);
        }
        else if (Methods.isWorld(level, Methods.mars)) {
            gravitySystem(entity, MARS_GRAVITY, MARS_DRAG);
        }
        else if (Methods.isWorld(level, Methods.glacio)) {
            gravitySystem(entity, GLACIO_GRAVITY, GLACIO_DRAG);
        }
        else if (Methods.isNoGravWorld(level)) {
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
        if (Methods.noGravWorlds.contains(entity.level.dimension()) || entity.getY() >= 590 && Methods.planetoidWorlds.contains(entity.level.dimension())){
            Level level = entity.getLevel();
            double x = entity.getX();
            double y = entity.getY();
            double z = entity.getZ();
            Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
            if (Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z - 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z - 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z - 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x + 1, y - 0.5, z + 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z + 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z + 1))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x - 1, y - 0.5, z))).getBlock())
                    && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock())) {
                if (!entity.isNoGravity()) {
                    entity.setNoGravity(true);
                }
                if (entity instanceof Player player) {
                    if (!player.getAbilities().flying) {
                        player.getAbilities().flying = (true);
                        player.onUpdateAbilities();
                    } else if (player.getAbilities().flying) {
                        entity.setDeltaMovement((entity.getDeltaMovement().x() / 1.25), (entity.getDeltaMovement().y() / 1.3), (entity.getDeltaMovement().z() / 1.25));
                    }
                }
            } else {
                entity.setDeltaMovement(entity.getDeltaMovement().x, ((entity.getDeltaMovement().y / 0.98) + 0.08 - gravity) * drag, entity.getDeltaMovement().z);
                if (entity.isNoGravity()) {
                    entity.setNoGravity(false);
                }
                if (entity instanceof Player player) {
                    if (player.getAbilities().flying) {
                        player.getAbilities().flying = (false);
                        player.onUpdateAbilities();
                    }
                }
            }
        } else {
            entity.setDeltaMovement(entity.getDeltaMovement().x, ((entity.getDeltaMovement().y / 0.98) + 0.08 - gravity) * drag, entity.getDeltaMovement().z);
            if (entity.isNoGravity()) {
                entity.setNoGravity(false);
            }
            if (entity instanceof Player player) {
                if (player.getAbilities().flying) {
                    player.getAbilities().flying = (false);
                    player.onUpdateAbilities();
                }
            }
        }
	}

    /** MAIN GRAVITY CHECK */
    private static boolean getCondition(LivingEntity entity) {
        if (entity instanceof Player) {
            return getPlayerEntityCondition((Player) entity);
        }

        return getLivingEntityCondition(entity);
    }

    /** LIVING ENTITY GRAVITY CHECK */
    private static boolean getPlayerEntityCondition(Player player) {
        return getLivingEntityCondition(player) && !player.isCreative() && !player.isSpectator();
     }

    /** LIVING ENTITY GRAVITY CHECK */
    private static boolean getLivingEntityCondition(LivingEntity entity) {
        return getEntityCondition(entity) && !entity.hasEffect(MobEffects.SLOW_FALLING) && !entity.hasEffect(MobEffects.LEVITATION) && !entity.onClimbable();
    }

    /** ENTITY GRAVITY CHECK */
    private static boolean getEntityCondition(Entity entity) {
        return !entity.isInWater() && !entity.isInLava() && !Methods.isVehicle(entity);
    }
}