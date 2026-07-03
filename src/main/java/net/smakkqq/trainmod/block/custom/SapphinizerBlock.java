package net.smakkqq.trainmod.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ModBlockEntities;
import net.smakkqq.trainmod.entity.custom.SapphinizerBlockEntity;
import org.jetbrains.annotations.Nullable;

public class SapphinizerBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final MapCodec<SapphinizerBlock> CODEC = SapphinizerBlock.createCodec(SapphinizerBlock::new);

    public SapphinizerBlock(Settings settings) {
	super(settings);
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
	return CODEC;
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
	return new SapphinizerBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
	return BlockRenderType.MODEL;
    }

    @Override
    public ActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
	if (!world.isClient()) {
	    NamedScreenHandlerFactory screenHandlerFactory = ((SapphinizerBlockEntity) world.getBlockEntity(pos));

	    if (screenHandlerFactory != null) {
		player.openHandledScreen(screenHandlerFactory);
	    }
	}
	return ActionResult.SUCCESS;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
	if (world.isClient) {
	    return null;
	}
	return validateTicker(type, ModBlockEntities.SAPPHINIZER_BE,
		(world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
    }

}
