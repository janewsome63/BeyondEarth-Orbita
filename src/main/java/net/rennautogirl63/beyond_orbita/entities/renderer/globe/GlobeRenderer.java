package net.rennautogirl63.beyond_orbita.entities.renderer.globe;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.globe.GlobeBlock;
import net.rennautogirl63.beyond_orbita.globe.GlobeTileEntity;
import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;
import net.rennautogirl63.beyond_orbita.registries.ItemsRegistry;

@OnlyIn(Dist.CLIENT)
public class GlobeRenderer<T extends GlobeTileEntity> extends BlockEntityWithoutLevelRenderer implements BlockEntityRenderer<GlobeTileEntity>, BlockEntityRendererProvider<T> {

    /**
     * TEXTURES
     */
    public static final ResourceLocation MOON_GLOBE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/blocks/globes/moon_globe.png");
    public static final ResourceLocation MARS_GLOBE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/blocks/globes/mars_globe.png");
    public static final ResourceLocation MERCURY_GLOBE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/blocks/globes/mercury_globe.png");
    public static final ResourceLocation VENUS_GLOBE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/blocks/globes/venus_globe.png");
    public static final ResourceLocation PLUTO_GLOBE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/blocks/globes/pluto_globe.png");

    /**
     * MODELS
     */
    private GlobeModel model;
    private GlobeModel itemModel;

    public GlobeRenderer(BlockEntityRenderDispatcher p_172550_, EntityModelSet p_172551_) {
        super(p_172550_, p_172551_);
    }

    @Override
    public void render(GlobeTileEntity p_112307_, float particleTicks, PoseStack matrixStackIn, MultiBufferSource buffer, int combinedLight, int p_112312_) {
        if (!(p_112307_.getLevel().getBlockState(p_112307_.getBlockPos()).getBlock() instanceof GlobeBlock)) {
            return;
        }

        Minecraft mc = Minecraft.getInstance();
        BlockState blockstate = p_112307_.getBlockState();
        Direction direction = blockstate.getValue(GlobeBlock.FACING);

        matrixStackIn.pushPose();

        matrixStackIn.translate(0.5D, 1.5D, 0.5D);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(direction.toYRot()));

        VertexConsumer vertexBuilder;

        if (this.model == null) {
            this.model = new GlobeModel(mc.getEntityModels().bakeLayer(GlobeModel.LAYER_LOCATION));
        }

        /** Animation */
        this.model.setupAnim(p_112307_, particleTicks);

        /** TEXTURE BINDING */
        if (blockstate.is(BlocksRegistry.MOON_GLOBE_BLOCK.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MOON_GLOBE));
        } else if (blockstate.is(BlocksRegistry.MARS_GLOBE_BLOCK.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MARS_GLOBE));
        } else if (blockstate.is(BlocksRegistry.MERCURY_GLOBE_BLOCK.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MERCURY_GLOBE));
        } else if (blockstate.is(BlocksRegistry.VENUS_GLOBE_BLOCK.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(VENUS_GLOBE));
        } else {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(PLUTO_GLOBE));
        }

        this.model.renderToBuffer(matrixStackIn, vertexBuilder, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStackIn.popPose();
    }

    @Override
    public void renderByItem(ItemStack p_108830_, ItemTransforms.TransformType p_108831_, PoseStack matrixStackIn, MultiBufferSource buffer, int combinedLight, int p_108835_) {
        matrixStackIn.pushPose();

        matrixStackIn.translate(0.5D, 1.5D, 0.5D);
        matrixStackIn.scale(-1.0F, -1.0F, 1.0F);

        Minecraft mc = Minecraft.getInstance();
        ClientLevel level = mc.level;

        VertexConsumer vertexBuilder;

        /** TEXTURE BINDING */
        if (p_108830_.is(ItemsRegistry.MOON_GLOBE_ITEM.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MOON_GLOBE));
        } else if (p_108830_.is(ItemsRegistry.MARS_GLOBE_ITEM.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MARS_GLOBE));
        } else if (p_108830_.is(ItemsRegistry.MERCURY_GLOBE_ITEM.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(MERCURY_GLOBE));
        } else if (p_108830_.is(ItemsRegistry.VENUS_GLOBE_ITEM.get())) {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(VENUS_GLOBE));
        } else {
            vertexBuilder = buffer.getBuffer(RenderType.entityCutoutNoCullZOffset(PLUTO_GLOBE));
        }

        if (this.itemModel == null) {
            this.itemModel = new GlobeModel(mc.getEntityModels().bakeLayer(GlobeModel.LAYER_LOCATION));
        }

        /** Animation */
        if (level != null) {
            if (!mc.isPaused()) {
                itemModel.globe.getChild("planet").yRot = (level.getGameTime() + mc.getFrameTime()) / -20;
            }
        }

        this.itemModel.renderToBuffer(matrixStackIn, vertexBuilder, combinedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);

        matrixStackIn.popPose();
    }

    @Override
    public BlockEntityRenderer<T> create(Context p_173571_) {
        return this::render;
    }
}