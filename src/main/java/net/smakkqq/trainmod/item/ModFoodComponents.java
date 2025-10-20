package net.smakkqq.trainmod.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent FUNNY_POTATO = new FoodComponent.Builder().nutrition(6).saturationModifier(0.15f).build();
//            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();
}
