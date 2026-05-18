package net.smakkqq.trainmod.villager;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;

public class ModVillagers {
    public static final RegistryKey<PointOfInterestType> CARPENTER_POI_KEY = registrerPoiKey("carpenter");
    public static final PointOfInterestType CARPENTER_POI = registrerPoi("carpenter_poi", ModBlocks.MANGROVE_CHAIR);
    
    private static PointOfInterestType registrerPoi(String name, Block block){
	return PointOfInterestHelper.register(Identifier.of(Train.MOD_ID, name), 1, 1, block);
    }
    
     private static RegistryKey<PointOfInterestType> registrerPoiKey(String name){
	return RegistryKey.of(RegistryKeys.POINT_OF_INTEREST_TYPE, Identifier.of(Train.MOD_ID, name));
    }
    
    
    public static void registerVillagers(){
	Train.LOGGER.info("Registering my Mod Villager for:" + Train.MOD_ID);
    }
}
