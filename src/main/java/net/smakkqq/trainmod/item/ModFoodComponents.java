package net.smakkqq.trainmod.item;

import net.minecraft.component.type.FoodComponent;

public class ModFoodComponents {

    public static final FoodComponent FUNNY_POTATO = new FoodComponent.Builder().nutrition(6).saturationModifier(0.15f).build();
    public static final FoodComponent RICE = new FoodComponent.Builder().nutrition(2).saturationModifier(0.3f).build();
    public static final FoodComponent BLUEBERRY = new FoodComponent.Builder().nutrition(3).saturationModifier(0.2f).build();
//            .statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST, 200), 0.15f).build();
}
