package net.rennautogirl63.beyond_orbita.compats;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.rennautogirl63.beyond_orbita.compats.mekanism.MekanismCompat;
import net.rennautogirl63.beyond_orbita.compats.theoneprobe.TOPCompat;
import net.rennautogirl63.beyond_orbita.compats.tinkers.TinkersCompat;
import net.rennautogirl63.beyond_orbita.compats.waila.WailaCompat;
import net.rennautogirl63.beyond_orbita.jei.JeiCompat;

public class CompatibleManager {

	public static final List<CompatibleMod> MODS;
	public static final JeiCompat JEI;
	public static final TinkersCompat TINKERS;
	public static final TOPCompat TOP;
	public static final WailaCompat WAILA;
	public static final MekanismCompat MEKANISM;

	static {
		List<CompatibleMod> mods = new ArrayList<>();
		mods.add(JEI = new JeiCompat());
		mods.add(TINKERS = new TinkersCompat());
		mods.add(TOP = new TOPCompat());
		mods.add(WAILA = new WailaCompat());
		mods.add(MEKANISM = new MekanismCompat());

		for (CompatibleMod mod : mods) {
			mod.tryLoad();
		}

		MODS = Collections.unmodifiableList(mods);
	}

	public static void visit() {

	}
}
