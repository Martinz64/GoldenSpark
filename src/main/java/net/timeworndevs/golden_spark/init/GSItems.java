package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;

public class GSItems {

    public static Item SPIREMETAL_INGOT;

    public static BlockItem SPIREMETAL_BLOCK;

    public static void init() {
        SPIREMETAL_INGOT = GSRegistryHelper.register("spiremetal_ingot", new Item(new Item.Settings()));
        SPIREMETAL_BLOCK = GSRegistryHelper.register("spiremetal_block", new BlockItem(GSBlocks.SPIREMETAL_BLOCK, new Item.Settings()));
        tempItemGroups();
    }

    public static void tempItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(content -> {content.add(SPIREMETAL_INGOT);});
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(content -> {content.add(SPIREMETAL_BLOCK);});
    }
}
