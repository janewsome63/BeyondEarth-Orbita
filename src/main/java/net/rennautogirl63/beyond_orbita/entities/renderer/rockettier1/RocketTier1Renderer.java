package net.rennautogirl63.beyond_orbita.entities.renderer.rockettier1;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.RocketTier1Entity;
import net.rennautogirl63.beyond_orbita.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class RocketTier1Renderer extends VehicleRenderer<RocketTier1Entity, RocketTier1Model<RocketTier1Entity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/rocket_t1.png");

    public RocketTier1Renderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new RocketTier1Model<>(renderManagerIn.bakeLayer(RocketTier1Model.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(RocketTier1Entity p_114482_) {
        return TEXTURE;
    }
}