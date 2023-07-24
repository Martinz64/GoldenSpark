package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;

public class GSItemGroups {

    public static final ItemGroup GOLDEN_SPARK_MAIN = FabricItemGroup.builder().icon(() -> new ItemStack(GSItems.SPIREMETAL_INGOT)).displayName(Text.translatable("itemGroup.golden_spark.golden_spark_main")).build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, new Identifier(GSMain.MODID, "golden_Spark_main"), GOLDEN_SPARK_MAIN);
    }
}
