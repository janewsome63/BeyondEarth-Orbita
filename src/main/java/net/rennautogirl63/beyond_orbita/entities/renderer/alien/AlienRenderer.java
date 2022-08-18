package net.rennautogirl63.beyond_orbita.entities.renderer.alien;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.rennautogirl63.beyond_orbita.BeyondOrbitaMod;
import net.rennautogirl63.beyond_orbita.entities.alien.AlienEntity;

public class AlienRenderer extends MobRenderer<AlienEntity, AlienModel<AlienEntity>> {

    /**
     * TEXTURES
     */
    public static final ResourceLocation texDefault = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien.png");

    public static final ResourceLocation tex1 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien1.png");
    public static final ResourceLocation tex2 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien2.png");
    public static final ResourceLocation tex3 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien3.png");
    public static final ResourceLocation tex4 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien4.png");
    public static final ResourceLocation tex5 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien5.png");
    public static final ResourceLocation tex6 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien6.png");
    public static final ResourceLocation tex7 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien7.png");
    public static final ResourceLocation tex8 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien8.png");
    public static final ResourceLocation tex9 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien9.png");
    public static final ResourceLocation tex10 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien10.png");
    public static final ResourceLocation tex11 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien11.png");
    public static final ResourceLocation tex12 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien12.png");
    public static final ResourceLocation tex13 = new ResourceLocation(BeyondOrbitaMod.MODID, "textures/entities/alien/entity_alien13.png");


    public AlienRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new AlienModel<>(renderManagerIn.bakeLayer(AlienModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public ResourceLocation getTextureLocation(AlienEntity entity) {
        if (entity.getVillagerData().getProfession() == VillagerProfession.FARMER) {
            return tex1;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.FISHERMAN) {
            return tex2;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.SHEPHERD) {
            return tex3;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.FLETCHER) {
            return tex4;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.LIBRARIAN) {
            return tex5;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.CARTOGRAPHER) {
            return tex6;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.CLERIC) {
            return tex7;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.ARMORER) {
            return tex8;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.WEAPONSMITH) {
            return tex9;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.TOOLSMITH) {
            return tex10;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.BUTCHER) {
            return tex11;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.LEATHERWORKER) {
            return tex12;
        } else if (entity.getVillagerData().getProfession() == VillagerProfession.MASON) {
            return tex13;
        }

        return texDefault;
    }
}