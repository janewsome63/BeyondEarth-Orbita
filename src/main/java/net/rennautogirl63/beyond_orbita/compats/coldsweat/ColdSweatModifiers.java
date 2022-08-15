package net.rennautogirl63.beyond_orbita.compats.coldsweat;

import dev.momostudios.coldsweat.api.temperature.Temperature;
import dev.momostudios.coldsweat.util.entity.TempHelper;
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

                if (TempHelper.getModifier(player, Temperature.Types.MAX, OxygenMaskModifierMax.class) == null) {
                    TempHelper.addModifier(player, new OxygenMaskModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, OxygenMaskModifierMin.class) == null) {
                    TempHelper.addModifier(player, new OxygenMaskModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.NETHERITE_OXYGEN_MASK.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, NetheriteOxygenMaskModifierMax.class) == null) {
                    TempHelper.addModifier(player, new NetheriteOxygenMaskModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, NetheriteOxygenMaskModifierMin.class) == null) {
                    TempHelper.addModifier(player, new NetheriteOxygenMaskModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_SUIT.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, SpaceSuitModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpaceSuitModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, SpaceSuitModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpaceSuitModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.CHEST) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.NETHERITE_SPACE_SUIT.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, NetheriteSpaceSuitModifierMax.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpaceSuitModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, NetheriteSpaceSuitModifierMin.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpaceSuitModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_PANTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, SpacePantsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpacePantsModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, SpacePantsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpacePantsModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.LEGS) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.NETHERITE_SPACE_PANTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, NetheriteSpacePantsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpacePantsModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, NetheriteSpacePantsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpacePantsModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.SPACE_BOOTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, SpaceBootsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new SpaceBootsModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, SpaceBootsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new SpaceBootsModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
            if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.FEET) : ItemStack.EMPTY)
                    .getItem() == ItemsRegistry.NETHERITE_SPACE_BOOTS.get()) {

                if (TempHelper.getModifier(player, Temperature.Types.MAX, NetheriteSpaceBootsModifierMax.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpaceBootsModifierMax().expires(5).tickRate(5), Temperature.Types.MAX, false);
                }
                if (TempHelper.getModifier(player, Temperature.Types.MIN, NetheriteSpaceBootsModifierMin.class) == null) {
                    TempHelper.addModifier(player, new NetheriteSpaceBootsModifierMin().expires(5).tickRate(5), Temperature.Types.MIN, false);
                }

            }
        }
    }
}
