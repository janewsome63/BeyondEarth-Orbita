package net.rennautogirl63.beyond_orbita.guis.screens.fluidoxidizer;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.network.IContainerFactory;
import net.rennautogirl63.beyond_orbita.guis.helper.ContainerHelper;
import net.rennautogirl63.beyond_orbita.machines.tile.FluidOxidizerBlockEntity;
import net.rennautogirl63.beyond_orbita.registries.ScreensRegistry;

public class FluidOxidizerGui {

    public static class GuiContainerFactory implements IContainerFactory<GuiContainer> {
        public GuiContainer create(int id, Inventory inv, FriendlyByteBuf extraData) {
            BlockPos pos = extraData.readBlockPos();
            FluidOxidizerBlockEntity blockEntity = (FluidOxidizerBlockEntity) inv.player.level.getBlockEntity(pos);
            return new GuiContainer(id, inv, blockEntity);
        }
    }

    public static class GuiContainer extends AbstractContainerMenu {
        private final FluidOxidizerBlockEntity blockEntity;

        public GuiContainer(int id, Inventory inv, FluidOxidizerBlockEntity blockEntity) {
            super(ScreensRegistry.FLUID_OXIDIZER_GUI.get(), id);
            this.blockEntity = blockEntity;

            IItemHandlerModifiable itemHandler = blockEntity.getItemHandler();
            this.addSlot(new SlotItemHandler(itemHandler, FluidOxidizerBlockEntity.SLOT_INPUT_SOURCE, 26, 22));
            this.addSlot(new SlotItemHandler(itemHandler, FluidOxidizerBlockEntity.SLOT_OUTPUT_SINK, 92, 52));
            this.addSlot(new SlotItemHandler(itemHandler, FluidOxidizerBlockEntity.SLOT_INPUT_SINK, 26, 52));
            this.addSlot(new SlotItemHandler(itemHandler, FluidOxidizerBlockEntity.SLOT_OUTPUT_SOURCE, 92, 22));

            ContainerHelper.addInventorySlots(this, inv, 8, 90, this::addSlot);
        }

        public FluidOxidizerBlockEntity getBlockEntity() {
            return this.blockEntity;
        }

        @Override
        public boolean stillValid(Player player) {
            return !this.getBlockEntity().isRemoved();
        }

        @Override
        public ItemStack quickMoveStack(Player playerIn, int index) {
            return ContainerHelper.transferStackInSlot(this, playerIn, index, this.getBlockEntity(), this::moveItemStackTo);
        }
    }
}
