package net.smakkqq.trainmod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup MOD_TAB = Registry.register(Registries.ITEM_GROUP,
	    Identifier.of(Train.MOD_ID, "ores_items"),
	    FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.SAPPHIRE))
		    .displayName(Text.translatable("itemGroup.train.ores_items"))
		    .entries((displayContext, entries) -> {
			entries.add(ModItems.RUBY);
			entries.add(ModBlocks.RUBY_BLOCK);
			entries.add(ModItems.SAPPHIRE);
			entries.add(ModBlocks.SAPPHIRE_BLOCK);
			entries.add(ModItems.LIGHTNING_ROD);
			entries.add(ModItems.FIRE_ROD);
			entries.add(ModItems.ARROW_ROD);
			entries.add(ModItems.FUNNY_POTATO);
			entries.add(ModItems.FUEL);
			
			entries.add(ModItems.RUBY_PICKAXE);
			entries.add(ModItems.RUBY_SHOVEL);
			entries.add(ModItems.RUBY_SWORD);
			entries.add(ModItems.RUBY_HOE);
			entries.add(ModItems.RUBY_AXE);
			
			entries.add(ModItems.SAPPHIRE_PICKAXE);
			entries.add(ModItems.SAPPHIRE_SHOVEL);
			entries.add(ModItems.SAPPHIRE_SWORD);
			entries.add(ModItems.SAPPHIRE_HOE);
			entries.add(ModItems.SAPPHIRE_AXE);

			entries.add(ModBlocks.RUBY_BLOCK_STAIRS);
			entries.add(ModBlocks.RUBY_BLOCK_SLAB);
			entries.add(ModBlocks.RUBY_BLOCK_BUTTON);
			entries.add(ModBlocks.RUBY_BLOCK_PRESSURE_PLATE);
			entries.add(ModBlocks.RUBY_BLOCK_FENCE_GATE);
			entries.add(ModBlocks.RUBY_BLOCK_FENCE);
			entries.add(ModBlocks.RUBY_BLOCK_TRAPDOOR);
			entries.add(ModBlocks.RUBY_BLOCK_DOOR);
			entries.add(ModBlocks.RUBY_BLOCK_WALL);
			entries.add(ModBlocks.RUBY_LAMP);
			
		    }).build());

    public static void registerItemsGroups() {
	Train.LOGGER.info("Registering Items Groups for " + Train.MOD_ID);
    }
}
