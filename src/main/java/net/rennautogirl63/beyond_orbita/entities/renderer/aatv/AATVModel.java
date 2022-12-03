package net.rennautogirl63.beyond_orbita.entities.renderer.aatv;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.AATVEntity;

@OnlyIn(Dist.CLIENT)
public class AATVModel<T extends AATVEntity> extends EntityModel<T> {

    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BeyondOrbitaMod.MODID, "aatv"), "main");
    private final ModelPart AATV;

    public AATVModel(ModelPart root) {
        this.AATV = root.getChild("AATV");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition AATV = partdefinition.addOrReplaceChild("AATV", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -7.0F));

        PartDefinition Chassis = AATV.addOrReplaceChild("Chassis", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r1 = Chassis.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(107, 4).addBox(-9.0F, -2.0F, -10.0F, 18.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(195, 56).addBox(-21.0F, -11.0F, -10.0F, 8.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(194, 30).addBox(13.0F, -11.0F, -10.0F, 9.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(4, 194).addBox(-8.0F, -3.0F, 12.0F, 16.0F, 1.0F, -2.0F, new CubeDeformation(0.0F))
                .texOffs(79, 200).addBox(-8.0F, -3.0F, -10.0F, 16.0F, 1.0F, -2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 189).addBox(-21.06F, -11.82F, 12.0F, 8.0F, 1.0F, -24.0F, new CubeDeformation(0.0F))
                .texOffs(157, 187).addBox(-22.06F, -11.82F, 11.0F, 1.0F, 1.0F, -22.0F, new CubeDeformation(0.0F))
                .texOffs(34, 184).addBox(13.0F, -12.0F, 10.0F, 9.0F, 1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(57, 199).addBox(12.94F, -11.91F, 11.0F, 8.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
                .texOffs(37, 199).addBox(12.94F, -11.91F, -10.0F, 8.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
                .texOffs(20, 199).addBox(12.94F, -11.82F, 12.0F, 6.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
                .texOffs(3, 199).addBox(12.94F, -11.82F, -11.0F, 6.0F, 1.0F, -1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 61).addBox(13.94F, -12.82F, -4.0F, 3.0F, 1.0F, -8.0F, new CubeDeformation(0.0F))
                .texOffs(73, 61).addBox(13.94F, -12.82F, 12.0F, 3.0F, 1.0F, -8.0F, new CubeDeformation(0.0F))
                .texOffs(54, 61).addBox(13.94F, -13.82F, 4.0F, 3.0F, 1.0F, -8.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r2 = Chassis.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(252, 187).addBox(-16.67F, 5.07F, 10.0F, 11.0F, 2.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(143, 200).addBox(-16.975F, 4.68F, 12.0F, 11.0F, 1.0F, -2.0F, new CubeDeformation(0.0F))
                .texOffs(83, 26).addBox(-16.975F, 4.68F, 10.0F, 2.0F, 1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(116, 200).addBox(-16.975F, 4.68F, -10.0F, 11.0F, 1.0F, -2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 1.5708F, 0.5655F, 1.5708F));

        PartDefinition cube_r3 = Chassis.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(176, 6).addBox(5.67F, 5.06F, 10.001F, 11.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(176, 6).addBox(5.67F, 5.06F, -10.001F, 11.0F, 2.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(192, 3).addBox(5.67F, 5.06F, -10.0F, 11.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(194, 200).addBox(5.974F, 4.682F, 12.0F, 11.0F, 1.0F, -2.0F, new CubeDeformation(0.0F))
                .texOffs(219, 187).addBox(14.974F, 4.682F, 10.0F, 2.0F, 1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(169, 200).addBox(5.974F, 4.682F, -10.0F, 11.0F, 1.0F, -2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -1.5708F, 0.5655F, -1.5708F));

        PartDefinition Steering_Wheel = AATV.addOrReplaceChild("Steering_Wheel", CubeListBuilder.create(), PartPose.offset(0.0F, -13.98F, -5.325F));

        PartDefinition cube_r4 = Steering_Wheel.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(50, 24).addBox(0.0F, -0.15F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 12).addBox(-1.0F, -1.75F, -2.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(50, 18).addBox(-1.0F, -1.75F, 1.7F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 29).addBox(-1.0F, -0.75F, -1.0F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(46, 37).addBox(-1.0F, 0.25F, -2.0F, 1.0F, 1.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 0.13F, -0.3F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Dash = AATV.addOrReplaceChild("Dash", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r5 = Dash.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(79, 12).addBox(8.625F, -9.775F, -10.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(81, 16).addBox(9.625F, -8.775F, -10.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(76, 21).addBox(7.625F, -9.775F, -10.0F, 6.0F, -3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(76, 24).addBox(7.625F, -9.775F, 10.0F, 6.0F, -3.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(82, 29).addBox(9.625F, -8.775F, 10.0F, 2.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(106, 9).addBox(8.625F, -9.775F, 10.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(106, 4).addBox(8.625F, -9.775F, -10.0F, 4.0F, 1.0F, 0.0F, new CubeDeformation(0.0F))
                .texOffs(83, 48).addBox(7.625F, -13.775F, -10.0F, 6.0F, 1.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(39, 25).addBox(6.625F, -13.775F, -10.0F, 1.0F, 3.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r6 = Dash.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(73, 14).addBox(12.0F, -4.0F, -10.0F, 1.0F, 6.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -1.5708F, 0.8727F, -1.5708F));

        PartDefinition Front_Box = AATV.addOrReplaceChild("Front_Box", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r7 = Front_Box.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(252, 102).addBox(22.0F, -10.0F, 10.0F, 2.0F, -1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(252, 132).addBox(25.0F, -8.0F, 10.0F, 1.0F, -1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(204, 100).addBox(25.0F, -3.0F, 9.0F, 1.0F, -1.0F, -18.0F, new CubeDeformation(0.0F))
                .texOffs(205, 132).addBox(26.0F, -4.0F, 10.0F, 1.0F, -4.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(162, 102).addBox(24.0F, -9.0F, 10.0F, 1.0F, -1.0F, -20.0F, new CubeDeformation(0.0F))
                .texOffs(236, 155).addBox(8.0F, -2.0F, 9.0F, 17.0F, -1.0F, -18.0F, new CubeDeformation(0.0F))
                .texOffs(1, 66).addBox(13.0F, -9.0F, 8.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 61).addBox(14.0F, -10.0F, 8.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 56).addBox(12.0F, -8.0F, 8.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 51).addBox(11.0F, -7.0F, 8.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 46).addBox(10.0F, -6.0F, 8.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 41).addBox(10.0F, -5.0F, 8.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 36).addBox(9.0F, -4.0F, 8.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 31).addBox(13.0F, -9.0F, -9.0F, 12.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 26).addBox(14.0F, -10.0F, -9.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 21).addBox(12.0F, -8.0F, -9.0F, 14.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 16).addBox(11.0F, -7.0F, -9.0F, 15.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 11).addBox(10.0F, -6.0F, -9.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 6).addBox(10.0F, -5.0F, -9.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(1, 1).addBox(9.0F, -4.0F, -9.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Rear_Box = AATV.addOrReplaceChild("Rear_Box", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r8 = Rear_Box.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(11, 139).addBox(-20.0F, -3.0F, -9.0F, 12.0F, 1.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(49, 107).addBox(-20.0F, -10.0F, -9.0F, 1.0F, 7.0F, 18.0F, new CubeDeformation(0.0F))
                .texOffs(28, 129).addBox(-19.0F, -10.0F, -9.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 124).addBox(-19.0F, -9.0F, -9.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 119).addBox(-19.0F, -8.0F, -9.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 114).addBox(-19.0F, -7.0F, -9.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(28, 109).addBox(-19.0F, -6.0F, -9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 149).addBox(-19.0F, -5.0F, -9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 144).addBox(-19.0F, -4.0F, -9.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 139).addBox(-19.0F, -10.0F, 8.0F, 6.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 134).addBox(-19.0F, -9.0F, 8.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 129).addBox(-19.0F, -8.0F, 8.0F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 124).addBox(-19.0F, -7.0F, 8.0F, 8.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 119).addBox(-19.0F, -6.0F, 8.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 114).addBox(-19.0F, -5.0F, 8.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 109).addBox(-19.0F, -4.0F, 8.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Left_Front_Wheel = AATV.addOrReplaceChild("Left_Front_Wheel", CubeListBuilder.create(), PartPose.offset(11.4737F, -5.5F, -18.5F));

        PartDefinition cube_r9 = Left_Front_Wheel.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(171, 215).addBox(-3.5F, 3.5F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(168, 249).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(148, 252).addBox(-4.5F, 2.5F, -1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 251).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(166, 245).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(165, 241).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 244).addBox(-5.5F, -2.5F, -1.5F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 241).addBox(-4.5F, -3.5F, -1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 238).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 236).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(158, 233).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(148, 233).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(167, 225).addBox(-4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 225).addBox(3.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(155, 224).addBox(4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(148, 224).addBox(-5.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 232).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 228).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 224).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(161, 221).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(148, 221).addBox(-2.5F, -4.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 220).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(166, 215).addBox(2.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(161, 218).addBox(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(161, 215).addBox(2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 218).addBox(-3.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 215).addBox(-3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(151, 218).addBox(-2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(151, 215).addBox(-3.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 218).addBox(-2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 215).addBox(-3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 215).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 212).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(173, 212).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(168, 212).addBox(1.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(163, 212).addBox(2.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(158, 212).addBox(2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 212).addBox(-3.5F, -4.5F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0263F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Left_Rear_Wheel = AATV.addOrReplaceChild("Left_Rear_Wheel", CubeListBuilder.create(), PartPose.offset(11.4737F, -5.5F, 18.5F));

        PartDefinition cube_r10 = Left_Rear_Wheel.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(171, 215).addBox(-3.5F, 3.5F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(168, 249).addBox(-4.5F, 2.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(148, 252).addBox(-4.5F, 2.5F, -1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 251).addBox(3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(166, 245).addBox(2.5F, 3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(165, 241).addBox(-3.5F, 3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 244).addBox(-5.5F, -2.5F, -1.5F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 241).addBox(-4.5F, -3.5F, -1.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(160, 238).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 236).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(158, 233).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(148, 233).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(167, 225).addBox(-4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(162, 225).addBox(3.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(155, 224).addBox(4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(148, 224).addBox(-5.5F, -2.5F, -0.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 232).addBox(-4.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 228).addBox(-3.5F, -4.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(141, 224).addBox(3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(161, 221).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(148, 221).addBox(-2.5F, -4.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 220).addBox(2.5F, -4.5F, -0.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(166, 215).addBox(2.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(161, 218).addBox(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(161, 215).addBox(2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 218).addBox(-3.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(156, 215).addBox(-3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(151, 218).addBox(-2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(151, 215).addBox(-3.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 218).addBox(-2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(146, 215).addBox(-3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 215).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(178, 212).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(173, 212).addBox(-0.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(168, 212).addBox(1.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(163, 212).addBox(2.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(158, 212).addBox(2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(141, 212).addBox(-3.5F, -4.5F, -1.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0263F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Right_Front_Wheel = AATV.addOrReplaceChild("Right_Front_Wheel", CubeListBuilder.create(), PartPose.offset(-11.4737F, -5.5F, -18.5F));

        PartDefinition cube_r11 = Right_Front_Wheel.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(116, 215).addBox(-3.5F, 3.5F, 0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 249).addBox(-4.5F, 2.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 252).addBox(-4.5F, 2.5F, 0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 251).addBox(3.5F, 2.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(111, 245).addBox(2.5F, 3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 241).addBox(-3.5F, 3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 244).addBox(-5.5F, -2.5F, 0.5F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 241).addBox(-4.5F, -3.5F, 0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(105, 238).addBox(-2.5F, 4.5F, 0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 236).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(103, 233).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 233).addBox(-2.5F, -5.5F, 0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 225).addBox(-4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(107, 225).addBox(3.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 224).addBox(4.5F, -2.5F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 224).addBox(-5.5F, -2.5F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 232).addBox(-4.5F, -3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 228).addBox(-3.5F, -4.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 224).addBox(3.5F, -3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 221).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 221).addBox(-2.5F, -4.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 220).addBox(2.5F, -4.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(111, 215).addBox(2.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 218).addBox(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 215).addBox(2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 218).addBox(-3.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 215).addBox(-3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 218).addBox(-2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 215).addBox(-3.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 218).addBox(-2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 215).addBox(-3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 215).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(123, 212).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 212).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 212).addBox(1.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 212).addBox(2.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 212).addBox(2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 212).addBox(-3.5F, -4.5F, 0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0263F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Right_Rear_Wheel = AATV.addOrReplaceChild("Right_Rear_Wheel", CubeListBuilder.create(), PartPose.offset(-11.4737F, -5.5F, 18.5F));

        PartDefinition cube_r12 = Right_Rear_Wheel.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(116, 215).addBox(-3.5F, 3.5F, 0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 249).addBox(-4.5F, 2.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 252).addBox(-4.5F, 2.5F, 0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 251).addBox(3.5F, 2.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(111, 245).addBox(2.5F, 3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(110, 241).addBox(-3.5F, 3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 244).addBox(-5.5F, -2.5F, 0.5F, 11.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 241).addBox(-4.5F, -3.5F, 0.5F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(105, 238).addBox(-2.5F, 4.5F, 0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 236).addBox(-2.5F, -5.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(103, 233).addBox(-2.5F, 4.5F, -1.5F, 5.0F, 1.0F, 3.0F, new CubeDeformation(0.0F))
                .texOffs(93, 233).addBox(-2.5F, -5.5F, 0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(112, 225).addBox(-4.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(107, 225).addBox(3.5F, -2.5F, -0.5F, 1.0F, 5.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(100, 224).addBox(4.5F, -2.5F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(93, 224).addBox(-5.5F, -2.5F, -1.5F, 1.0F, 5.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 232).addBox(-4.5F, -3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 228).addBox(-3.5F, -4.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(86, 224).addBox(3.5F, -3.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(106, 221).addBox(-2.5F, 3.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(93, 221).addBox(-2.5F, -4.5F, -0.5F, 5.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 220).addBox(2.5F, -4.5F, -1.5F, 1.0F, 1.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(111, 215).addBox(2.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 218).addBox(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(106, 215).addBox(2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 218).addBox(-3.5F, 1.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(101, 215).addBox(-3.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 218).addBox(-2.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(96, 215).addBox(-3.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 218).addBox(-2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(91, 215).addBox(-3.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 215).addBox(-0.5F, -1.5F, -0.5F, 1.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(123, 212).addBox(-1.5F, -0.5F, -0.5F, 3.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(118, 212).addBox(-0.5F, -0.5F, -1.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(113, 212).addBox(1.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(108, 212).addBox(2.5F, -2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(103, 212).addBox(2.5F, -3.5F, -0.5F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(86, 212).addBox(-3.5F, -4.5F, 0.5F, 7.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.0263F, 0.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Windshield = AATV.addOrReplaceChild("Windshield", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r13 = Windshield.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(158, 136).addBox(12.88F, -14.28F, 12.0F, 1.0F, 3.0F, -24.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r14 = Windshield.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(52, 83).addBox(18.81F, -18.02F, -10.0F, 1.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(12, 72).addBox(18.81F, -16.02F, -12.0F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(2, 83).addBox(18.81F, -4.02F, -10.0F, 1.0F, 2.0F, 20.0F, new CubeDeformation(0.0F))
                .texOffs(2, 96).addBox(18.81F, -17.02F, -11.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 91).addBox(18.81F, -17.02F, 10.0F, 1.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 72).addBox(18.81F, -16.02F, 10.0F, 1.0F, 14.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, -1.5708F, 0.8727F, -1.5708F));

        PartDefinition Seat = AATV.addOrReplaceChild("Seat", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r15 = Seat.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(41, 215).addBox(-8.0F, -4.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 204).addBox(-8.0F, -4.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(34, 210).addBox(0.0F, -4.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(41, 221).addBox(0.0F, -4.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(45, 251).addBox(-10.0F, -6.0F, -6.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 233).addBox(-10.0F, -6.0F, 5.0F, 10.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(23, 238).addBox(0.0F, -6.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(15, 233).addBox(0.0F, -6.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(35, 238).addBox(1.0F, -6.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 231).addBox(0.0F, -5.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 243).addBox(-10.0F, -5.0F, -5.0F, 10.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r16 = Seat.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(2, 203).addBox(-20.0F, 6.0F, -6.0F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(2, 210).addBox(-20.0F, 6.0F, 5.0F, 13.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 230).addBox(-21.0F, 6.0F, -5.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(49, 236).addBox(-21.0F, 6.0F, 4.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(62, 238).addBox(-22.0F, 6.0F, -4.0F, 1.0F, 2.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(48, 234).addBox(-21.0F, 7.0F, -4.0F, 1.0F, 1.0F, 8.0F, new CubeDeformation(0.0F))
                .texOffs(2, 217).addBox(-20.0F, 7.0F, -5.0F, 13.0F, 1.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 1.5708F, 0.3037F, 1.5708F));

        PartDefinition Roll_Cage = AATV.addOrReplaceChild("Roll_Cage", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r17 = Roll_Cage.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(220, 237).addBox(-16.0F, -26.207F, -0.24F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F))
                .texOffs(243, 242).addBox(-19.0F, -14.0F, 7.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(199, 239).addBox(-16.0F, -26.0F, 2.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(206, 239).addBox(-16.0F, -26.0F, -3.0F, 1.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(250, 242).addBox(-19.0F, -14.0F, -8.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(213, 245).addBox(-16.0F, -20.0F, 7.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(234, 245).addBox(-16.0F, -20.0F, -8.0F, 1.0F, 8.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(242, 248).addBox(-16.0F, -26.207F, -4.765F, 1.0F, 1.0F, 5.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition cube_r18 = Roll_Cage.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(185, 247).addBox(-23.452F, -8.62F, 7.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(192, 247).addBox(-23.452F, -8.62F, -8.0F, 1.0F, 6.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 1.5708F, 1.0472F, 1.5708F));

        PartDefinition cube_r19 = Roll_Cage.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(220, 246).addBox(-16.0F, -21.045F, 15.33F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, -0.48F));

        PartDefinition cube_r20 = Roll_Cage.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(227, 246).addBox(-16.0F, -21.045F, -16.33F, 1.0F, 7.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.48F));

        PartDefinition Side_Panels = AATV.addOrReplaceChild("Side_Panels", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

        PartDefinition cube_r21 = Side_Panels.addOrReplaceChild("cube_r21", CubeListBuilder.create().texOffs(232, 231).addBox(-0.7F, -5.0F, 9.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(232, 227).addBox(-9.25F, -5.0F, 9.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(234, 223).addBox(-8.6F, -4.0F, 9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(220, 219).addBox(-8.0F, -3.0F, 9.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(234, 215).addBox(-0.35F, -4.0F, 9.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(234, 211).addBox(-8.6F, -4.0F, -10.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(232, 207).addBox(-9.25F, -5.0F, -10.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(232, 203).addBox(-0.7F, -5.0F, -10.0F, 10.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(234, 199).addBox(-0.35F, -4.0F, -10.0F, 9.0F, 1.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(220, 195).addBox(-8.0F, -3.0F, -10.0F, 16.0F, 1.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -2.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Rear_Axle = AATV.addOrReplaceChild("Rear_Axle", CubeListBuilder.create(), PartPose.offset(0.0F, -5.5F, 18.5F));

        PartDefinition RearAxle_r1 = Rear_Axle.addOrReplaceChild("RearAxle_r1", CubeListBuilder.create().texOffs(124, 55).addBox(-19.0F, -4.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, -18.5F, 0.0F, 1.5708F, 0.0F));

        PartDefinition Front_Axle = AATV.addOrReplaceChild("Front_Axle", CubeListBuilder.create(), PartPose.offset(0.0F, -5.5F, -18.5F));

        PartDefinition Front_Axle_r1 = Front_Axle.addOrReplaceChild("Front_Axle_r1", CubeListBuilder.create().texOffs(124, 30).addBox(18.0F, -4.0F, -10.0F, 1.0F, 1.0F, 20.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 3.5F, 18.5F, 0.0F, 1.5708F, 0.0F));

        return LayerDefinition.create(meshdefinition, 256, 256);
    }

    @Override
    public void setupAnim(T entity, float f, float f1, float f2, float f3, float f4) {
        this.AATV.yRot = f3 / (180F / (float) Math.PI);

        this.AATV.getChild("Left_Front_Wheel").xRot = f2 / (180F / (float) Math.PI);
        this.AATV.getChild("Left_Rear_Wheel").xRot = f2 / (180F / (float) Math.PI);
        this.AATV.getChild("Right_Front_Wheel").xRot = f2 / (180F / (float) Math.PI);
        this.AATV.getChild("Right_Rear_Wheel").xRot = f2 / (180F / (float) Math.PI);
        this.AATV.getChild("Front_Axle").xRot = f2 / (180F / (float) Math.PI);
        this.AATV.getChild("Rear_Axle").xRot = f2 / (180F / (float) Math.PI);
        if (entity.getforward()) {
            this.AATV.getChild("Left_Front_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Left_Rear_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Right_Front_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Right_Rear_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Front_Axle").xRot = (float) (f / 4);
            this.AATV.getChild("Rear_Axle").xRot = (float) (f / 4);
        }
        if (!entity.getforward()) {
            this.AATV.getChild("Left_Front_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Left_Rear_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Right_Front_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Right_Rear_Wheel").xRot = (float) (f / 4);
            this.AATV.getChild("Front_Axle").xRot = (float) (f / 4);
            this.AATV.getChild("Rear_Axle").xRot = (float) (f / 4);
        }

        this.AATV.getChild("Steering_Wheel").zRot = f2 / 20f;
    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        AATV.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}