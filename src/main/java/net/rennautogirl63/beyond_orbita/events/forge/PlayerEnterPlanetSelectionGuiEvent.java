package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.rennautogirl63.beyond_orbita.entities.IRocketEntity;

public class PlayerEnterPlanetSelectionGuiEvent extends PlayerEvent {

    private IRocketEntity rocket;

    public PlayerEnterPlanetSelectionGuiEvent(Player player, IRocketEntity rocket) {
        super(player);
        this.rocket = rocket;
    }

    public IRocketEntity getRocket() {
        return rocket;
    }
}