package net.smakkqq.trainmod.datagen;

import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TextureMap;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.client.data.VariantsBlockModelDefinitionCreator;
import net.minecraft.client.render.model.json.WeightedVariant;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.block.custom.RubyLampBlock;
import static net.smakkqq.trainmod.block.custom.RubyLampBlock.CLICKED;
import net.smakkqq.trainmod.item.ModItems;

public class ModModelTagProvider extends FabricModelProvider {

    public ModModelTagProvider(FabricDataOutput output) {
	super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
	blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.RUBY_BLOCK)
		.stairs(ModBlocks.RUBY_BLOCK_STAIRS)
		.slab(ModBlocks.RUBY_BLOCK_SLAB)
		.fence(ModBlocks.RUBY_BLOCK_FENCE)
		.fenceGate(ModBlocks.RUBY_BLOCK_FENCE_GATE)
		.pressurePlate(ModBlocks.RUBY_BLOCK_PRESSURE_PLATE)
		.button(ModBlocks.RUBY_BLOCK_BUTTON)
		.wall(ModBlocks.RUBY_BLOCK_WALL);

	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK_TRAPDOOR);
	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RUBY_BLOCK_DOOR);

	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_BLOCK);
	blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SAPPHIRE_ORE);

	WeightedVariant offVariant = BlockStateModelGenerator.createWeightedVariant(
		TexturedModel.CUBE_ALL.upload(ModBlocks.RUBY_LAMP, blockStateModelGenerator.modelCollector)
	);
	WeightedVariant onVariant = BlockStateModelGenerator.createWeightedVariant(
		blockStateModelGenerator.createSubModel(ModBlocks.RUBY_LAMP,
			"_on", Models.CUBE_ALL, TextureMap::all)
	);
	blockStateModelGenerator.blockStateCollector.accept(
		VariantsBlockModelDefinitionCreator
		.of(ModBlocks.RUBY_LAMP)
		.with(BlockStateModelGenerator.createBooleanModelMap(RubyLampBlock.CLICKED, onVariant, offVariant))
	);
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
