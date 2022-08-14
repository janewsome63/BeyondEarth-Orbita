package net.rennautogirl63.beyond_orbita.entities.renderer.mogler;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.MoglerEntity;

@OnlyIn(Dist.CLIENT)
public class MoglerRenderer extends MobRenderer<MoglerEntity, MoglerModel<MoglerEntity>> {
    private static final ResourceLocation HOGLIN_LOCATION = new ResourceLocation(BeyondOrbitaMod.MODID,"textures/entities/mogler_entity.png");

    public MoglerRenderer(EntityRendererProvider.Context p_174165_) {
        super(p_174165_, new MoglerModel<>(p_174165_.bakeLayer(MoglerModel.LAYER_LOCATION)), 0.7F);
    }

    public ResourceLocation getTextureLocation(MoglerEntity p_114862_) {
        return HOGLIN_LOCATION;
    }

    protected boolean isShaking(MoglerEntity p_114864_) {
        return super.isShaking(p_114864_) || p_114864_.isConverting();
    }
}