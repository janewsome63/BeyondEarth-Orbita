package net.rennautogirl63.beyond_orbita.crafting;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.rennautogirl63.beyond_orbita.registries.RecipeSerializersRegistry;

public class OxygenLoaderRecipe extends OxygenMakingRecipeAbstract {

	public OxygenLoaderRecipe(ResourceLocation id, JsonObject json) {
		super(id, json);
	}

	public OxygenLoaderRecipe(ResourceLocation id, FriendlyByteBuf buffer) {
		super(id, buffer);
	}

	public OxygenLoaderRecipe(ResourceLocation id, FluidIngredient ingredient, int oxygen) {
		super(id, ingredient, oxygen);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RecipeSerializersRegistry.RECIPE_SERIALIZER_OXYGEN_LOADER.get();
	}

	@Override
	public RecipeType<?> getType() {
		return BeyondEarthRecipeTypes.OXYGEN_LOADING;
	}

}
