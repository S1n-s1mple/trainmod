package net.smakkqq.trainmod.world;

import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModVegetationPlacedFeatures {
public static final RegistryKey<PlacedFeature> BLUEBERRY_BUSH = ModPlacedFeatures.of("blueberry_bush");

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
	var configuredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

	ModPlacedFeatures.register(
		featureRegisterable,
		BLUEBERRY_BUSH,
		configuredFeatures.getOrThrow(ModVegetationConfiguredFeatures.BLUEBERRY_BUSH),
		RarityFilterPlacementModifier.of(32),
		SquarePlacementModifier.of(),
		PlacedFeatures.WORLD_SURFACE_WG_HEIGHTMAP,
		BiomePlacementModifier.of()
	);
    }
}
