package net.smakkqq.trainmod.enchantment;

import net.minecraft.component.EnchantmentEffectComponentTypes;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.effect.EnchantmentEffectTarget;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.enchantment.custom.LightningStrikerEnchantmentEffect;
import net.smakkqq.trainmod.utill.ModTags;

public class ModEnchantments {

    public static final RegistryKey<Enchantment> LIGHTNING_STRIKER = of("lightning_striker");

    public static void bootstrap(Registerable<Enchantment> registerable) {
	var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
	var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

	register(registerable, LIGHTNING_STRIKER,
		Enchantment.builder(Enchantment.definition(
			items.getOrThrow(ModTags.Items.LIGHTNING_STRIKER_ENCHANTABLE),
			items.getOrThrow(ItemTags.SWORD_ENCHANTABLE),
			5,
			3,
			Enchantment.leveledCost(10, 10),
			Enchantment.leveledCost(50, 10),
			5,
			AttributeModifierSlot.MAINHAND))
			.exclusiveSet(enchantments.getOrThrow(EnchantmentTags.DAMAGE_EXCLUSIVE_SET))
			.addEffect(EnchantmentEffectComponentTypes.POST_ATTACK,
				EnchantmentEffectTarget.ATTACKER,
				EnchantmentEffectTarget.VICTIM,
				new LightningStrikerEnchantmentEffect())
	);
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
	registry.register(key, builder.build(key.getValue()));
    }

    private static RegistryKey<Enchantment> of(String id) {
	return RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(Train.MOD_ID, id));
    }

    public static void registerEnchantments() {
	Train.LOGGER.info("Registering mod enchantments for:" + Train.MOD_ID);
    }

}
