package net.timeworndevs.golden_spark.block_entity;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.timeworndevs.golden_spark.init.GSBlockEntityTypes;
import team.reborn.energy.api.base.SimpleEnergyStorage;

public class EndlessSourceBlockEntity extends BlockEntity {
    public EndlessSourceBlockEntity( BlockPos pos, BlockState state) {
        super(GSBlockEntityTypes.ENDLESS_SOURCE_TYPE, pos, state);
    }

    public static long MAX_ENERGY = 100000000;

    public final SimpleEnergyStorage energyStorage = new SimpleEnergyStorage(MAX_ENERGY, MAX_ENERGY, MAX_ENERGY) {
        @Override
        protected void onFinalCommit() {
            markDirty();
        }
    };

    public void tick() {

    }

    public static void tick(World world, BlockPos pos, BlockState state, EndlessSourceBlockEntity be) {
        be.energyStorage.amount = MAX_ENERGY;
        be.markDirty();
    }
}
