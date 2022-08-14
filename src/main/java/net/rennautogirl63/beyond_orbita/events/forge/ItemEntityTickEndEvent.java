package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemEvent;

public class ItemEntityTickEndEvent extends ItemEvent {

    public ItemEntityTickEndEvent(ItemEntity entity) {
        super(entity);
    }
}