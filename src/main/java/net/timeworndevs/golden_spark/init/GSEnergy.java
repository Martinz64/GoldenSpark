package net.timeworndevs.golden_spark.init;

import team.reborn.energy.api.EnergyStorage;

import static net.timeworndevs.golden_spark.init.GSBlockEntityTypes.ENDLESS_SOURCE_TYPE;
import static net.timeworndevs.golden_spark.init.GSBlockEntityTypes.POWERED_FURNACE_TYPE;

public class GSEnergy {

    public static void init(){
        EnergyStorage.SIDED.registerForBlockEntity((endlessSourceBlockEntity, direction) -> endlessSourceBlockEntity.energyStorage, ENDLESS_SOURCE_TYPE);
        EnergyStorage.SIDED.registerForBlockEntity((poweredFurnaceBlockEntity, direction) -> poweredFurnaceBlockEntity.energyStorage, POWERED_FURNACE_TYPE);
    }
}
