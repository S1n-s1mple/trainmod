package net.smakkqq.trainmod.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.entity.custom.CapibaraEntity;
import net.smakkqq.trainmod.entity.custom.TomahawkProjectileEntity;
import static net.smakkqq.trainmod.utill.createIdentifier.createIdentifier;

public class ModEntities {

    private static final RegistryKey<EntityType<?>> CAPIBARA_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, createIdentifier("capibara"));
    private static final RegistryKey<EntityType<?>> TOMAHAWK_KEY = RegistryKey.of(RegistryKeys.ENTITY_TYPE, createIdentifier("tomahawk"));

    public static final EntityType<CapibaraEntity> CAPIBARA = Registry.register(Registries.ENTITY_TYPE, createIdentifier("capibara"),
	    EntityType.Builder.create(CapibaraEntity::new, SpawnGroup.CREATURE).dimensions(0.5f, 0.6f).eyeHeight(0.26f).build(CAPIBARA_KEY));

    public static final EntityType<TomahawkProjectileEntity> TOMAHAWK = Registry.register(Registries.ENTITY_TYPE, createIdentifier("tomahawk"),
	    EntityType.Builder.<TomahawkProjectileEntity>create(TomahawkProjectileEntity::new, SpawnGroup.CREATURE).dimensions(0.5f, 0.6f).build(TOMAHAWK_KEY));

    public static void registerModEntities() {
	Train.LOGGER.info("Registering my Mod Entities for:" + Train.MOD_ID);
    }
}
