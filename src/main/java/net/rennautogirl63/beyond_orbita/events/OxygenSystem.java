package net.rennautogirl63.beyond_orbita.events;

import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.IOxygenStorage;
import net.rennautogirl63.beyond_orbita.capabilities.oxygen.OxygenUtil;
import net.rennautogirl63.beyond_orbita.config.Config;
import net.rennautogirl63.beyond_orbita.registries.EffectsRegistry;

public class OxygenSystem {

    public static void OxygenSystem(Player entity, Level level) {
        if ((Config.PLAYER_OXYGEN_SYSTEM.get() && Methods.isSpaceWorldWithoutOxygen(level) && !entity.isSpectator() && !entity.getAbilities().instabuild) || Config.PLAYER_OXYGEN_SYSTEM.get() && Methods.isPlanetoidWorld(level) && entity.blockPosition().getY() >= 590 && !entity.isSpectator() && !entity.getAbilities().instabuild) {

            if (entity.getAirSupply() < 1) {
                Methods.oxygenDamage(entity);
            }

            if (Methods.spaceSuitCheckBoth(entity) && !entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {

                ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 2));
                IOxygenStorage oxygenStorage = OxygenUtil.getItemStackOxygenStorage(itemstack);

                if (oxygenStorage.getOxygenStored() == 0) {
                    entity.setAirSupply(-4);
                }

                if (oxygenStorage.getOxygenStored() > 0) {
                    entity.setAirSupply(300);
                }

            }

            if (!Methods.spaceSuitCheckBoth(entity) && !entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {
                entity.setAirSupply(-4);
            }

            if (entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get()) || entity.getPersistentData().getBoolean(BeyondOrbitaMod.MODID + ":planet_selection_gui_open")) {
                entity.setAirSupply(300);
            }
        }

        //Out of Space
        if (Methods.spaceSuitCheckBoth(entity) && entity.isEyeInFluid(FluidTags.WATER) && !entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {

            ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.byTypeAndIndex(EquipmentSlot.Type.ARMOR, 2));
            IOxygenStorage oxygenStorage = OxygenUtil.getItemStackOxygenStorage(itemstack);
            if (oxygenStorage.getOxygenStored() > 0) {
                entity.setAirSupply(300);
            }
        }

        if (entity.hasEffect(EffectsRegistry.OXYGEN_EFFECT.get())) {
            entity.setAirSupply(300);
        }
    }
}
