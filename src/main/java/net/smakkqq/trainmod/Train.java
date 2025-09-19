package net.smakkqq.trainmod;

import net.fabricmc.api.ModInitializer;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.item.ModItems;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Train implements ModInitializer {

    public static final String MOD_ID = "train";

    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModBlocks.registerModBlocks();
    }
}
