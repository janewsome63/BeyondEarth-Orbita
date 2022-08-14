package net.rennautogirl63.beyond_orbita.itemgroups;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

import net.rennautogirl63.beyond_orbita.registries.BlocksRegistry;
import net.rennautogirl63.beyond_orbita.registries.ItemsRegistry;

public class ItemGroups {
	public static CreativeModeTab tab_normal = new CreativeModeTab("tab_normal") {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(ItemsRegistry.TIER_1_ROCKET_ITEM.get(), 1);
		}
	};
}
