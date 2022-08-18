package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraftforge.energy.IEnergyStorage;

public abstract class PowerSystemEnergyCommon extends PowerSystemEnergy {

    public PowerSystemEnergyCommon(AbstractMachineBlockEntity blockEntity) {
        super(blockEntity);
    }

    public PowerSystemEnergyCommon(AbstractMachineBlockEntity blockEntity, IEnergyStorage energyStorage) {
        super(blockEntity, energyStorage);
    }

    @Override
    public int getBasePowerPerTick() {
        return 0;
    }

}
