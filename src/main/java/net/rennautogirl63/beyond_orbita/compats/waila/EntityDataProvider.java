package net.rennautogirl63.beyond_orbita.compats.waila;

import mcp.mobius.waila.api.EntityAccessor;
import mcp.mobius.waila.api.IEntityComponentProvider;
import mcp.mobius.waila.api.IServerDataProvider;
import mcp.mobius.waila.api.ITooltip;
import mcp.mobius.waila.api.config.IPluginConfig;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.rennautogirl63.beyond_orbita.gauge.IGaugeValue;
import net.rennautogirl63.beyond_orbita.gauge.IGaugeValuesProvider;

import java.util.ArrayList;
import java.util.List;

public class EntityDataProvider implements IServerDataProvider<Entity>, IEntityComponentProvider {

    public static final EntityDataProvider INSTANCE = new EntityDataProvider();

    @Override
    public void appendServerData(CompoundTag data, ServerPlayer player, Level level, Entity entity, boolean b) {

        List<IGaugeValue> list = new ArrayList<>();

        if (entity instanceof IGaugeValuesProvider) {
            ((IGaugeValuesProvider) entity).getGaugeValues().forEach(list::add);
        }

        WailaPlugin.put(data, WailaPlugin.write(list));
    }

    @Override
    public void appendTooltip(ITooltip tooltip, EntityAccessor accessor, IPluginConfig config) {
        WailaPlugin.appendTooltip(tooltip, accessor.getServerData());
    }

}
