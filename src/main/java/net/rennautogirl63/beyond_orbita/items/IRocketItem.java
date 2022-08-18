package net.rennautogirl63.beyond_orbita.items;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.blocks.RocketLaunchPad;
import net.rennautogirl63.beyond_orbita.entities.IRocketEntity;
import net.rennautogirl63.beyond_orbita.entities.RocketTier1Entity;
import net.rennautogirl63.beyond_orbita.events.forge.PlaceRocketEvent;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import net.rennautogirl63.beyond_orbita.gauge.GaugeValueHelper;

import java.util.List;
import java.util.function.Consumer;

public abstract class IRocketItem extends VehicleItem {

    public static final String fuelTag = BeyondOrbitaMod.MODID + ":fuel";
    public static final String bucketTag = BeyondOrbitaMod.MODID + ":buckets";

    public IRocketItem(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        BlockState state = level.getBlockState(pos);
        InteractionHand hand = context.getHand();
        ItemStack itemStack = context.getItemInHand();

        if (level.isClientSide()) {
            return InteractionResult.PASS;
        }

        /** POS */
        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        if (state.getBlock() instanceof RocketLaunchPad && state.getValue(RocketLaunchPad.STAGE)) {

            BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
            BlockPos blockpos = blockplacecontext.getClickedPos();
            Vec3 vec3 = Vec3.upFromBottomCenterOf(blockpos, this.getRocketPlaceHigh());
            AABB aabb = this.getEntityType().getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());

            if (level.noCollision(aabb)) {

                /** CHECK IF NO ENTITY ON THE LAUNCH PAD */
                AABB scanAbove = new AABB(x - 0, y - 0, z - 0, x + 1, y + 1, z + 1);
                List<Entity> entities = player.getCommandSenderWorld().getEntitiesOfClass(Entity.class, scanAbove);

                if (entities.isEmpty()) {
                    IRocketEntity rocket = this.getRocket(context.getLevel());

                    /** SET PRE POS */
                    rocket.setPos(pos.getX() + 0.5D, pos.getY() + 1, pos.getZ() + 0.5D);

                    double d0 = this.getYOffset(level, pos, true, rocket.getBoundingBox());
                    float f = (float) Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 45.0F) / 90.0F) * 90.0F;

                    /** SET FINAL POS */
                    rocket.moveTo(pos.getX() + 0.5D, pos.getY() + d0, pos.getZ() + 0.5D, f, 0.0F);

                    rocket.yRotO = rocket.getYRot();

                    level.addFreshEntity(rocket);

                    /** SET TAGS */
                    rocket.getEntityData().set(RocketTier1Entity.FUEL, itemStack.getOrCreateTag().getInt(fuelTag));
                    rocket.getEntityData().set(RocketTier1Entity.BUCKETS, itemStack.getOrCreateTag().getInt(bucketTag));

                    /** CALL PLACE ROCKET EVENT */
                    MinecraftForge.EVENT_BUS.post(new PlaceRocketEvent(rocket, context));

                    /** ITEM REMOVE */
                    if (!player.getAbilities().instabuild) {
                        player.setItemInHand(hand, ItemStack.EMPTY);
                    }

                    /** PLACE SOUND */
                    this.rocketPlaceSound(pos, level);

                    return InteractionResult.SUCCESS;
                }
            }
        }

        return super.useOn(context);
    }

    @Override
    public void appendHoverText(ItemStack itemstack, Level world, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(itemstack, world, list, flag);

        int fuel = itemstack.getOrCreateTag().getInt(fuelTag) / 3;
        list.add(GaugeTextHelper.buildBlockTooltip(GaugeTextHelper.getPercentText(GaugeValueHelper.getFuel(fuel, 100))));
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return IRocketItem.this.getRenderer();
            }
        });
    }

    public float getRocketPlaceHigh() {
        return -0.6F;
    }

    @OnlyIn(Dist.CLIENT)
    public abstract BlockEntityWithoutLevelRenderer getRenderer();

    public abstract EntityType getEntityType();

    public abstract IRocketEntity getRocket(Level level);

    public void rocketPlaceSound(BlockPos pos, Level world) {
        world.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1, 1);
    }
}
