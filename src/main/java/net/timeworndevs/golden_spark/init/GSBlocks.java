package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.Item;
import net.minecraft.sound.BlockSoundGroup;

public class GSBlocks {

    public static Block SPIREMETAL_BLOCK;

    public static void init() {
        SPIREMETAL_BLOCK = GSRegistryHelper.register("spiremetal_block", new Block(FabricBlockSettings.of().mapColor(MapColor.GOLD).sounds(BlockSoundGroup.COPPER).instrument(Instrument.IRON_XYLOPHONE).requiresTool().strength(5.0F, 6.0F)));
    }

}
