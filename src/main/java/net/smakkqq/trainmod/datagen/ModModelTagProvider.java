package net.smakkqq.trainmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.item.ModItems;

public class ModModelTagProvider extends FabricModelProvider {

    public ModModelTagProvider(FabricDataOutput output) {
	super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK);
	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
	itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
	itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
	itemModelGenerator.register(ModItems.LIGHTNING_ROD, Models.GENERATED);
	itemModelGenerator.register(ModItems.FIRE_ROD, Models.GENERATED);
	itemModelGenerator.register(ModItems.ARROW_ROD, Models.GENERATED);
	itemModelGenerator.register(ModItems.FUEL, Models.GENERATED);
	itemModelGenerator.register(ModItems.FUNNY_POTATO, Models.GENERATED);
    }

}
