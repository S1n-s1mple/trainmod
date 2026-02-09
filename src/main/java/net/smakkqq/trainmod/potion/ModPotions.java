package net.smakkqq.trainmod.potion;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.effect.ModEffects;

public class ModPotions {
    public static final RegistryEntry<Potion> SPIDER_LEGS_POTION = registerPotion("spider_legs",
	    new Potion("spider_legs", new StatusEffectInstance(ModEffects.SPIDER_LEGS, 600, 0)));
    
    public static final RegistryEntry<Potion> BLESSIN_POTION = registerPotion("blessing",
	    new Potion("blessing", new StatusEffectInstance(ModEffects.BLESSING, 1200, 0)));

    
    public static  RegistryEntry<Potion> registerPotion(String name, Potion potion){
	
	return Registry.registerReference(Registries.POTION, Identifier.of(Train.MOD_ID, name), potion);
    }
    
    public static void registerPotions() {
	Train.LOGGER.info("Registering potions for:" + Train.MOD_ID);
    }
}
