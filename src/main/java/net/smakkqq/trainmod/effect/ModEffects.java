package net.smakkqq.trainmod.effect;

import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class ModEffects {

    public static final RegistryEntry<StatusEffect> SPIDER_LEGS = registerStatusEffect("spider_legs",
	    new SpiderLegs(StatusEffectCategory.NEUTRAL, 0x443169)
		    .addAttributeModifier(EntityAttributes.MOVEMENT_SPEED, Identifier.of(Train.MOD_ID, "effect.spider_legs"),
			    -0.25,
			    EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE));

    public static final RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
	return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(Train.MOD_ID, name), statusEffect);
    }

    public static void registerEffect() {
	Train.LOGGER.info("Registering my effects for:" + Train.MOD_ID);
    }
}
