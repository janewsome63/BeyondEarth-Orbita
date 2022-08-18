package net.rennautogirl63.beyond_orbita.armors;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.IItemRenderProperties;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.CapabilityOxygen;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.IOxygenStorage;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.OxygenUtil;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.SpaceSuitCapabilityProvider;
import net.rennautogirl63.beyond_orbita.entities.renderer.armors.SpaceSuitModel;
import net.rennautogirl63.beyond_orbita.events.Methods;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class NetheriteSpaceSuit {

    public static class OxygenMask extends ArmorItem {
        public OxygenMask(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
            super(p_40386_, p_40387_, p_40388_);
        }

        @Override
        public void initializeClient(Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {

                @Override
                public HumanoidModel getBaseArmorModel(LivingEntity living, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {

                    Map<String, ModelPart> map = Map.of("head", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).head,

                            "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())
                    );

                    ModelPart modelPart = new ModelPart(Collections.emptyList(), map);
                    SpaceSuitModel.SPACE_SUIT_P1 armorModel = new SpaceSuitModel.SPACE_SUIT_P1(modelPart);

                    armorModel.entity = living;

                    return armorModel;
                }
            });
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return BeyondOrbitaMod.MODID + ":textures/armor/netherite_oxygen_mask.png";
        }
    }

    public static class Suit extends ArmorItem {
        public Suit(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
            super(p_40386_, p_40387_, p_40388_);
        }

        @Override
        public void initializeClient(Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {

                @Override
                public HumanoidModel getBaseArmorModel(LivingEntity living, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {

                    Map<String, ModelPart> map = Map.of(
                            "body", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).body,
                            "right_arm", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).rightArm,
                            "left_arm", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).leftArm,

                            "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "left_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap())
                    );

                    ModelPart modelPart = new ModelPart(Collections.emptyList(), map);
                    SpaceSuitModel.SPACE_SUIT_P1 armorModel = new SpaceSuitModel.SPACE_SUIT_P1(modelPart);

                    armorModel.entity = living;

                    return armorModel;
                }
            });
        }

        @Override
        public void fillItemCategory(CreativeModeTab p_41391_, NonNullList<ItemStack> p_41392_) {
            super.fillItemCategory(p_41391_, p_41392_);
            if (this.allowdedIn(p_41391_)) {
                ItemStack itemStack = new ItemStack(this);
                IOxygenStorage oxygenStorage = itemStack.getCapability(CapabilityOxygen.OXYGEN).orElse(null);

                oxygenStorage.setOxygenStored(oxygenStorage.getMaxOxygenStored());
                p_41392_.add(itemStack);
            }
        }

        @Override
        public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
            return new SpaceSuitCapabilityProvider(stack, 48000);
        }

        @Override
        public void appendHoverText(ItemStack p_41421_, Level p_41422_, List<Component> p_41423_, TooltipFlag p_41424_) {
            super.appendHoverText(p_41421_, p_41422_, p_41423_, p_41424_);
            IOxygenStorage oxygenStorage = OxygenUtil.getItemStackOxygenStorage(p_41421_);
            p_41423_.add(GaugeTextHelper.buildSpacesuitOxygenTooltip(oxygenStorage));
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return BeyondOrbitaMod.MODID + ":textures/armor/netherite_space_suit.png";
        }

        @Override
        public void onArmorTick(ItemStack stack, Level world, Player player) {
            Methods.extractArmorOxygenUsingTimer(stack, player);
        }
    }

    public static class Pants extends ArmorItem {
        public Pants(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
            super(p_40386_, p_40387_, p_40388_);
        }

        @Override
        public void initializeClient(Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {

                @Override
                public HumanoidModel getBaseArmorModel(LivingEntity living, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {

                    Map<String, ModelPart> map = Map.of(
                            "right_leg", new SpaceSuitModel.SPACE_SUIT_P2(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P2.LAYER_LOCATION)).rightLeg,
                            "left_leg", new SpaceSuitModel.SPACE_SUIT_P2(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P2.LAYER_LOCATION)).leftLeg,

                            "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())

                    );

                    ModelPart modelPart = new ModelPart(Collections.emptyList(), map);
                    SpaceSuitModel.SPACE_SUIT_P2 armorModel = new SpaceSuitModel.SPACE_SUIT_P2(modelPart);

                    armorModel.entity = living;

                    return armorModel;
                }
            });
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return BeyondOrbitaMod.MODID + ":textures/armor/netherite_space_pants.png";
        }
    }

    public static class Boots extends ArmorItem {
        public Boots(ArmorMaterial p_40386_, EquipmentSlot p_40387_, Properties p_40388_) {
            super(p_40386_, p_40387_, p_40388_);
        }

        @Override
        public void initializeClient(Consumer<IItemRenderProperties> consumer) {
            consumer.accept(new IItemRenderProperties() {

                @Override
                public HumanoidModel getBaseArmorModel(LivingEntity living, ItemStack itemStack, EquipmentSlot armorSlot, HumanoidModel<?> defaultModel) {

                    Map<String, ModelPart> map = Map.of(
                            "right_leg", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).rightLeg,
                            "left_leg", new SpaceSuitModel.SPACE_SUIT_P1(Minecraft.getInstance().getEntityModels().bakeLayer(SpaceSuitModel.SPACE_SUIT_P1.LAYER_LOCATION)).leftLeg,

                            "head", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "body", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "right_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap()),
                            "left_arm", new ModelPart(Collections.emptyList(), Collections.emptyMap())

                    );

                    ModelPart modelPart = new ModelPart(Collections.emptyList(), map);
                    SpaceSuitModel.SPACE_SUIT_P1 armorModel = new SpaceSuitModel.SPACE_SUIT_P1(modelPart);

                    armorModel.entity = living;

                    return armorModel;
                }
            });
        }

        @Override
        public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
            return BeyondOrbitaMod.MODID + ":textures/armor/netherite_space_suit.png";
        }
    }
}