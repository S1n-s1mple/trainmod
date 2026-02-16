package net.smakkqq.trainmod.enchantment;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.enchantment.effect.EnchantmentValueEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.enchantment.custom.DivinePunishmentEntityEffect;
import net.smakkqq.trainmod.enchantment.custom.LightningStrikerEnchantmentEffect;

public class ModEnchantmentEffects {

    public static final MapCodec<? extends EnchantmentEntityEffect> LIGHTNING_STRIKER = registerEntityEffect("lightning_striker", LightningStrikerEnchantmentEffect.CODEC);

    public static final MapCodec<? extends EnchantmentEntityEffect> DIVINE_PUNISHMENT = registerEntityEffect("divine_punishment", DivinePunishmentEntityEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(
	    String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
	return Registry.register(
		Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE,
		Identifier.of(Train.MOD_ID, name),
		codec
	);
    }

    private static MapCodec<? extends EnchantmentValueEffect> registerValueEffect(
	    String name, MapCodec<? extends EnchantmentValueEffect> codec) {
	return Registry.register(
		Registries.ENCHANTMENT_VALUE_EFFECT_TYPE,
		Identifier.of(Train.MOD_ID, name),
		codec
	);
    }

    public static void registerEffect() {
	Train.LOGGER.info("Registering mod enchantment effects for: " + Train.MOD_ID);
    }
}
