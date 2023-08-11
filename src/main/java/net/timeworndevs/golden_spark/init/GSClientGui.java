package net.timeworndevs.golden_spark.init;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.timeworndevs.golden_spark.gui.PoweredFurnaceScreen;

public class GSClientGui {
    @Environment(EnvType.CLIENT)
    public static void init(){
        HandledScreens.register(GSGui.POWERED_FURNACE_SCREEN_HANDLER, PoweredFurnaceScreen::new);
    }
}
