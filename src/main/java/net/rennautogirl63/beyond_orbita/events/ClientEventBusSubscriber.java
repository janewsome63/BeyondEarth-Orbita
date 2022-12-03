package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ParticleFactoryRegisterEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.client.gui.OverlayRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.renderer.TileEntityBoxRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.alien.AlienModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.alien.AlienRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.armors.SpaceSuitModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.flag.TileEntityHeadModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.flag.TileEntityHeadRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.globe.GlobeModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.globe.GlobeRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.lander.LanderModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.lander.LanderRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.martianraptor.MartianRaptorModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.martianraptor.MartianRaptorRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.mogler.MoglerModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.mogler.MoglerRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.pygro.PygroModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.pygro.PygroRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.pygrobrute.PygroBruteRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier1.RocketTier1ItemRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier1.RocketTier1Model;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier1.RocketTier1Renderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier2.RocketTier2ItemRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier2.RocketTier2Model;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier2.RocketTier2Renderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier3.RocketTier3ItemRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier3.RocketTier3Model;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier3.RocketTier3Renderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier4.RocketTier4ItemRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier4.RocketTier4Model;
import net.rennautogirl63.beyond_orbita.entities.renderer.rockettier4.RocketTier4Renderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.aatv.AATVItemRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.aatv.AATVModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.aatv.AATVRenderer;
import net.rennautogirl63.beyond_orbita.entities.renderer.starcrawler.StarCrawlerModel;
import net.rennautogirl63.beyond_orbita.entities.renderer.starcrawler.StarCrawlerRenderer;
import net.rennautogirl63.beyond_orbita.guis.screens.coalgenerator.CoalGeneratorGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.fluidoxidizer.FluidOxidizerGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.lander.LanderGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenbubbledistributor.OxygenBubbleDistributorGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.oxygenloader.OxygenLoaderGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.PlanetSelectionGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.rocket.RocketGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.aatv.AATVGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.AdvancedSolarPanelGuiWindow;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.SolarPanelGuiWindow;
import net.rennautogirl63.beyond_orbita.overlays.Overlays;
import net.rennautogirl63.beyond_orbita.particles.*;
import net.rennautogirl63.beyond_orbita.registries.*;
import org.lwjgl.glfw.GLFW;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    public static KeyMapping key1;

    public static final ResourceLocation OXYGEN_BUBBLE = new ResourceLocation(BeyondOrbitaMod.MODID, "entities/tile_entity_box_oxygen_generator");
    public static final GlobeRenderer GLOBE_RENDERER = new GlobeRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());

    public static final RocketTier1ItemRenderer ROCKET_TIER_1_ITEM_RENDERER = new RocketTier1ItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    public static final RocketTier2ItemRenderer ROCKET_TIER_2_ITEM_RENDERER = new RocketTier2ItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    public static final RocketTier3ItemRenderer ROCKET_TIER_3_ITEM_RENDERER = new RocketTier3ItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    public static final RocketTier4ItemRenderer ROCKET_TIER_4_ITEM_RENDERER = new RocketTier4ItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    public static final AATVItemRenderer AATV_ITEM_RENDERER = new AATVItemRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());

    @SubscribeEvent
    public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntitiesRegistry.ALIEN.get(), AlienRenderer::new);
        event.registerEntityRenderer(EntitiesRegistry.STAR_CRAWLER.get(), StarCrawlerRenderer::new);
        event.registerEntityRenderer(EntitiesRegistry.PYGRO.get(), (p_174068_) -> {
            return new PygroRenderer(p_174068_, PygroModel.LAYER_LOCATION, ModelLayers.PIGLIN_INNER_ARMOR, ModelLayers.PIGLIN_OUTER_ARMOR);
        });
        event.registerEntityRenderer(EntitiesRegistry.PYGRO_BRUTE.get(), (p_174068_) -> {
            return new PygroBruteRenderer(p_174068_, PygroModel.LAYER_LOCATION, ModelLayers.PIGLIN_BRUTE_INNER_ARMOR, ModelLayers.PIGLIN_BRUTE_OUTER_ARMOR);
        });
        event.registerEntityRenderer(EntitiesRegistry.MOGLER.get(), MoglerRenderer::new);
        event.registerEntityRenderer(EntitiesRegistry.MARTIAN_RAPTOR.get(), MartianRaptorRenderer::new);
        event.registerEntityRenderer(EntitiesRegistry.TIER_1_ROCKET.get(), RocketTier1Renderer::new);
        event.registerEntityRenderer(EntitiesRegistry.TIER_2_ROCKET.get(), RocketTier2Renderer::new);
        event.registerEntityRenderer(EntitiesRegistry.TIER_3_ROCKET.get(), RocketTier3Renderer::new);
        event.registerEntityRenderer(EntitiesRegistry.TIER_4_ROCKET.get(), RocketTier4Renderer::new);
        event.registerEntityRenderer(EntitiesRegistry.LANDER.get(), LanderRenderer::new);
        event.registerEntityRenderer(EntitiesRegistry.AATV.get(), AATVRenderer::new);

        event.registerBlockEntityRenderer(BlockEntitiesRegistry.OXYGEN_BUBBLE_DISTRIBUTOR_BLOCK_ENTITY.get(), TileEntityBoxRenderer::new);

        event.registerBlockEntityRenderer(BlockEntitiesRegistry.FLAG_BLOCK_ENTITY.get(), TileEntityHeadRenderer::new);
        event.registerBlockEntityRenderer(BlockEntitiesRegistry.GLOBE_BLOCK_ENTITY.get(), GLOBE_RENDERER);
    }

    @SubscribeEvent
    public static void registerEntityRenderingHandler(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(AlienModel.LAYER_LOCATION, AlienModel::createBodyLayer);
        event.registerLayerDefinition(StarCrawlerModel.LAYER_LOCATION, StarCrawlerModel::createBodyLayer);
        event.registerLayerDefinition(PygroModel.LAYER_LOCATION, PygroModel::createBodyLayer);
        event.registerLayerDefinition(MoglerModel.LAYER_LOCATION, MoglerModel::createBodyLayer);
        event.registerLayerDefinition(MartianRaptorModel.LAYER_LOCATION, MartianRaptorModel::createBodyLayer);
        event.registerLayerDefinition(TileEntityHeadModel.LAYER_LOCATION, TileEntityHeadModel::createHumanoidHeadLayer);
        event.registerLayerDefinition(GlobeModel.LAYER_LOCATION, GlobeModel::createLayer);

        event.registerLayerDefinition(RocketTier1Model.LAYER_LOCATION, RocketTier1Model::createBodyLayer);
        event.registerLayerDefinition(RocketTier2Model.LAYER_LOCATION, RocketTier2Model::createBodyLayer);
        event.registerLayerDefinition(RocketTier3Model.LAYER_LOCATION, RocketTier3Model::createBodyLayer);
        event.registerLayerDefinition(RocketTier4Model.LAYER_LOCATION, RocketTier4Model::createBodyLayer);
        event.registerLayerDefinition(LanderModel.LAYER_LOCATION, LanderModel::createBodyLayer);
        event.registerLayerDefinition(AATVModel.LAYER_LOCATION, AATVModel::createBodyLayer);

        event.registerLayerDefinition(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION, SpaceSuitModel.SPACE_SUIT_P1::createBodyLayer);
        event.registerLayerDefinition(SpaceSuitModel.SPACE_SUIT_P2.LAYER_LOCATION, SpaceSuitModel.SPACE_SUIT_P2::createBodyLayer);
    }

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
        //GUIS
        MenuScreens.register(ScreensRegistry.ROCKET_GUI.get(), RocketGuiWindow::new);
        MenuScreens.register(ScreensRegistry.FLUID_OXIDIZER_GUI.get(), FluidOxidizerGuiWindow::new);
        MenuScreens.register(ScreensRegistry.COAL_GENERATOR_GUI.get(), CoalGeneratorGuiWindow::new);
        MenuScreens.register(ScreensRegistry.OXYGEN_LOADER_GUI.get(), OxygenLoaderGuiWindow::new);
        MenuScreens.register(ScreensRegistry.SOLAR_PANEL_GUI.get(), SolarPanelGuiWindow::new);
        MenuScreens.register(ScreensRegistry.ADVANCED_SOLAR_PANEL_GUI.get(), AdvancedSolarPanelGuiWindow::new);
        MenuScreens.register(ScreensRegistry.OXYGEN_BUBBLE_DISTRIBUTOR_GUI.get(), OxygenBubbleDistributorGuiWindow::new);
        MenuScreens.register(ScreensRegistry.LANDER_GUI.get(), LanderGuiWindow::new);
        MenuScreens.register(ScreensRegistry.AATV_GUI.get(), AATVGuiWindow::new);
        MenuScreens.register(ScreensRegistry.PLANET_SELECTION_GUI.get(), PlanetSelectionGuiWindow::new);

        //Key Binding Registrys
        key1 = new KeyMapping("key." + BeyondOrbitaMod.MODID + ".rocket_start", GLFW.GLFW_KEY_SPACE, "key.categories." + BeyondOrbitaMod.MODID);
        ClientRegistry.registerKeyBinding(key1);

        //Fluid Translucent Renderer
        ItemBlockRenderTypes.setRenderLayer(FluidsRegistry.FLOWING_PROPELLANT.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidsRegistry.PROPELLANT_STILL.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(FluidsRegistry.FLOWING_KEROSENE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(FluidsRegistry.KEROSENE_STILL.get(), RenderType.translucent());

        //Block Translucent Renderer
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.COAL_LANTERN_BLOCK.get(), RenderType.translucent());

        //OVERLAY
        OverlayRegistry.registerOverlayTop("warning", Overlays.WARNING);
        OverlayRegistry.registerOverlayTop("rocket_timer", Overlays.ROCKET_TIMER);
        OverlayRegistry.registerOverlayBottom("oxygen_tank", Overlays.OXYGEN_TANK);
        OverlayRegistry.registerOverlayBottom("rocket_height", Overlays.ROCKET_HEIGHT);
    }

    @SubscribeEvent
    public static void registerParticlesFactory(ParticleFactoryRegisterEvent event) {
        Minecraft mc = Minecraft.getInstance();
        mc.particleEngine.register(ParticlesRegistry.VENUS_RAIN_PARTICLE.get(), VenusRainParticle.ParticleFactory::new);
        mc.particleEngine.register(ParticlesRegistry.LARGE_FLAME_PARTICLE.get(), LargeFlameParticle.ParticleFactory::new);
        mc.particleEngine.register(ParticlesRegistry.LARGE_SMOKE_PARTICLE.get(), LargeSmokeParticle.ParticleFactory::new);
        mc.particleEngine.register(ParticlesRegistry.SMALL_FLAME_PARTICLE.get(), SmallFlameParticle.ParticleFactory::new);
        mc.particleEngine.register(ParticlesRegistry.SMALL_SMOKE_PARTICLE.get(), SmallSmokeParticle.ParticleFactory::new);
    }

    @SubscribeEvent
    public static void atlas(TextureStitchEvent.Pre event) {
        event.addSprite(OXYGEN_BUBBLE);
    }
}
