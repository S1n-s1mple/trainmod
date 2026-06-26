package net.smakkqq.trainmod.recipe;

import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class ModRecipes {

    public static final RecipeSerializer<SapphinizerRecipe> SAPPHINIZER_SERIALIZER = Registry.register(
	    Registries.RECIPE_SERIALIZER, Identifier.of(Train.MOD_ID, "sapphinizer"), new SapphinizerRecipe.Serializer());

    public static final RecipeType<SapphinizerRecipe> SAPPHINIZER_TYPE = Registry.register(
	    Registries.RECIPE_TYPE, Identifier.of(Train.MOD_ID, "sapphinizer"), new RecipeType<SapphinizerRecipe>() {
	@Override
	public String toString() {
	    return "sapphinizer";
	}
    });

    public static void registerRecipes() {
	Train.LOGGER.info("Registering custom recipes for:" + Train.MOD_ID);
    }
}
