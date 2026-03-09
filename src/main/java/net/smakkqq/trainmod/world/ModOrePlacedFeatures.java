package net.smakkqq.trainmod.world;

import java.util.List;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.HeightRangePlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModOrePlacedFeatures {

    public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE = ModPlacedFeatures.of("ore_sapphire");
    public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE_NETHER = ModPlacedFeatures.of("ore_sapphire_nether");
    public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE_END = ModPlacedFeatures.of("ore_sapphire_end");

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
	return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWIthCount(int count, PlacementModifier heightModifier) {
	return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier) {
	return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }

    public static void bootstrap(Registerable<PlacedFeature> featureRegisterable) {
	var ConfiguredFeatures = featureRegisterable.getRegistryLookup(RegistryKeys.CONFIGURED_FEATURE);

	ModPlacedFeatures.register(
		featureRegisterable,
		ORE_SAPPHIRE,
		ConfiguredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_SAPPHIRE),
		modifiersWIthCount(16, HeightRangePlacementModifier.uniform(YOffset.fixed(-48), YOffset.fixed(256)))
	);
	ModPlacedFeatures.register(
		featureRegisterable,
		ORE_SAPPHIRE_NETHER,
		ConfiguredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_SAPPHIRE_NETHER),
		modifiersWIthCount(12, HeightRangePlacementModifier.uniform(YOffset.fixed(-32), YOffset.fixed(80)))
	);
	ModPlacedFeatures.register(
		featureRegisterable,
		ORE_SAPPHIRE_END,
		ConfiguredFeatures.getOrThrow(ModOreConfiguredFeatures.ORE_SAPPHIRE_END),
		modifiersWIthCount(8, HeightRangePlacementModifier.uniform(YOffset.fixed(-80), YOffset.fixed(80)))
	);
    }
}
