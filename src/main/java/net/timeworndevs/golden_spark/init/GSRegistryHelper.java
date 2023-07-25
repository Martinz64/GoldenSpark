package net.timeworndevs.golden_spark.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;

public class GSRegistryHelper {

    public GSRegistryHelper() {
        return;
    }

    public static BlockItem registerBlockItem(String name, Block block) {
        BlockItem item = new BlockItem(block, new Item.Settings());
        return register(name, item);
    }

    public static <I extends Item> I register(String name, I item){
        if(item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, blockItem);
        }
        return Registry.register(Registries.ITEM, Identifier.of(GSMain.MODID, name), item);
    }

    public static <B extends Block> B register(String name, B block){
        return Registry.register(Registries.BLOCK, Identifier.of(GSMain.MODID, name), block);
    }

}
