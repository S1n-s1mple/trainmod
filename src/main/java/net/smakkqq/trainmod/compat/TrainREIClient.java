package net.smakkqq.trainmod.compat;

import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.interfaceMod.custom.SapphinizerScreen;
import net.smakkqq.trainmod.recipe.ModRecipes;
import net.smakkqq.trainmod.recipe.SapphinizerRecipe;

public class TrainREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
	registry.add(new SapphinizerCategory());

	registry.addWorkstations(SapphinizerCategory.SAPPHINIZER, EntryStack.of(ModBlocks.SAPPHINIZER));
    }

    @Override
    public void registerDisplays(DisplayRegistry registry) {
	registry.registerRecipeFiller(SapphinizerRecipe.class, ModRecipes.SAPPHINIZER_TYPE, SapphinizerDisplay::new);
    }

    @Override
    public void registerScreens(ScreenRegistry registry) {
	registry.registerClickArea(screen -> new Rectangle(
		((screen.width - 18 -) / 2) + 80, ((screen.height - 160) / 2) + 30, 20, 25),
		SapphinizerScreen.class,
		SapphinizerCategory.SAPPHINIZER);
    }

}
