package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.ColdSweatModifiers;
import net.rennautogirl63.beyond_orbita.compats.simpleplanes.SimplePlanesGravity;
import net.rennautogirl63.beyond_orbita.entities.LanderEntity;
import net.rennautogirl63.beyond_orbita.entities.VehicleEntity;
import net.rennautogirl63.beyond_orbita.events.forge.EntityTickEvent;
import net.rennautogirl63.beyond_orbita.events.forge.ItemEntityTickEndEvent;
import net.rennautogirl63.beyond_orbita.events.forge.LivingEntityTickEndEvent;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID)
public class Events {
    @SubscribeEvent
    public static void playerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Player player = event.player;
            Level level = player.level;

            /** LANDER ORBIT TELEPORT SYSTEM */
            if (player.getVehicle() instanceof LanderEntity) {
                Methods.landerTeleportOrbit(player, level);
            }

            /** DISABLE CLOSE PLANET GUI SYSTEM */
            Methods.openPlanetGui(player);

            /** PLAYER OXYGEN SYSTEM */
            OxygenSystem.OxygenSystem(player, level);

            /** DROP OFF HAND VEHICLE ITEM */
            Methods.dropRocket(player);

            /** DISABLE KICK BY FLYING IF IN PLANET GUI */
            if (player instanceof ServerPlayer) {
                Methods.disableFlyAntiCheat((ServerPlayer) player, player.getPersistentData().getBoolean(BeyondOrbitaMod.MODID + ":planet_selection_gui_open"));
            }
            if (Methods.noAtmoWorlds.contains(player.level.dimension()) || player.getY() >= 590 && Methods.planetoidWorlds.contains(player.level.dimension())) {
                Methods.elytraCancel(player);
            }

            /** Cold Sweat Temperature Modifiers */
            ColdSweatModifiers.spaceSuits(event, player);
        }
    }

    @SubscribeEvent
    public static void livingEntityTick(LivingEvent.LivingUpdateEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level level = entity.level;

        /** ENTITY OXYGEN SYSTEM */
        Methods.entityOxygen(entity, level);

        /** VENUS RAIN SYSTEM */
        Methods.venusRain(entity, Methods.venus);

        /** PLANET FIRE SYSTEM */
        Methods.planetFire(entity, Methods.venus);
        Methods.planetFire(entity, Methods.mercury);
    }

    @SubscribeEvent
    public static void livingEntityEndTick(LivingEntityTickEndEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level level = entity.level;

        /** ENTITY GRAVITY SYSTEM */
        EntityGravity.gravity(entity, level);
    }

    @SubscribeEvent
    public static void itemEntityEndTick(ItemEntityTickEndEvent event) {
        ItemEntity entity = event.getEntityItem();
        Level level = entity.level;

        /** ITEM ENTITY GRAVITY SYSTEM */
        ItemGravity.gravity(entity, level);
    }

    @SubscribeEvent
    public static void entityTick(EntityTickEvent event) {
        Entity entity = event.getEntity();
        Level level = entity.level;
        double y = entity.getY();

        /** ORBITTELEPORT SYSTEM */
        if (y < 0 && entity.level.dimension() == Methods.orbit && !(entity.getVehicle() instanceof LanderEntity)) {
            if ((entity instanceof LanderEntity) && entity.isVehicle()) {
                return;
            }
            Methods.entityFallToPlanet(level, entity);
        } else if (y > 700 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            Methods.entityExitAtmosphere(level, entity);
        }

        /** Simple Planes Gravity */
        if (("" + entity.getType().getRegistryName()).contains("simpleplanes")) {
            SimplePlanesGravity.gravity(entity, level);
        }

        /** Other Entity Gravity */
        if (!(entity instanceof LivingEntity) && !(entity instanceof ItemEntity) && !(entity instanceof VehicleEntity)) {
            OtherGravity.gravity(entity, level);
        }
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Level level = event.world;

            if (Methods.noAtmoWorlds.contains(level.dimension())) {
                level.thunderLevel = 0;
                level.rainLevel = 0;
            } else if (Methods.isWorld(level, Methods.venus)) {
                level.thunderLevel = 0;
            }
        }
    }

    @SubscribeEvent
    public static void livingEntityAttack(LivingAttackEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }

        if (!event.getSource().isFire()) {
            return;
        }

        Player entity = (Player) event.getEntity();

        if (!Methods.advancedSpaceSuitCheck(entity)) {
            return;
        }

        /** entity.setRemainingFireTicks(0);
        event.setCanceled(true); */
    }

    @SubscribeEvent
    public static void projectileImpact(ProjectileImpactEvent event) {
        if (event.getRayTraceResult().getType() != HitResult.Type.ENTITY) {
            return;
        }

        Entity entity = ((EntityHitResult) event.getRayTraceResult()).getEntity();

        if (Methods.isVehicle(entity)) {
            event.setCanceled(true);
        }
    }

    @SubscribeEvent
    public static void livingDeath(LivingDeathEvent event) {
        if (event.getEntity() instanceof Player && event.getEntity().getPersistentData().getBoolean(BeyondOrbitaMod.MODID + ":planet_selection_gui_open")) {
            Player player = (Player) event.getEntity();

            player.closeContainer();
            Methods.cleanUpPlayerNBT(player);
            player.setNoGravity(false);
        }
    }

    @SubscribeEvent
    public static void livingFall(LivingFallEvent event) {
        LivingEntity entity = event.getEntityLiving();
        Level level = entity.level;

        if (Methods.isWorld(level, Methods.moon)) {
            event.setDistance(event.getDistance() - 5.5F);
        } else if (Methods.isWorld(level, Methods.mars)) {
            event.setDistance(event.getDistance() - 5.0F);
        } else if (Methods.isWorld(level, Methods.glacio)) {
            event.setDistance(event.getDistance() - 5.0F);
        } else if (Methods.isWorld(level, Methods.mercury)) {
            event.setDistance(event.getDistance() - 5.5F);
        } else if (Methods.isNoGravWorld(level)) {
            event.setDistance(event.getDistance() - 8.5F);
        }
    }
}
