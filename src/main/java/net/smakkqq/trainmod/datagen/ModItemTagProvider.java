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
		.add(ModItems.SAPPHIRE_LEGGINS)
		.add(ModItems.SAPPHIRE_BOOTS);

    }
}
