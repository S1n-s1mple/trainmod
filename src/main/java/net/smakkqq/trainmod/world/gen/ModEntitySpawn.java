package net.smakkqq.trainmod.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnLocationTypes;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import net.minecraft.world.biome.BiomeKeys;
import net.smakkqq.trainmod.entity.ModEntities;

public class ModEntitySpawn {

    public static void addSpawns() {
	var capibara = ModEntities.CAPIBARA;

	BiomeModifications.addSpawn(
		BiomeSelectors.includeByKey(
			BiomeKeys.PLAINS,
			BiomeKeys.SUNFLOWER_PLAINS,
			BiomeKeys.FOREST,
			BiomeKeys.FLOWER_FOREST,
			BiomeKeys.SWAMP,
			BiomeKeys.RIVER
		),
		SpawnGroup.CREATURE,
		ModEntities.CAPIBARA,
		30,
		1,
		3
	);

	SpawnRestriction.register(capibara,
		SpawnLocationTypes.ON_GROUND,
		Heightmap.Type.MOTION_BLOCKING_NO_LEAVES,
		AnimalEntity::isValidNaturalSpawn);
    }
}
