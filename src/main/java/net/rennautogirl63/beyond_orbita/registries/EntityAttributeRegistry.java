package net.rennautogirl63.beyond_orbita.registries;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.MartianRaptor;
import net.rennautogirl63.beyond_orbita.entities.MoglerEntity;
import net.rennautogirl63.beyond_orbita.entities.PygroBruteEntity;
import net.rennautogirl63.beyond_orbita.entities.StarCrawlerEntity;
import net.rennautogirl63.beyond_orbita.entities.alien.AlienEntity;
import net.rennautogirl63.beyond_orbita.entities.pygro.PygroEntity;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EntityAttributeRegistry {

    @SubscribeEvent
    public static void defaultAttributes(EntityAttributeCreationEvent event) {
        event.put(EntitiesRegistry.ALIEN.get(), AlienEntity.setCustomAttributes().build());
        event.put(EntitiesRegistry.PYGRO.get(), PygroEntity.setCustomAttributes().build());
        event.put(EntitiesRegistry.PYGRO_BRUTE.get(), PygroBruteEntity.setCustomAttributes().build());
        event.put(EntitiesRegistry.MOGLER.get(), MoglerEntity.setCustomAttributes().build());
        event.put(EntitiesRegistry.MARTIAN_RAPTOR.get(), MartianRaptor.setCustomAttributes().build());
        event.put(EntitiesRegistry.STAR_CRAWLER.get(), StarCrawlerEntity.setCustomAttributes().build());
    }
}
