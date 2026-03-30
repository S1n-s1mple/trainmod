package net.smakkqq.trainmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.smakkqq.trainmod.world.ModVegetationPlacedFeatures;

public class ModVegetationGeneration {
    public static void generateVegetation() {
	BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS, BiomeKeys.FOREST),
	GenerationStep.Feature.VEGETAL_DECORATION,
	ModVegetationPlacedFeatures.BLUEBERRY_BUSH);
    }
}
