package net.rennautogirl63.beyond_orbita.guis.screens.planetselection.helper;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CategoryHelper {

    private int category = 0;

    public int get() {
        return category;
    }

    public void set(int category) {
        this.category = category;
    }
}
