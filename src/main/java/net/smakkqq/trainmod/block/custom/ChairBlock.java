package net.smakkqq.trainmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.util.math.BlockPos;

public class ChairBlock extends HorizontalFacingBlock {

    public static final MapCodec<ChairBlock> CODEC = createCodec(ChairBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 10.0, 14.0);

    public ChairBlock(Settings settings) {
	super(settings);
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext context) {
	return this.getDefaultState().with(FACING, context.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() {
	return CODEC;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	return SHAPE;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
	super.appendProperties(builder);
	builder.add(FACING);
    }
//onUse
}
