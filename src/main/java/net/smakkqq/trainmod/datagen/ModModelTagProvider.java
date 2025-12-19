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
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.block.custom.RubyLampBlock;
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
		.pressurePlate(ModBlocks.RUBY_BLOCK_PRESSURE_PLATE)
		.button(ModBlocks.RUBY_BLOCK_BUTTON)
		.wall(ModBlocks.RUBY_BLOCK_WALL)
		.fenceGate(ModBlocks.RUBY_BLOCK_FENCE_GATE);
	blockStateModelGenerator.registerTrapdoor(ModBlocks.RUBY_BLOCK_TRAPDOOR);
	blockStateModelGenerator.registerDoor(ModBlocks.RUBY_BLOCK_DOOR);

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
	//Предметы
	itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
	itemModelGenerator.register(ModItems.SAPPHIRE, Models.GENERATED);
	itemModelGenerator.register(ModItems.FIRE_ROD, Models.GENERATED);
	itemModelGenerator.register(ModItems.FUEL, Models.GENERATED);
	itemModelGenerator.register(ModItems.FUNNY_POTATO, Models.GENERATED);

	//Инструменты
	itemModelGenerator.register(ModItems.RUBY_AXE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.RUBY_SWORD, Models.HANDHELD);
	itemModelGenerator.register(ModItems.RUBY_HOE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.RUBY_PICKAXE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.RUBY_HAMMER, Models.HANDHELD);
	itemModelGenerator.register(ModItems.RUBY_SHOVEL, Models.HANDHELD);
	itemModelGenerator.register(ModItems.SAPPHIRE_AXE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.SAPPHIRE_SWORD, Models.HANDHELD);
	itemModelGenerator.register(ModItems.SAPPHIRE_HOE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.SAPPHIRE_PICKAXE, Models.HANDHELD);
	itemModelGenerator.register(ModItems.SAPPHIRE_SHOVEL, Models.HANDHELD);

	//Броня
	itemModelGenerator.registerArmor(ModItems.SAPPHIRE_HELMET, RegistryKey.of(
		RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
		Identifier.of(Train.MOD_ID, "sapphire")), ItemModelGenerator.HELMET_TRIM_ID_PREFIX, false);
	itemModelGenerator.registerArmor(ModItems.SAPPHIRE_CHESTPLATE, RegistryKey.of(
		RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
		Identifier.of(Train.MOD_ID, "sapphire")), ItemModelGenerator.CHESTPLATE_TRIM_ID_PREFIX, false);
	itemModelGenerator.registerArmor(ModItems.SAPPHIRE_LEGGINS, RegistryKey.of(
		RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
		Identifier.of(Train.MOD_ID, "sapphire")), ItemModelGenerator.LEGGINGS_TRIM_ID_PREFIX, false);
	itemModelGenerator.registerArmor(ModItems.SAPPHIRE_BOOTS, RegistryKey.of(
		RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")),
		Identifier.of(Train.MOD_ID, "sapphire")), ItemModelGenerator.BOOTS_TRIM_ID_PREFIX, false);
    }

}
