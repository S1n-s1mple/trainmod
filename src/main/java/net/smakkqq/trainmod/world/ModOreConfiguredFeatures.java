package net.smakkqq.trainmod.world;

import java.util.List;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.BlockMatchRuleTest;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModOreConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE = ModConfiguredFeatures.of("ore_sapphire");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_NETHER = ModConfiguredFeatures.of("ore_sapphire_nether");
    public static final RegistryKey<ConfiguredFeature<?, ?>> ORE_SAPPHIRE_END = ModConfiguredFeatures.of("ore_sapphire_end");
    
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> featurRegisterable) {
	RuleTest stoneReplaceables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
	RuleTest deepslateReplaceables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
	RuleTest netherReplaceables = new BlockMatchRuleTest(Blocks.NETHERRACK);
	RuleTest endReplaceables = new BlockMatchRuleTest(Blocks.END_STONE);
	
	List <OreFeatureConfig.Target> owerworldSapphireOres = List.of(
		OreFeatureConfig.createTarget(stoneReplaceables, ModBlocks.SAPPHIRE_ORE.getDefaultState()),
		OreFeatureConfig.createTarget(deepslateReplaceables, ModBlocks.DEEPSLATE_SAPPHIRE_ORE.getDefaultState())
	);
	
	List <OreFeatureConfig.Target> netherSapphireOres = List.of(
		OreFeatureConfig.createTarget(netherReplaceables, ModBlocks.NETHER_SAPPHIRE_ORE.getDefaultState())
	);
	
	List <OreFeatureConfig.Target> endSapphireOres = List.of(
		OreFeatureConfig.createTarget(endReplaceables, ModBlocks.END_SAPPHIRE_ORE.getDefaultState())
	);
	
	ModConfiguredFeatures.register(featurRegisterable, ORE_SAPPHIRE, Feature.ORE, new OreFeatureConfig(owerworldSapphireOres, 12));
	ModConfiguredFeatures.register(featurRegisterable, ORE_SAPPHIRE_NETHER, Feature.ORE, new OreFeatureConfig(netherSapphireOres, 12));
	ModConfiguredFeatures.register(featurRegisterable, ORE_SAPPHIRE_END, Feature.ORE, new OreFeatureConfig(endSapphireOres, 12));
    }
}
