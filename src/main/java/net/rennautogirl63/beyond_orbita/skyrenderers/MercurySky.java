package net.rennautogirl63.beyond_orbita.skyrenderers;

import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;

import javax.annotation.Nullable;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.platform.GlStateManager;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.skyrenderers.helper.StarHelper;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class MercurySky {

    private static final ResourceLocation DIM_RENDER_INFO = new ResourceLocation(BeyondOrbitaMod.MODID, "mercury");

    @Nullable
    public static VertexBuffer starBuffer;
    private static final ResourceLocation SUN_TEXTURES = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/no_a_sun.png");

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void clientSetup(FMLClientSetupEvent event) {
        DimensionSpecialEffects.EFFECTS.put(DIM_RENDER_INFO, new DimensionSpecialEffects(192, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {
            @Override
            public Vec3 getBrightnessDependentFogColor(Vec3 p_108878_, float p_108879_) {
                return new Vec3(0.572549019608, 0.082352941176, 0.082352941176);
            }

            @Override
            public boolean isFoggyAt(int p_108874_, int p_108875_) {
                return false;
            }

            @Override
            public ICloudRenderHandler getCloudRenderHandler() {
                return new ICloudRenderHandler() {
                    @Override
                    public void render(int ticks, float partialTicks, PoseStack matrixStack, ClientLevel world, Minecraft mc, double viewEntityX, double viewEntityY, double viewEntityZ) {

                    }
                };
            }

            @Override
            public ISkyRenderHandler getSkyRenderHandler() {
                return new ISkyRenderHandler() {
                    @Override
                    public void render(int ticks, float p_181412_, PoseStack p_181410_, ClientLevel level, Minecraft minecraft) {
                        Camera camera = minecraft.gameRenderer.getMainCamera();
                        FogType fogtype = camera.getFluidInCamera();

                        if (fogtype != FogType.POWDER_SNOW && fogtype != FogType.LAVA) {
                            Entity entity = camera.getEntity();
                            if (entity instanceof LivingEntity) {
                                LivingEntity livingentity = (LivingEntity) entity;
                                if (livingentity.hasEffect(MobEffects.BLINDNESS)) {
                                    return;
                                }
                            }

                            Matrix4f matrix4f = RenderSystem.getProjectionMatrix();
                            Matrix4f starMatrix4f = RenderSystem.getProjectionMatrix();
                            RenderSystem.disableTexture();
                            Vec3 vec3 = level.getSkyColor(minecraft.gameRenderer.getMainCamera().getPosition(), p_181412_);
                            float f = (float) vec3.x;
                            float f1 = (float) vec3.y;
                            float f2 = (float) vec3.z;
                            FogRenderer.levelFogColor();
                            BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
                            RenderSystem.depthMask(false);
                            RenderSystem.setShaderColor(f, f1, f2, 1.0F);
                            ShaderInstance shaderinstance = RenderSystem.getShader();
                            minecraft.levelRenderer.skyBuffer.drawWithShader(p_181410_.last().pose(), matrix4f, shaderinstance);

                            /** ENABLE BLEND SYSTEM */
                            RenderSystem.enableBlend();
                            RenderSystem.defaultBlendFunc();

                            /** COLOR SYSTEM */
                            float[] afloat = level.effects().getSunriseColor(level.getTimeOfDay(p_181412_), p_181412_);
                            if (afloat != null) {
                                RenderSystem.setShader(GameRenderer::getPositionColorShader);
                                RenderSystem.disableTexture();
                                RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                                p_181410_.pushPose();
                                p_181410_.mulPose(Vector3f.XP.rotationDegrees(90.0F));
                                float f3 = Mth.sin(level.getSunAngle(p_181412_)) < 0.0F ? 180.0F : 0.0F;
                                p_181410_.mulPose(Vector3f.ZP.rotationDegrees(f3));
                                p_181410_.mulPose(Vector3f.ZP.rotationDegrees(90.0F));
                                float f4 = afloat[0];
                                float f5 = afloat[1];
                                float f6 = afloat[2];
                                matrix4f = p_181410_.last().pose();
                                bufferbuilder.begin(VertexFormat.Mode.TRIANGLE_FAN, DefaultVertexFormat.POSITION_COLOR);
                                bufferbuilder.vertex(matrix4f, 0.0F, 100.0F, 0.0F).color(f4, f5, f6, afloat[3]).endVertex();

                                for (int j = 0; j <= 16; ++j) {
                                    float f7 = (float) j * ((float) Math.PI * 2F) / 16.0F;
                                    float f8 = Mth.sin(f7);
                                    float f9 = Mth.cos(f7);
                                    bufferbuilder.vertex(matrix4f, f8 * 120.0F, f9 * 120.0F, -f9 * 40.0F * afloat[3]).color(afloat[0], afloat[1], afloat[2], 0.0F).endVertex();
                                }

                                bufferbuilder.end();
                                BufferUploader.end(bufferbuilder);
                                p_181410_.popPose();
                            }

                            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);

                            p_181410_.pushPose();
                            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                            RenderSystem.enableTexture();

                            /** DEFAULT ROT */
                            p_181410_.mulPose(Vector3f.YP.rotationDegrees(-90.0F));
                            p_181410_.mulPose(Vector3f.XP.rotationDegrees(level.getTimeOfDay(p_181412_) * 360.0F));
                            Matrix4f matrix4f1 = p_181410_.last().pose();

                            RenderSystem.setShader(GameRenderer::getPositionTexShader);

                            /** SUN */
                            float f12 = 60.0F;

                            RenderSystem.setShaderTexture(0, SUN_TEXTURES);
                            bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
                            bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
                            bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
                            bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
                            bufferbuilder.end();
                            BufferUploader.end(bufferbuilder);

                            RenderSystem.disableTexture();

                            /** STAR */
                            starBuffer = StarHelper.createStars(starBuffer, 0.1F, 6000, 13000, 160, 190, -1);
                            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                            FogRenderer.setupNoFog();
                            starBuffer.drawWithShader(p_181410_.last().pose(), starMatrix4f, GameRenderer.getPositionColorShader());

                            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                            RenderSystem.disableBlend();
                            p_181410_.popPose();

                            /** CUT AWAY SYSTEM */
                            RenderSystem.disableTexture();
                            RenderSystem.setShaderColor(0.0F, 0.0F, 0.0F, 1.0F);

                            double d0 = minecraft.player.getEyePosition(p_181412_).y - level.getLevelData().getHorizonHeight(level);

                            if (d0 < 0.0D) {
                                p_181410_.pushPose();
                                p_181410_.translate(0.0D, 12.0D, 0.0D);
                                minecraft.levelRenderer.darkBuffer.drawWithShader(p_181410_.last().pose(), matrix4f, shaderinstance);
                                p_181410_.popPose();
                            }

                            if (level.effects().hasGround()) {
                                RenderSystem.setShaderColor(f * 0.2F + 0.04F, f1 * 0.2F + 0.04F, f2 * 0.6F + 0.1F, 1.0F);
                            } else {
                                RenderSystem.setShaderColor(f, f1, f2, 1.0F);
                            }

                            RenderSystem.enableTexture();
                            RenderSystem.depthMask(true);
                        }
                    }
                };
            }
        });
    }
}
