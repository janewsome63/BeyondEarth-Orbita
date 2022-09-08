package net.rennautogirl63.beyond_orbita.compats.simpleplanes;

import net.minecraft.commands.CommandSource;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.events.forge.EntityGravityEvent;
import xyz.przemyk.simpleplanes.setup.SimplePlanesItems;

import java.util.Arrays;

import static java.lang.Math.abs;

public class SimplePlanesGravity {

    public static void gravity(Entity entity, Level level) {
        if (Methods.isNoGravWorld(level)) {
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
        if (MinecraftForge.EVENT_BUS.post(new EntityGravityEvent(entity, gravity))) {
            return;
        }

        // Default gravity for planes seems to be near v - 0.024
        gravity = gravity * 0.024F;
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
            Block[] blocks = {Blocks.AIR, Blocks.VOID_AIR, Blocks.CAVE_AIR};
            if (!entity.isOnGround() && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 0.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 1.5, z))).getBlock()) && Arrays.asList(blocks).contains((level.getBlockState(new BlockPos(x, y - 2.5, z))).getBlock())) {
                if (!entity.isNoGravity()) {
                    entity.setNoGravity(true);
                }
                entity.setDeltaMovement(0, yv, 0);
            } else {
                if (entity.isNoGravity()) {
                    entity.setNoGravity(false);
                }
                entity.setDeltaMovement(0, ((yv / 0.98) + 0.024 - (Methods.MAGBOOT_STRENGTH * 0.024)) * drag, 0);
            }
        } else if (Methods.isPlanetoidWorld(level)) {
            if (y >= 590) {
                entity.setDeltaMovement(((xv / 0.98) * drag) * 0.9, abs(((yv / 0.98) + 0.024 - (gravity * 4) * drag)) * -1, ((zv / 0.98) * drag) * 0.9);
            } else if (y > 320) {
                entity.setDeltaMovement(((xv / 0.98) * drag) * 0.95, (((yv / 0.98) + 0.024 - gravity) * drag) * 0.95, ((zv / 0.98) * drag) * 0.95);
            } else {
                entity.setDeltaMovement((xv / 0.98) * drag, ((yv / 0.98) + 0.024 - gravity) * drag, (zv / 0.98) * drag);
            }
        } else if (Methods.isNoAtmoWorld(level)) {
            if (("" + entity.getType().getRegistryName()).contains("parachute")) {
                if (level instanceof ServerLevel server)
                    server.getServer().getCommands().performCommand(new CommandSourceStack(CommandSource.NULL, new Vec3(x, y, z), Vec2.ZERO, server, 4, "", new TextComponent(""), server.getServer(), null).withSuppressedOutput(), "kill @e[type=simpleplanes:parachute,distance=..4]");
                if (!level.isClientSide()) {
                    ItemEntity entityToSpawn = new ItemEntity(level, x, y, z, new ItemStack(SimplePlanesItems.PARACHUTE_ITEM.get()));
                    entityToSpawn.setPickUpDelay(20);
                    level.addFreshEntity(entityToSpawn);
                }
            }
            entity.setDeltaMovement(xv / 5, abs(((yv / 0.98) + 0.024 - gravity) * drag) * -1, zv / 5);
        }
    }
}