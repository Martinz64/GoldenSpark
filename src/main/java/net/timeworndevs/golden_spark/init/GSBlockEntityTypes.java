package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;
import net.timeworndevs.golden_spark.block_entity.EndlessSourceBlockEntity;

public class GSBlockEntityTypes {

    //This BlockEntity type is for a creative power cell
    //e
    public static BlockEntityType<EndlessSourceBlockEntity> ENDLESS_SOURCE_TYPE;

    public static void init() {
        ENDLESS_SOURCE_TYPE = Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(GSMain.MODID, "endless_source_entity"), FabricBlockEntityTypeBuilder.create(EndlessSourceBlockEntity::new, GSBlocks.ENDLESS_SOURCE).build());
    }

}
