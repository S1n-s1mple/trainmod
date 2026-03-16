package net.smakkqq.trainmod.world;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.collection.Pool;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.intprovider.WeightedListIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.CherryFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.CherryTrunkPlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModTreeConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> TREES_JACARANDA = ModConfiguredFeatures.of("trees_jacaranda");

    private static TreeFeatureConfig.Builder builder(Block log, Block leaves, int baseHeight, int firstRandomHeight, int secondRandomHeight, int radius) {
	return new TreeFeatureConfig.Builder(
		BlockStateProvider.of(log),
		new StraightTrunkPlacer(baseHeight, firstRandomHeight, secondRandomHeight),
		BlockStateProvider.of(leaves),
		new BlobFoliagePlacer(ConstantIntProvider.create(radius), ConstantIntProvider.create(0), 3),
		new TwoLayersFeatureSize(1, 0, 1)
	);
    }

    private static TreeFeatureConfig.Builder jacaranda() {
	return new TreeFeatureConfig.Builder(
		BlockStateProvider.of(ModBlocks.JACARANDA_LOG),
		new CherryTrunkPlacer(
			7,
			1,
			0,
			new WeightedListIntProvider(
				Pool.<IntProvider>builder().add(ConstantIntProvider.create(1), 1).add(ConstantIntProvider.create(2), 1).add(ConstantIntProvider.create(3), 1).build()
			),
			UniformIntProvider.create(2, 4),
			UniformIntProvider.create(-4, -3),
			UniformIntProvider.create(-1, 0)
		),
		BlockStateProvider.of(ModBlocks.JACARANDA_LEAVES),
		new CherryFoliagePlacer(ConstantIntProvider.create(4), ConstantIntProvider.create(0), ConstantIntProvider.create(5), 0.25F, 0.5F, 0.16666667F, 0.33333334F),
		new TwoLayersFeatureSize(1, 0, 2)
	)
		.ignoreVines();
    }

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featurRegisterable) {
	ModConfiguredFeatures.register(featurRegisterable, TREES_JACARANDA, Feature.TREE, jacaranda().build());
    }
}
