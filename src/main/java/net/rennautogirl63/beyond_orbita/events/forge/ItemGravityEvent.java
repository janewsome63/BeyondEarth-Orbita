package net.rennautogirl63.beyond_orbita.events.forge;

import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemEvent;
import net.minecraftforge.eventbus.api.Cancelable;

@Cancelable
public class ItemGravityEvent extends ItemEvent {

    private double gravity;

    public ItemGravityEvent(ItemEntity itemEntity, double gravity) {
        super(itemEntity);
        this.gravity = gravity;
    }

    public double getGravity() {
        return gravity;
    }
}