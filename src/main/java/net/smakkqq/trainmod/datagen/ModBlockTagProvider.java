/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.smakkqq.trainmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.utill.ModTags;

/**
 *
 * @author Coddy
 */
public class ModBlockTagProvider  extends FabricTagProvider.BlockTagProvider{

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
	super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
	valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
		.add(ModBlocks.RUBY_BLOCK);
	
	valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
		.add(ModBlocks.RUBY_BLOCK);
	
	valueLookupBuilder(BlockTags.FENCES).add(ModBlocks.RUBY_BLOCK_FENCE);
	valueLookupBuilder(BlockTags.FENCE_GATES).add(ModBlocks.RUBY_BLOCK_FENCE_GATE);
	valueLookupBuilder(BlockTags.WALLS).add(ModBlocks.RUBY_BLOCK_WALL);
	
	valueLookupBuilder(ModTags.Blocks.NEEDS_RUBY_TOOL)
		.add(ModBlocks.RUBY_LAMP)
		.addTag(BlockTags.NEEDS_IRON_TOOL);
	valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL).add(ModBlocks.RUBY_LAMP);
    }
    
}
