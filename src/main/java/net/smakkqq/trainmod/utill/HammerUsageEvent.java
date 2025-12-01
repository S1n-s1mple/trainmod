package net.smakkqq.trainmod.utill;

import java.util.HashSet;
import java.util.Set;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smakkqq.trainmod.item.custom.HammerItem;

public class HammerUsageEvent implements PlayerBlockBreakEvents.Before {

    private static final Set<BlockPos> HARVESTED_BLOCKS = new HashSet<>();

    @Override
    public boolean beforeBlockBreak(World world, PlayerEntity player, BlockPos pos, 
	    BlockState state, BlockEntity blockEntity) {
	ItemStack mainHandItem = player.getMainHandStack();
	
	if (mainHandItem.getItem() instanceof  HammerItem hammer && player instanceof ServerPlayerEntity serverPlayer) {
	    if(HARVESTED_BLOCKS.contains(pos)){
		return false;
	    }
	    
	    for(BlockPos position : HammerItem.getBlocksToBeDestroyed(1, pos, serverPlayer)){
		if (pos == position || !hammer.isCorrectForDrops(mainHandItem, world.getBlockState(position))) {
		    continue;
		}
		
		HARVESTED_BLOCKS.add(position);
		serverPlayer.interactionManager.tryBreakBlock(position);
		HARVESTED_BLOCKS.remove(position);
	    }
	}
	return true;
    }

}
