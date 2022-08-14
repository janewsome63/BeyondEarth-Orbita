package net.rennautogirl63.beyond_orbita.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RocketLaunchPad extends Block implements SimpleWaterloggedBlock {

    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    public static final BooleanProperty STAGE = BlockStateProperties.LIT;

    public static final VoxelShape SHAPE_HIGH = Shapes.box(0, 0, 0, 1, 0.25, 1);
    public static final VoxelShape SHAPE_NORMAL = Shapes.box(0, 0, 0, 1, 0.187, 1);

    public RocketLaunchPad(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(WATERLOGGED, false).setValue(STAGE, false));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        boolean flag = context.getLevel().getFluidState(context.getClickedPos()).is(Fluids.WATER);
        return this.defaultBlockState().setValue(WATERLOGGED, flag);
    }

    @Override
    public BlockState updateShape(BlockState p_56285_, Direction p_56286_, BlockState p_56287_, LevelAccessor p_56288_, BlockPos p_56289_, BlockPos p_56290_) {
        if (p_56285_.getValue(WATERLOGGED)) {
            p_56288_.scheduleTick(p_56289_, Fluids.WATER, Fluids.WATER.getTickDelay(p_56288_));
        }

        return super.updateShape(p_56285_, p_56286_, p_56287_, p_56288_, p_56289_, p_56290_);
    }

    @Override
    public FluidState getFluidState(BlockState p_56299_) {
        return p_56299_.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(p_56299_);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(WATERLOGGED, STAGE);
    }

    @Override
    public boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return !world.getBlockState(pos.below()).is(state.getBlock());
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        if (state.getValue(STAGE)) {
            return SHAPE_HIGH;
        } else {
            return SHAPE_NORMAL;
        }
    }

    @Override
    public void onPlace(BlockState p_60566_, Level p_60567_, BlockPos p_60568_, BlockState p_60569_, boolean p_60570_) {
        super.onPlace(p_60566_, p_60567_, p_60568_, p_60569_, p_60570_);
        p_60567_.scheduleTick(p_60568_, this, 1);
    }

    @Override
    public void tick(BlockState state, ServerLevel world, BlockPos pos, Random random) {
        int y = pos.getY();

        /** POS FOR 3x3 */
        int x = pos.getX() - 1;
        int z = pos.getZ() - 1;

        /** POS FOR 5x5 */
        int x2 = pos.getX() - 2;
        int z2 = pos.getZ() - 2;

        /** LISTS */
        List<Boolean> flag1 = new ArrayList<>();
        List<Boolean> flag2 = new ArrayList<>();

        /** CHECK IF LAUNCH PAD 3x3 */
        for (int f1 = x; f1 < x + 3; f1++) {
            for (int f2 = z; f2 < z + 3; f2++) {
                BlockPos pos2 = new BlockPos(f1, y, f2);

                flag1.add(world.getBlockState(pos2).is(BlocksRegistry.ROCKET_LAUNCH_PAD.get()));
            }
        }

        /** CHECK IF LAUNCH PAD 5x5 (STAGE == FALSE) */
        for (int f1 = x2; f1 < x2 + 5; f1++) {
            for (int f2 = z2; f2 < z2 + 5; f2++) {
                BlockPos pos2 = new BlockPos(f1, y, f2);

                if (world.getBlockState(pos2).is(BlocksRegistry.ROCKET_LAUNCH_PAD.get()) && !pos2.equals(pos)) {
                    flag2.add(world.getBlockState(pos2).getValue(STAGE));
                }
            }
        }

        /** VARIABLE SETTER */
        if (!flag1.contains(false)) {
            if (!state.getValue(STAGE) && !flag2.contains(true)) {
                world.setBlock(pos, state.setValue(STAGE, true), 2);
            }
        } else {
            if (state.getValue(STAGE)) {
                world.setBlock(pos, state.setValue(STAGE, false), 2);
            }
        }

        world.scheduleTick(new BlockPos(pos.getX(), pos.getY(), pos.getZ()), this, 1);
    }

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }
}
