package net.rennautogirl63.beyond_orbita.guis.screens.solarpanel;

import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.IContainerFactory;
import net.rennautogirl63.beyond_orbita.guis.helper.ContainerHelper;
import net.rennautogirl63.beyond_orbita.machines.tile.AdvancedSolarPanelBlockEntity;
import net.rennautogirl63.beyond_orbita.machines.tile.SolarPanelBlockEntity;
import net.rennautogirl63.beyond_orbita.registries.ScreensRegistry;

public class AdvancedSolarPanelGui {

    public static class GuiContainerFactory implements IContainerFactory<GuiContainer> {
        public GuiContainer create(int id, Inventory inv, FriendlyByteBuf extraData) {
            BlockPos pos = extraData.readBlockPos();
            AdvancedSolarPanelBlockEntity blockEntity = (AdvancedSolarPanelBlockEntity) inv.player.level.getBlockEntity(pos);
            return new GuiContainer(id, inv, blockEntity);
        }
    }

    public static class GuiContainer extends AbstractContainerMenu {
        private AdvancedSolarPanelBlockEntity blockEntity;

        public GuiContainer(int id, Inventory inv, AdvancedSolarPanelBlockEntity blockEntity) {
            super(ScreensRegistry.ADVANCED_SOLAR_PANEL_GUI.get(), id);
            this.blockEntity = blockEntity;

            ContainerHelper.addInventorySlots(this, inv, 8, 84, this::addSlot);
        }

        public AdvancedSolarPanelBlockEntity getBlockEntity() {
            return this.blockEntity;
        }

        @Override
        public boolean stillValid(Player p_38874_) {
            return !this.getBlockEntity().isRemoved();
        }

        @Override
        public ItemStack quickMoveStack(Player playerIn, int index) {
            return ContainerHelper.transferStackInSlot(this, playerIn, index, this.getBlockEntity(), this::moveItemStackTo);
        }
    }
}
