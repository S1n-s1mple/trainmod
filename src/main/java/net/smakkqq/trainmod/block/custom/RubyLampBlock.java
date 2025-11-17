package net.smakkqq.trainmod.block.custom;

import static net.fabricmc.fabric.api.networking.v1.PlayerLookup.world;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RubyLampBlock extends Block {

    public static final BooleanProperty CLICKED = BooleanProperty.of("clicked");

    public RubyLampBlock(Settings settings) {
	super(settings);
	setDefaultState(this.getDefaultState().with(CLICKED, false));
    }
    
    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
	if (!world.isClient()) {
	    world.setBlockState(pos, state.cycle(CLICKED));
	}
	return ActionResult.SUCCESS;
    }
    
    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
	builder.add(CLICKED);
    }

}
