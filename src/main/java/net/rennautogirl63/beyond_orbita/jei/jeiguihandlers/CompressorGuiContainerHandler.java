package net.rennautogirl63.beyond_orbita.jei.jeiguihandlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.recipe.IFocusFactory;
import mezz.jei.api.runtime.IRecipesGui;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import net.rennautogirl63.beyond_orbita.guis.helper.GuiHelper;
import net.rennautogirl63.beyond_orbita.guis.screens.compressor.CompressorGuiWindow;
import net.rennautogirl63.beyond_orbita.jei.JeiPlugin;

public class CompressorGuiContainerHandler implements IGuiContainerHandler<CompressorGuiWindow> {

	public CompressorGuiContainerHandler() {

	}

	@Override
	public Collection<IGuiClickableArea> getGuiClickableAreas(CompressorGuiWindow containerScreen, double mouseX, double mouseY) {
		return Collections.singleton(new IGuiClickableArea() {
			@Override
			public Rect2i getArea() {
				return GuiHelper.getArrowBounds(CompressorGuiWindow.ARROW_LEFT, CompressorGuiWindow.ARROW_TOP).toRect2i();
			}

			@Override
			public void onClick(IFocusFactory focusFactory, IRecipesGui recipesGui) {
				recipesGui.showTypes(Arrays.asList(JeiPlugin.CompressorJeiCategory.recipeType));
			}

			@Override
			public List<Component> getTooltipStrings() {
				List<Component> list = new ArrayList<>();
				list.add(GaugeTextHelper.getStorageText(containerScreen.getMenu().getBlockEntity().getCookTimeGaugeValue()).build());
				list.add(new TranslatableComponent("jei.tooltip.show.recipes"));
				return list;
			}
		});
	}
}
