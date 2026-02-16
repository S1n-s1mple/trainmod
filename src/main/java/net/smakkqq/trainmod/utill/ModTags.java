package net.smakkqq.trainmod.utill;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class ModTags {

    public static class Blocks {
	public static final TagKey<Block> NEEDS_RUBY_TOOL = createTag("needs_ruby_tool");
	public static final TagKey<Block> INCORRECT_FOR_RUBY_TOOL = createTag("incorrect_for_ruby_tool");
	
	public static final TagKey<Block> NEEDS_SAPPHIRE_TOOL = createTag("needs_sapphrie_tool");
	public static final TagKey<Block> INCORRECT_FOR_SAPPHIRE_TOOL = createTag("incorrect_for_sapphrie_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(Train.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");
        public static final TagKey<Item> SAPPHIRE_REPAIR = createTag("sapphire_repair");
        public static final TagKey<Item> SAPPHIRE_ARMOR = createTag("sapphire_armor");
        public static final TagKey<Item> LIGHTNING_STRIKER_ENCHANTABLE = createTag("lightning_striker_enchantable");
        public static final TagKey<Item> DIVINE_PUNISHMENT_ENCHANTABLE = createTag("divine_punishment_enchantable");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(Train.MOD_ID, name));
        }
    }
}
