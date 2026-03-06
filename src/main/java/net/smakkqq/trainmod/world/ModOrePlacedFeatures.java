package net.smakkqq.trainmod.world;

import java.util.List;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.placementmodifier.BiomePlacementModifier;
import net.minecraft.world.gen.placementmodifier.CountPlacementModifier;
import net.minecraft.world.gen.placementmodifier.PlacementModifier;
import net.minecraft.world.gen.placementmodifier.RarityFilterPlacementModifier;
import net.minecraft.world.gen.placementmodifier.SquarePlacementModifier;

public class ModOrePlacedFeatures {

    public static final RegistryKey<PlacedFeature> ORE_SAPPHIRE = ModPlacedFeatures.of("ore_sapphire");
    
    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier){
	return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }
    private static List<PlacementModifier> modifiersWIthCount(int count, PlacementModifier heightModifier){
	return modifiers(CountPlacementModifier.of(count), heightModifier);
    }
    private static List<PlacementModifier> modifiersWithRarity(int chance, PlacementModifier heightModifier){
	return modifiers(RarityFilterPlacementModifier.of(chance), heightModifier);
    }
    
    public static void bootstrap(){
	    
    }
}
