package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.init;

import dev.momostudios.coldsweat.api.event.core.TempModifierRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.*;

@Mod.EventBusSubscriber
public class RegisterModifiers {
    @SubscribeEvent
    public static void onModifiersRegister(TempModifierRegisterEvent event) {
        event.register(new OxygenMaskModifierMax());
        event.register(new OxygenMaskModifierMin());
        event.register(new SpaceSuitModifierMax());
        event.register(new SpaceSuitModifierMin());
        event.register(new SpacePantsModifierMax());
        event.register(new SpacePantsModifierMin());
        event.register(new SpaceBootsModifierMax());
        event.register(new SpaceBootsModifierMin());
        event.register(new AdvancedOxygenMaskModifierMax());
        event.register(new AdvancedOxygenMaskModifierMin());
        event.register(new AdvancedSpaceSuitModifierMax());
        event.register(new AdvancedSpaceSuitModifierMin());
        event.register(new AdvancedSpacePantsModifierMax());
        event.register(new AdvancedSpacePantsModifierMin());
        event.register(new AdvancedSpaceBootsModifierMax());
        event.register(new AdvancedSpaceBootsModifierMin());
    }
}
