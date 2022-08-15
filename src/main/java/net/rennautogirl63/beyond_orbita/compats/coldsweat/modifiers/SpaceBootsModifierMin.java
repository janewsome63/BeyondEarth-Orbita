package net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers;

import net.minecraft.world.entity.player.Player;

import java.util.function.Function;

import dev.momostudios.coldsweat.api.temperature.modifier.TempModifier;
import dev.momostudios.coldsweat.api.temperature.Temperature;

public class SpaceBootsModifierMin extends TempModifier {
	@Override
	public Function<Temperature, Temperature> calculate(Player player) {
		return temp -> temp.add(-0.335);
	}

	@Override
	public String getID() {
		return "beyond_orbita:space_boots_modifier_min";
	}
}
