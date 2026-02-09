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
	// Проверяем, есть ли у сущности сопротивление урону
	// Если нет, добавляем его
	if (!entity.hasStatusEffect(StatusEffects.RESISTANCE)) {
	    entity.addStatusEffect(new StatusEffectInstance(
		    StatusEffects.RESISTANCE,
		    40, // Короткая длительность (2 секунды)
		    4, // Уровень 4 = Resistance V (100% защиты)
		    false, false, true
	    ));
	}
	return true;
    }

    @Override
    public void onApplied(LivingEntity entity, int amplifier) {
	super.onApplied(entity, amplifier);

	if (!entity.getWorld().isClient()) {
	    // Создаем молнию
	    LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, entity.getWorld());
	    lightning.setPosition(entity.getX(), entity.getY(), entity.getZ());
	    entity.getWorld().spawnEntity(lightning);

	    entity.addStatusEffect(new StatusEffectInstance(
		    StatusEffects.RESISTANCE,
		    600, // тики
		    4, // сопротивление
		    false, false, true // частицы и показывать ли  в инцентаре
	    ));

	    // Опционально: наносим урон от молнии (5 сердец)
	    // entity.damage(entity.getDamageSources().lightningBolt(), 10.0f);
	}
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
	// Вызывать applyUpdateEffect каждый тик
	return true;
    }
}
