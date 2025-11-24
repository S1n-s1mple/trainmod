package net.racc0on.lessonmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.racc0on.lessonmod.item.ModItems;
import net.racc0on.lessonmod.utill.ModTags;

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
		.add(ModItems.RUBY_SWORD);
	valueLookupBuilder(ItemTags.SHOVELS)
		.add(ModItems.RUBY_SHOVEL);
	valueLookupBuilder(ItemTags.HOES)
		.add(ModItems.RUBY_HOE);
	valueLookupBuilder(ItemTags.PICKAXES)
		.add(ModItems.RUBY_PICKAXE);
	valueLookupBuilder(ItemTags.AXES)
		.add(ModItems.RUBY_AXE);
	
    }
}
