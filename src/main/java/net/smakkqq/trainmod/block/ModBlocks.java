package net.smakkqq.trainmod.block;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.custom.MagicBlock;
import net.smakkqq.trainmod.block.custom.RubyLampBlock;

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
	    MagicBlock::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_STAIRS = registerBlockItem(
	    "ruby_block_stairs",
	    (settings) -> new StairsBlock(ModBlocks.RUBY_BLOCK.getDefaultState(), settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_SLAB = registerBlockItem(
	    "ruby_block_slab",
	    SlabBlock::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_BUTTON = registerBlockItem(
	    "ruby_block_button",
	    (settings) -> new ButtonBlock(BlockSetType.IRON, 2, settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK).noCollision(),
	    true
    );

    public static final Block RUBY_BLOCK_PRESSURE_PLATE = registerBlockItem(
	    "ruby_block_pressure_plate",
	    (settings) -> new PressurePlateBlock(BlockSetType.IRON, settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_FENCE_GATE = registerBlockItem(
	    "ruby_block_fence_gate",
	    (settings) -> new FenceGateBlock(WoodType.BAMBOO, settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_FENCE = registerBlockItem(
	    "ruby_block_fence",
	    FenceBlock::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_BLOCK_TRAPDOOR = registerBlockItem(
	    "ruby_block_trapdoor",
	    (settings) -> new TrapdoorBlock(BlockSetType.IRON, settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque(),
	    true
    );

    public static final Block RUBY_BLOCK_DOOR = registerBlockItem(
	    "ruby_block_door",
	    (settings) -> new DoorBlock(BlockSetType.IRON, settings),
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK).nonOpaque(),
	    true
    );

    public static final Block RUBY_BLOCK_WALL = registerBlockItem(
	    "ruby_block_wall",
	    WallBlock::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block RUBY_LAMP = registerBlockItem(
	    "ruby_lamp",
	    RubyLampBlock::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(1f)
		    .luminance(state -> state.get(RubyLampBlock.CLICKED) ? 15 : 0)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

//    public static final Block SAPPHIRE_BLOCK = registerBlockItem(
//            "sapphire_block",
//            Block::new,
//            AbstractBlock.Settings.create()
//                .requiresTool()
//                .strength(5.0F, 6.0F)
//                .burnable()
//                .luminance(state -> 10)
//                .sounds(BlockSoundGroup.AMETHYST_BLOCK),
//            true
//    );
//    public static final Block SAPPHIRE_BLOCK = registerBlockItem(
//	    "magic_block",
//	    MagicBlock::new,
//	    AbstractBlock.Settings.create()
//		    .requiresTool()
//		    .strength(5.0F, 6.0F)
//		    .burnable()
//		    .luminance(state -> 10)
//		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
//	    true
//    );

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

//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(ModBlocks.RUBY_BLOCK);
//            
//        });
//        
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {
//            entries.add(ModBlocks.SAPPHIRE_BLOCK);
//            
//        });
    }
}
