package net.rennautogirl63.beyond_orbita.compats.waila;

import mcp.mobius.waila.api.BlockAccessor;
import mcp.mobius.waila.api.IComponentProvider;
import mcp.mobius.waila.api.IServerDataProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.config.IPluginConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.rennautogirl63.beyond_orbita.gauge.IGaugeValue;
import net.rennautogirl63.beyond_orbita.gauge.IGaugeValuesProvider;

import java.util.ArrayList;
import java.util.List;

public class BlockDataProvider implements IServerDataProvider<BlockEntity>, IComponentProvider {

    public static final BlockDataProvider INSTANCE = new BlockDataProvider();

    @Override
    public void appendServerData(CompoundTag data, ServerPlayer player, Level level, BlockEntity blockEntity, boolean b) {

        List<IGaugeValue> list = new ArrayList<>();

        if (blockEntity instanceof IGaugeValuesProvider) {
            ((IGaugeValuesProvider) blockEntity).getGaugeValues().forEach(list::add);
        }

        WailaPlugin.put(data, WailaPlugin.write(list));
    }

    @Override
    public void appendTooltip(ITooltip tooltip, BlockAccessor accessor, IPluginConfig config) {
        WailaPlugin.appendTooltip(tooltip, accessor.getServerData());
    }

}
