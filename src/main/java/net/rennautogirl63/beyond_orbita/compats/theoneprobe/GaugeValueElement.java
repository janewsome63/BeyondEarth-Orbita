package net.rennautogirl63.beyond_orbita.compats.theoneprobe;

import mcjty.theoneprobe.api.IElement;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.gauge.GaugeValueRenderer;
import net.rennautogirl63.beyond_orbita.gauge.IGaugeValue;

public class GaugeValueElement extends GaugeValueRenderer implements IElement {

    public GaugeValueElement(IGaugeValue value) {
        super(value);
    }

    public GaugeValueElement(FriendlyByteBuf buffer) {
        super(buffer);
    }

    @Override
    public ResourceLocation getID() {
        return GaugeValueElementFactory.ELEMENT_ID;
    }

}
