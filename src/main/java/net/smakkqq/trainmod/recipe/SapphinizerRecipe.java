package net.smakkqq.trainmod.recipe;

import static java.lang.Character.getType;
import static net.fabricmc.fabric.impl.recipe.ingredient.CustomIngredientImpl.getSerializer;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.IngredientPlacement;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import static net.minecraft.recipe.SmithingTrimRecipe.craft;
import net.minecraft.recipe.book.RecipeBookCategories;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record SapphinizerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<SapphinizerRecipeInput> {

    public DefaultedList<Ingredient> getIngredients() {
	DefaultedList<Ingredient> list = DefaultedList.of();
	list.add(this.inputItem);
	return list;
    }

    @Override
    public boolean matches(SapphinizerRecipeInput input, World world) {
	if (world.isClient()) {
	    return false;
	}
	return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(SapphinizerRecipeInput input, RegistryWrapper.WrapperLookup registries) {
	return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<SapphinizerRecipeInput>> getSerializer() {
	return ModRecipes.SAPPHINIZER_SERIALIZER;
    }

    @Override
    public RecipeType<? extends Recipe<SapphinizerRecipeInput>> getType() {
	return ModRecipes.SAPPHINIZER_TYPE;
    }

    @Override
    public IngredientPlacement getIngredientPlacement() {
	return IngredientPlacement.forSingleSlot(inputItem);
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
	return RecipeBookCategories.CRAFTING_MISC;
    }

}
