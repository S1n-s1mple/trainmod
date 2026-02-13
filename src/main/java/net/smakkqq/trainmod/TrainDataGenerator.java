package net.smakkqq.trainmod;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;
import net.smakkqq.trainmod.datagen.ModBlockTagProvider;
import net.smakkqq.trainmod.datagen.ModItemTagProvider;
import net.smakkqq.trainmod.datagen.ModLootTableTagProvider;
import net.smakkqq.trainmod.datagen.ModModelTagProvider;
import net.smakkqq.trainmod.datagen.ModRecipeTagProvider;
import net.smakkqq.trainmod.datagen.ModRegistryDataGenerator;
import net.smakkqq.trainmod.enchantment.ModEnchantments;

public class TrainDataGenerator implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
	FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
	
	pack.addProvider(ModBlockTagProvider::new);
	pack.addProvider(ModItemTagProvider::new);
	pack.addProvider(ModLootTableTagProvider::new);
	pack.addProvider(ModModelTagProvider::new);
	pack.addProvider(ModRecipeTagProvider::new);
	pack.addProvider(ModRegistryDataGenerator::new);
    }
    @Override
    public void buildRegistry(RegistryBuilder registryBuilder) {
	registryBuilder.addRegistry(RegistryKeys.ENCHANTMENT, ModEnchantments::bootstrap);

	DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
    }
}
