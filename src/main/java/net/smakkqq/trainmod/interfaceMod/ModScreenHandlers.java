package net.smakkqq.trainmod.interfaceMod;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.minecraft.util.math.BlockPos;
import net.smakkqq.trainmod.interfaceMod.PedestalScreenHandler;

public class ModScreenHandlers {

    public static final ScreenHandlerType<PedestalScreenHandler> PEDESTAL_SCREEN_HANDLER = Registry.register(
	    Registries.SCREEN_HANDLER,
	    Identifier.of(Train.MOD_ID, "pedestal_screen_handler"),
	    new ExtendedScreenHandlerType<>(PedestalScreenHandler::new, BlockPos.PACKET_CODEC));

    public static final ScreenHandlerType<SapphinizerScreenHandler> SAPPHINIZER_SCREEN_HANDLER = Registry.register(
	    Registries.SCREEN_HANDLER,
	    Identifier.of(Train.MOD_ID, "sapphinizer_screen_handler"),
	    new ExtendedScreenHandlerType<>(SapphinizerScreenHandler::new, BlockPos.PACKET_CODEC));

    public static void registerScreenHandlers() {
	Train.LOGGER.info("Registering my Screen Handlers for: " + Train.MOD_ID);
    }
}
