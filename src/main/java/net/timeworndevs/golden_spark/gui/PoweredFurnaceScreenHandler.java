package net.timeworndevs.golden_spark.gui;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.screen.AbstractFurnaceScreenHandler;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandlerType;
import net.timeworndevs.golden_spark.init.GSGui;

public class PoweredFurnaceScreenHandler extends AbstractFurnaceScreenHandler {
    public PoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(GSGui.POWERED_FURNACE_SCREEN_HANDLER, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory);
    }

    public PoweredFurnaceScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, PropertyDelegate propertyDelegate) {
        super(GSGui.POWERED_FURNACE_SCREEN_HANDLER, RecipeType.SMELTING, RecipeBookCategory.FURNACE, syncId, playerInventory, inventory, propertyDelegate);
    }
}
