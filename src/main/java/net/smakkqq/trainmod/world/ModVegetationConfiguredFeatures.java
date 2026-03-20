
package net.smakkqq.trainmod.world;

import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.SimpleBlockFeatureConfig;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.block.custom.BlueberryBushBlock;

public class ModVegetationConfiguredFeatures {
    
    public static final RegistryKey<ConfiguredFeature<?, ?>> BLUEBERRY_BUSH = ModConfiguredFeatures.of("blueberry_bush");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featureRegisterable) {
	ModConfiguredFeatures.register(
		featureRegisterable,
		BLUEBERRY_BUSH,
		Feature.RANDOM_PATCH,
		ConfiguredFeatures.createRandomPatchFeatureConfig(
			Feature.SIMPLE_BLOCK,
			new SimpleBlockFeatureConfig(
				BlockStateProvider.of(ModBlocks.BLUEBERRY_BUSH.getDefaultState().with(
					BlueberryBushBlock.AGE, 3))),
			List.of(Blocks.GRASS_BLOCK, Blocks.STONE)));
    }
}
