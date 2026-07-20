package net.smakkqq.trainmod.compat;

import java.util.List;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.basic.BasicDisplay;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.recipe.RecipeEntry;
import net.smakkqq.trainmod.recipe.SapphinizerRecipe;

public class SapphinizerDisplay extends BasicDisplay {
    
    public SapphinizerDisplay(RecipeEntry<SapphinizerRecipe> recipe ){
	super(List.of(EntryIngredients.ofIngredient(recipe.value().getIngredients().get(0))),
		(List.of(EntryIngredient.of(EntryStack.of(recipe.value().getResult(null))))
		));
    }

    @Override
    public CategoryIdentifier<?> getCategoryIdentifier() {
	return SapphinizerCategory.SAPPHINIZER;
    }


}
