package net.smakkqq.trainmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;
import net.smakkqq.trainmod.world.ModOrePlacedFeatures;

public class ModOreWorldGeneration {

    public static void generateOres() {
	BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE);
	BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE_NETHER);
	BiomeModifications.addFeature(BiomeSelectors.foundInTheEnd(), GenerationStep.Feature.UNDERGROUND_ORES, ModOrePlacedFeatures.ORE_SAPPHIRE_END);
    }
}
