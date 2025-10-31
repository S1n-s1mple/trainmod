package net.smakkqq.trainmod.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider.ItemTagProvider;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;
import net.smakkqq.trainmod.item.ModItems;
import net.smakkqq.trainmod.utill.ModTags;

public class ModItemTagProvider extends ItemTagProvider {

    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        valueLookupBuilder(ModTags.Items.TRANSFORMABL_ITEMS)
                .add(ModItems.RUBY)
                .add(ModItems.SAPPHIRE)
                .add(Items.COAL)
                .add(Items.DIRT)
                .add(Items.APPLE)
                .add(Items.STICK);
    }

}
