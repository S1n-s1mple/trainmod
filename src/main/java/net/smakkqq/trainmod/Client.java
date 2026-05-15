package net.smakkqq.trainmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.BlockRenderLayer;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.entity.ModEntities;
import net.smakkqq.trainmod.entity.client.CapibaraModel;
import net.smakkqq.trainmod.entity.client.CapibaraRenderer;
import net.smakkqq.trainmod.entity.client.ChairRenderer;
import net.smakkqq.trainmod.entity.client.TomahawkProjectileModel;
import net.smakkqq.trainmod.entity.client.TomahawkProjectileRenderer;
import net.smakkqq.trainmod.tooltip.ModToolTips;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
	ModToolTips.registerModTooltips();
	BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
		ModBlocks.RICE,
		ModBlocks.BLUEBERRY_BUSH);
	BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT,
		ModBlocks.JACARANDA_SAPLING);

	EntityRendererRegistry.register(ModEntities.CAPIBARA, CapibaraRenderer::new);
	EntityModelLayerRegistry.registerModelLayer(CapibaraModel.CAPIBARA, CapibaraModel::getTexturedModelData);

	EntityRendererRegistry.register(ModEntities.TOMAHAWK, TomahawkProjectileRenderer::new);
	EntityModelLayerRegistry.registerModelLayer(TomahawkProjectileModel.TOMAHAWK, TomahawkProjectileModel::createBodyLayer);
	
	EntityRendererRegistry.register(ModEntities.CHAIR, ChairRenderer::new);

    }

}
