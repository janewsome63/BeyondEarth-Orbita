package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers;

import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

import dev.momostudios.coldsweat.api.temperature.modifier.TempModifier;
import dev.momostudios.coldsweat.api.temperature.Temperature;

public class NetheriteSpacePantsModifierMax extends TempModifier {
	@Override
	public Function<Temperature, Temperature> calculate(Player player) {
		return temp -> temp.add(3.795);
	}

	@Override
	public String getID() {
		return "beyond_orbita:netherite_space_pants_modifier_max";
	}
}
