package net.mehvahdjukaar.amendments.common.fabric;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;


public class FlowerPotHandlerImpl {

    public static void setup() {
    }

    public static boolean isEmptyPot(Block b) {
        return b == Blocks.FLOWER_POT;
    }

    public static Block getFullPot(FlowerPotBlock emptyPot, Block flowerBlock) {
        return FlowerPotBlock.POTTED_BY_CONTENT.get(flowerBlock);
    }

    public static Block getEmptyPot(FlowerPotBlock fullPot) {
        return Blocks.FLOWER_POT;
    }
}
