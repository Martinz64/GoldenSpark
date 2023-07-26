package net.timeworndevs.golden_spark.init;

import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;

public class GSItems {

    public static final Item GS_ICON = new Item(new Item.Settings());
    public static final Item SPIREMETAL_INGOT = new Item(new Item.Settings());
    public static final Item TONITRIUM_INGOT = new Item(new Item.Settings());

    public static final BlockItem SPIREMETAL_BLOCK = new BlockItem(GSBlocks.SPIREMETAL_BLOCK, new Item.Settings());
    public static final BlockItem TONITRIUM_BLOCK = new BlockItem(GSBlocks.TONITRIUM_BLOCK, new Item.Settings());
    public static final BlockItem STORMGLASS = new BlockItem(GSBlocks.STORMGLASS, new Item.Settings());

    public static final BlockItem ENDLESS_SOURCE = new BlockItem(GSBlocks.ENDLESS_SOURCE, new Item.Settings());

    public static void init() {
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "butter_spark"), GS_ICON);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "spiremetal_ingot"), SPIREMETAL_INGOT);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "tonitrium_ingot"), TONITRIUM_INGOT);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "spiremetal_block"), SPIREMETAL_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "tonitrium_block"), TONITRIUM_BLOCK);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "stormglass"), STORMGLASS);
        Registry.register(Registries.ITEM, new Identifier(GSMain.MODID, "endless_source"), ENDLESS_SOURCE);
    }
}
