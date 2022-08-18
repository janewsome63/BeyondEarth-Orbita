package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers;

import dev.momostudios.coldsweat.api.temperature.Temperature;
import dev.momostudios.coldsweat.api.temperature.modifier.TempModifier;
import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

public class SpacePantsModifierMin extends TempModifier {
    @Override
    public Function<Temperature, Temperature> calculate(Player player) {
        return temp -> temp.add(-0.67);
    }

    @Override
    public String getID() {
        return "beyond_orbita:space_pants_modifier_min";
    }
}
