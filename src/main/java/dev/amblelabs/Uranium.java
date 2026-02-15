package dev.amblelabs;

import dev.amblelabs.power.PowerArmorManager;
import dev.amblelabs.radiation.RadiationManager;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Uranium implements ModInitializer {
	public static final String MOD_ID = "uranium";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static ResourceLocation of(String path) {
		return ResourceLocation.fromNamespaceAndPath(MOD_ID, path);
	}

	@Override
	public void onInitialize() {
		LOGGER.info("War. War never changes.");
		
		// Register everything
		ModEffects.register();
		ModBlocks.register();
		ModItems.register();
		ModEntities.register();
		ModItemGroups.register();
		
		// Register tick events for radiation and power armor
		ServerTickEvents.END_SERVER_TICK.register(server -> {
			for (ServerPlayer player : server.getPlayerList().getPlayers()) {
				RadiationManager.tick(player);
				PowerArmorManager.tick(player);
			}
		});
		
		LOGGER.info("Uranium mod initialized successfully!");
	}
}