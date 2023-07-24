package net.timeworndevs.golden_spark;

import net.fabricmc.api.ModInitializer;
import net.timeworndevs.golden_spark.init.GSBlocks;
import net.timeworndevs.golden_spark.init.GSItemGroups;
import net.timeworndevs.golden_spark.init.GSItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GSMain implements ModInitializer {

	public static final String MODID = "golden_spark";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize() {
		LOGGER.info("THE VOLTAGE!! IT SURGES!!!");
		GSItems.init();
		GSBlocks.init();
		GSItemGroups.init();
	}
}
