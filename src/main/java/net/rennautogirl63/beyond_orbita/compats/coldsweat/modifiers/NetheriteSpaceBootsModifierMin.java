package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers;

import dev.momostudios.coldsweat.api.temperature.Temperature;
import dev.momostudios.coldsweat.api.temperature.modifier.TempModifier;
import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

public class NetheriteSpaceBootsModifierMin extends TempModifier {
    @Override
    public Function<Temperature, Temperature> calculate(Player player) {
        return temp -> temp.add(-1.17875);
    }

    @Override
    public String getID() {
        return "beyond_orbita:netherite_space_boots_modifier_min";
    }
}
