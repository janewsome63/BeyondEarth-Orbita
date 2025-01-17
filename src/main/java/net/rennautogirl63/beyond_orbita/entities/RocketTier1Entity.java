package net.rennautogirl63.beyond_orbita.entities;

import io.netty.buffer.Unpooled;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.network.NetworkHooks;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.events.forge.RocketPickResultEvent;
import net.rennautogirl63.beyond_orbita.fluids.FluidUtil2;
import net.rennautogirl63.beyond_orbita.guis.screens.rocket.RocketGui;
import net.rennautogirl63.beyond_orbita.registries.ItemsRegistry;
import net.rennautogirl63.beyond_orbita.registries.ParticlesRegistry;
import net.rennautogirl63.beyond_orbita.registries.TagsRegistry;

public class RocketTier1Entity extends IRocketEntity {

    public RocketTier1Entity(EntityType type, Level world) {
        super(type, world);
        this.setRocketSpeed(0.63);
    }

    @Override
    public double getPassengersRidingOffset() {
        return super.getPassengersRidingOffset() - 2.35;
    }

    @Override
    public ItemStack getPickedResult(HitResult target) {
        ItemStack itemStack = new ItemStack(ItemsRegistry.TIER_1_ROCKET_ITEM.get(), 1);
        itemStack.getOrCreateTag().putInt(BeyondOrbitaMod.MODID + ":fuel", this.getEntityData().get(FUEL));
        itemStack.getOrCreateTag().putInt(BeyondOrbitaMod.MODID + ":buckets", this.getEntityData().get(BUCKETS));
        MinecraftForge.EVENT_BUS.post(new RocketPickResultEvent(this, itemStack));

        return itemStack;
    }

    @Override
    protected void spawnRocketItem() {
        ItemStack itemStack = new ItemStack(ItemsRegistry.TIER_1_ROCKET_ITEM.get(), 1);
        itemStack.getOrCreateTag().putInt(BeyondOrbitaMod.MODID + ":fuel", this.getEntityData().get(FUEL));
        itemStack.getOrCreateTag().putInt(BeyondOrbitaMod.MODID + ":buckets", this.getEntityData().get(BUCKETS));

        ItemEntity entityToSpawn = new ItemEntity(level, this.getX(), this.getY(), this.getZ(), itemStack);
        entityToSpawn.setPickUpDelay(10);
        level.addFreshEntity(entityToSpawn);
    }

    @Override
    public InteractionResult interact(Player player, InteractionHand hand) {
        super.interact(player, hand);
        InteractionResult result = InteractionResult.sidedSuccess(this.level.isClientSide);

        if (!this.level.isClientSide) {
            if (player.isCrouching()) {
                NetworkHooks.openGui((ServerPlayer) player, new MenuProvider() {
                    @Override
                    public Component getDisplayName() {
                        return new TranslatableComponent("container.entity." + BeyondOrbitaMod.MODID + ".rocket_t1");
                    }

                    @Override
                    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
                        FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
                        packetBuffer.writeVarInt(RocketTier1Entity.this.getId());
                        return new RocketGui.GuiContainer(id, inventory, packetBuffer);
                    }
                }, buf -> {
                    buf.writeVarInt(this.getId());
                });

                return InteractionResult.CONSUME;
            }

            player.startRiding(this);
            return InteractionResult.CONSUME;
        }

        return result;
    }

    @Override
    public void particleSpawn() {
        Vec3 vec = this.getDeltaMovement();

        if (level instanceof ServerLevel) {
            if (this.entityData.get(START_TIMER) == 200) {
                for (ServerPlayer p : ((ServerLevel) level).getServer().getPlayerList().getPlayers()) {
                    ((ServerLevel) level).sendParticles(p, (ParticleOptions) ParticlesRegistry.LARGE_FLAME_PARTICLE.get(), true, this.getX() - vec.x, this.getY() - vec.y - 2.2, this.getZ() - vec.z, 20, 0.1, 0.1, 0.1, 0.001);
                    ((ServerLevel) level).sendParticles(p, (ParticleOptions) ParticlesRegistry.LARGE_SMOKE_PARTICLE.get(), true, this.getX() - vec.x, this.getY() - vec.y - 3.2, this.getZ() - vec.z, 10, 0.1, 0.1, 0.1, 0.04);
                }
            } else {
                for (ServerPlayer p : ((ServerLevel) level).getServer().getPlayerList().getPlayers()) {
                    ((ServerLevel) level).sendParticles(p, ParticleTypes.CAMPFIRE_COSY_SMOKE, true, this.getX() - vec.x, this.getY() - vec.y - 0.1, this.getZ() - vec.z, 6, 0.1, 0.1, 0.1, 0.023);
                }
            }
        }
    }

    @Override
    public void fillUpRocket() {
        if (Methods.tagCheck(FluidUtil2.findBucketFluid(this.getInventory().getStackInSlot(0).getItem()), TagsRegistry.FLUID_ROCKET_FUEL_TAG) && this.entityData.get(BUCKETS) != 1) {
            this.getInventory().setStackInSlot(0, new ItemStack(Items.BUCKET));
            this.getEntityData().set(BUCKETS, 1);
        }

        if (this.getEntityData().get(BUCKETS) == 1 && this.getEntityData().get(FUEL) < 300) {
            this.getEntityData().set(FUEL, this.getEntityData().get(FUEL) + 1);
        }
    }
}