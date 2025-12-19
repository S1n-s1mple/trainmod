//package net.smakkqq.trainmod.datagen;
//
//import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
//import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
//import net.minecraft.block.Blocks;
//import net.minecraft.data.recipe.CraftingRecipeJsonBuilder;
//import net.minecraft.data.recipe.RecipeExporter;
//import net.minecraft.data.recipe.RecipeGenerator;
//import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
//import net.minecraft.item.Item;
//import net.minecraft.item.ItemConvertible;
//import net.minecraft.item.Items;
//import net.minecraft.recipe.Ingredient;
//import net.minecraft.recipe.book.RecipeCategory;
//import net.minecraft.registry.RegistryKeys;
//import net.minecraft.registry.RegistryWrapper;
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//import net.smakkqq.trainmod.item.ModItems;
//import net.smakkqq.trainmod.block.ModBlocks;
//import net.smakkqq.trainmod.block.ModBlocks;
//import net.smakkqq.trainmod.item.ModItems;
//
//public class ModRecipeTagProvider extends FabricRecipeProvider {
//
//    public ModRecipeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
//	super(output, registriesFuture);
//    }
//
//    @Override
//    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
//	return new RecipeGenerator(wrapperLookup, recipeExporter) {
//	    @Override
//	    public void generate() {
//		RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);
//
//		offerSmelting(List.of(ModItems.RUBY), RecipeCategory.MISC, ModItems.RUBY, .25f, 200, "sapphire");
//		offerBlasting(List.of(ModItems.RUBY), RecipeCategory.MISC, ModItems.RUBY, .25f, 100, "sapphire");
//		offerSmelting(List.of(ModBlocks.RUBY_BLOCK), RecipeCategory.MISC, ModBlocks.RUBY_BLOCK, 2.5f, 600, "sapphire_block");
//		offerBlasting(List.of(ModBlocks.RUBY_BLOCK), RecipeCategory.MISC, ModBlocks.RUBY_BLOCK, 2.5f, 300, "sapphire_block");
//
//		offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);
//		offerReversibleCompactingRecipes(RecipeCategory.BUILDING_BLOCKS, ModItems.SAPPHIRE, RecipeCategory.DECORATIONS, ModBlocks.SAPPHIRE_BLOCK);
//
//		offerSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK_SLAB, ModBlocks.RUBY_BLOCK);
//		offerWallRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RUBY_BLOCK_WALL, ModBlocks.RUBY_BLOCK);
//
//		offerWithCriterion(createStairsRecipe(ModBlocks.RUBY_BLOCK_STAIRS, Ingredient.ofItem(ModBlocks.RUBY_BLOCK)), ModBlocks.RUBY_BLOCK);
//		offerWithCriterion(createFenceRecipe(ModBlocks.RUBY_BLOCK_FENCE, Ingredient.ofItem(ModBlocks.RUBY_BLOCK)), ModItems.RUBY);
//		offerWithCriterion(createFenceGateRecipe(ModBlocks.RUBY_BLOCK_FENCE_GATE, Ingredient.ofItem(ModBlocks.RUBY_BLOCK)), ModBlocks.RUBY_BLOCK);
//		offerWithCriterion(createDoorRecipe(ModBlocks.RUBY_BLOCK_DOOR, Ingredient.ofItem(ModItems.RUBY)), ModItems.RUBY);
//		offerWithCriterion(createTrapdoorRecipe(ModBlocks.RUBY_BLOCK_TRAPDOOR, Ingredient.ofItem(ModItems.RUBY)), ModItems.RUBY);
//		offerWithCriterion(createButtonRecipe(ModBlocks.RUBY_BLOCK_BUTTON, Ingredient.ofItem(ModItems.RUBY)), ModBlocks.RUBY_BLOCK);
//		offerWithCriterion(createPressurePlateRecipe(RecipeCategory.REDSTONE, ModBlocks.RUBY_BLOCK_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.RUBY_BLOCK)), ModBlocks.RUBY_BLOCK);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModBlocks.RUBY_BLOCK)
//			.pattern("DPD")
//			.pattern("PDP")
//			.pattern("DPD")
//			.input('D', Blocks.DIAMOND_BLOCK)
//			.input('P', ModBlocks.RUBY_BLOCK),
//			ModBlocks.RUBY_BLOCK);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_SWORD)
//			.pattern(" P ")
//			.pattern(" P ")
//			.pattern(" S ")
//			.input('P', ModItems.RUBY)
//			.input('S', Items.STICK),
//			ModItems.RUBY);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_PICKAXE)
//			.pattern("PPP")
//			.pattern(" S ")
//			.pattern(" S ")
//			.input('P', ModItems.RUBY)
//			.input('S', Items.STICK),
//			ModItems.RUBY);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_AXE)
//			.pattern("PP ")
//			.pattern("PS ")
//			.pattern(" S ")
//			.input('P', ModItems.RUBY)
//			.input('S', Items.STICK),
//			ModItems.RUBY);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_SHOVEL)
//			.pattern(" P ")
//			.pattern(" S ")
//			.pattern(" S ")
//			.input('P', ModItems.RUBY)
//			.input('S', Items.STICK),
//			ModItems.RUBY);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_HOE)
//			.pattern("PP ")
//			.pattern(" S ")
//			.pattern(" S ")
//			.input('P', ModItems.RUBY)
//			.input('S', Items.STICK),
//			ModItems.RUBY);
//
//		offerWithCriterion(ShapedRecipeJsonBuilder.create(itemLookup, RecipeCategory.MISC, ModItems.RUBY_HAMMER)
//			.pattern("PPP")
//			.pattern(" S ")
//			.pattern(" S ")
//			.input('P', ModBlocks.RUBY_BLOCK)
//			.input('S', Items.STICK),
//			ModBlocks.RUBY_BLOCK);
//	    }
//
//	    private void offerWithCriterion(CraftingRecipeJsonBuilder recipe, ItemConvertible unlockItem) {
//		recipe.criterion(hasItem(unlockItem), conditionsFromItem(unlockItem)).offerTo(recipeExporter);
//	    }
//	};
//    }
//
//    @Override
//    public String getName() {
//	return "RecipeGenerator";
//    }
//}
