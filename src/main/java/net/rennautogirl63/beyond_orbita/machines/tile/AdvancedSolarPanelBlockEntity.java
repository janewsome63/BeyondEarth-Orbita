package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.rennautogirl63.beyond_orbita.guis.screens.solarpanel.AdvancedSolarPanelGui;
import net.rennautogirl63.beyond_orbita.registries.BlockEntitiesRegistry;

import java.util.Arrays;
import java.util.List;

public class AdvancedSolarPanelBlockEntity extends GeneratorBlockEntity {

    public static final int ENERGY_PER_TICK = 15;

    public AdvancedSolarPanelBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.ADVANCED_SOLAR_PANEL_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new AdvancedSolarPanelGui.GuiContainer(id, inventory, this);
    }

    protected int getGenerationInTick() {
        return this.getMaxGeneration();
    }

    @Override
    public int getMaxGeneration() {
        return ENERGY_PER_TICK;
    }

    @Override
    protected boolean canGenerateEnergy() {
        Level level = this.getLevel();
        BlockPos blockPos = new BlockPos(this.getBlockPos().getX(), this.getBlockPos().getY() + 1, this.getBlockPos().getZ());

        return level.isDay() && level.canSeeSky(blockPos);
    }

    @Override
    protected void generateEnergy() {
        this.generateEnergy(this.getGenerationInTick());
    }

    @Override
    protected List<Direction> getEjectDirections() {
        List<Direction> list = super.getEjectDirections();
        list.addAll(Arrays.stream(Direction.values()).filter(d -> d != Direction.UP).toList());
        return list;
    }
}