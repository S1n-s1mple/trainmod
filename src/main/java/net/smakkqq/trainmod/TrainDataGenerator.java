package net.smakkqq.trainmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.smakkqq.trainmod.datagen.ModBlockTagProvider;
import net.smakkqq.trainmod.datagen.ModItemTagProvider;
import net.smakkqq.trainmod.datagen.ModLootTableTagProvider;
import net.smakkqq.trainmod.datagen.ModModelTagProvider;

public class TrainDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
	FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

	pack.addProvider(ModBlockTagProvider::new);
	pack.addProvider(ModItemTagProvider::new);
	pack.addProvider(ModLootTableTagProvider::new);
	pack.addProvider(ModModelTagProvider::new);
    }
}
