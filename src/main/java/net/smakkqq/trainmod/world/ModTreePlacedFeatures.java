package net.smakkqq.trainmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModTreePlacedFeatures {

    public static final RegistryKey<PlacedFeature> TREES_JACARANDA = ModPlacedFeatures.of("trees_jacaranda");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
	var configuredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

	ModPlacedFeatures.register(
		featureRegisterable,
		TREES_JACARANDA,
		configuredFeatures.getOrThrow(ModTreeConfiguredFeatures.TREES_JACARANDA),
		VegetationPlacedFeatures.treeModifiersWithWouldSurvive(
			PlacedFeatures.createCountExtraModifier(1, 0.1f, 1),
			ModBlocks.JACARANDA_SAPLING));
    }
}
