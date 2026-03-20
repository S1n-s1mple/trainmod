package net.smakkqq.trainmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.smakkqq.trainmod.world.ModTreePlacedFeatures;

public class ModTreeGeneration {

    public static void generateTrees() {
	BiomeModifications.addFeature(
		BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN, BiomeKeys.WOODED_BADLANDS, BiomeKeys.DARK_FOREST, BiomeKeys.BADLANDS),
		GenerationStep.Feature.VEGETAL_DECORATION,
		ModTreePlacedFeatures.TREES_JACARANDA);
    }
}
