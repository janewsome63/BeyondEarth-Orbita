package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraftforge.event.entity.EntityEvent;
import net.rennautogirl63.beyond_orbita.entities.IRocketEntity;

public class PlaceRocketEvent extends EntityEvent {

    private final UseOnContext context;

    public PlaceRocketEvent(IRocketEntity entity, UseOnContext context) {
        super(entity);
        this.context = context;
    }

    public UseOnContext getContext() {
        return context;
    }
}