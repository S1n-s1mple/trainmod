package net.smakkqq.trainmod.item;

import java.util.List;
import net.minecraft.component.type.ConsumableComponent;
import static net.minecraft.component.type.ConsumableComponents.food;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

public class ModConsumableComponents {

    public static final ConsumableComponent RICE = food()
	    .consumeEffect(new ApplyEffectsConsumeEffect(List.of(
		    new StatusEffectInstance(StatusEffects.STRENGTH, 300, 1),
		    new StatusEffectInstance(StatusEffects.GLOWING, 300, 1)
		    ), 0.25f
	    )).build();
}
