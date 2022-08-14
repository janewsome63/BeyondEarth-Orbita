package net.rennautogirl63.beyond_orbita.events;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class HotPlanetsWater {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getPlayer().getUsedItemHand())
			return;
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getFace(), event.getPlayer());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		execute(null, world, x, y, z, direction, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, Direction direction, Entity entity) {
		if (direction == null || entity == null)
			return;
		boolean found = false;
		double sx = 0;
		double sy = 0;
		double sz = 0;
		if (Methods.hotWorlds.contains(entity.level.dimension())) {
			if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
				if (y + 1 < 71) {
					if (direction == Direction.UP) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y + 1, z))) {
							world.setBlock(new BlockPos(x, y + 1, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.DOWN) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y - 1, z))) {
							world.setBlock(new BlockPos(x, y - 1, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.SOUTH) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z + 1))) {
							world.setBlock(new BlockPos(x, y, z + 1), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.NORTH) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z - 1))) {
							world.setBlock(new BlockPos(x, y, z - 1), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.EAST) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x + 1, y, z))) {
							world.setBlock(new BlockPos(x + 1, y, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.WEST) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x - 1, y, z))) {
							world.setBlock(new BlockPos(x - 1, y, z), Blocks.WATER.defaultBlockState(), 3);
						}
					}
				}
			} else if ((entity instanceof LivingEntity _livEnt ? _livEnt.getOffhandItem() : ItemStack.EMPTY).getItem() == Items.WATER_BUCKET) {
				if (y + 1 < 71) {
					if (direction == Direction.UP) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y + 1, z))) {
							world.setBlock(new BlockPos(x, y + 1, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.DOWN) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y - 1, z))) {
							world.setBlock(new BlockPos(x, y - 1, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.SOUTH) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z + 1))) {
							world.setBlock(new BlockPos(x, y, z + 1), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.NORTH) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x, y, z - 1))) {
							world.setBlock(new BlockPos(x, y, z - 1), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.EAST) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x + 1, y, z))) {
							world.setBlock(new BlockPos(x + 1, y, z), Blocks.WATER.defaultBlockState(), 3);
						}
					} else if (direction == Direction.WEST) {
						if (!world.canSeeSkyFromBelowWater(new BlockPos(x - 1, y, z))) {
							world.setBlock(new BlockPos(x - 1, y, z), Blocks.WATER.defaultBlockState(), 3);
						}
					}
				}
			}
		}
	}
}
