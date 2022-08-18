package net.rennautogirl63.beyond_orbita.jei.jeiguihandlers;

import mezz.jei.api.gui.handlers.IGuiClickableArea;
import mezz.jei.api.gui.handlers.IGuiContainerHandler;
import mezz.jei.api.recipe.IFocusFactory;
import mezz.jei.api.runtime.IRecipesGui;
import net.minecraft.client.renderer.Rect2i;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.rennautogirl63.beyond_orbita.guis.screens.rover.RoverGuiWindow;
import net.rennautogirl63.beyond_orbita.jei.JeiPlugin;

import java.util.*;

public class RoverGuiContainerHandler implements IGuiContainerHandler<RoverGuiWindow> {

    public RoverGuiContainerHandler() {

    }

    @Override
    public Collection<IGuiClickableArea> getGuiClickableAreas(RoverGuiWindow containerScreen, double mouseX, double mouseY) {
        return Collections.singleton(new IGuiClickableArea() {
            @Override
            public Rect2i getArea() {
                return containerScreen.getFluidBounds().toRect2i();
            }

            @Override
            public void onClick(IFocusFactory focusFactory, IRecipesGui recipesGui) {
                recipesGui.showTypes(Arrays.asList(JeiPlugin.RoverJeiCategory.recipeType));
            }

            @Override
            public List<Component> getTooltipStrings() {
                List<Component> list = new ArrayList<>();
                list.add(containerScreen.getFuelGaugeComponent());
                list.add(new TranslatableComponent("jei.tooltip.show.recipes"));
                return list;
            }
        });
    }
}
