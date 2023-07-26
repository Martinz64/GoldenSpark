package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.MapColor;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;
import net.timeworndevs.golden_spark.block.EndlessSourceBlock;

public class GSBlocks {

    public static final Block SPIREMETAL_BLOCK = new Block(FabricBlockSettings.of().mapColor(MapColor.GOLD).sounds(BlockSoundGroup.COPPER).requiresTool().strength(5.0F, 6.0F));
    public static final Block TONITRIUM_BLOCK = new Block(FabricBlockSettings.of().mapColor(MapColor.DARK_AQUA).sounds(BlockSoundGroup.NETHERITE).requiresTool().strength(5.0F, 6.0F));
    public static final GlassBlock STORMGLASS = new GlassBlock(FabricBlockSettings.of().mapColor(MapColor.CYAN).sounds(BlockSoundGroup.GLASS).requiresTool().strength(0.3f).nonOpaque());

    public static final EndlessSourceBlock ENDLESS_SOURCE = new EndlessSourceBlock(FabricBlockSettings.of().mapColor(MapColor.PURPLE).sounds(BlockSoundGroup.COPPER));

    public static void init() {
        Registry.register(Registries.BLOCK, new Identifier(GSMain.MODID, "spiremetal_block"), SPIREMETAL_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(GSMain.MODID, "tonitrium_block"), TONITRIUM_BLOCK);
        Registry.register(Registries.BLOCK, new Identifier(GSMain.MODID, "stormglass"), STORMGLASS);

        Registry.register(Registries.BLOCK, new Identifier(GSMain.MODID, "endless_source"), ENDLESS_SOURCE);
        clientBlockRendering();
    }

    public static void clientBlockRendering() {
        BlockRenderLayerMap.INSTANCE.putBlocks(RenderLayer.getTranslucent(), STORMGLASS);
    }

}
