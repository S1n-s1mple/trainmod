package net.smakkqq.trainmod.datagen;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import static net.minecraft.data.recipe.RecipeGenerator.hasItem;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.item.ModItems;

public class ModRecipeTagProvider extends FabricRecipeProvider {

    public ModRecipeTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
	super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
	List<ItemConvertible> RUBY_SMELT_TO_SAPPHIRE = List.of(ModItems.RUBY, ModItems.SAPPHIRE, ModItems.FUNNY_POTATO);
//	offerSmelting(exporter, RUBY_SMELT_TO_SAPPHIRE, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.25f, 200, "ruby");
//	offerBlasting(exporter, RUBY_SMELT_TO_SAPPHIRE, RecipeCategory.MISC, ModItems.SAPPHIRE, 0.25f, 200, "ruby");
	ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.RUBY_BLOCK)
		.pattern("RRR")
		.pattern("RRR")
		.pattern("RRR")
		.input('R', ModItems.RUBY)
		.criterion(hasItem(ModItems.RUBY), conditionsFromItem(ModItems.RUBY))
	offerTo(exporter);
    }

    @Override
    public String getName() {
	throw new UnsupportedOperationException("Not supported yet");
    }

}
