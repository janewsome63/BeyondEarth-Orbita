package net.rennautogirl63.beyond_orbita.machines.tile;

import java.util.List;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.energy.IEnergyStorage;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.IOxygenStorage;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.OxygenUtil;
import net.rennautogirl63.beyond_orbita.crafting.BeyondEarthRecipeType;
import net.rennautogirl63.beyond_orbita.crafting.BeyondEarthRecipeTypes;
import net.rennautogirl63.beyond_orbita.crafting.OxygenMakingRecipeAbstract;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenloader.OxygenLoaderGui;
import net.rennautogirl63.beyond_orbita.registries.BlockEntitiesRegistry;

public class OxygenLoaderBlockEntity extends OxygenMakingBlockEntity {

	public static final int ENERGY_PER_TICK = 1;
	public static final int SLOT_OUTPUT_SINK = 2;
	public static final int SLOT_OUTPUT_SOURCE = 3;

	public OxygenLoaderBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesRegistry.OXYGEN_LOADER_BLOCK_ENTITY.get(), pos, state);
	}

	@Override
	protected void drainSources() {
		super.drainSources();
		OxygenUtil.drainSource(this.getItemHandler(), this.getOutputSourceSlot(), this.getOutputTank(), this.getTransferPerTick());
	}

	@Override
	protected void fillSinks() {
		super.fillSinks();
		OxygenUtil.fillSink(this.getItemHandler(), this.getOutputSinkSlot(), this.getOutputTank(), this.getTransferPerTick());
	}

	@Override
	protected boolean onCanPlaceItemThroughFace(int index, ItemStack stack, Direction direction) {
		if (index == this.getOutputSourceSlot()) {
			return OxygenUtil.canExtract(stack);
		} else if (index == this.getOutputSinkSlot()) {
			return OxygenUtil.canReceive(stack);
		}

		return super.onCanPlaceItemThroughFace(index, stack, direction);
	}

	@Override
	public boolean canTakeItemThroughFace(int index, ItemStack stack, Direction direction) {
		if (index == this.getOutputSourceSlot()) {
			return !OxygenUtil.canExtract(stack);
		} else if (index == this.getOutputSinkSlot()) {
			return !OxygenUtil.canReceive(stack);
		}

		return super.canTakeItemThroughFace(index, stack, direction);
	}

	@Override
	protected void getSlotsForFace(Direction direction, List<Integer> slots) {
		super.getSlotsForFace(direction, slots);
		slots.add(this.getOutputSourceSlot());
		slots.add(this.getOutputSinkSlot());
	}

	@Override
	public AbstractContainerMenu createMenu(int id, Inventory inventory) {
		return new OxygenLoaderGui.GuiContainer(id, inventory, this);
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
				return OxygenLoaderBlockEntity.this.getBasePowerForOperation();
			}
		});
	}

	public int getBasePowerForOperation() {
		return ENERGY_PER_TICK;
	}

	@Override
	public BeyondEarthRecipeType<? extends OxygenMakingRecipeAbstract> getRecipeType() {
		return BeyondEarthRecipeTypes.OXYGEN_LOADING;
	}

	@Override
	protected int getInitialInventorySize() {
		return super.getInitialInventorySize() + 2;
	}

	public boolean isSourceSlot(int slot) {
		return slot == this.getOutputSourceSlot() || super.isSourceSlot(slot);
	}

	public boolean isSinkSlot(int slot) {
		return slot == this.getOutputSinkSlot() || super.isSinkSlot(slot);
	}

	public IOxygenStorage slotToOxygenTank(int slot) {
		if (slot == this.getOutputSourceSlot() || slot == this.getOutputSinkSlot()) {
			return this.getOutputTank();
		} else {
			return super.slotToOxygenTank(slot);
		}
	}

	public ResourceLocation slotToTankName(int slot) {
		if (slot == this.getOutputSourceSlot() || slot == this.getOutputSinkSlot()) {
			return this.getOutputTankName();
		} else {
			return super.slotToTankName(slot);
		}
	}

	public int getOutputSourceSlot() {
		return SLOT_OUTPUT_SOURCE;
	}

	public int getOutputSinkSlot() {
		return SLOT_OUTPUT_SINK;
	}
}
