package net.smakkqq.trainmod.utill;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.item.ModItems;

public class ModLootTableModifiers {
    private static final Identifier GRASS_BLOCK_ID = Identifier.of("minecraft", "blocks/short_grass");
    
    private static final Identifier CAPIBARA_ID = Identifier.of("trainmod", "entities/capibara");
    
    public static void modifyLootTables(){
	LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) ->{
	    if(GRASS_BLOCK_ID.equals(key.getValue())){
		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(0.25f))
			.with(ItemEntry.builder(ModItems.RICE))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 2.0f)).build());
		
		tableBuilder.pool(poolBuilder.build());
	    }
	    
	    if(LootTables.DESERT_PYRAMID_CHEST.equals(key)){
		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(0.25f))
			.with(ItemEntry.builder(ModItems.SAPPHIRE_CHISEL))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 1.0f)).build());
		tableBuilder.pool(poolBuilder.build());
	    }
	    
	    if(CAPIBARA_ID.equals(key.getValue())){
		LootPool.Builder poolBuilder = LootPool.builder()
			.rolls(ConstantLootNumberProvider.create(1))
			.conditionally(RandomChanceLootCondition.builder(0.25f))
			.with(ItemEntry.builder(ModItems.BLUEBERRY))
			.apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0f, 5.0f)).build());
		tableBuilder.pool(poolBuilder.build());
	    }
	    
	    
	});
    }
}
