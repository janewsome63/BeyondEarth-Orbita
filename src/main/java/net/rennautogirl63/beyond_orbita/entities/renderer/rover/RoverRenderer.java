package net.rennautogirl63.beyond_orbita.entities.renderer.rover;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.RoverEntity;
import net.rennautogirl63.beyond_orbita.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class RoverRenderer extends VehicleRenderer<RoverEntity, RoverModel<RoverEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/rover.png");

    public RoverRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new RoverModel<>(renderManagerIn.bakeLayer(RoverModel.LAYER_LOCATION)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(RoverEntity p_114482_) {
        return TEXTURE;
    }
}