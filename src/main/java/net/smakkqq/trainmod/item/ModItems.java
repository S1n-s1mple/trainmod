package net.smakkqq.trainmod.item;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.item.equipment.EquipmentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.item.custom.ArrowRod;
import net.smakkqq.trainmod.item.custom.ChiselItem;
import net.smakkqq.trainmod.item.custom.FireRod;
import net.smakkqq.trainmod.item.custom.HammerItem;
import net.smakkqq.trainmod.item.custom.LightningRod;


public class ModItems {

    public static final Item RUBY = registerItem(
	    "ruby",
	    Item::new,
	    new Item.Settings()
    );

    public static final Item SAPPHIRE = registerItem(
	    "sapphire",
	    Item::new,
	    new Item.Settings()
    );

    public static final Item LIGHTNING_ROD = registerItem(
	    "lightning_rod",
	    LightningRod::new,
	    new Item.Settings()
    );

    public static final Item FIRE_ROD = registerItem(
	    "fire_rod",
	    FireRod::new,
	    new Item.Settings()
    );

    public static final Item ARROW_ROD = registerItem(
	    "arrow_rod",
	    ArrowRod::new,
	    new Item.Settings()
    );

    public static final Item FUNNY_POTATO = registerItem(
	    "funny_potato",
	    Item::new,
	    new Item.Settings().food(ModFoodComponents.FUNNY_POTATO)
    );

    public static final Item FUEL = registerItem(
	    "fuel",
	    Item::new,
	    new Item.Settings()
    );

    public static final Item RUBY_HOE = registerItem(
	    "ruby_hoe",
	    settings -> new HoeItem(ToolMaterial.NETHERITE, 0F, -3.0F, settings),
	    new Item.Settings()
    );

    public static final Item RUBY_SHOVEL = registerItem(
	    "ruby_shovel",
	    settings -> new ShovelItem(ToolMaterial.NETHERITE, 1.5F, -2.8F, settings),
	    new Item.Settings()
    );

    public static final Item RUBY_AXE = registerItem(
	    "ruby_axe",
	    settings -> new AxeItem(ToolMaterial.NETHERITE, 6.0F, -3.2F, settings),
	    new Item.Settings()
    );

    public static final Item RUBY_PICKAXE = registerItem(
	    "ruby_pickaxe",
	    Item::new,
	    new Item.Settings().pickaxe(ToolMaterial.NETHERITE, 1.0F, -2.8F)
    );

    public static final Item RUBY_SWORD = registerItem(
	    "ruby_sword",
	    Item::new,
	    new Item.Settings().sword(ToolMaterial.NETHERITE, 5.0F, -2.8F)
    );

    public static final Item SAPPHIRE_HOE = registerItem(
	    "sapphire_hoe",
	    settings -> new HoeItem(ModToolMaterials.SAPPHIRE_MATERIAL, 0F, -3.0F, settings),
	    new Item.Settings()
    );

    public static final Item SAPPHIRE_SHOVEL = registerItem(
	    "sapphire_shovel",
	    settings -> new ShovelItem(ModToolMaterials.SAPPHIRE_MATERIAL, 1.5F, -2.8F, settings),
	    new Item.Settings()
    );

    public static final Item SAPPHIRE_AXE = registerItem(
	    "sapphire_axe",
	    settings -> new AxeItem(ModToolMaterials.SAPPHIRE_MATERIAL, 6.0F, -3.2F, settings),
	    new Item.Settings()
    );

    public static final Item SAPPHIRE_PICKAXE = registerItem(
	    "sapphire_pickaxe",
	    Item::new,
	    new Item.Settings().pickaxe(ModToolMaterials.SAPPHIRE_MATERIAL, 1.0F, -2.8F)
    );

    public static final Item SAPPHIRE_SWORD = registerItem(
	    "sapphire_sword",
	    Item::new,
	    new Item.Settings().sword(ModToolMaterials.SAPPHIRE_MATERIAL, 5.0F, -2.8F)
    );

    public static final Item RUBY_HAMMER = registerItem(
	    "ruby_hammer",
	    settings -> new HammerItem(ModToolMaterials.SAPPHIRE_MATERIAL, 7.0F, -3.4F, settings),
	    new Item.Settings()
    );
    
    
    public static final Item SAPPHIRE_CHISEL = registerItem(
	    "sapphire_chisel",
	    settings -> new ChiselItem(settings.maxDamage(64)),
	    new Item.Settings()
    );

//@@@@@@@@@@@@@@@@@     БРОНЯ     @@@@@@@@@@@@@@@@@@@@@@@@
    public static final Item SAPPHIRE_HELMET = registerItem(
	    "sapphire_helmet",
	    Item::new,
	    new Item.Settings().armor(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, EquipmentType.HELMET)
		    .maxDamage(
			    EquipmentType.HELMET.getMaxDamage(
				    ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL.durability()))
    );

    public static final Item SAPPHIRE_CHESTPLATE = registerItem(
	    "sapphire_chestplate",
	    Item::new,
	    new Item.Settings().armor(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, EquipmentType.CHESTPLATE)
		    .maxDamage(
			    EquipmentType.CHESTPLATE.getMaxDamage(
				    ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL.durability()))
    );

    public static final Item SAPPHIRE_LEGGINGS = registerItem(
	    "sapphire_leggings",
	    Item::new,
	    new Item.Settings().armor(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, EquipmentType.LEGGINGS)
		    .maxDamage(
			    EquipmentType.LEGGINGS.getMaxDamage(
				    ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL.durability()))
    );

    public static final Item SAPPHIRE_BOOTS = registerItem(
	    "sapphire_boots",
	    Item::new,
	    new Item.Settings().armor(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL, EquipmentType.BOOTS)
		    .maxDamage(
			    EquipmentType.BOOTS.getMaxDamage(
				    ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL.durability()))
    );
    
     public static final Item SAPPHIRE_HORSE_ARMOR = registerItem(
	    "sapphire_horse_armor",
	    settings -> new Item(settings.horseArmor(ModArmorMaterials.SAPPHIRE_ARMOR_MATERIAL)),
	    new Item.Settings()
    );

    private static Item registerItem(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
	// Создание ключа для предмета
	RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Train.MOD_ID, name));
	Item item = itemFactory.apply(settings.registryKey(itemKey));
	return Registry.register(Registries.ITEM, itemKey, item);
    }

    public static void registerModItems() {
	Train.LOGGER.info("Registering my Mod Items for:" + Train.MOD_ID);

	ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
//            entries.add(RUBY);
//            entries.add(SAPPHIRE);
	});
    }
}
