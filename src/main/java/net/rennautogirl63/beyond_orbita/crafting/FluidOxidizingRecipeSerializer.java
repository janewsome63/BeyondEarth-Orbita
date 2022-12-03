package net.rennautogirl63.beyond_orbita.crafting;

import com.google.gson.JsonObject;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;

public class FluidOxidizingRecipeSerializer extends BeyondEarthRecipeSerializer<FluidOxidizingRecipe> {

    @Override
    public FluidOxidizingRecipe fromJson(ResourceLocation id, JsonObject json) {
        return new FluidOxidizingRecipe(id, json);
    }

    @Override
    public FluidOxidizingRecipe fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
        return new FluidOxidizingRecipe(id, buffer);
    }

    @Override
    public void toNetwork(FriendlyByteBuf buffer, FluidOxidizingRecipe recipe) {
        recipe.write(buffer);
    }

}
