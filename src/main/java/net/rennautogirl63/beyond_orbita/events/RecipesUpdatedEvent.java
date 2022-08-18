package net.rennautogirl63.beyond_orbita.events;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.alien.AlienTrade;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RecipesUpdatedEvent {

    @SubscribeEvent
    public static void onRecipesUpdated(net.minecraftforge.client.event.RecipesUpdatedEvent event) {
        AlienTrade.registerTrades(event.getRecipeManager());
    }
}
