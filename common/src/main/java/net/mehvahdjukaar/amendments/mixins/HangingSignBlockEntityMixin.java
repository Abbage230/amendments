package net.mehvahdjukaar.amendments.mixins;

import dev.architectury.injectables.annotations.PlatformOnly;
import net.mehvahdjukaar.amendments.common.ExtendedHangingSign;
import net.mehvahdjukaar.amendments.common.tile.HangingSignTileExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.HangingSignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(HangingSignBlockEntity.class)
public abstract class HangingSignBlockEntityMixin extends BlockEntity implements ExtendedHangingSign {

    @Unique
    private final HangingSignTileExtension supplementaries$extension = new HangingSignTileExtension(this.getBlockState());

    protected HangingSignBlockEntityMixin(BlockEntityType<?> blockEntityType, BlockPos blockPos, BlockState blockState) {
        super(blockEntityType, blockPos, blockState);
    }

    @PlatformOnly(PlatformOnly.FORGE)
    public AABB getRenderBoundingBox() {
        return new AABB(worldPosition).inflate(0.5);
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);
        this.supplementaries$extension.saveAdditional(tag);
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);
        this.supplementaries$extension.load(tag);
    }

    @Override
    public HangingSignTileExtension getExtension() {
        return supplementaries$extension;
    }
}
