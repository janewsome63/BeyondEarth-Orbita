package net.rennautogirl63.beyond_orbita.entities.renderer.lander;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.LanderEntity;
import net.rennautogirl63.beyond_orbita.entities.renderer.VehicleRenderer;

@OnlyIn(Dist.CLIENT)
public class LanderRenderer extends VehicleRenderer<LanderEntity, LanderModel<LanderEntity>> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/lander.png");

    public LanderRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new LanderModel<>(renderManagerIn.bakeLayer(LanderModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(LanderEntity p_114482_) {
        return TEXTURE;
    }
}