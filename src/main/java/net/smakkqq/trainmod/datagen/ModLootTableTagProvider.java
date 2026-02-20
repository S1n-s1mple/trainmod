package net.smakkqq.trainmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.block.custom.RicesCropBlock;
import net.smakkqq.trainmod.item.ModItems;

public class ModLootTableTagProvider extends FabricBlockLootTableProvider {

    public ModLootTableTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
	super(output, registriesFuture);
    }

    @Override
    public void generate() {
	addDrop(ModBlocks.RUBY_BLOCK);
	
	addDrop(ModBlocks.RUBY_BLOCK_STAIRS);
	addDrop(ModBlocks.RUBY_BLOCK_SLAB, slabDrops(ModBlocks.RUBY_BLOCK_SLAB));
	
	addDrop(ModBlocks.RUBY_BLOCK_BUTTON);
	addDrop(ModBlocks.RUBY_BLOCK_PRESSURE_PLATE);
	
	addDrop(ModBlocks.RUBY_BLOCK_WALL);
	addDrop(ModBlocks.RUBY_BLOCK_FENCE);
	addDrop(ModBlocks.RUBY_BLOCK_FENCE_GATE);
	
	addDrop(ModBlocks.RUBY_BLOCK_DOOR, doorDrops(ModBlocks.RUBY_BLOCK_DOOR));
	addDrop(ModBlocks.RUBY_BLOCK_TRAPDOOR);
	
//	addDrop(ModBlocks.RUBY_ORE, oreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY));
//	addDrop(ModBlocks.RUBY_ORE, multipleOreDrops(ModBlocks.RUBY_ORE, ModItems.RUBY, 3, 7));

	BlockStatePropertyLootCondition.Builder riceCondition = BlockStatePropertyLootCondition.builder(ModBlocks.RICE)
		.properties(StatePredicate.Builder.create().exactMatch(RicesCropBlock.AGE, RicesCropBlock.MAX_AGE));
	this.addDrop(ModBlocks.RICE, this.cropDrops(ModBlocks.RICE, ModItems.RICE, ModItems.RICE, riceCondition));
	
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
	RegistryWrapper.Impl<Enchantment>impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
	return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
		ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
	.apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }

}
