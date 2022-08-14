package net.rennautogirl63.beyond_orbita.entities.renderer.rockettier3;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.RocketTier3Entity;
import net.rennautogirl63.beyond_orbita.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class RocketTier3Renderer extends VehicleRenderer<RocketTier3Entity, RocketTier3Model<RocketTier3Entity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/rocket_t3.png");

    public RocketTier3Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new RocketTier3Model<>(renderManagerIn.bakeLayer(RocketTier3Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RocketTier3Entity p_114482_) {
        return TEXTURE;
    }
}