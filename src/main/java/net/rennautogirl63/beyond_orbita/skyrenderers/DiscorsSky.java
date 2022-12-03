package net.rennautogirl63.beyond_orbita.skyrenderers;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.*;
import com.mojang.math.Matrix4f;
import com.mojang.math.Vector3f;
import net.minecraft.client.Camera;
import net.minecraft.client.CloudStatus;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.ShaderInstance;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.material.FogType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ICloudRenderHandler;
import net.minecraftforge.client.ISkyRenderHandler;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

@Mod.EventBusSubscriber(modid = BeyondOrbitaMod.MODID, bus = Bus.MOD, value = Dist.CLIENT)
public class DiscorsSky {

    private static final ResourceLocation DIM_RENDER_INFO = new ResourceLocation(BeyondOrbitaMod.MODID, "discors");

    private static final ResourceLocation SUN_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/red_sun.png");
    private static final ResourceLocation CLOUD_TEXTURE = new ResourceLocation("textures/environment/clouds.png");

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void clientSetup(FMLClientSetupEvent event) {
        DimensionSpecialEffects.EFFECTS.put(DIM_RENDER_INFO, new DimensionSpecialEffects(192, true, DimensionSpecialEffects.SkyType.NORMAL, false, false) {
            public Vec3 getBrightnessDependentFogColor(Vec3 p_108878_, float p_108879_) {
                return p_108878_.multiply(p_108879_ * 0.867058823529 + 0.03, p_108879_ * 0.770980392157 + 0.03, p_108879_ * 0.494901960784 + 0.06);
            }

            public boolean isFoggyAt(int p_108874_, int p_108875_) {
                return false;
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
                                int i = 16;

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
                            if (level.rainLevel == 0) {
                                float f12 = 96.25F;

                                RenderSystem.setShaderTexture(0, SUN_TEXTURE);
                                bufferbuilder.begin(VertexFormat.Mode.QUADS, DefaultVertexFormat.POSITION_TEX);
                                bufferbuilder.vertex(matrix4f1, -f12, 100.0F, -f12).uv(0.0F, 0.0F).endVertex();
                                bufferbuilder.vertex(matrix4f1, f12, 100.0F, -f12).uv(1.0F, 0.0F).endVertex();
                                bufferbuilder.vertex(matrix4f1, f12, 100.0F, f12).uv(1.0F, 1.0F).endVertex();
                                bufferbuilder.vertex(matrix4f1, -f12, 100.0F, f12).uv(0.0F, 1.0F).endVertex();
                                bufferbuilder.end();
                                BufferUploader.end(bufferbuilder);
                            }

                            /** MOON */
                            int k = minecraft.level.getMoonPhase();
                            int l = k % 4;
                            int i1 = k / 4 % 2;
                            float f13 = (float) (l + 0) / 4.0F;
                            float f14 = (float) (i1 + 0) / 2.0F;
                            float f15 = (float) (l + 1) / 4.0F;
                            float f16 = (float) (i1 + 1) / 2.0F;

                            /** STAR */
                            float f10 = level.getStarBrightness(p_181412_) * 1;
                            if (f10 > 0.0F) {
                                RenderSystem.setShaderColor(f10, f10, f10, f10);
                                FogRenderer.setupNoFog();
                                minecraft.levelRenderer.starBuffer.drawWithShader(p_181410_.last().pose(), starMatrix4f, GameRenderer.getPositionShader());
                            }

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
            @Override
            public ICloudRenderHandler getCloudRenderHandler() {
                return new ICloudRenderHandler() {
                    @Override
                    public void render(int ticks, float p_172957_, PoseStack p_172955_, ClientLevel level, Minecraft minecraft, double p_172958_, double p_172959_, double p_172960_) {
                        float f = level.effects().getCloudHeight();
                        if (!Float.isNaN(f)) {
                            RenderSystem.disableCull();
                            RenderSystem.enableBlend();
                            RenderSystem.enableDepthTest();
                            RenderSystem.blendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
                            RenderSystem.depthMask(true);
                            float f1 = 12.0F;
                            float f2 = 4.0F;
                            double d0 = 2.0E-4D;
                            double d1 = (double) (((float) ticks + p_172957_) * 0.03F);
                            double d2 = (p_172958_ + d1) / 12.0D;
                            double d3 = (double) (f - (float) p_172959_ + 0.33F);
                            double d4 = p_172960_ / 12.0D + (double) 0.33F;
                            d2 -= (double) (Mth.floor(d2 / 2048.0D) * 2048);
                            d4 -= (double) (Mth.floor(d4 / 2048.0D) * 2048);
                            float f3 = (float) (d2 - (double) Mth.floor(d2));
                            float f4 = (float) (d3 / 4.0D - (double) Mth.floor(d3 / 4.0D)) * 4.0F;
                            float f5 = (float) (d4 - (double) Mth.floor(d4));
                            Vec3 vec3 = level.getCloudColor(p_172957_);
                            int i = (int) Math.floor(d2);
                            int j = (int) Math.floor(d3 / 4.0D);
                            int k = (int) Math.floor(d4);
                            if (i != minecraft.levelRenderer.prevCloudX || j != minecraft.levelRenderer.prevCloudY || k != minecraft.levelRenderer.prevCloudZ || minecraft.options.getCloudsType() != minecraft.levelRenderer.prevCloudsType || minecraft.levelRenderer.prevCloudColor.distanceToSqr(vec3) > 2.0E-4D) {
                                minecraft.levelRenderer.prevCloudX = i;
                                minecraft.levelRenderer.prevCloudY = j;
                                minecraft.levelRenderer.prevCloudZ = k;
                                minecraft.levelRenderer.prevCloudColor = vec3;
                                minecraft.levelRenderer.prevCloudsType = minecraft.options.getCloudsType();
                                minecraft.levelRenderer.generateClouds = true;
                            }

                            if (minecraft.levelRenderer.generateClouds) {
                                minecraft.levelRenderer.generateClouds = false;
                                BufferBuilder bufferbuilder = Tesselator.getInstance().getBuilder();
                                if (minecraft.levelRenderer.cloudBuffer != null) {
                                    minecraft.levelRenderer.cloudBuffer.close();
                                }

                                minecraft.levelRenderer.cloudBuffer = new VertexBuffer();
                                minecraft.levelRenderer.buildClouds(bufferbuilder, d2, d3, d4, vec3);
                                bufferbuilder.end();
                                minecraft.levelRenderer.cloudBuffer.upload(bufferbuilder);
                            }

                            RenderSystem.setShader(GameRenderer::getPositionTexColorNormalShader);
                            RenderSystem.setShaderTexture(0, CLOUD_TEXTURE);
                            FogRenderer.levelFogColor();
                            p_172955_.pushPose();
                            p_172955_.scale(12.0F, 1.0F, 12.0F);
                            p_172955_.translate((double) (-f3), (double) f4, (double) (-f5));
                            if (minecraft.levelRenderer.cloudBuffer != null) {
                                int i1 = minecraft.levelRenderer.prevCloudsType == CloudStatus.FANCY ? 0 : 1;

                                for (int l = i1; l < 2; ++l) {
                                    if (l == 0) {
                                        RenderSystem.colorMask(false, false, false, false);
                                    } else {
                                        RenderSystem.colorMask(true, true, true, true);
                                    }

                                    ShaderInstance shaderinstance = RenderSystem.getShader();
                                    minecraft.levelRenderer.cloudBuffer.drawWithShader(p_172955_.last().pose(), RenderSystem.getProjectionMatrix(), shaderinstance);
                                }
                            }

                            p_172955_.popPose();
                            RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
                            RenderSystem.enableCull();
                            RenderSystem.disableBlend();
                        }
                    }
                };
            }
        });
    }
}
