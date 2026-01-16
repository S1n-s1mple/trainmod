package net.smakkqq.trainmod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smakkqq.trainmod.component.ModDataComponentTypes;
import net.smakkqq.trainmod.sound.ModSound;

import java.util.Map;

public class ChiselItem extends Item {

    public static final Map<Block, Block> CHISEL_MAP = Map.of(
	    Blocks.STONE, Blocks.STONE_BRICKS,
	    Blocks.DEEPSLATE, Blocks.DEEPSLATE_BRICKS,
	    Blocks.POLISHED_BLACKSTONE, Blocks.POLISHED_BLACKSTONE_BRICKS,
	    Blocks.END_STONE, Blocks.END_STONE_BRICKS
    );

    public ChiselItem(Settings settings) {
	super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
	World world = context.getWorld();
	BlockPos pos = context.getBlockPos();
	Block clickedBlock = world.getBlockState(pos).getBlock();

	if (CHISEL_MAP.containsKey(clickedBlock)) {
	    if (!world.isClient()) {
		world.setBlockState(pos, CHISEL_MAP.get(clickedBlock).getDefaultState());

		ItemStack stack = context.getStack();
		if (context.getPlayer() instanceof ServerPlayerEntity serverPlayer) {
		    stack.damage(1, serverPlayer, EquipmentSlot.MAINHAND);

		    stack.set(ModDataComponentTypes.COORDINATES, pos);
		    stack.set(ModDataComponentTypes.BLOCK, clickedBlock);
		}

		world.playSound(null, context.getBlockPos(), ModSound.CHISEL_USE, SoundCategory.BLOCKS);
	    }
	    return ActionResult.SUCCESS;
	}

	return ActionResult.PASS;
    }
}
