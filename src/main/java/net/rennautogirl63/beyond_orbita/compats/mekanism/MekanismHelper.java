package net.rennautogirl63.beyond_orbita.compats.mekanism;

import mekanism.api.chemical.gas.IGasHandler;
import mekanism.common.capabilities.Capabilities;
import mekanism.common.integration.lookingat.theoneprobe.TOPChemicalElement;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.IOxygenStorage;

import java.util.ArrayList;
import java.util.List;

public class MekanismHelper {

    public static Capability<IGasHandler> getGasHandlerCapability() {
        return Capabilities.GAS_HANDLER_CAPABILITY;
    }

    public static IGasHandler getItemStackGasHandler(ItemStack itemStack) {
        if (itemStack.isEmpty()) {
            return null;
        }

        return itemStack.getCapability(getGasHandlerCapability()).orElse(null);
    }

    public static IOxygenStorage getItemStackOxygenAdapter(ItemStack itemStack) {
        IGasHandler gasHandler = getItemStackGasHandler(itemStack);

        if (gasHandler != null) {
            return new GasHandlerOxygenAdapter(gasHandler, true, true);
        } else {
            return null;
        }
    }

    public static List<TOPChemicalElement> createGasGaugeDataElement(IGasHandler gasHandler) {
        List<TOPChemicalElement> list = new ArrayList<>();

        if (gasHandler != null) {
            int tanks = gasHandler.getTanks();

            for (int i = 0; i < tanks; i++) {
                list.add(TOPChemicalElement.create(gasHandler.getChemicalInTank(i), gasHandler.getTankCapacity(i)));
            }
        }

        return list;
    }
}