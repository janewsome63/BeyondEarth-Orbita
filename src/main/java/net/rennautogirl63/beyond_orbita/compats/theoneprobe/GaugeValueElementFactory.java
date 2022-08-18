package net.rennautogirl63.beyond_orbita.compats.theoneprobe;

import mcjty.theoneprobe.api.IElement;
import mcjty.theoneprobe.api.IElementFactory;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;

public class GaugeValueElementFactory implements IElementFactory {

    public static final ResourceLocation ELEMENT_ID = new ResourceLocation(BeyondOrbitaMod.MODID, "top_element");
    public static final GaugeValueElementFactory INSTANCE = new GaugeValueElementFactory();

    @Override
    public ResourceLocation getId() {
        return ELEMENT_ID;
    }

    @Override
    public IElement createElement(FriendlyByteBuf buffer) {
        return new GaugeValueElement(buffer);
    }

}
