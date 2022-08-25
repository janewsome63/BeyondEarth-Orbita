package net.rennautogirl63.beyond_orbita.armormaterials;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

public class AdvancedSpaceSuitMaterial {
    public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial() {

        @Override
        public int getDurabilityForSlot(EquipmentSlot slot) {
            return new int[]{429, 495, 528, 363}[slot.getIndex()];
        }

        @Override
        public int getDefenseForSlot(EquipmentSlot slot) {
            return new int[]{3, 6, 8, 3}[slot.getIndex()];
        }

        @Override
        public int getEnchantmentValue() {
            return 10;
        }

        @Override
        public SoundEvent getEquipSound() {
            return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("item.armor.equip_leather"));
        }

        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.of(new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("beyond_orbita:titanium_ingot"))));
        }

        @Override
        public String getName() {
            return "advanced_space_suit";
        }

        @Override
        public float getToughness() {
            return 2.0f;
        }

        @Override
        public float getKnockbackResistance() {
            return 0.0f;
        }
    };
}
