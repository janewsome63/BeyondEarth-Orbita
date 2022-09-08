package net.rennautogirl63.beyond_orbita.events;

import com.simibubi.create.content.contraptions.components.structureMovement.train.capability.MinecartControllerUpdatePacket;
import com.terraforged.noise.combiner.Min;
import com.terraforged.noise.modifier.Abs;
import commoble.infiniverse.api.InfiniverseAPI;
import mcjty.lostcities.LostCities;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.AbstractMinecart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.entity.LevelEntityGetter;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.extensions.IForgeAbstractMinecart;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.ColdSweatModifiers;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.init.RegisterModifiers;
import net.rennautogirl63.beyond_orbita.compats.simpleplanes.SimplePlanesGravity;
import net.rennautogirl63.beyond_orbita.entities.LanderEntity;
import net.rennautogirl63.beyond_orbita.entities.VehicleEntity;
import net.rennautogirl63.beyond_orbita.events.forge.EntityTickEvent;
import net.rennautogirl63.beyond_orbita.events.forge.ItemEntityTickEndEvent;
import net.rennautogirl63.beyond_orbita.events.forge.LivingEntityTickEndEvent;
import org.apache.logging.log4j.core.jmx.Server;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID)
public class Events {
    @SubscribeEvent
    public static void serverStart(ServerStartedEvent event) {
        if (ModList.get().isLoaded("cold_sweat")) {
            RegisterModifiers.onModifiersRegister();
        }

        if (ModList.get().isLoaded("lostcities")) {
            ResourceKey<Level> level = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(LostCities.MODID, "lostcity"));
            InfiniverseAPI.get().markDimensionForUnregistration(event.getServer(), level);
        }
        else {
            ResourceKey<Level> level = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "relictus"));
            InfiniverseAPI.get().markDimensionForUnregistration(event.getServer(), level);
        }

        if (!ModList.get().isLoaded("terraforged")) {
            ResourceKey<Level> level = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "avium"));
            InfiniverseAPI.get().markDimensionForUnregistration(event.getServer(), level);
        }
    }

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
            if (ModList.get().isLoaded("cold_sweat")) {
                ColdSweatModifiers.spaceSuits(event, player);
            }
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
        LivingEntityGravity.gravity(entity, level);
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

        /** ORBIT TELEPORT SYSTEM */
        if (y < 0 && entity.level.dimension() == Methods.orbit && !(entity.getVehicle() instanceof LanderEntity)) {
            if ((entity instanceof LanderEntity) && entity.isVehicle()) {
                return;
            }
            Methods.entityFallToPlanet(level, entity);
        } else if (y > 700 && Methods.planetoidWorlds.contains(entity.level.dimension())) {
            Methods.entityExitAtmosphere(level, entity);
        }

        /** Non-living Entity Gravities */
        if (("" + entity.getType().getRegistryName()).contains("simpleplanes")) {
            SimplePlanesGravity.gravity(entity, level);
        } else if (!(entity instanceof LivingEntity) && !(entity instanceof ItemEntity)) {
            EntityGravity.gravity(entity, level);
        }
    }

    @SubscribeEvent
    public static void worldTick(TickEvent.WorldTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            Level level = event.world;
            ServerLevel serverLevel = (ServerLevel) level;

            if (Methods.noAtmoWorlds.contains(level.dimension())) {
                level.thunderLevel = 0;
                level.rainLevel = 0;
            } else if (Methods.isWorld(level, Methods.venus)) {
                level.thunderLevel = 0;
            }

            Iterable<Entity> entities = serverLevel.getAllEntities();
            for (Entity entity : entities) {
                if (entity instanceof AbstractMinecart) {
                    MinecartGravity.gravity(entity, level);
                } else if (entity instanceof PrimedTnt) {
                    BlockGravity.gravity(entity, level);
                }
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

        if (Methods.isNoGravWorld(level) || entity.getY() >= 590 && Methods.isPlanetoidWorld(level)) {
            event.setDistance(event.getDistance() * Methods.SPACE_GRAVITY);
        } else if (Methods.isWorld(level, Methods.mercury)) {
            event.setDistance(event.getDistance() * Methods.MERCURY_GRAVITY);
        } else if (Methods.isWorld(level, Methods.venus)) {
            event.setDistance(event.getDistance() * Methods.VENUS_GRAVITY);
        } else if (Methods.isWorld(level, Methods.overworld)) {
            event.setDistance(event.getDistance() * Methods.EARTH_GRAVITY);
        } else if (Methods.isWorld(level, Methods.moon)) {
            event.setDistance(event.getDistance() * Methods.MOON_GRAVITY);
        } else if (Methods.isWorld(level, Methods.mars)) {
            event.setDistance(event.getDistance() * Methods.MARS_GRAVITY);
        } else if (Methods.isWorld(level, Methods.pluto)) {
            event.setDistance(event.getDistance() * Methods.PLUTO_GRAVITY);
        } else if (Methods.isWorld(level, Methods.relictus)) {
            event.setDistance(event.getDistance() * Methods.RELICTUS_GRAVITY);
        } else if (Methods.isWorld(level, Methods.caeruleum)) {
            event.setDistance(event.getDistance() * Methods.CAERULEUM_GRAVITY);
        } else if (Methods.isWorld(level, Methods.avium)) {
            event.setDistance(event.getDistance() * Methods.AVIUM_GRAVITY);
        } else if (Methods.isWorld(level, Methods.discors)) {
            event.setDistance(event.getDistance() * Methods.DISCORS_GRAVITY);
        } else if (Methods.isWorld(level, Methods.petra)) {
            event.setDistance(event.getDistance() * Methods.PETRA_GRAVITY);
        }
    }
}
