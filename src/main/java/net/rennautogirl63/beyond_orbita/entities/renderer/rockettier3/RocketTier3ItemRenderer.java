package net.rennautogirl63.beyond_orbita.entities.renderer.rockettier3;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.RocketTier3Entity;

@OnlyIn(Dist.CLIENT)
public class RocketTier3ItemRenderer<T extends RocketTier3Entity> extends BlockEntityWithoutLevelRenderer {

    /** TEXTURE */
    public static final ResourceLocation TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/vehicles/rocket_t3.png");

    /** MODEL */
    private RocketTier3Model model;

    public RocketTier3ItemRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
    }

    @Override
    public void renderByItem(ItemStack p_108830_, ItemTransforms.TransformType p_108831_, PoseStack matrixStackIn, MultiBufferSource buffer, int combinedLight, int p_108835_) {
        matrixStackIn.pushPose();

        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(180));
        matrixStackIn.translate(0.0, -1.5, 0.0);

        Minecraft mc = Minecraft.getInstance();

        VertexConsumer vertexBuilder;

        /** TEXTURE BINDING */
        vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(TEXTURE));

        if (this.model == null) {
            this.model = new RocketTier3Model(mc.getEntityModels().bakeLayer(RocketTier3Model.LAYER_LOCATION));
        }

        this.model.renderToBuffer(matrixStackIn, vertexBuilder, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStackIn.popPose();
    }
}