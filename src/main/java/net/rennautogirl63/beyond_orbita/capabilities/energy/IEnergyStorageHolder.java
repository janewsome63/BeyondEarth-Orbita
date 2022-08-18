package net.rennautogirl63.beyond_orbita.capabilities.energy;

import net.minecraftforge.energy.IEnergyStorage;

public interface IEnergyStorageHolder {

    void onEnergyChanged(IEnergyStorage energyStorage, int energyDelta);

}
