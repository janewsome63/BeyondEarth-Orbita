package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.init;

import dev.momostudios.coldsweat.api.registry.TempModifierRegistry;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.*;

public class RegisterModifiers {
    public static void onModifiersRegister() {
        TempModifierRegistry.register(new OxygenMaskModifierMax());
        TempModifierRegistry.register(new OxygenMaskModifierMin());
        TempModifierRegistry.register(new SpaceSuitModifierMax());
        TempModifierRegistry.register(new SpaceSuitModifierMin());
        TempModifierRegistry.register(new SpacePantsModifierMax());
        TempModifierRegistry.register(new SpacePantsModifierMin());
        TempModifierRegistry.register(new SpaceBootsModifierMax());
        TempModifierRegistry.register(new SpaceBootsModifierMin());
        TempModifierRegistry.register(new AdvancedOxygenMaskModifierMax());
        TempModifierRegistry.register(new AdvancedOxygenMaskModifierMin());
        TempModifierRegistry.register(new AdvancedSpaceSuitModifierMax());
        TempModifierRegistry.register(new AdvancedSpaceSuitModifierMin());
        TempModifierRegistry.register(new AdvancedSpacePantsModifierMax());
        TempModifierRegistry.register(new AdvancedSpacePantsModifierMin());
        TempModifierRegistry.register(new AdvancedSpaceBootsModifierMax());
        TempModifierRegistry.register(new AdvancedSpaceBootsModifierMin());
    }
}
