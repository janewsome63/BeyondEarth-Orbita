package net.rennautogirl63.beyond_orbita.events;

import io.netty.buffer.Unpooled;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.protocol.game.ClientboundStopSoundPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.portal.PortalInfo;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.util.ITeleporter;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.network.NetworkHooks;
import net.minecraftforge.registries.ForgeRegistries;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.IOxygenStorage;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.OxygenUtil;
import net.rennautogirl63.beyond_orbita.config.Config;
import net.rennautogirl63.beyond_orbita.entities.IRocketEntity;
import net.rennautogirl63.beyond_orbita.entities.LanderEntity;
import net.rennautogirl63.beyond_orbita.entities.VehicleEntity;
import net.rennautogirl63.beyond_orbita.events.forge.*;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.PlanetSelectionGui;
import net.rennautogirl63.beyond_orbita.items.VehicleItem;
import net.rennautogirl63.beyond_orbita.registries.*;

import java.util.Set;
import java.util.function.Function;

public class Methods {
    public static final ResourceKey<Level> mercury = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mercury"));
    public static final ResourceKey<Level> venus = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "venus"));
    public static final ResourceKey<Level> overworld = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation("overworld"));
    public static final ResourceKey<Level> orbit = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "orbit"));
    public static final ResourceKey<Level> moon = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "moon"));
    public static final ResourceKey<Level> mars = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "mars"));
    public static final ResourceKey<Level> asteroid_belt = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "asteroid_belt"));
    public static final ResourceKey<Level> pluto = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "pluto"));

    public static final ResourceKey<Level> relictus = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "relictus"));
    public static final ResourceKey<Level> avium = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "avium"));
    public static final ResourceKey<Level> holdplacer = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "holdplacer"));
    public static final ResourceKey<Level> caeruleum = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "caeruleum"));
    public static final ResourceKey<Level> discors = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "discors"));
    public static final ResourceKey<Level> petra = ResourceKey.create(Registry.DIMENSION_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "petra"));

    public static final ResourceLocation space_station = new ResourceLocation(BeyondOrbitaMod.MODID, "space_station");

    /** Gravity and Drag Values */

    // Sol
        public static final float MERCURY_GRAVITY = 0.377F;
        public static final float MERCURY_DRAG = 0.0F;
        public static final float VENUS_GRAVITY = 0.904F;
        public static final float VENUS_DRAG = 0.04F;
        public static final float EARTH_GRAVITY = 1.0F;
        public static final float EARTH_DRAG = 0.02F;
        public static final float MOON_GRAVITY = 0.165F;
        public static final float MOON_DRAG = 0.0F;
        public static final float MARS_GRAVITY = 0.379F;
        public static final float MARS_DRAG = 0.015F;
        public static final float PLUTO_GRAVITY = 0.063F;
        public static final float PLUTO_DRAG = 0.015F;

    // Rigil
        public static final float RELICTUS_GRAVITY = 1.07F;
        public static final float RELICTUS_DRAG = 0.03F;

    // Toliman
        public static final float CAERULEUM_GRAVITY = 0.93F;
        public static final float CAERULEUM_DRAG = 0.02F;
        public static final float AVIUM_GRAVITY = 0.98F;
        public static final float AVIUM_DRAG = 0.02F;

    // Proxima
        public static final float DISCORS_GRAVITY = 0.632F;
        public static final float DISCORS_DRAG = 0.02F;
        public static final float PETRA_GRAVITY = 1.35F;
        public static final float PETRA_DRAG = 0.0F;

    // Other
        public static final float SPACE_GRAVITY = 0.0F;
        public static final float SPACE_DRAG = 0.0F;
        public static final float MAGBOOT_STRENGTH = 0.333F;

    /** Time Values */

    // Sol
    public static final double MERCURY_DAY = 176;
    public static final double VENUS_DAY = 116.8;
    public static final double EARTH_DAY = 1.0;
    public static final double MOON_DAY = 29.5;
    public static final double MARS_DAY = 1.027;
    public static final double PLUTO_DAY = 6.375;
    public static final double RELICTUS_DAY = 2.0;
    public static final double CAERULEUM_DAY = 0.75;
    public static final double AVIUM_DAY = 1.1;
    public static final double PETRA_DAY = 15.0;

    public static Set<ResourceKey<Level>> noAtmoWorlds = Set.of(
            moon,
            mercury,
            orbit,
            asteroid_belt,
            petra
    );

    public static Set<ResourceKey<Level>> darkWorlds = Set.of(
            pluto,
            petra
    );

    public static Set<ResourceKey<Level>> spaceWorldsWithoutOxygen = Set.of(
            moon,
            mars,
            mercury,
            venus,
            orbit,
            asteroid_belt,
            pluto,
            petra
    );

    public static Set<ResourceKey<Level>> noRainWorlds = Set.of(
            mercury,
            orbit,
            moon,
            mars,
            asteroid_belt,
            pluto,
            relictus,
            petra
    );

    public static Set<ResourceKey<Level>> noGravWorlds = Set.of(
            orbit,
            asteroid_belt
    );

    public static Set<ResourceKey<Level>> planetoidWorlds = Set.of(
            mercury,
            venus,
            overworld,
            moon,
            mars,
            pluto,
            relictus,
            caeruleum,
            avium,
            discors,
            petra
    );

    public static Set<ResourceKey<Level>> hotWorlds = Set.of(
            mercury,
            venus
    );

    public static Set<ResourceKey<Level>> toxicWorlds = Set.of(
            discors
    );

    public static void entityWorldTeleporter(Entity entity, ResourceKey<Level> planet, double high) {
        if (entity.canChangeDimensions()) {

            if (entity.getServer() == null) {
                return;
            }

            ServerLevel nextLevel = entity.getServer().getLevel(planet);

            if (nextLevel == null) {
                BeyondOrbitaMod.LOGGER.error(planet.getRegistryName() + " does not exist!");
                return;
            }

            entity.changeDimension(nextLevel, new ITeleporter() {

                @Override
                public PortalInfo getPortalInfo(Entity entity, ServerLevel destWorld, Function<ServerLevel, PortalInfo> defaultPortalInfo) {
                    double x = entity.getX();
                    double z = entity.getZ();
                    boolean surface = false;
                    if (planet == Methods.asteroid_belt) {
                        while (surface == false) {
                            x -= 1;
                            z -= 1;
                            for (int y = 384; y >= -64; y--) {
                                BlockPos b = new BlockPos(x, y, z);
                                if (!destWorld.getBlockState(b).isAir()) {
                                    surface = true;
                                    break;
                                }
                            }
                        }
                    }
                    Vec3 pos = new Vec3(x, high, z);
                    return new PortalInfo(pos, Vec3.ZERO, entity.getYRot(), entity.getXRot());
                }

                @Override
                public boolean isVanilla() {
                    return false;
                }

                @Override
                public boolean playTeleportSound(ServerPlayer player, ServerLevel sourceWorld, ServerLevel destWorld) {
                    return false;
                }
            });
        }
    }

    public static boolean advancedSpaceSuitCheck(LivingEntity entity) {
        if (!checkArmor(entity, 3, ItemsRegistry.ADVANCED_OXYGEN_MASK.get())) return false;
        if (!checkArmor(entity, 2, ItemsRegistry.ADVANCED_SPACE_SUIT.get())) return false;
        if (!checkArmor(entity, 1, ItemsRegistry.ADVANCED_SPACE_PANTS.get())) return false;
        if (!checkArmor(entity, 0, ItemsRegistry.ADVANCED_SPACE_BOOTS.get())) return false;

        return true;
    }

    public static boolean spaceSuitCheck(LivingEntity entity) {
        if (!checkArmor(entity, 3, ItemsRegistry.OXYGEN_MASK.get())) return false;
        if (!checkArmor(entity, 2, ItemsRegistry.SPACE_SUIT.get())) return false;
        if (!checkArmor(entity, 1, ItemsRegistry.SPACE_PANTS.get())) return false;
        if (!checkArmor(entity, 0, ItemsRegistry.SPACE_BOOTS.get())) return false;

        return true;
    }

    public static boolean spaceSuitCheckBoth(LivingEntity entity) {
        boolean item3 = checkArmor(entity, 3, ItemsRegistry.OXYGEN_MASK.get());
        boolean item3b = checkArmor(entity, 3, ItemsRegistry.ADVANCED_OXYGEN_MASK.get());

        if (!item3 && !item3b) {
            return false;
        }

        boolean item2 = checkArmor(entity, 2, ItemsRegistry.SPACE_SUIT.get());
        boolean item2b = checkArmor(entity, 2, ItemsRegistry.ADVANCED_SPACE_SUIT.get());

        if (!item2 && !item2b) {
            return false;
        }

        boolean item1 = checkArmor(entity, 1, ItemsRegistry.SPACE_PANTS.get());
        boolean item1b = checkArmor(entity, 1, ItemsRegistry.ADVANCED_SPACE_PANTS.get());

        if (!item1 && !item1b) {
            return false;
        }

        boolean item0 = checkArmor(entity, 0, ItemsRegistry.SPACE_BOOTS.get());
        boolean item0b = checkArmor(entity, 0, ItemsRegistry.ADVANCED_SPACE_BOOTS.get());

        if (!item0 && !item0b) {
            return false;
        }

        return true;
    }

    public static boolean checkArmor(LivingEntity entity, int number, Item item) {
        return entity.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, number)).getItem() == item;
    }

    public static boolean isRainWorld(Level world) { return noRainWorlds.contains(world.dimension()); }
    public static boolean isNoAtmoWorld(Level world) { return noAtmoWorlds.contains(world.dimension()); }
    public static boolean isDarkWorld(Level world) { return darkWorlds.contains(world.dimension()); }
    public static boolean isSpaceWorldWithoutOxygen(Level world) { return spaceWorldsWithoutOxygen.contains(world.dimension()); }
    public static boolean isNoGravWorld(Level world) {
        return noGravWorlds.contains(world.dimension());
    }
    public static boolean isPlanetoidWorld(Level world) {
        return planetoidWorlds.contains(world.dimension());
    }
    public static boolean isHotWorld(Level world) { return hotWorlds.contains(world.dimension()); }
    public static boolean isToxicWorld(Level world) { return toxicWorlds.contains(world.dimension()); }
    public static boolean isWorld(Level world, ResourceKey<Level> loc) {
        return world.dimension() == loc;
    }

    public static void oxygenDamage(LivingEntity entity) {
        entity.hurt(DamageSourcesRegistry.DAMAGE_SOURCE_OXYGEN, 1.0F);
    }

    public static void venusRainDamage(LivingEntity entity) {
        entity.hurt(DamageSourcesRegistry.DAMAGE_SOURCE_ACID_RAIN, 1.0F);
    }

    public static boolean isRocket(Entity entity) {
        return entity instanceof IRocketEntity;
    }

    public static boolean isVehicle(Entity entity) {
        return entity instanceof VehicleEntity;
    }

    public static void dropRocket(Player player) {
        Item item1 = player.getMainHandItem().getItem();
        Item item2 = player.getOffhandItem().getItem();

        if (item1 instanceof VehicleItem && item2 instanceof VehicleItem) {

            ItemEntity spawn = new ItemEntity(player.level, player.getX(), player.getY(), player.getZ(), new ItemStack(item2));
            spawn.setPickUpDelay(0);
            player.level.addFreshEntity(spawn);

            player.getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY).ifPresent(capability -> {
                capability.extractItem(40, 1, false); //40 is offhand
            });
        }
    }

    /**
     * If an entity should not get Fire add it to the Tag "venus_fire"
     */
    public static void planetFire(LivingEntity entity, ResourceKey<Level> planet) {
        Level level = entity.level;

        if (!Methods.isWorld(level, planet)) {
            return;
        }

        if ((entity instanceof Mob || entity instanceof Player) && (Methods.advancedSpaceSuitCheck(entity) || entity.hasEffect(MobEffects.FIRE_RESISTANCE) || entity.fireImmune())) {
            return;
        }

        if (entity instanceof Player) {
            Player player = (Player) entity;

            if (player.isSpectator() || player.getAbilities().instabuild) {
                return;
            }
        }

        if (MinecraftForge.EVENT_BUS.post(new LivingSetFireInHotPlanetEvent(entity, planet))) {
            return;
        }

        if (tagCheck(entity, TagsRegistry.PLANET_FIRE_TAG)) {
            return;
        }

        if (entity.level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Math.floor(entity.getX()), (int) Math.floor(entity.getZ())) <= Math.floor(entity.getY()) + 1) {
            entity.setSecondsOnFire(10);
        }
    }

    /**
     * If an entity should not get Damage add it to the Tag "venus_rain"
     */
    public static void venusRain(LivingEntity entity, ResourceKey<Level> planet) {
        if (!Methods.isWorld(entity.level, planet)) {
            return;
        }

        if (entity.isPassenger() && (Methods.isRocket(entity.getVehicle()) || entity.getVehicle() instanceof LanderEntity)) {
            return;
        }

        if (entity instanceof Player) {
            Player player = (Player) entity;

            if (player.isSpectator() || player.getAbilities().instabuild) {
                return;
            }
        }

        if (MinecraftForge.EVENT_BUS.post(new LivingSetVenusRainEvent(entity, planet))) {
            return;
        }

        if (tagCheck(entity, TagsRegistry.VENUS_RAIN_TAG)) {
            return;
        }

        if (entity.level.getLevelData().isRaining() && entity.level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) Math.floor(entity.getX()), (int) Math.floor(entity.getZ())) <= Math.floor(entity.getY()) + 1) {
            if (!entity.level.isClientSide) {
                Methods.venusRainDamage(entity);
            }
        }
    }

    /**
     * If an entity should get oxygen damage add it to the tag "oxygen"
     */
    public static void entityOxygen(LivingEntity entity, Level level) {
        if (entity instanceof Player) {
            return;
        }

        if (Config.ENTITY_OXYGEN_SYSTEM.get() && Methods.isSpaceWorldWithoutOxygen(level) && tagCheck(entity, TagsRegistry.OXYGEN_TAG) || Config.ENTITY_OXYGEN_SYSTEM.get() && Methods.isPlanetoidWorld(level) && entity.blockPosition().getY() >= 590 && tagCheck(entity, TagsRegistry.OXYGEN_TAG)) {

            if (!entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {

                entity.getPersistentData().putDouble(BeyondOrbitaMod.MODID + ":oxygen_tick", entity.getPersistentData().getDouble(BeyondOrbitaMod.MODID + ":oxygen_tick") + 1);

                if (entity.getPersistentData().getDouble(BeyondOrbitaMod.MODID + ":oxygen_tick") > 15) {

                    if (!level.isClientSide) {
                        Methods.oxygenDamage(entity);
                    }

                    entity.getPersistentData().putDouble(BeyondOrbitaMod.MODID + ":oxygen_tick", 0);
                }
            }
        }

        //Out of Space
        if (Config.ENTITY_OXYGEN_SYSTEM.get() && entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {
            entity.setAirSupply(300);
        }
    }

    public static void vehicleRotation(Entity vehicle, float rotation) {
        vehicle.setYRot(vehicle.getYRot() + rotation);
        vehicle.setYBodyRot(vehicle.getYRot());
        vehicle.yRotO = vehicle.getYRot();
    }

    public static boolean tagCheck(Entity entity, TagKey<EntityType<?>> tag) {
        return entity.getType().is(tag);
    }

    public static boolean tagCheck(Fluid fluid, TagKey<Fluid> tag) {
        return fluid.is(tag);
    }

    public static boolean tagCheck(ItemStack item, TagKey<Item> tag) {
        return item.is(tag);
    }

    public static void landerTeleport(Player player, ResourceKey<Level> newPlanet) {
        LanderEntity lander = (LanderEntity) player.getVehicle();

        if (lander.getY() < 1) {

            /** CALL LANDER ORBIT TELEPORT PRE EVENT */
            MinecraftForge.EVENT_BUS.post(new LanderOrbitTeleportEvent.Pre(lander, player));

            ItemStack slot_0 = lander.getInventory().getStackInSlot(0);
            ItemStack slot_1 = lander.getInventory().getStackInSlot(1);
            if (!player.level.isClientSide) {
                lander.remove(Entity.RemovalReason.DISCARDED);
            }

            Methods.entityWorldTeleporter(player, newPlanet, 699);

            Level newWorld = player.level;

            if (!player.level.isClientSide) {
                LanderEntity entityToSpawn = new LanderEntity(EntitiesRegistry.LANDER.get(), newWorld);
                entityToSpawn.moveTo(player.getX(), player.getY(), player.getZ(), 0, 0);
                newWorld.addFreshEntity(entityToSpawn);

                entityToSpawn.getInventory().setStackInSlot(0, slot_0);
                entityToSpawn.getInventory().setStackInSlot(1, slot_1);

                player.startRiding(entityToSpawn);

                /** CALL LANDER ORBIT TELEPORT POST EVENT */
                MinecraftForge.EVENT_BUS.post(new LanderOrbitTeleportEvent.Post(lander, player));
            }
        }
    }

    public static void rocketTeleport(Player player, ResourceKey<Level> planet, ItemStack rocketItem, Boolean SpaceStation) {
        Level level = player.level;

        if (!Methods.isWorld(level, planet)) {
            Methods.entityWorldTeleporter(player, planet, 699);
        } else {
            player.setPos(player.getX(), 699, player.getZ());

            if (player instanceof ServerPlayer) {
                ((ServerPlayer) player).connection.teleport(player.getX(), 699, player.getZ(), player.getYRot(), player.getXRot());
            }
        }

        Level newLevel = player.level;

        if (!newLevel.isClientSide) {
            LanderEntity landerSpawn = new LanderEntity(EntitiesRegistry.LANDER.get(), newLevel);
            landerSpawn.moveTo(player.getX(), player.getY(), player.getZ(), 0, 0);
            newLevel.addFreshEntity(landerSpawn);

            String itemId = player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":slot0");

            landerSpawn.getInventory().setStackInSlot(0, new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId)), 1));
            landerSpawn.getInventory().setStackInSlot(1, rocketItem);

            if (SpaceStation) {
                createSpaceStation(player, (ServerLevel) newLevel);
            }

            /** CALL START RIDE LANDER EVENT */
            MinecraftForge.EVENT_BUS.post(new StartRideLanderEvent(landerSpawn, player));

            cleanUpPlayerNBT(player);

            player.startRiding(landerSpawn);
        }
    }

    public static void createSpaceStation(Player player, ServerLevel serverWorld) {
        BlockPos pos = new BlockPos(player.getX() - 3.5, 160, player.getZ() - 3.5);
        serverWorld.getStructureManager().getOrCreate(space_station).placeInWorld(serverWorld, pos, pos, new StructurePlaceSettings(), serverWorld.random, 2);
    }

    public static void cleanUpPlayerNBT(Player player) {
        player.getPersistentData().putBoolean(BeyondOrbitaMod.MODID + ":planet_selection_gui_open", false);
        player.getPersistentData().putString(BeyondOrbitaMod.MODID + ":rocket_type", "");
        player.getPersistentData().putString(BeyondOrbitaMod.MODID + ":slot0", "");

        MinecraftForge.EVENT_BUS.post(new PlayerExitPlanetSelectionGuiEvent(player));
    }

    public static void openPlanetGui(Player player) {
        if (!(player.containerMenu instanceof PlanetSelectionGui.GuiContainer) && player.getPersistentData().getBoolean(BeyondOrbitaMod.MODID + ":planet_selection_gui_open")) {
            if (player instanceof ServerPlayer) {
                ServerPlayer serverPlayer = (ServerPlayer) player;

                /** OPEN MENU */
                NetworkHooks.openGui(serverPlayer, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TextComponent("Planet Selection");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeUtf(player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type"));
                        return new PlanetSelectionGui.GuiContainer(id, inventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeUtf(player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type"));
                });
            }
        }
    }

    public static void teleportButton(Player player, ResourceKey<Level> planet, boolean SpaceStation) {
        ItemStack itemStack = new ItemStack(Items.AIR, 1);

        if (player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type").equals("entity." + BeyondOrbitaMod.MODID + ".rocket_t1")) {
            itemStack = new ItemStack(ItemsRegistry.TIER_1_ROCKET_ITEM.get(), 1);
        } else if (player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type").equals("entity." + BeyondOrbitaMod.MODID + ".rocket_t2")) {
            itemStack = new ItemStack(ItemsRegistry.TIER_2_ROCKET_ITEM.get(), 1);
        } else if (player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type").equals("entity." + BeyondOrbitaMod.MODID + ".rocket_t3")) {
            itemStack = new ItemStack(ItemsRegistry.TIER_3_ROCKET_ITEM.get(), 1);
        } else if (player.getPersistentData().getString(BeyondOrbitaMod.MODID + ":rocket_type").equals("entity." + BeyondOrbitaMod.MODID + ".rocket_t4")) {
            itemStack = new ItemStack(ItemsRegistry.TIER_4_ROCKET_ITEM.get(), 1);
        }

        Methods.rocketTeleport(player, planet, itemStack, SpaceStation);
    }

    public static void landerTeleportOrbit(Player player, Level world) {
        if (Methods.isWorld(world, Methods.orbit)) {
            Methods.landerTeleport(player, Methods.overworld);
        }
    }

    public static void entityFallToPlanet(Level world, Entity entity) {
        ResourceKey<Level> world2 = world.dimension();

        if (world2 == Methods.orbit) {
            Methods.entityWorldTeleporter(entity, Methods.overworld, 699);
        }
    }

    public static void entityExitAtmosphere(Level world, Entity entity) {
        ResourceKey<Level> world2 = world.dimension();
        double xv = entity.getDeltaMovement().x;
        double yv = entity.getDeltaMovement().y;
        double zv = entity.getDeltaMovement().z;
        if (world2 == Methods.overworld) {
            Methods.entityWorldTeleporter(entity, Methods.orbit, 1);
        } else {
            if (entity instanceof ItemEntity) {
                entity.setDeltaMovement(xv, 0, zv);
            } else {
                entity.setDeltaMovement(xv, -0.5, zv);
            }
        }
    }

    public static void extractArmorOxygenUsingTimer(ItemStack itemstack, Player player) {
        if (!player.getAbilities().instabuild && !player.isSpectator() && Methods.spaceSuitCheckBoth(player) && !player.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get()) && Config.PLAYER_OXYGEN_SYSTEM.get() && (Methods.isSpaceWorldWithoutOxygen(player.level) || (Methods.isPlanetoidWorld(player.level) && player.blockPosition().getY() >= 590) || player.isEyeInFluid(FluidTags.WATER))) {
            IOxygenStorage oxygenStorage = OxygenUtil.getItemStackOxygenStorage(itemstack);

            CompoundTag persistentData = player.getPersistentData();
            String key = BeyondOrbitaMod.MODID + ":oxygen_timer";
            int oxygenTimer = persistentData.getInt(key);
            oxygenTimer++;

            if (oxygenStorage.getOxygenStored() > 0 && oxygenTimer > 3) {
                oxygenStorage.extractOxygen(1, false);
                oxygenTimer = 0;
            }

            persistentData.putInt(key, oxygenTimer);
        }
    }

    public static void disableFlyAntiCheat(ServerPlayer player, boolean condition) {
        if (condition) {
            player.connection.aboveGroundTickCount = 0;
        }
    }

    public static void stopSounds(ServerPlayer serverPlayer, ResourceLocation sound, SoundSource source) {
        ClientboundStopSoundPacket stopSoundS2CPacket = new ClientboundStopSoundPacket(sound, source);
        serverPlayer.connection.send(stopSoundS2CPacket);
    }

    public static void playRocketSound(Entity entity, Level world) {
        world.playSound(null, entity, SoundsRegistry.ROCKET_SOUND.get(), SoundSource.AMBIENT, 1, 1);
    }

    public static void noFuelMessage(Player player) {
        if (!player.level.isClientSide) {
            player.displayClientMessage(new TranslatableComponent("message." + BeyondOrbitaMod.MODID + ".no_fuel"), false);
        }
    }

    public static void elytraCancel(Player player) {
        if (player.isFallFlying()) {
            player.stopFallFlying();
            player.setDeltaMovement(player.getDeltaMovement().x, player.getDeltaMovement().y - 0.1, player.getDeltaMovement().z);
        }
    }
}
