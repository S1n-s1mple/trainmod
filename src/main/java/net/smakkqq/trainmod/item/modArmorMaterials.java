package net.smakkqq.trainmod.item;

import java.util.EnumMap;
import java.util.function.Supplier;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.utill.ModTags;

public class modArmorMaterials {
    public static final ArmorMaterial RUBY_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(
	    new EnumMap<>(EquipmentType.class), map ->{
		map.put(EquipmentType.CHESTPLATE, 8);
		map.put(EquipmentType.LEGGINGS, 6);
		map.put(EquipmentType.HELMET, 3);
		map.put(EquipmentType.BOOTS, 3);
	    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, 0, ModTags.RUBY_REPAIR, 
	    RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipmnet_asset")), Identifier.of(Train.MOD_ID, "ruby"))
    );

//    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
//	return Registry.registerReference(Registries.ITEM_GROUP, Identifier.of(Train.MOD_ID, name), material.get());
//    }
}
