package net.smakkqq.trainmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
	super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
	valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
		.add(ModBlocks.RUBY_BLOCK)
		.add(ModBlocks.SAPPHIRE_BLOCK)
		.add(ModBlocks.SAPPHIRE_ORE);

	valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
		.add(ModBlocks.RUBY_BLOCK)
		.add(ModBlocks.SAPPHIRE_BLOCK)
		.add(ModBlocks.SAPPHIRE_ORE);

	valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_BLOCK_FENCE);
	valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_BLOCK_FENCE_GATE);
	valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_BLOCK_WALL);
    }

}
