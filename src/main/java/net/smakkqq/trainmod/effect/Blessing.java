package net.smakkqq.trainmod.effect;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;

public class Blessing extends StatusEffect {

    public Blessing(StatusEffectCategory category, int color) {
	super(category, color);
    }

    @Override
    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
	if (!entity.hasStatusEffect(StatusEffects.RESISTANCE)) {
	    entity.addStatusEffect(new StatusEffectInstance(
		    StatusEffects.RESISTANCE,
		    40,
		    4,
		    false, false, true
	    ));
	}
	return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
	super.onApplied(entity, amplifier);

	if (!entity.getWorld().isClient()) {
	    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getWorld());
	    lightning.setPosition(entity.getX(), entity.getY(), entity.getZ());
	    entity.getWorld().spawnEntity(lightning);

	    entity.addStatusEffect(new StatusEffectInstance(
		    StatusEffects.RESISTANCE,
		    600,
		    4, 
		    false, false, true
	    ));
	}
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
	return true;
    }
}
