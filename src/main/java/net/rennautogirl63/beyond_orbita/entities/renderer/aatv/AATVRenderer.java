package net.rennautogirl63.beyond_orbita.entities.renderer.aatv;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.AATVEntity;
import net.rennautogirl63.beyond_orbita.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class AATVRenderer extends VehicleRenderer<AATVEntity, AATVModel<AATVEntity>> {

    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/aatv.png");

    public AATVRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new AATVModel<>(renderManagerIn.bakeLayer(AATVModel.LAYER_LOCATION)), 0f);
    }

    @Override
    public ResourceLocation getTextureLocation(AATVEntity p_114482_) {
        return TEXTURE;
    }
}