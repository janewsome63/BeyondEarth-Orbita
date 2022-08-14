package net.rennautogirl63.beyond_orbita.items;

import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.IItemRenderProperties;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.RoverEntity;
import net.rennautogirl63.beyond_orbita.events.ClientEventBusSubscriber;
import net.rennautogirl63.beyond_orbita.fluids.FluidUtil2;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import net.rennautogirl63.beyond_orbita.gauge.GaugeValueHelper;
import net.rennautogirl63.beyond_orbita.registries.EntitiesRegistry;

import java.util.List;
import java.util.function.Consumer;

public class RoverItem extends VehicleItem {
    public static String fuelTag = BeyondOrbitaMod.MODID + ":fuel";

    public RoverItem(Properties properties) {
        super(properties);
    }

    @Override
    public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
        super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
        int fuel = p_41421_.getOrCreateTag().getInt(fuelTag);
        p_41423_.add(GaugeTextHelper.buildBlockTooltip(GaugeTextHelper.getStorageText(GaugeValueHelper.getFuel(fuel, RoverEntity.FUEL_BUCKETS * FluidUtil2.BUCKET_SIZE))));
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        Player player = context.getPlayer();
        Level world = context.getLevel();
        
        if (world.isClientSide()) {
        	return InteractionResult.PASS;
        }
        
        BlockPos pos = context.getClickedPos();
        InteractionHand hand = context.getHand();
        ItemStack itemStack = context.getItemInHand();
        Level level = context.getLevel();

        int x = pos.getX();
        int y = pos.getY();
        int z = pos.getZ();

        BlockPlaceContext blockplacecontext = new BlockPlaceContext(context);
        BlockPos blockpos = blockplacecontext.getClickedPos();
        Vec3 vec3 = Vec3.atBottomCenterOf(blockpos);
        AABB aabb = EntitiesRegistry.ROVER.get().getDimensions().makeBoundingBox(vec3.x(), vec3.y(), vec3.z());

        if (level.noCollision(aabb)) {

            AABB scanAbove = new AABB(x - 0, y - 0, z - 0, x + 1, y + 1, z + 1);
            List<Entity> entities = player.getCommandSenderWorld().getEntitiesOfClass(Entity.class, scanAbove);

            if (entities.isEmpty()) {
                RoverEntity rover = new RoverEntity(EntitiesRegistry.ROVER.get(), world);

                rover.setPos((double) pos.getX() + 0.5D,  pos.getY() + 1, (double) pos.getZ() + 0.5D);
                double d0 = this.getYOffset(world, pos, true, rover.getBoundingBox());

                /** ROTATION */
                float f = (float) Mth.floor((Mth.wrapDegrees(context.getRotation() - 180.0F) + 5.626F) / 11.25F) * 11.25F;

                rover.moveTo((double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D, f + 180.0F, 0.0F);

                rover.yRotO = rover.getYRot();

                world.addFreshEntity(rover);

                rover.getEntityData().set(RoverEntity.FUEL, itemStack.getOrCreateTag().getInt(fuelTag));

                if (!player.getAbilities().instabuild) {
                    player.setItemInHand(hand, ItemStack.EMPTY);
                } else {
                    player.swing(context.getHand(), true);
                }

                roverPlaceSound(pos, world);
            }
        }

        return super.useOn(context);
    }

    @Override
    public void initializeClient(Consumer<IItemRenderProperties> consumer) {
        consumer.accept(new IItemRenderProperties() {

            @Override
            public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
                return ClientEventBusSubscriber.ROVER_ITEM_RENDERER;
            }
        });
    }

    @Override
    public void fillItemCategory(CreativeModeTab p_41391_, NonNullList<ItemStack> p_41392_) {
        super.fillItemCategory(p_41391_, p_41392_);
        if (this.allowdedIn(p_41391_)) {
            ItemStack itemStack = new ItemStack(this);
            itemStack.getOrCreateTag().putInt(fuelTag, 3000);
            p_41392_.add(itemStack);
        }
    }

    public static void roverPlaceSound(BlockPos pos, Level world) {
        world.playSound(null, pos, SoundEvents.STONE_BREAK, SoundSource.BLOCKS, 1,1);
    }
}
