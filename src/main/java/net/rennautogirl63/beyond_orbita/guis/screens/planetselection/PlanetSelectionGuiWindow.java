package net.rennautogirl63.beyond_orbita.guis.screens.planetselection;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.crafting.IngredientStack;
import net.rennautogirl63.beyond_orbita.crafting.SpaceStationRecipe;
import net.rennautogirl63.beyond_orbita.events.forge.PlanetSelectionGuiBackgroundRenderEvent;
import net.rennautogirl63.beyond_orbita.events.forge.PlanetSelectionGuiButtonVisibilityEvent;
import net.rennautogirl63.beyond_orbita.events.forge.PlanetSelectionGuiInitEvent;
import net.rennautogirl63.beyond_orbita.events.forge.PlanetSelectionGuiRenderEvent;
import net.rennautogirl63.beyond_orbita.guis.helper.ImageButtonPlacer;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.helper.CategoryHelper;
import net.rennautogirl63.beyond_orbita.guis.screens.planetselection.helper.PlanetSelectionGuiHelper;
import net.rennautogirl63.beyond_orbita.registries.NetworksRegistry;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class PlanetSelectionGuiWindow extends Screen implements MenuAccess<PlanetSelectionGui.GuiContainer> {

    /**
     * TEXTURES
     */
    public static final ResourceLocation BACKGROUND_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/screens/planet_selection.png");

    public static final ResourceLocation SCROLLER_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/scroller.png");

    public static final ResourceLocation GREEN_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/green_button.png");
    public static final ResourceLocation GREEN_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/green_button_2.png");

    public static final ResourceLocation RED_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/red_button.png");
    public static final ResourceLocation RED_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/red_button_2.png");

    public static final ResourceLocation DARK_BLUE_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/dark_blue_button.png");
    public static final ResourceLocation DARK_BLUE_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/dark_blue_button_2.png");

    public static final ResourceLocation BLUE_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/blue_button.png");
    public static final ResourceLocation BLUE_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/blue_button_2.png");

    public static final ResourceLocation SMALL_BLUE_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/small_blue_button.png");
    public static final ResourceLocation SMALL_BLUE_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/small_blue_button_2.png");

    public static final ResourceLocation LARGE_GREEN_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/big_green_button.png");
    public static final ResourceLocation LARGE_GREEN_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/big_green_button_2.png");

    public static final ResourceLocation LARGE_RED_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/big_red_button.png");
    public static final ResourceLocation LARGE_RED_LIGHT_BUTTON_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/buttons/big_red_button_2.png");

    public static final ResourceLocation MILKY_WAY_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/milky_way.png");

    public static final ResourceLocation SUN_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/sun.png");
    public static final ResourceLocation BLUE_SUN_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/blue_sun.png");
    public static final ResourceLocation MARS_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/mars.png");
    public static final ResourceLocation EARTH_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/earth.png");
    public static final ResourceLocation VENUS_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/venus.png");
    public static final ResourceLocation MERCURY_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/mercury.png");
    public static final ResourceLocation ASTEROID_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/asteroid.png");
    public static final ResourceLocation PLUTO_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/pluto.png");

    public static final ResourceLocation RELICTUS_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/sky/gui/relictus.png");

    public static final ResourceLocation SMALL_MENU_LIST = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/rocket_menu_list.png");
    public static final ResourceLocation LARGE_MENU_TEXTURE = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/rocket_menu_list_2.png");

    /** Text */
    public static final Component CATALOG_TEXT = PlanetSelectionGuiHelper.tl("catalog");
    public static final Component BACK_TEXT = PlanetSelectionGuiHelper.tl("back");

    public static final Component SUN_TEXT = PlanetSelectionGuiHelper.tl("sun");
    public static final Component TAU_CETI_TEXT = PlanetSelectionGuiHelper.tl("tau_ceti");

    public static final Component SOLAR_SYSTEM_TEXT = PlanetSelectionGuiHelper.tl("solar_system");

    public static final Component SOLAR_SYSTEM_SUN_TEXT = PlanetSelectionGuiHelper.tl("solar_system_sun");
    public static final Component SOLAR_SYSTEM_TAU_CETI_TEXT = PlanetSelectionGuiHelper.tl("solar_system_tau_ceti");

    public static final Component MERCURY_TEXT = PlanetSelectionGuiHelper.tl("mercury");
    public static final Component VENUS_TEXT = PlanetSelectionGuiHelper.tl("venus");
    public static final Component EARTH_TEXT = PlanetSelectionGuiHelper.tl("earth");
    public static final Component MOON_TEXT = PlanetSelectionGuiHelper.tl("moon");
    public static final Component MARS_TEXT = PlanetSelectionGuiHelper.tl("mars");
    public static final Component ASTEROID_BELT_TEXT = PlanetSelectionGuiHelper.tl("asteroid_belt");
    public static final Component PLUTO_TEXT = PlanetSelectionGuiHelper.tl("pluto");

    public static final Component RELICTUS_TEXT = PlanetSelectionGuiHelper.tl("relictus");

    public static final Component PLANET_TEXT = PlanetSelectionGuiHelper.tl("planet");
    public static final Component DWARF_PLANET_TEXT = PlanetSelectionGuiHelper.tl("dwarf_planet");
    public static final Component ORBIT_TEXT = PlanetSelectionGuiHelper.tl("orbit");
    public static final Component ASTEROID_TEXT = PlanetSelectionGuiHelper.tl("asteroid_field");

    public static final Component NO_GRAVITY_TEXT = PlanetSelectionGuiHelper.tl("no_gravity");

    public static final Component SPACE_STATION_TEXT = PlanetSelectionGuiHelper.tl("space_station");

    public static final Component CATEGORY_TEXT = PlanetSelectionGuiHelper.tl("category");
    public static final Component ROCKET_TEXT = PlanetSelectionGuiHelper.tl("rocket");
    public static final Component TYPE_TEXT = PlanetSelectionGuiHelper.tl("type");
    public static final Component GRAVITY_TEXT = PlanetSelectionGuiHelper.tl("gravity");
    public static final Component OXYGEN_TEXT = PlanetSelectionGuiHelper.tl("oxygen");
    public static final Component TEMPERATURE_TEXT = PlanetSelectionGuiHelper.tl("temperature");
    public static final Component OXYGEN_TRUE_TEXT = PlanetSelectionGuiHelper.tl("oxygen.true");
    public static final Component OXYGEN_FALSE_TEXT = PlanetSelectionGuiHelper.tl("oxygen.false");
    public static final Component ITEM_REQUIREMENT_TEXT = PlanetSelectionGuiHelper.tl("item_requirement");

    public static final Component ROCKET_TIER_1_TEXT = new TranslatableComponent("entity." + BeyondOrbitaMod.MODID + ".rocket_t" + 1);
    public static final Component ROCKET_TIER_2_TEXT = new TranslatableComponent("entity." + BeyondOrbitaMod.MODID + ".rocket_t" + 2);
    public static final Component ROCKET_TIER_3_TEXT = new TranslatableComponent("entity." + BeyondOrbitaMod.MODID + ".rocket_t" + 3);
    public static final Component ROCKET_TIER_4_TEXT = new TranslatableComponent("entity." + BeyondOrbitaMod.MODID + ".rocket_t" + 4);

    /**
     * MENU
     */
    private PlanetSelectionGui.GuiContainer menu;

    /**
     * CATEGORY
     */
    public CategoryHelper category; //IF YOU DO A ADDON MOD SET THIS CATEGORY TO -1 AND CREATE A OWN WITH "AbstractCategoryHelper"

    /**
     * BUTTON LISTS
     */
    public List<ImageButtonPlacer> visibleButtons;

    /** Rotations */
    public float rotationMilkyWay;
    public float rotationMars;
    public float rotationEarth;
    public float rotationVenus;
    public float rotationMercury;
    public float rotationAsteroid;
    public float rotationPluto;
    public float rotationRelictus;

    /** System Buttons */
    public ImageButtonPlacer solarSystemButton;
    public ImageButtonPlacer tauCetiButton;

    /** Sol Buttons */
    public ImageButtonPlacer mercuryButton;
    public ImageButtonPlacer venusButton;

        /** Earth Category */
        public ImageButtonPlacer earthCategoryButton;
        public ImageButtonPlacer earthButton;
        public ImageButtonPlacer moonButton;
        public ImageButtonPlacer spaceStationButton;

    public ImageButtonPlacer orbitButton;
    public ImageButtonPlacer marsButton;
    public ImageButtonPlacer asteroidButton;
    public ImageButtonPlacer plutoButton;

    /** Tau Ceti Buttons */
    public ImageButtonPlacer relictusButton;

    /**
     * BACK BUTTONS
     */
    public ImageButtonPlacer backButton;

    /**
     * SPACE STATION RECIPE SYSTEM
     */
    public SpaceStationRecipe recipe;
    public boolean spaceStationItemList;

    /**
     * SCROLL SYSTEM
     */
    public int scrollIndex;

    /**
     * BUTTON ROW END
     */
    public int rowEnd;

    public PlanetSelectionGuiWindow(PlanetSelectionGui.GuiContainer menu, Inventory inventory, Component p_96550_) {
        super(p_96550_);
        this.menu = menu;
    }

    @Override
    public PlanetSelectionGui.GuiContainer getMenu() {
        return menu;
    }

    @Override
    public void render(PoseStack poseStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBg(poseStack, partialTicks, mouseX, mouseY);
        super.render(poseStack, mouseX, mouseY, partialTicks);

        /** RENDER PRE EVENT FOR ADDONS */
        if (MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiRenderEvent.Pre(this, poseStack, partialTicks, mouseX, mouseY))) {
            return;
        }

        /** CATALOG TEXT RENDERER */
        this.font.draw(poseStack, CATALOG_TEXT, 24, (this.height / 2) - 143 / 2, -1);

        /** RENDER POST EVENT FOR ADDONS */
        MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiRenderEvent.Post(this, poseStack, partialTicks, mouseX, mouseY));
    }

    protected void renderBg(PoseStack poseStack, float partialTicks, int mouseX, int mouseY) {

        /** RENDER BACKGROUND PRE EVENT FOR ADDONS */
        if (MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiBackgroundRenderEvent.Pre(this, poseStack, partialTicks, mouseX, mouseY))) {
            return;
        }

        PlanetSelectionGuiHelper.enableRenderSystem();

        /** BACKGROUND RENDERER */
        PlanetSelectionGuiHelper.addTexture(poseStack, 0, 0, this.width, this.height, BACKGROUND_TEXTURE);

        /** SUN SOLAR SYSTEM RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 23.0, 180);
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 46.0, 180);
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 69.5, 180);
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 92.0, 180);
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 180.0, 180);
        }

        /** TAU CETI SOLAR SYSTEM RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 3, 3)) {
            PlanetSelectionGuiHelper.addCircle(this.width / 2, this.height / 2, 23.0, 180);
        }

        /** OBJECT ROTATIONS */
        this.rotateObjects(partialTicks);

        /** ROTATED OBJECTS RENDERER */
        this.renderRotatedObjects(poseStack);

        /** SUN RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, (this.width - 15) / 2, (this.height - 15) / 2, 15, 15, SUN_TEXTURE);
        }

        /** BLUE SUN RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 3, 3)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, (this.width - 15) / 2, (this.height - 15) / 2, 15, 15, BLUE_SUN_TEXTURE);
        }

        /** SMALL MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 0, 1) || PlanetSelectionGuiHelper.categoryRange(this.category.get(), 3, 3)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (this.height / 2) - 177 / 2, 105, 177, SMALL_MENU_LIST);
            this.renderScroller(poseStack);
        }

        /** LARGE MENU RENDERER */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 2, 2)) {
            PlanetSelectionGuiHelper.addTexture(poseStack, 0, (this.height / 2) - 177 / 2, 215, 177, LARGE_MENU_TEXTURE);
        }

        PlanetSelectionGuiHelper.disableRenderSystem();

        /** RENDER BACKGROUND POST EVENT FOR ADDONS */
        MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiBackgroundRenderEvent.Post(this, poseStack, partialTicks, mouseX, mouseY));
    }

    @Override
    protected void init() {
        super.init();

        /** INIT PRE EVENT FOR ADDONS */
        if (MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiInitEvent.Pre(this))) {
            return;
        }

        /** ROW END */
        this.rowEnd = 5;

        /** SET CATEGORY */
        this.category = new CategoryHelper();

        /** SET PLANET ROTATIONS */
        this.rotationMilkyWay = 0;
        this.rotationMars = 0;
        this.rotationEarth = 90;
        this.rotationVenus = 180;
        this.rotationMercury = 270;
        this.rotationAsteroid = 360;
        this.rotationPluto = 450;
        this.rotationRelictus = 180;

        /** SET SCROLL */
        this.scrollIndex = 0;

        /** SPACE STATION RECIPE SYSTEM */
        this.recipe = (SpaceStationRecipe) this.minecraft.level.getRecipeManager().byKey(SpaceStationRecipe.KEY).orElse(null);
        this.spaceStationItemList = this.recipe.getIngredientStacks().stream().allMatch(this::getSpaceStationItemCheck);

        /** SET BUTTON LISTS */
        this.visibleButtons = Lists.newArrayList();

        /** MAIN CATEGORY BUTTON 1 */
        solarSystemButton = PlanetSelectionGuiHelper.addCategoryButton(this, this.category, 10, 1, 70, 20, 1, true, ImageButtonPlacer.Types.MILKY_WAY_CATEGORY, List.of(SUN_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, SOLAR_SYSTEM_SUN_TEXT);
        this.visibleButton(solarSystemButton, false);

        /** BACK BUTTON */
        backButton = PlanetSelectionGuiHelper.addBackButton(this, 10, 1, 70, 20, DARK_BLUE_BUTTON_TEXTURE, DARK_BLUE_LIGHT_BUTTON_TEXTURE, BACK_TEXT, (onPress) -> {
            if (this.category.get() == 1) {
                this.category.set(0);
                this.scrollIndex = 0;
                this.updateButtonVisibility();
            } else if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 2, 2)) {
                this.category.set(1);
                this.scrollIndex = 0;
                this.updateButtonVisibility();
            } else if (this.category.get() == 3) {
                this.category.set(0);
                this.scrollIndex = 0;
                this.updateButtonVisibility();
            }
        });
        this.visibleButton(backButton, false);

        /** Solar System Planets */
        mercuryButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(3), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(3), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(PLANET_TEXT.getString(), "0.38G", "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "179\u00B0C", ROCKET_TIER_3_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, MERCURY_TEXT);
        this.visibleButton(mercuryButton, false);

        venusButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(2), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(4), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(PLANET_TEXT.getString(), "0.90G", "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "428\u00B0C", ROCKET_TIER_2_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, VENUS_TEXT);
        this.visibleButton(venusButton, false);

        /** Earth Category */
        earthCategoryButton = PlanetSelectionGuiHelper.addCategoryButton(this, this.category, 10, 1, 70, 20, 2, this.checkTier(1), ImageButtonPlacer.Types.SOLAR_SYSTEM_CATEGORY, List.of(EARTH_TEXT.getString()), RED_BUTTON_TEXTURE, RED_LIGHT_BUTTON_TEXTURE, EARTH_TEXT);
        this.visibleButton(earthCategoryButton, false);

        earthButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(1), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(0), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(PLANET_TEXT.getString(), "1.00G", "a" + OXYGEN_TRUE_TEXT.getString(), "a" + "12\u00B0C", ROCKET_TIER_1_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, EARTH_TEXT);
        this.visibleButton(earthButton, false);

        moonButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(1), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(1), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(MOON_TEXT.getString(), "0.17G", "c" + OXYGEN_FALSE_TEXT.getString(), "a" + "-15\u00B0C", ROCKET_TIER_1_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, MOON_TEXT);
        this.visibleButton(moonButton, false);

        orbitButton = PlanetSelectionGuiHelper.addHandlerButton(this, 84, 2, 37, 20, true, true, this.checkTier(1), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(6), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(ORBIT_TEXT.getString(), NO_GRAVITY_TEXT.getString(), "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "0\u00B0C", ROCKET_TIER_1_TEXT.getString()), SMALL_BLUE_BUTTON_TEXTURE, SMALL_BLUE_LIGHT_BUTTON_TEXTURE, ORBIT_TEXT);
        this.visibleButton(orbitButton, false);

        spaceStationButton = PlanetSelectionGuiHelper.addHandlerButton(this, 125, 3, 75, 20, this.spaceStationItemList, true, this.checkTier(1), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(7), ImageButtonPlacer.Types.PLANET_SPACE_STATION_CATEGORY, List.of(ORBIT_TEXT.getString(), NO_GRAVITY_TEXT.getString(), "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "0\u00B0C", ROCKET_TIER_1_TEXT.getString()), LARGE_RED_BUTTON_TEXTURE, LARGE_RED_LIGHT_BUTTON_TEXTURE, SPACE_STATION_TEXT);
        this.visibleButton(spaceStationButton, false);
        /** End Earth Category */

        marsButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(2), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(2), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(PLANET_TEXT.getString(), "0.38G", "c" + OXYGEN_FALSE_TEXT.getString(), "a" + "-28\u00B0C", ROCKET_TIER_2_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, MARS_TEXT);
        this.visibleButton(marsButton, false);

        asteroidButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(3), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(5), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(ASTEROID_TEXT.getString(), NO_GRAVITY_TEXT.getString(), "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "0\u00B0C", ROCKET_TIER_3_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, ASTEROID_BELT_TEXT);
        this.visibleButton(asteroidButton, false);

        plutoButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(3), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(8), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(DWARF_PLANET_TEXT.getString(), "0.06G", "c" + OXYGEN_FALSE_TEXT.getString(), "c" + "-220\u00B0C", ROCKET_TIER_3_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, PLUTO_TEXT);
        this.visibleButton(asteroidButton, false);

        /** Tau Ceti Button */
        tauCetiButton = PlanetSelectionGuiHelper.addCategoryButton(this, this.category, 10, 1, 70, 20, 3, true, ImageButtonPlacer.Types.MILKY_WAY_CATEGORY, List.of(TAU_CETI_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, SOLAR_SYSTEM_TAU_CETI_TEXT);
        this.visibleButton(tauCetiButton, false);

        /** Tau Ceti Planets */
        relictusButton = PlanetSelectionGuiHelper.addHandlerButton(this, 10, 1, 70, 20, true, true, this.checkTier(4), NetworksRegistry.PACKET_HANDLER, PlanetSelectionGuiHelper.getNetworkHandler(9), ImageButtonPlacer.Types.PLANET_CATEGORY, List.of(PLANET_TEXT.getString(), "1.00G", "a" + OXYGEN_TRUE_TEXT.getString(), "a" + "12\u00B0C", ROCKET_TIER_4_TEXT.getString()), BLUE_BUTTON_TEXTURE, BLUE_LIGHT_BUTTON_TEXTURE, RELICTUS_TEXT);
        this.visibleButton(relictusButton, false);

        /** INIT POST EVENT FOR ADDONS */
        MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiInitEvent.Post(this));

        /** UPDATE BUTTON VISIBILITY */
        this.updateButtonVisibility();
    }

    @Override
    public void onClose() {

    }

    @Override
    public boolean mouseScrolled(double p_99314_, double p_99315_, double p_99316_) {
        if (this.getVisibleButtons(1).size() > this.rowEnd) {
            if (p_99316_ == 1) {
                if (this.scrollIndex != 0) {
                    this.scrollIndex = this.scrollIndex + 1;
                    this.updateButtonVisibility();
                    return true;
                }
            } else {
                if (this.scrollIndex != -(this.getVisibleButtons(1).size() - this.rowEnd)) {
                    this.scrollIndex = this.scrollIndex - 1;
                    this.updateButtonVisibility();
                    return true;
                }
            }
        }

        return false;
    }

    public void updateButtonVisibility() {

        /** BUTTON VISIBILITY PRE EVENT FOR ADDONS */
        if (MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiButtonVisibilityEvent.Pre(this))) {
            return;
        }

        this.visibleButtons.clear();

        /** System Visible Logic */
        this.visibleButton(this.solarSystemButton, this.category.get() == 0);
        this.visibleButton(this.tauCetiButton, this.category.get() == 0);

        /** Back Button Visible Logic */
        this.visibleButton(this.backButton, PlanetSelectionGuiHelper.categoryRange(this.category.get(), 1, 3));

        /** Sol Visible Logic */
        this.visibleButton(this.mercuryButton, this.category.get() == 1);
        this.visibleButton(this.venusButton, this.category.get() == 1);
        this.visibleButton(this.earthCategoryButton, this.category.get() == 1);
        this.visibleButton(this.earthButton, this.category.get() == 2);
        this.visibleButton(this.moonButton, this.category.get() == 2);
        this.visibleButton(this.orbitButton, this.category.get() == 2);
        this.visibleButton(this.spaceStationButton, this.category.get() == 2);
        this.visibleButton(this.marsButton, this.category.get() == 1);
        this.visibleButton(this.asteroidButton, this.category.get() == 1);
        this.visibleButton(this.plutoButton, this.category.get() == 1);

        /** Tau Ceti Visible Logic */
        this.visibleButton(this.relictusButton, this.category.get() == 3);

        /** BUTTON VISIBILITY POST EVENT FOR ADDONS */
        MinecraftForge.EVENT_BUS.post(new PlanetSelectionGuiButtonVisibilityEvent.Post(this));
    }

    public void rotateObjects(float partialTicks) {

        /** Solar Systems */
        this.rotationMilkyWay = (this.rotationMilkyWay + partialTicks * 0.4f) % 360;

        /** Sol */
        this.rotationMars = (this.rotationMars + partialTicks * 0.4f) % 360;
        this.rotationEarth = (this.rotationEarth + partialTicks * 0.8f) % 360;
        this.rotationVenus = (this.rotationVenus + partialTicks * 0.7f) % 360;
        this.rotationMercury = (this.rotationMercury + partialTicks * 0.7f) % 360;
        this.rotationAsteroid = (this.rotationAsteroid + partialTicks * 0.1f) % 360;
        this.rotationPluto = (this.rotationPluto + partialTicks * 0.05f) % 360;

        /** Tau Ceti */
        this.rotationRelictus = (this.rotationRelictus + partialTicks * 0.7f) % 360;
    }

    public void renderRotatedObjects(PoseStack poseStack) {

        /** Solar Systems */
        if (this.category.get() == 0) {
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, MILKY_WAY_TEXTURE, -125, -125, 250, 250, this.rotationMilkyWay);
        }

        /** Sol */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 1, 2)) {
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, MARS_TEXTURE, -70, -70, 10, 10, this.rotationMars);
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, EARTH_TEXTURE, -54, -54, 10, 10, this.rotationEarth);
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, VENUS_TEXTURE, -37, -37, 10, 10, this.rotationVenus);
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, MERCURY_TEXTURE, -20.5F, -20.5F, 10, 10, this.rotationMercury);
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, ASTEROID_TEXTURE, -128F, -128F, 256, 256, this.rotationAsteroid);
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, PLUTO_TEXTURE, -132F, -132F, 10, 10, this.rotationPluto);
        }

        /** Tau Ceti */
        if (PlanetSelectionGuiHelper.categoryRange(this.category.get(), 3, 3)) {
            PlanetSelectionGuiHelper.addRotatedObject(this, poseStack, RELICTUS_TEXTURE, -20.5F, -20.5F, 10, 10, this.rotationRelictus);
        }
    }

    public void renderScroller(PoseStack poseStack) {
        if (this.visibleButtons.size() > this.rowEnd) {

            int buttonStartY = (this.height / 2) - 67 / 2;
            int scrollSize = this.visibleButtons.size() - this.rowEnd;

            float y = buttonStartY + ((97.0F / scrollSize) * -this.scrollIndex);

            PlanetSelectionGuiHelper.addTexture(poseStack, 92, (int) y, 4, 8, SCROLLER_TEXTURE);
        }
    }

    public void handleButtonPos(int rowStart, int rowEnd) {
        /** SET POS OF VISIBLE BUTTONS */
        for (int f1 = rowStart; f1 <= rowEnd; f1++) {
            for (int f2 = 0; f2 < this.getVisibleButtons(f1).size(); f2++) {
                ImageButtonPlacer button = this.getVisibleButtons(f1).get(f2);

                int buttonStartY = (this.height / 2) - 68 / 2;

                int extraPos = 0;

                if (f1 >= 2 && rowEnd <= 3) {
                    extraPos = 1;
                }

                int y = buttonStartY + (22 * (f2 + extraPos + this.scrollIndex));

                if (button.y != y) {
                    button.setPosition(button.x, y);
                }
            }
        }
    }

    public boolean buttonScrollVisibility(ImageButtonPlacer button) {
        int buttonStartY = (this.height / 2) - 68 / 2;
        int buttonEndY = buttonStartY + 22 * this.rowEnd;

        /** IF BUTTON ABOVE THE MENU */
        if (button.y < buttonStartY && button.row != 0) {
            return false;
        }

        /** IF BUTTON UNDER THE MENU */
        if (button.y >= buttonEndY && button.row != 0) {
            return false;
        }

        return true;
    }

    public List<ImageButtonPlacer> getVisibleButtons(int row) {
        /** VISIBLE BUTTON LIST */
        List<ImageButtonPlacer> listVisible = new ArrayList<>();

        /** ADD VISIBLE BUTTONS TO THE LIST */
        for (int f1 = 0; f1 < this.visibleButtons.size(); f1++) {
            ImageButtonPlacer button = this.visibleButtons.get(f1);

            if (button.row == row) {
                listVisible.add(button);
            }
        }

        return listVisible;
    }

    public void visibleButton(ImageButtonPlacer button, Boolean condition) {
        /** HANDLE VISIBLE BUTTON LIST */
        if (condition && !visibleButtons.contains(button)) {
            visibleButtons.add(button);
        }

        /** POS HANDLER */
        this.handleButtonPos(1, 3);

        /** BUTTON VISIBILITY */
        button.visible = condition && this.buttonScrollVisibility(button);
    }

    public boolean getSpaceStationItemCheck(IngredientStack ingredientStack) {
        Player player = this.menu.player;

        if (player.getAbilities().instabuild || player.isSpectator()) {
            return true;
        }

        Inventory inv = player.getInventory();
        int itemStackCount = 0;

        for (int i = 0; i < inv.getContainerSize(); ++i) {
            ItemStack itemStack = inv.getItem(i);

            if (ingredientStack.testWithoutCount(itemStack)) {
                itemStackCount += itemStack.getCount();
            }
        }

        return itemStackCount >= ingredientStack.getCount();
    }

    public boolean checkTier(int tier) {
        return PlanetSelectionGuiHelper.checkTier(this.menu.getRocket(), tier);
    }

    /**
     * USE THIS METHOD TO ADD A OWN BUTTON SYSTEM (YOU SHOULD USE THE PlanetGuiHelper ONE, IF YOU NEED NOT A OWN SYSTEM)
     */
    public ImageButtonPlacer addButton(int x, int y, int row, int width, int height, boolean rocketCondition, ImageButtonPlacer.Types type, List<String> list, ResourceLocation buttonTexture, ResourceLocation hoverButtonTexture, Component title, Button.OnPress onPress) {
        ImageButtonPlacer button = this.addRenderableWidget(new ImageButtonPlacer(x, y, row, width, height, 0, 0, 0, rocketCondition, type, list, buttonTexture, hoverButtonTexture, width, height, onPress, title));
        return button;
    }
}