package net.smakkqq.trainmod.villager;

import com.google.common.collect.ImmutableSet;
import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.village.VillagerProfession;
import net.minecraft.world.poi.PointOfInterestType;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModVillagers {

    public static final RegistryKey<PointOfInterestType> CARPENTER_POI_KEY = registrerPoiKey("carpenter_poi");
    public static final PointOfInterestType CARPENTER_POI = registrerPoi("carpenter_poi", ModBlocks.MANGROVE_CHAIR);

    public static final RegistryKey<VillagerProfession> CARPENTER_KEY
	    = RegistryKey.of(RegistryKeys.VILLAGER_PROFESSION, Identifier.of(Train.MOD_ID, "carpenter"));
    public static final VillagerProfession CARPENTER = registerProfession("carpenter", CARPENTER_POI_KEY);

    private static VillagerProfession registerProfession(String name, RegistryKey<PointOfInterestType> type) {
	return Registry.register(Registries.VILLAGER_PROFESSION, Identifier.of(Train.MOD_ID, name),
		new VillagerProfession(Text.literal("Carpenter"), entry -> entry.matchesKey(type), entry -> entry.matchesKey(type),
			ImmutableSet.of(), ImmutableSet.of(), SoundEvents.ENTITY_VILLAGER_WORK_LIBRARIAN));
    }

    private static PointOfInterestType registrerPoi(String name, Block block) {
	return PointOfInterestHelper.register(Identifier.of(Train.MOD_ID, name), 1, 1, block);
    }

    private static RegistryKey<PointOfInterestType> registrerPoiKey(String name) {
	return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Train.MOD_ID, name));
    }

    public static void registerVillagers() {
	Train.LOGGER.info("Registering my Mod Villager for:" + Train.MOD_ID);
    }
}
