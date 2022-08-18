package net.rennautogirl63.beyond_orbita.compats.theoneprobe;

import mcjty.theoneprobe.api.ITheOneProbe;

import java.util.function.Function;

public class TOPPlugin implements Function<ITheOneProbe, Void> {

    @Override
    public Void apply(ITheOneProbe top) {
        top.registerProvider(ProbeInfoBlockProvider.INSTANCE);
        top.registerEntityProvider(ProbeInfoEntityProvider.INSTANCE);
        top.registerProbeConfigProvider(ProbeConfigProvider.INSTANCE);
        top.registerElementFactory(GaugeValueElementFactory.INSTANCE);

        return null;
    }

}
