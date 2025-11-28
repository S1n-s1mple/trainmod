package net.smakkqq.trainmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.item.ModItemGroups;
import net.smakkqq.trainmod.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Train implements ModInitializer {

    public static final String MOD_ID = "train";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
	ModItemGroups.registerItemsGroups();

	ModItems.registerModItems();
	ModBlocks.registerModBlocks();

	FuelRegistryEvents.BUILD.register((builder, context) -> {
	    builder.add(ModItems.FUEL, 60 * 20);
	});

    }
}
