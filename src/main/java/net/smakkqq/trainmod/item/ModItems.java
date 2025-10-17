package net.smakkqq.trainmod.item;

import java.util.function.Function;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.item.custom.FireRod;
import net.smakkqq.trainmod.item.custom.LightningRod;

public class ModItems {

    public static final Item RUBY = registerItem(
            "ruby",
            FireRod::new,
            new Item.Settings()
    );
 
    public static final Item SAPPHIRE = registerItem(
            "sapphire",
            LightningRod::new,
            new Item.Settings()
    );

//    public static final Item LIGHTNING_ROD = registerItem(
//            "lightning_rod",
//            LightningRod::new,
//            new Item.Settings()
//    );
//    
//     public static final Item FIRE_ROD = registerItem(
//            "fire_rod",
//            FireRod::new,
//            new Item.Settings()
//    );

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
