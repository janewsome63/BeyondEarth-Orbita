package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.entity.player.Player;
import net.minecraftforge.eventbus.api.Event;
import net.rennautogirl63.beyond_orbita.entities.LanderEntity;

public class StartRideLanderEvent extends Event {

    private final LanderEntity landerEntity;
    private final Player player;

    public StartRideLanderEvent(LanderEntity landerEntity, Player player) {
        this.landerEntity = landerEntity;
        this.player = player;
    }

    public LanderEntity getLanderEntity() {
        return landerEntity;
    }

    public Player getPlayer() {
        return player;
    }
}
