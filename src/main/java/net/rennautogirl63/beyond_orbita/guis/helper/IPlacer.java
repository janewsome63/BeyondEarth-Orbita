package net.rennautogirl63.beyond_orbita.guis.helper;

import net.rennautogirl63.beyond_orbita.utils.Rectangle2d;

@FunctionalInterface
public interface IPlacer {
    Rectangle2d place(int index, int left, int top, int mod);
}
