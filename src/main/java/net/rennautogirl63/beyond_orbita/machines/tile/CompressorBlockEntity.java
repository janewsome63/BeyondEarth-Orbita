package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.IEnergyStorage;
import net.rennautogirl63.beyond_orbita.crafting.BeyondEarthRecipeTypes;
import net.rennautogirl63.beyond_orbita.crafting.ItemStackToItemStackRecipeType;
import net.rennautogirl63.beyond_orbita.guis.screens.compressor.CompressorGui;
import net.rennautogirl63.beyond_orbita.registries.BlockEntitiesRegistry;

public class CompressorBlockEntity extends ItemStackToItemStackBlockEntity {

	public static final int ENERGY_PER_TICK = 1;

	public CompressorBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesRegistry.COMPRESSOR_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new CompressorGui.GuiContainer(id, inventory, this);
	}

	@Override
	public ItemStackToItemStackRecipeType<?> getRecipeType() {
		return BeyondEarthRecipeTypes.COMPRESSING;
	}

	@Override
	protected void createEnergyStorages(NamedComponentRegistry<IEnergyStorage> registry) {
		super.createEnergyStorages(registry);
		registry.put(this.createEnergyStorageCommon());
	}

	@Override
	protected void createPowerSystems(PowerSystemRegistry map) {
		super.createPowerSystems(map);
		map.put(new PowerSystemEnergyCommon(this) {
			@Override
			public int getBasePowerForOperation() {
				return CompressorBlockEntity.this.getBasePowerForOperation();
			}
		});
	}

	public int getBasePowerForOperation() {
		return ENERGY_PER_TICK;
	}
}