package net.timeworndevs.golden_spark.init;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.timeworndevs.golden_spark.GSMain;
import net.timeworndevs.golden_spark.gui.PoweredFurnaceScreenHandler;

public class GSGui {

    public static final ScreenHandlerType<PoweredFurnaceScreenHandler> POWERED_FURNACE_SCREEN_HANDLER;
    public static final Identifier POWERED_FURNACE_SCREEN_ID;
    static {
        //We use registerSimple here because our Entity is not an ExtendedScreenHandlerFactory
        //but a NamedScreenHandlerFactory.
        //In a later Tutorial you will see what ExtendedScreenHandlerFactory can do!
        POWERED_FURNACE_SCREEN_ID = new Identifier(GSMain.MODID,"powered_furnace_gui");
        POWERED_FURNACE_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(POWERED_FURNACE_SCREEN_ID, PoweredFurnaceScreenHandler::new);
    }
    public static void init(){

    }
}
