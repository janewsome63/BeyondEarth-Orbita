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
        event.register(new NetheriteOxygenMaskModifierMax());
        event.register(new NetheriteOxygenMaskModifierMin());
        event.register(new NetheriteSpaceSuitModifierMax());
        event.register(new NetheriteSpaceSuitModifierMin());
        event.register(new NetheriteSpacePantsModifierMax());
        event.register(new NetheriteSpacePantsModifierMin());
        event.register(new NetheriteSpaceBootsModifierMax());
        event.register(new NetheriteSpaceBootsModifierMin());
    }
}
