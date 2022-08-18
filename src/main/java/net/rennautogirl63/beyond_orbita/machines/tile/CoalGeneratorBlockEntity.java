package net.rennautogirl63.beyond_orbita.machines.tile;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.state.BlockState;
import net.rennautogirl63.beyond_orbita.guis.screens.coalgenerator.CoalGeneratorGui;
import net.rennautogirl63.beyond_orbita.registries.BlockEntitiesRegistry;

import java.util.List;

public class CoalGeneratorBlockEntity extends GeneratorBlockEntity {

    public static final int SLOT_FUEL = 0;
    public static final int ENERGY_PER_TICK = 2;

    private PowerSystemFuelGeneratingRecipe powerSystemGenerating;

    public CoalGeneratorBlockEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.COAL_GENERATOR_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory) {
        return new CoalGeneratorGui.GuiContainer(id, inventory, this);
    }

    @Override
    public int getMaxGeneration() {
        return ENERGY_PER_TICK;
    }

    protected int getGenerationInTick() {
        return this.getMaxGeneration();
    }

    @Override
    protected boolean canGenerateEnergy() {
        return true;
    }

    @Override
    protected void generateEnergy() {
        this.generateEnergy(this.getGenerationInTick());
    }

    @Override
    protected List<Direction> getEjectDirections() {
        List<Direction> list = super.getEjectDirections();
        list.add(Direction.UP);
        list.add(Direction.DOWN);
        return list;
    }

    @Override
    protected void createPowerSystems(PowerSystemRegistry map) {
        super.createPowerSystems(map);
        map.put(this.powerSystemGenerating = new PowerSystemFuelGeneratingRecipe(this, this.getFuelSlot()));
    }

    public PowerSystemFuelGeneratingRecipe getPowerSystemGenerating() {
        return this.powerSystemGenerating;
    }

    public int getFuelSlot() {
        return SLOT_FUEL;
    }
}