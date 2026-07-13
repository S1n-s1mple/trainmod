package net.smakkqq.trainmod.compat;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;

public class TrainREIClient implements REIClientPlugin {

    @Override
    public void registerCategories(CategoryRegistry registry) {
	registry.add(new SapphinizerCategory());
    }

}
