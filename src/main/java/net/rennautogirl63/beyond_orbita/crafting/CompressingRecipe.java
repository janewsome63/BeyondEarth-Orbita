package net.rennautogirl63.beyond_orbita.crafting;

import com.google.gson.JsonObject;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.rennautogirl63.beyond_orbita.registries.RecipeSerializersRegistry;

public class CompressingRecipe extends ItemStackToItemStackRecipe {

	public CompressingRecipe(ResourceLocation id, JsonObject json) {
		super(id, json);
	}

	public CompressingRecipe(ResourceLocation id, FriendlyByteBuf buffer) {
		super(id, buffer);
	}

	public CompressingRecipe(ResourceLocation id, Ingredient ingredient, ItemStack output, int cookTime) {
		super(id, ingredient, output, cookTime);
	}

	@Override
	public RecipeSerializer<?> getSerializer() {
		return RecipeSerializersRegistry.RECIPE_SERIALIZER_COMPRESSOR.get();
	}

	@Override
	public RecipeType<?> getType() {
		return BeyondEarthRecipeTypes.COMPRESSING;
	}

}
