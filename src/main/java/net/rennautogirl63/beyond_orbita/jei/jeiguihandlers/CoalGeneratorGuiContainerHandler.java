package net.rennautogirl63.beyond_orbita.jei.jeiguihandlers;

import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.recipe.IFocusFactory;
import mezz.jei.api.runtime.IRecipesGui;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.rennautogirl63.beyond_orbita.gauge.GaugeTextHelper;
import net.rennautogirl63.beyond_orbita.gauge.GaugeValueHelper;
import net.rennautogirl63.beyond_orbita.guis.helper.GuiHelper;
import net.rennautogirl63.beyond_orbita.guis.screens.coalgenerator.CoalGeneratorGuiWindow;
import net.rennautogirl63.beyond_orbita.jei.JeiPlugin;

import java.util.*;

public class CoalGeneratorGuiContainerHandler implements IGuiContainerHandler<CoalGeneratorGuiWindow> {

    public CoalGeneratorGuiContainerHandler() {

    }

    @Override
    public Collection<IGuiClickableArea> getGuiClickableAreas(CoalGeneratorGuiWindow containerScreen, double mouseX, double mouseY) {
        return Collections.singleton(new IGuiClickableArea() {
            @Override
            public Rect2i getArea() {
                return GuiHelper.getFireBounds(CoalGeneratorGuiWindow.FIRE_LEFT, CoalGeneratorGuiWindow.FIRE_TOP).toRect2i();
            }

            @Override
            public void onClick(IFocusFactory focusFactory, IRecipesGui recipesGui) {
                recipesGui.showTypes(Arrays.asList(JeiPlugin.CoalGeneratorJeiCategory.recipeType));
            }

            @Override
            public List<Component> getTooltipStrings() {
                List<Component> list = new ArrayList<>();
                list.add(GaugeTextHelper.getStorageText(GaugeValueHelper.getBurnTime(containerScreen.getMenu().getBlockEntity().getPowerSystemGenerating())).build());
                list.add(new TranslatableComponent("jei.tooltip.show.recipes"));
                return list;
            }
        });
    }
}