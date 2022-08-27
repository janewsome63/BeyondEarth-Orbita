package net.rennautogirl63.beyond_orbita.compats.coldsweat;

import dev.momostudios.coldsweat.api.temperature.Temperature;
import dev.momostudios.coldsweat.api.util.TempHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.Event;
import net.rennautogirl63.beyond_orbita.compats.coldsweat.modifiers.*;
import net.rennautogirl63.beyond_orbita.registries.ItemsRegistry;

public class ColdSweatModifiers {

    public static void spaceSuits(Event event, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof Player player) {
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.OXYGEN_MASK.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, OxygenMaskModifierMax.class) == null) {
                    TempHelper.addModifier(player, new OxygenMaskModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, OxygenMaskModifierMin.class) == null) {
                    TempHelper.addModifier(player, new OxygenMaskModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.ADVANCED_OXYGEN_MASK.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, AdvancedOxygenMaskModifierMax.class) == null) {
                    TempHelper.addModifier(player, new AdvancedOxygenMaskModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, AdvancedOxygenMaskModifierMin.class) == null) {
                    TempHelper.addModifier(player, new AdvancedOxygenMaskModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_SUIT.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, SpaceSuitModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpaceSuitModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, SpaceSuitModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpaceSuitModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.ADVANCED_SPACE_SUIT.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, AdvancedSpaceSuitModifierMax.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpaceSuitModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, AdvancedSpaceSuitModifierMin.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpaceSuitModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_PANTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, SpacePantsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpacePantsModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, SpacePantsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpacePantsModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.ADVANCED_SPACE_PANTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, AdvancedSpacePantsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpacePantsModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, AdvancedSpacePantsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpacePantsModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_BOOTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, SpaceBootsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpaceBootsModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, SpaceBootsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpaceBootsModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.ADVANCED_SPACE_BOOTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Type.MAX, AdvancedSpaceBootsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpaceBootsModifierMax().expires(5).tickRate(5), Temperature.Type.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Type.MIN, AdvancedSpaceBootsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new AdvancedSpaceBootsModifierMin().expires(5).tickRate(5), Temperature.Type.MIN, false);
                }

            }
        }
    }
}
