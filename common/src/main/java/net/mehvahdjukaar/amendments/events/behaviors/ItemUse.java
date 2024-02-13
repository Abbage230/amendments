package net.mehvahdjukaar.amendments.events.behaviors;

import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;
import org.jetbrains.annotations.Nullable;

interface ItemUse {


    boolean isEnabled();

    boolean appliesToItem(Item item);

    @Nullable
    default MutableComponent getTooltip() {
        return null;
    }

    InteractionResult tryPerformingAction(Level world, Player player, InteractionHand hand,
                                          ItemStack stack, BlockHitResult hit);
}
