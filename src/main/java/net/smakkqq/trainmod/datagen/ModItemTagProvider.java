package net.smakkqq.trainmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.smakkqq.trainmod.item.ModItems;
import net.smakkqq.trainmod.utill.ModTags;

public class ModItemTagProvider extends ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
	super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
	valueLookupBuilder(ModTags.Items.TRANSFORMABLE_ITEMS)
		.add(ModItems.RUBY)
		.add(Items.COAL)
		.add(Items.DIRT)
		.add(Items.APPLE)
		.add(Items.STICK);

	valueLookupBuilder(ModTags.Items.SAPPHIRE_REPAIR)
		.add(ModItems.SAPPHIRE);

	valueLookupBuilder(ItemTags.SWORDS)
		.add(ModItems.RUBY_SWORD)
		.add(ModItems.SAPPHIRE_SWORD);
	valueLookupBuilder(ItemTags.SHOVELS)
		.add(ModItems.RUBY_SHOVEL)
		.add(ModItems.SAPPHIRE_SHOVEL);
	valueLookupBuilder(ItemTags.HOES)
		.add(ModItems.RUBY_HOE)
		.add(ModItems.SAPPHIRE_HOE);
	valueLookupBuilder(ItemTags.PICKAXES)
		.add(ModItems.RUBY_PICKAXE)
		.add(ModItems.SAPPHIRE_PICKAXE);
	valueLookupBuilder(ItemTags.AXES)
		.add(ModItems.RUBY_AXE)
		.add(ModItems.SAPPHIRE_AXE);

	valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
		.add(ModItems.SAPPHIRE_HELMET)
		.add(ModItems.SAPPHIRE_CHESTPLATE)
		.add(ModItems.SAPPHIRE_LEGGINGS)
		.add(ModItems.SAPPHIRE_BOOTS);

	valueLookupBuilder(ModTags.Items.SAPPHIRE_ARMOR)
		.add(ModItems.SAPPHIRE_HELMET)
		.add(ModItems.SAPPHIRE_CHESTPLATE)
		.add(ModItems.SAPPHIRE_LEGGINGS)
		.add(ModItems.SAPPHIRE_BOOTS);

	valueLookupBuilder(ModTags.Items.LIGHTNING_STRIKER_ENCHANTABLE)
		.add(Items.WOODEN_SWORD)
		.add(Items.STONE_SWORD)
		.add(Items.GOLDEN_SWORD)
		.add(Items.IRON_SWORD)
		.add(Items.DIAMOND_SWORD)
		.add(Items.NETHERITE_SWORD)
		.add(Items.BOW)
		.add(ModItems.SAPPHIRE_SWORD)
		.add(ModItems.RUBY_SWORD);

	valueLookupBuilder(ModTags.Items.DIVINE_PUNISHMENT_ENCHANTABLE)
		.add(Items.LEATHER_HELMET, Items.LEATHER_CHESTPLATE, Items.LEATHER_LEGGINGS, Items.LEATHER_BOOTS)
		.add(Items.CHAINMAIL_HELMET, Items.CHAINMAIL_CHESTPLATE, Items.CHAINMAIL_LEGGINGS, Items.CHAINMAIL_BOOTS)
		.add(Items.IRON_HELMET, Items.IRON_CHESTPLATE, Items.IRON_LEGGINGS, Items.IRON_BOOTS)
		.add(Items.GOLDEN_HELMET, Items.GOLDEN_CHESTPLATE, Items.GOLDEN_LEGGINGS, Items.GOLDEN_BOOTS)
		.add(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS)
		.add(Items.NETHERITE_HELMET, Items.NETHERITE_CHESTPLATE, Items.NETHERITE_LEGGINGS, Items.NETHERITE_BOOTS)
		.add(ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS)
		.add(Items.TURTLE_HELMET);
    }
}
