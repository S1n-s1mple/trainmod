//package net.smakkqq.trainmod.item.custom;
//
//import static java.nio.file.Files.lines;
//import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
//import static net.minecraft.command.argument.ItemStackArgumentType.itemStack;
//import net.minecraft.text.Text;
//import net.smakkqq.trainmod.block.ModBlocks;
//import net.smakkqq.trainmod.item.ModItems;
//
//public class ModToolTips {
//    
//        ItemTooltipCallback.EVENT.register((itemStack, context, type, lines) -> {
//            if (itemStack.isOf(ModBlocks.RUBY_BLOCK.asItem())) {
//                lines.add(Text.translatable("block.train.ruby_block.tooltip"));
//            }
//            if (itemStack.isOf(ModItems.RUBY.asItem())) {
//                lines.add(Text.translatable("block.train.ruby.tooltip"));
//            }
//        });
//}
