package net.mehvahdjukaar.amendments.integration.fabric;

import net.mehvahdjukaar.amendments.common.CakeRegistry;
import net.mehvahdjukaar.amendments.reg.ModRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CakeBlock;
import net.minecraft.world.level.block.state.BlockState;

public class FarmersDelightCompatImpl {
    public static InteractionResult onCakeInteract(BlockState state, BlockPos pos, Level level, ItemStack stack) {
        if (stack.is(TagsRegistry.KNIVES)) {
            int bites = state.getValue(CakeBlock.BITES);
            if (bites < 6) {
                level.setBlock(pos, state.setValue(CakeBlock.BITES, bites + 1), 3);
            } else {
                if (state.is(ModRegistry.DOUBLE_CAKES.get(CakeRegistry.VANILLA)))
                    level.setBlock(pos, Blocks.CAKE.defaultBlockState(), 3);
                else
                    level.removeBlock(pos, false);
            }
            //Block.popResource();
            Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ItemsRegistry.CAKE_SLICE.get()));
            level.playSound(null, pos, SoundEvents.WOOL_BREAK, SoundSource.PLAYERS, 0.8F, 0.8F);
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        return InteractionResult.PASS;
    }
}
