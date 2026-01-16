package net.smakkqq.trainmod.tooltip;

import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.block.Block;
import net.minecraft.text.Text;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.item.ModItems;

import net.minecraft.client.gui.screen.Screen;

import static net.smakkqq.trainmod.component.ModDataComponentTypes.BLOCK;
import static net.smakkqq.trainmod.component.ModDataComponentTypes.COORDINATES;

public class ModToolTips {

    public static void registerModTooltips() {
	Train.LOGGER.info("Registering tool tipe for:" + Train.MOD_ID);

	ItemTooltipCallback.EVENT.register((itemStack, Tooltipcontext, tooltipType, list) -> {

	    if (itemStack.isOf(ModItems.SAPPHIRE_CHISEL)) {
		if (!Screen.hasShiftDown()) {
		    list.add(Text.translatable("item.train.sapphire_chisel.tooltip"));
		    return;
		}

		list.add(Text.translatable("item.train.sapphire_chisel.tooltip_expanded"));

		if (itemStack.get(COORDINATES) != null && itemStack.get(BLOCK) instanceof Block block) {
		    list.add(Text.literal("Last Block changed: " + block.getName().getString() + " at " + itemStack.get(COORDINATES)));
		}
	    }

	    if (itemStack.isOf(ModBlocks.SAPPHIRE_BLOCK.asItem())) {
		list.add(Text.translatable("block.train.sapphire_block.tooltip"));
		return;
	    }
	    if (itemStack.isOf(ModBlocks.RUBY_BLOCK.asItem())) {
		list.add(Text.translatable("block.train.ruby_block.tooltip"));
		return;
	    }

	    if (itemStack.isOf(ModItems.SAPPHIRE.asItem())) {
		list.add(Text.translatable("item.train.sapphrie"));
		return;
	    }
	    if (itemStack.isOf(ModItems.RUBY.asItem())) {
		list.add(Text.translatable("item.train.ruby"));
		return;
	    }

	    if (itemStack.isOf(ModItems.LIGHTNING_ROD.asItem())) {
		list.add(Text.translatable("item.train.lightning_rod"));
		return;
	    }
	    if (itemStack.isOf(ModItems.FIRE_ROD.asItem())) {
		list.add(Text.translatable("item.train.fire_rod"));
		return;
	    }
	    if (itemStack.isOf(ModItems.ARROW_ROD.asItem())) {
		list.add(Text.translatable("item.train.arrow_rod"));
		return;
	    }

	});
    }
}
