package net.rennautogirl63.beyond_orbita;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.rennautogirl63.beyond_orbita.compats.CompatibleManager;
import net.rennautogirl63.beyond_orbita.config.Config;
import net.rennautogirl63.beyond_orbita.registries.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(BeyondOrbitaMod.MODID)
public class BeyondOrbitaMod {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "beyond_orbita";

    public BeyondOrbitaMod() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);

        /** CONFIG REGISTRIES */
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC, "beyond_orbita-common.toml");

        /** NETWORK REGISTRIES */
        NetworksRegistry.register();

        /** COMPAT REGISTRIES */
        CompatibleManager.visit();

        /** DEFAULT REGISTRIES */
        ItemsRegistry.ITEMS.register(bus);
        BlocksRegistry.BLOCKS.register(bus);
        FluidsRegistry.FLUIDS.register(bus);
        EntitiesRegistry.ENTITIES.register(bus);
        BlockEntitiesRegistry.BLOCK_ENTITIES.register(bus);
        RocketPartsRegistry.ROCKET_PARTS.register(bus);
        SensorsRegistry.SENSOR.register(bus);
        RecipeSerializersRegistry.RECIPE_SERIALIZERS.register(bus);
        SoundsRegistry.SOUNDS.register(bus);
        EffectsRegistry.EFFECTS.register(bus);
        ParticlesRegistry.PARTICLES.register(bus);
        ScreensRegistry.SCREENS.register(bus);
        StructuresRegistry.STRUCTURES.register(bus);
        FeatureRegistry.FEATURES.register(bus);
        FeatureRegistry.CONFIGURED_FEATURES.register(bus);
        FeatureRegistry.PLACED_FEATURES.register(bus);
    }
}
