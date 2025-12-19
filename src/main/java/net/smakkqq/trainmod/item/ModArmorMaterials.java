package net.smakkqq.trainmod.item;

import java.util.EnumMap;
import net.minecraft.item.equipment.ArmorMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.utill.ModTags;

class ModArmorMaterials {

    public static final ArmorMaterial SAPPHIRE_ARMOR_MATERIAL = new ArmorMaterial(500, Util.make(
	    new EnumMap<>(EquipmentType.class), map -> {
		map.put(EquipmentType.BOOTS, 3);
		map.put(EquipmentType.LEGGINGS, 6);
		map.put(EquipmentType.CHESTPLATE, 8);
		map.put(EquipmentType.HELMET, 3);
	    }), 20, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 0, 0, ModTags.Items.SAPPHIRE_REPAIR,
	    RegistryKey.of(RegistryKey.ofRegistry(Identifier.ofVanilla("equipment_asset")), Identifier.of(Train.MOD_ID, "ruby")));

//    public static RegistryEntry<ArmorMaterial> registerArmorMaterial(String name, Supplier<ArmorMaterial> material) {
//	return Registry.registerReference(Registries., Identifier.of(Lesson.MOD_ID, name), material.get());
//    }
}
