package net.rennautogirl63.beyond_orbita.guis.helper;

import java.util.function.BiConsumer;
import java.util.function.Function;

import net.rennautogirl63.beyond_orbita.crafting.RocketPart;
import net.rennautogirl63.beyond_orbita.inventory.RocketPartsItemHandler;
import net.rennautogirl63.beyond_orbita.utils.Rectangle2d;
import org.jetbrains.annotations.NotNull;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;

public class RocketPartGridPlacer {

	public static void place(int left, int top, int mod, IPlacer placer, RocketPart part, BiConsumer<Integer, Rectangle2d> consumer) {
		for (int i = 0; i < part.getSlots(); i++) {
			Rectangle2d bounds = placer.place(i, left, top, mod);
			consumer.accept(i, bounds);
		}
	}

	public static void placeContainer(int left, int top, int mod, IPlacer placer, RocketPart part, RocketPartsItemHandler itemHandler, Function<Slot, Slot> addSlot) {
		place(left, top, mod, placer, part, (i, bounds) -> {
			IItemHandlerModifiable parent = itemHandler.getParent();
			int slot = itemHandler.getParentSlotIndex(part, i);
			addSlot.apply(new SlotItemHandler(parent, slot, bounds.getX(), bounds.getY()) {
				@Override
				public boolean mayPlace(@NotNull ItemStack stack) {
					return true;
				}
			});
		});
	}

	private RocketPartGridPlacer() {

	}

}
