package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.guis.screens.coalgenerator.CoalGeneratorGui;
import net.rennautogirl63.beyond_orbita.guis.screens.compressor.CompressorGui;
import net.rennautogirl63.beyond_orbita.guis.screens.fuelrefinery.FuelRefineryGui;
import net.rennautogirl63.beyond_orbita.guis.screens.lander.LanderGui;
import net.rennautogirl63.beyond_orbita.guis.screens.nasaworkbench.NasaWorkbenchGui;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenbubbledistributor.OxygenBubbleDistributorGui;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenloader.OxygenLoaderGui;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.PlanetSelectionGui;
import net.rennautogirl63.beyond_orbita.guis.screens.rocket.RocketGui;
import net.rennautogirl63.beyond_orbita.guis.screens.rover.RoverGui;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.SolarPanelGui;
import net.rennautogirl63.beyond_orbita.guis.screens.waterpump.WaterPumpGui;

public class ScreensRegistry {

    public static final DeferredRegister<MenuType<?>> SCREENS = DeferredRegister.create(ForgeRegistries.CONTAINERS, BeyondOrbitaMod.MODID);

    /** SCREENS */
    public static final RegistryObject<MenuType<RocketGui.GuiContainer>> ROCKET_GUI = SCREENS.register("rocket_gui", () -> new MenuType(new RocketGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<CompressorGui.GuiContainer>> COMPRESSOR_GUI = SCREENS.register("compressor_gui", () -> new MenuType(new CompressorGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<FuelRefineryGui.GuiContainer>> FUEL_REFINERY_GUI = SCREENS.register("fuel_refinery_gui", () -> new MenuType(new FuelRefineryGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<CoalGeneratorGui.GuiContainer>> COAL_GENERATOR_GUI = SCREENS.register("coal_generator_gui", () -> new MenuType(new CoalGeneratorGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<NasaWorkbenchGui.GuiContainer>> NASA_WORKBENCH_GUI = SCREENS.register("nasa_workbench_gui", () -> new MenuType(new NasaWorkbenchGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<OxygenLoaderGui.GuiContainer>> OXYGEN_LOADER_GUI = SCREENS.register("oxygen_loader_gui", () -> new MenuType(new OxygenLoaderGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<SolarPanelGui.GuiContainer>> SOLAR_PANEL_GUI = SCREENS.register("solar_panel_gui", () -> new MenuType(new SolarPanelGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<WaterPumpGui.GuiContainer>> WATER_PUMP_GUI = SCREENS.register("water_pump_gui", () -> new MenuType(new WaterPumpGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<OxygenBubbleDistributorGui.GuiContainer>> OXYGEN_BUBBLE_DISTRIBUTOR_GUI = SCREENS.register("oxygen_bubble_distributor_gui", () -> new MenuType(new OxygenBubbleDistributorGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<LanderGui.GuiContainer>> LANDER_GUI = SCREENS.register("lander_gui", () -> new MenuType(new LanderGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<RoverGui.GuiContainer>> ROVER_GUI = SCREENS.register("rover_gui", () -> new MenuType(new RoverGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<PlanetSelectionGui.GuiContainer>> PLANET_SELECTION_GUI = SCREENS.register("planet_selection_gui", () -> new MenuType(new PlanetSelectionGui.GuiContainerFactory()));
}
