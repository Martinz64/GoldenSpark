package net.timeworndevs.golden_spark.gui;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.AbstractFurnaceScreen;
import net.minecraft.client.gui.screen.recipebook.FurnaceRecipeBookScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.FurnaceScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class PoweredFurnaceScreen extends AbstractFurnaceScreen<PoweredFurnaceScreenHandler> {
    private static final Identifier TEXTURE = new Identifier("textures/gui/container/furnace.png");

    public PoweredFurnaceScreen(PoweredFurnaceScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, new FurnaceRecipeBookScreen(), inventory, title, TEXTURE);
    }
}