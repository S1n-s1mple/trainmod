package net.smakkqq.trainmod.block.custom;

import com.mojang.serialization.MapCodec;
import static net.minecraft.block.AbstractBlock.createCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.ShapeContext;
import static net.minecraft.block.StairsBlock.SHAPE;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class PedestalBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final MapCodec<PedestalBlock> CODEC = PedestalBlock.createCodec(PedestalBlock::new);
    private static final VoxelShape SHAPE = Block.createCuboidShape(2.0, 0.0, 2.0, 14.0, 13.0, 14.0);

    public PedestalBlock(Settings settings) {
	super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
	return SHAPE;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
	return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
	return new PedestalBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
	return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
	if (world.getBlockEntity.(pos) instanceof PedestalBlockEntity pedestalBlockEntity) {
	    if (pedestalBlockEntity.isEmpty() && !stack.isEmpty()) {
		pedestalBlockEntity.setStack(0, stack.copyWithCount(1));
		world.playSound(player, pos, SoundEvents.ENTITY_ITEM_FRAME_ADD_ITEM, SoundCategory.BLOCKS, 1f, 1f);
		stack.decrement(1);

		pedestalBlockEntity.markDirty();
		world.updateListeners(pos, state, state, 0);
	    } else if (stack.isEmpty() && !player.isSneaking()) {
		ItemStack stackOnPedestal = pedestalBlockEntity.getStack(0);
		player.setStackInHand(Hand.MAIN_HAND, stackOnPedestal);
		world.playSound(player, pos, SoundEvents.ENTITY_ITEM_PICKUP, SoundCategory.BLOCKS, 1f, 1f);
		pedestalBlockEntity.clear();
		
		pedestalBlockEntity.markDirty();
		world.updateListeners(pos, state, state, 0);
	    }
	}
	return ActionResult.SUCCESS;
    }
}
