package net.timeworndevs.golden_spark.block_entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.timeworndevs.golden_spark.init.GSBlockEntityTypes;

public class EndlessSourceBlockEntity extends BlockEntity {
    public EndlessSourceBlockEntity( BlockPos pos, BlockState state) {
        super(GSBlockEntityTypes.ENDLESS_SOURCE_TYPE, pos, state);
    }
}
