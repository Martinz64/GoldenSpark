package net.timeworndevs.golden_spark.block;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.timeworndevs.golden_spark.block_entity.EndlessSourceBlockEntity;
import net.timeworndevs.golden_spark.init.GSBlockEntityTypes;
import org.jetbrains.annotations.Nullable;

public class EndlessSourceBlock extends BlockWithEntity {

    public EndlessSourceBlock(Settings settings) {
        super(settings);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EndlessSourceBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        //return checkType(type, GSBlockEntityTypes.ENDLESS_SOURCE_TYPE, (world1, pos, state1, be) -> EndlessSourceBlockEntity.tick(world1, pos, state1, be));
        //intellij told me to change it to this:
        return checkType(type, GSBlockEntityTypes.ENDLESS_SOURCE_TYPE, EndlessSourceBlockEntity::tick);
    }
}
