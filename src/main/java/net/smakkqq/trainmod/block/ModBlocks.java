package net.smakkqq.trainmod.block;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import static net.minecraft.advancement.criterion.ConsumeItemCriterion.Conditions.item;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class ModBlocks {

    public static final Block RUBY_BLOCK = registerBlockItem(
            "ruby_block",
            Block::new,
            AbstractBlock.Settings.create()
                .requiresTool()
                .strength(5.0F, 6.0F)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );
    
    public static final Block SAPPHIRE_BLOCK = registerBlockItem(
            "sapphire_block",
            Block::new,
            AbstractBlock.Settings.create()
                .requiresTool()
                .strength(5.0F, 6.0F)
                .burnable()
                .luminance(state -> 10)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );
    
    public static final Block SAPPHIRE_ORE = registerBlockItem(
            "sapphire_ore",
            Block::new,
            AbstractBlock.Settings.create()
                .requiresTool()
                .strength(5.0F, 6.0F)
                .burnable()
                .luminance(state -> 10)
                .sounds(BlockSoundGroup.AMETHYST_BLOCK),
            true
    );

    private static Block registerBlockItem(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        RegistryKey<Block> blockKey = keyOfBlock(name);

        Block block = blockFactory.apply(settings.registryKey(blockKey));

        if (shouldRegisterItem) {
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey).useBlockPrefixedTranslationKey());
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }
        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Train.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Train.MOD_ID, name));
    }

    public static void registerModBlocks() {
        Train.LOGGER.info("Registering my Mod Blocks for:" + Train.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.RUBY_BLOCK);
            
        });
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SAPPHIRE_BLOCK);
            
        });
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
            entries.add(ModBlocks.SAPPHIRE_ORE);
            
        });
    }
}
