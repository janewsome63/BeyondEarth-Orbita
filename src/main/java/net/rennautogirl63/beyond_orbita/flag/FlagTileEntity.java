package net.rennautogirl63.beyond_orbita.flag;

import com.mojang.authlib.GameProfile;

import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.util.StringUtil;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.rennautogirl63.beyond_orbita.registries.BlockEntitiesRegistry;

public class FlagTileEntity extends BlockEntity {

    @Nullable
    private GameProfile owner;

    public FlagTileEntity(BlockPos pos, BlockState state) {
        super(BlockEntitiesRegistry.FLAG_BLOCK_ENTITY.get(), pos, state);
    }

    @Override
    protected void saveAdditional(CompoundTag p_187518_) {
        super.saveAdditional(p_187518_);
        if (this.owner != null) {
            CompoundTag compoundtag = new CompoundTag();
            NbtUtils.writeGameProfile(compoundtag, this.owner);
            p_187518_.put("FlagOwner", compoundtag);
        }

    }

    @Override
    public void load(CompoundTag p_155745_) {
        super.load(p_155745_);
        if (p_155745_.contains("FlagOwner", 10)) {
            this.setOwner(NbtUtils.readGameProfile(p_155745_.getCompound("FlagOwner")));
        } else if (p_155745_.contains("ExtraType", 8)) {
            String s = p_155745_.getString("ExtraType");
            if (!StringUtil.isNullOrEmpty(s)) {
                this.setOwner(new GameProfile((UUID)null, s));
            }
        }
    }

    @Nullable
    @OnlyIn(Dist.CLIENT)
    public GameProfile getPlayerProfile() {
        return this.owner;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public CompoundTag getUpdateTag() {
        return this.saveWithFullMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        this.load(pkt.getTag());
    }

    public void setOwner(@Nullable GameProfile p_59770_) {
        synchronized(this) {
            this.owner = p_59770_;
        }

        this.updateOwnerProfile();
    }

    private void updateOwnerProfile() {
        SkullBlockEntity.updateGameprofile(this.owner, (p_155747_) -> {
            this.owner = p_155747_;
            this.setChanged();
        });
    }
}