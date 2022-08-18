package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.pygro.PygroMobsSensor;

public class SensorsRegistry {

    public static final DeferredRegister<SensorType<?>> SENSOR = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, BeyondOrbitaMod.MODID);

    /**
     * SENSORS
     */
    public static final RegistryObject<SensorType<PygroMobsSensor>> PYGRO_SENSOR = SENSOR.register("pygro_sensor", () -> new SensorType<>(PygroMobsSensor::new));
}
