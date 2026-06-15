package net.smakkqq.trainmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.util.InputUtil;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.entity.ModBlockEntities;
import net.smakkqq.trainmod.entity.ModEntities;
import net.smakkqq.trainmod.entity.client.CapibaraModel;
import net.smakkqq.trainmod.entity.client.CapibaraRenderer;
import net.smakkqq.trainmod.entity.client.ChairRenderer;
import net.smakkqq.trainmod.entity.client.PedestalBlockEntityRenderer;
import net.smakkqq.trainmod.entity.client.TomahawkProjectileModel;
import net.smakkqq.trainmod.entity.client.TomahawkProjectileRenderer;
import net.smakkqq.trainmod.interfaceMod.ModScreenHandlers;
import net.smakkqq.trainmod.interfaceMod.SimpleScreen;
import net.smakkqq.trainmod.interfaceMod.custom.PedestalScreen;
import net.smakkqq.trainmod.tooltip.ModToolTips;
import org.lwjgl.glfw.GLFW;

public class Client implements ClientModInitializer {

    private static KeyBinding openKeyBinding;

    @Override
    public void onInitializeClient() {
	ModToolTips.registerModTooltips();
	BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
		ModBlocks.RICE,
		ModBlocks.BLUEBERRY_BUSH);
	BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
		ModBlocks.JACARANDA_SAPLING);
	
	HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);

	EntityRendererRegistry.register(ModEntities.CAPIBARA, CapibaraRenderer::new);
	EntityModelLayerRegistry.registerModelLayer(CapibaraModel.CAPIBARA, CapibaraModel::getTexturedModelData);

	EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
	EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::createBodyLayer);

	EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

	BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);

	openKeyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
		"key.g_interface_mod.open",
		InputUtil.Type.KEYSYM,
		GLFW.GLFW_KEY_GRAVE_ACCENT,
		"category.g_interface_mod.general"
	));

	ClientTickEvents.END_CLIENT_TICK.register(client
		-> {
	    while (openKeyBinding.wasPressed()) {
		if (client.player != null && client.currentScreen == null) {
		    client.setScreen(new SimpleScreen());
		}
	    }
	});

    }

}
