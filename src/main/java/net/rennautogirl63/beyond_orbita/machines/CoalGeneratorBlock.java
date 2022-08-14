package net.rennautogirl63.beyond_orbita.machines;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import net.rennautogirl63.beyond_orbita.gauge.GaugeValueHelper;
import net.rennautogirl63.beyond_orbita.machines.tile.CoalGeneratorBlockEntity;

public class CoalGeneratorBlock extends AbstractMachineBlock<CoalGeneratorBlockEntity> {

	public CoalGeneratorBlock(BlockBehaviour.Properties properties) {
		super(properties);
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter level, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, level, list, flag);
		list.add(GaugeTextHelper.buildBlockTooltip(GaugeTextHelper.getGeneratingPerTickText(GaugeValueHelper.getEnergy(CoalGeneratorBlockEntity.ENERGY_PER_TICK))));
	}

	@Override
	protected boolean useFacing() {
		return true;
	}

	@Override
	protected boolean useLit() {
		return true;
	}

	@Override
	public CoalGeneratorBlockEntity newBlockEntity(BlockPos pos, BlockState state) {
		return new CoalGeneratorBlockEntity(pos, state);
	}

}
