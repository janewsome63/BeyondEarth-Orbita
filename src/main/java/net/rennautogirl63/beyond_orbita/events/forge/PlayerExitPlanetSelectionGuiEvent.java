package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class PlayerExitPlanetSelectionGuiEvent extends PlayerEvent {

    public PlayerExitPlanetSelectionGuiEvent(Player player) {
        super(player);
    }
}