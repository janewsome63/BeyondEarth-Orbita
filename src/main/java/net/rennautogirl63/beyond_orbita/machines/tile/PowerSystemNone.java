package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

public class PowerSystemNone extends PowerSystem {
	public PowerSystemNone(AbstractMachineBlockEntity blockEntity) {
		super(blockEntity);
	}

	@Override
	public int getBasePowerPerTick() {
		return 0;
	}

	@Override
	public int getBasePowerForOperation() {
		return 0;
	}

	@Override
	public int getStored() {
		return 0;
	}

	@Override
	public int getCapacity() {
		return 0;
	}

	@Override
	public int receive(int amount, boolean simulate) {
		return 0;
	}

	@Override
	public int extract(int amount, boolean simulate) {
		return 0;
	}

	@Override
	public ResourceLocation getName() {
		return new ResourceLocation(BeyondOrbitaMod.MODID, "none");
	}
}
