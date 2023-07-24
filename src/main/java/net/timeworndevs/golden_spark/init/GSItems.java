package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;

public class GSItems {

    public static Item SPIREMETAL_INGOT;

    public static void init() {
        SPIREMETAL_INGOT = GSRegistryHelper.register("spiremetal_ingot", new Item(new Item.Settings()));
    }

    public static void addItemGroups() {
        ItemGroupEvents.modifyEntriesEvent(GSItemGroups.GOLDEN_SPARK_MAIN).register(content -> content.add(SPIREMETAL_INGOT));
    }
}
