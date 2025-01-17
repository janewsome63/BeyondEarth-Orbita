package net.rennautogirl63.beyond_orbita.registries;

import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.guis.screens.coalgenerator.CoalGeneratorGui;
import net.rennautogirl63.beyond_orbita.guis.screens.fluidoxidizer.FluidOxidizerGui;
import net.rennautogirl63.beyond_orbita.guis.screens.lander.LanderGui;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenbubbledistributor.OxygenBubbleDistributorGui;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenloader.OxygenLoaderGui;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.PlanetSelectionGui;
import net.rennautogirl63.beyond_orbita.guis.screens.rocket.RocketGui;
import net.rennautogirl63.beyond_orbita.guis.screens.aatv.AATVGui;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.AdvancedSolarPanelGui;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.SolarPanelGui;

public class ScreensRegistry {

    public static final DeferredRegister<MenuType<?>> SCREENS = DeferredRegister.create(ForgeRegistries.CONTAINERS, BeyondOrbitaMod.MODID);

    /**
     * SCREENS
     */
    public static final RegistryObject<MenuType<RocketGui.GuiContainer>> ROCKET_GUI = SCREENS.register("rocket_gui", () -> new MenuType(new RocketGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<FluidOxidizerGui.GuiContainer>> FLUID_OXIDIZER_GUI = SCREENS.register("fluid_oxidizer_gui", () -> new MenuType(new FluidOxidizerGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<CoalGeneratorGui.GuiContainer>> COAL_GENERATOR_GUI = SCREENS.register("coal_generator_gui", () -> new MenuType(new CoalGeneratorGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<OxygenLoaderGui.GuiContainer>> OXYGEN_LOADER_GUI = SCREENS.register("oxygen_loader_gui", () -> new MenuType(new OxygenLoaderGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<SolarPanelGui.GuiContainer>> SOLAR_PANEL_GUI = SCREENS.register("solar_panel_gui", () -> new MenuType(new SolarPanelGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<AdvancedSolarPanelGui.GuiContainer>> ADVANCED_SOLAR_PANEL_GUI = SCREENS.register("advanced_solar_panel_gui", () -> new MenuType(new AdvancedSolarPanelGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<OxygenBubbleDistributorGui.GuiContainer>> OXYGEN_BUBBLE_DISTRIBUTOR_GUI = SCREENS.register("oxygen_bubble_distributor_gui", () -> new MenuType(new OxygenBubbleDistributorGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<LanderGui.GuiContainer>> LANDER_GUI = SCREENS.register("lander_gui", () -> new MenuType(new LanderGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<AATVGui.GuiContainer>> AATV_GUI = SCREENS.register("aatv_gui", () -> new MenuType(new AATVGui.GuiContainerFactory()));
    public static final RegistryObject<MenuType<PlanetSelectionGui.GuiContainer>> PLANET_SELECTION_GUI = SCREENS.register("planet_selection_gui", () -> new MenuType(new PlanetSelectionGui.GuiContainerFactory()));
}
