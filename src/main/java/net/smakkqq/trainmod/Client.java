package net.smakkqq.trainmod;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.client.render.RenderLayer;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.tooltip.ModToolTips;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
	ModToolTips.registerModTooltips();
	BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, ModBlocks.RICE);
    }

}
