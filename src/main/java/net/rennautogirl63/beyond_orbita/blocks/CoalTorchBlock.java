package net.rennautogirl63.beyond_orbita.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.TorchBlock;
import net.minecraft.world.level.block.WallTorchBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;

import java.util.Random;

public class CoalTorchBlock extends TorchBlock {

    public CoalTorchBlock(Properties p_57491_) {
        super(p_57491_, null);
    }

    @Override
    public InteractionResult use(BlockState p_51274_, Level p_51275_, BlockPos p_51276_, Player p_51277_, InteractionHand p_51278_, BlockHitResult p_51279_) {
        ItemStack itemstack = p_51277_.getItemInHand(p_51278_);

        if (p_51275_.getBlockState(p_51276_).getBlock() == BlocksRegistry.WALL_COAL_TORCH_BLOCK.get() && !Methods.isSpaceWorldWithoutOxygen(p_51275_) && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!p_51275_.isClientSide) {

                BlockState state = p_51275_.getBlockState(p_51276_);

                p_51275_.setBlock(p_51276_, Blocks.WALL_TORCH.defaultBlockState().setValue(WallTorchBlock.FACING, state.getValue(WallCoalTorchBlock.FACING)), 3);

                this.flintManager(itemstack, p_51277_, p_51278_, p_51276_, p_51275_);
                return InteractionResult.SUCCESS;
            }
        }

        if (p_51275_.getBlockState(p_51276_).getBlock() == BlocksRegistry.COAL_TORCH_BLOCK.get() && !Methods.isSpaceWorldWithoutOxygen(p_51275_) && (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE)) {
            if (!p_51275_.isClientSide) {

                p_51275_.setBlock(p_51276_, Blocks.TORCH.defaultBlockState(), 3);

                this.flintManager(itemstack, p_51277_, p_51278_, p_51276_, p_51275_);
                return InteractionResult.SUCCESS;
            }
        }

        if (itemstack.getItem() == Items.FLINT_AND_STEEL || itemstack.getItem() == Items.FIRE_CHARGE) {
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }

    @Override
    public void animateTick(BlockState p_57494_, Level p_57495_, BlockPos p_57496_, Random p_57497_) {

    }

    public void flintManager(ItemStack itemstack, Player playerEntity, InteractionHand hand, BlockPos pos, Level world) {
        if (itemstack.getItem() == Items.FLINT_AND_STEEL) {
            world.playSound(null, pos, SoundEvents.FLINTANDSTEEL_USE, SoundSource.BLOCKS, 1, 1);

            itemstack.hurtAndBreak(1, playerEntity, (player) -> {
                player.broadcastBreakEvent(hand);
            });
        }

        if (itemstack.getItem() == Items.FIRE_CHARGE) {
            world.playSound(null, pos, SoundEvents.FIRECHARGE_USE, SoundSource.BLOCKS, 1,1);

            if (!playerEntity.getAbilities().instabuild && !playerEntity.isSpectator()) {
                itemstack.setCount(itemstack.getCount() - 1);
            }
        }
    }
}