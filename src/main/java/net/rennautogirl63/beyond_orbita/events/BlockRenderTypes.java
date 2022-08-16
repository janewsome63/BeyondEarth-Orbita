package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class BlockRenderTypes {
    @SubscribeEvent
    public static void init(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.SULPHUR_ORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.CHROMITE_ORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.DEEPSLATE_CHROMITE_ORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.BAUXITE_ORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.DEEPSLATE_BAUXITE_ORE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(BlocksRegistry.DEEPSLATE_TITANIUM_ORE.get(), RenderType.cutout());
    }
}