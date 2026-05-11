package net.smakkqq.trainmod.block;

import java.util.function.Function;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSetType;
import net.minecraft.block.Blocks;
import static net.minecraft.block.Blocks.createLeavesSettings;
import static net.minecraft.block.Blocks.register;
import net.minecraft.block.ButtonBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.PillarBlock;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.TintedParticleLeavesBlock;
import net.minecraft.block.TrapdoorBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WoodType;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.custom.BlueberryBushBlock;
import net.smakkqq.trainmod.block.custom.ChairBlock;
import net.smakkqq.trainmod.block.custom.RicesCropBlock;
import net.smakkqq.trainmod.block.custom.RubyLampBlock;
import net.smakkqq.trainmod.world.tree.ModSaplingGenerators;

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

    public static final Block RICE = registerBlockItem(
	    "rice",
	    RicesCropBlock::new,
	    AbstractBlock.Settings.create()
		    .noCollision()
		    .ticksRandomly()
		    .breakInstantly()
		    .pistonBehavior(PistonBehavior.DESTROY)
		    .sounds(BlockSoundGroup.CROP)
		    .mapColor(MapColor.DARK_CRIMSON),
	    true
    );

    public static final Block BLUEBERRY_BUSH = registerBlockItem(
	    "blueberry_bush",
	    BlueberryBushBlock::new,
	    AbstractBlock.Settings.create()
		    .noCollision()
		    .ticksRandomly()
		    .breakInstantly()
		    .pistonBehavior(PistonBehavior.DESTROY)
		    .sounds(BlockSoundGroup.SWEET_BERRY_BUSH)
		    .mapColor(MapColor.PALE_GREEN),
	    true
    );

    public static final Block SAPPHIRE_ORE = registerBlockItem(
	    "sapphire_ore",
	    Block::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );
    public static final Block DEEPSLATE_SAPPHIRE_ORE = registerBlockItem(
	    "deepslate_sapphire_ore",
	    Block::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block NETHER_SAPPHIRE_ORE = registerBlockItem(
	    "nether_sapphire_ore",
	    Block::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );
    public static final Block END_SAPPHIRE_ORE = registerBlockItem(
	    "end_sapphire_ore",
	    Block::new,
	    AbstractBlock.Settings.create()
		    .requiresTool()
		    .strength(5.0F, 6.0F)
		    .sounds(BlockSoundGroup.AMETHYST_BLOCK),
	    true
    );

    public static final Block JACARANDA_LOG = registerBlockItem(
	    "jacaranda_log",
	    PillarBlock::new,
	    AbstractBlock.Settings.create()
		    .mapColor(state -> state.get(PillarBlock.AXIS) == Direction.Axis.Y ? MapColor.OAK_TAN : MapColor.SPRUCE_BROWN)
		    .instrument(NoteBlockInstrument.BASS)
		    .strength(2.0F)
		    .sounds(BlockSoundGroup.WOOD)
		    .burnable(),
	    true
    );

    public static final Block JACARANDA_WOOD = registerBlockItem(
	    "jacaranda_wood",
	    PillarBlock::new,
	    AbstractBlock.Settings.create()
		    .mapColor(MapColor.OAK_TAN)
		    .instrument(NoteBlockInstrument.BASS)
		    .strength(2.0F)
		    .sounds(BlockSoundGroup.WOOD)
		    .burnable(),
	    true
    );
    public static final Block STRIPPED_JACARANDA_LOG = registerBlockItem(
	    "stripped_jacaranda_log",
	    PillarBlock::new,
	    AbstractBlock.Settings.create()
		    .mapColor(MapColor.OAK_TAN)
		    .instrument(NoteBlockInstrument.BASS)
		    .strength(2.0F)
		    .sounds(BlockSoundGroup.WOOD)
		    .burnable(),
	    true
    );
    public static final Block STRIPPED_JACARANDA_WOOD = registerBlockItem(
	    "stripped_jacaranda_wood",
	    PillarBlock::new,
	    AbstractBlock.Settings.create()
		    .mapColor(MapColor.OAK_TAN)
		    .instrument(NoteBlockInstrument.BASS)
		    .strength(2.0F)
		    .sounds(BlockSoundGroup.WOOD)
		    .burnable(),
	    true
    );

    public static final Block JACARANDA_PLANKS = registerBlockItem(
	    "jacaranda_planks",
	    Block::new,
	    AbstractBlock.Settings.create()
		    .mapColor(MapColor.OAK_TAN)
		    .instrument(NoteBlockInstrument.BASS)
		    .strength(2.0F, 3.0F)
		    .sounds(BlockSoundGroup.WOOD)
		    .burnable(),
	    true
    );

    public static final Block JACARANDA_LEAVES = registerBlockItem(
	    "jacaranda_leaves",
	    settings -> new TintedParticleLeavesBlock(0.01F, settings), createLeavesSettings(BlockSoundGroup.GRASS),
	    true
    );

    public static final Block JACARANDA_SAPLING = registerBlockItem(
	    "jacaranda_sapling",
	    settings -> new SaplingBlock(ModSaplingGenerators.JACARANDA, settings),
	    AbstractBlock.Settings.create()
		    .mapColor(MapColor.DARK_GREEN)
		    .noCollision()
		    .ticksRandomly()
		    .breakInstantly()
		    .sounds(BlockSoundGroup.GRASS)
		    .pistonBehavior(PistonBehavior.DESTROY),
	    true
    );

    public static final Block MANGROVE_CHAIR = registerBlockItem(
	    "mangrove_chair",
	    settings -> new ChairBlock(settings),
	    AbstractBlock.Settings.create().nonOpaque(),
	    true
    );

//    public static final Block JACARANDA_SAPLING = registerBlockItem(
//	    "jacaranda_sapling",
//	    settings -> new SaplingBlock(ModSaplingGenerators.JACARANDA, settings),
//	    AbstractBlock.Settings.create()
//		    .mapColor(MapColor.DARK_GREEN)
//		    .noCollision()
//		    .ticksRandomly()
//		    .breakInstantly()
//		    .sounds(BlockSoundGroup.GRASS)
//		    .pistonBehavior(PistonBehavior.DESTROY),
//	    true
//    );
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
