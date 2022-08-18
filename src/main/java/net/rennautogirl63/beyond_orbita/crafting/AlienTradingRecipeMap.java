package net.rennautogirl63.beyond_orbita.crafting;

import com.google.gson.JsonObject;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.TagKey;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraftforge.registries.ForgeRegistries;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.registries.RecipeSerializersRegistry;
import net.rennautogirl63.beyond_orbita.utils.EnumUtils;
import org.apache.commons.lang3.tuple.Triple;

import java.util.Locale;
import java.util.Random;

public class AlienTradingRecipeMap extends AlienTradingRecipeItemStackBase {

    private ResourceLocation structureName;
    private MapDecoration.Type mapDecorationType;

    public AlienTradingRecipeMap(ResourceLocation id, JsonObject json) {
        super(id, json);

        JsonObject result = GsonHelper.getAsJsonObject(json, "result");
        this.structureName = new ResourceLocation(GsonHelper.getAsString(result, "structureName"));
        this.mapDecorationType = EnumUtils.valueOfIgnoreCase(MapDecoration.Type.class, GsonHelper.getAsString(result, "mapDecorationType"));
    }

    public AlienTradingRecipeMap(ResourceLocation id, FriendlyByteBuf buffer) {
        super(id, buffer);

        this.structureName = buffer.readResourceLocation();
        this.mapDecorationType = buffer.readEnum(MapDecoration.Type.class);
    }

    @Override
    public void write(FriendlyByteBuf buffer) {
        super.write(buffer);

        buffer.writeResourceLocation(this.structureName);
        buffer.writeEnum(this.mapDecorationType);
    }

    public static final TagKey<EntityType<?>> OXYGEN_TAG = TagKey.create(Registry.ENTITY_TYPE_REGISTRY, new ResourceLocation(BeyondOrbitaMod.MODID, "entities/oxygen"));

    @Override
    public Triple<ItemStack, ItemStack, ItemStack> getTrade(Entity trader, Random rand) {
        Level level = trader.level;
        StructureFeature<?> structure = ForgeRegistries.STRUCTURE_FEATURES.getValue(this.getStructureName());
        ItemStack itemstack = new ItemStack(Items.FILLED_MAP);

        if (level instanceof ServerLevel) {
            ServerLevel serverWorld = (ServerLevel) level;
            BlockPos blockpos = serverWorld.findNearestMapFeature(TagKey.create(Registry.CONFIGURED_STRUCTURE_FEATURE_REGISTRY, structure.getRegistryName()), trader.blockPosition(), 100, true);

            if (blockpos != null) {
                itemstack = MapItem.create(level, blockpos.getX(), blockpos.getZ(), (byte) 2, true, true);
                MapItemSavedData.addTargetDecoration(itemstack, blockpos, "+", this.getMapDecorationType());
            }

            MapItem.renderBiomePreviewMap(serverWorld, itemstack);
        }

        itemstack.setHoverName(new TranslatableComponent("filled_map." + structure.getRegistryName().toString().toLowerCase(Locale.ROOT)));
        return Triple.of(this.getCostA(), this.getCostB(), itemstack);
    }

    public ResourceLocation getStructureName() {
        return this.structureName;
    }

    public MapDecoration.Type getMapDecorationType() {
        return this.mapDecorationType;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return RecipeSerializersRegistry.RECIPE_SERIALIZER_ALIEN_TRADING_MAP.get();
    }

    @Override
    public RecipeType<?> getType() {
        return BeyondEarthRecipeTypes.ALIEN_TRADING_MAP;
    }

    public static class Serializer extends BeyondEarthRecipeSerializer<AlienTradingRecipeMap> {
        @Override
        public AlienTradingRecipeMap fromJson(ResourceLocation id, JsonObject json) {
            return new AlienTradingRecipeMap(id, json);
        }

        @Override
        public AlienTradingRecipeMap fromNetwork(ResourceLocation id, FriendlyByteBuf buffer) {
            return new AlienTradingRecipeMap(id, buffer);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, AlienTradingRecipeMap recipe) {
            recipe.write(buffer);
        }

    }

}
