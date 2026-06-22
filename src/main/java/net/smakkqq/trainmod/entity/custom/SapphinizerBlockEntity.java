package net.smakkqq.trainmod.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ImplementedInventory;
import net.smakkqq.trainmod.entity.ModBlockEntities;

public class SapphinizerBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final ModBlockEntities propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public SapphinizerBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
	super(ModBlockEntities.SAPPHINIZER_BE, pos, state);
	this.propertyDelegate = new PropertyDelegate() {
	    @Override
	    public int get(int index) {
		return switch (index) {
		    case 0 ->
			SapphinizerBlockEntity.this.progress;
		    case 1 ->
			SapphinizerBlockEntity.this.maxProgress;
		    default ->
			0;
		};
	    }

	    @Override
	    public void set(int index, int value) {
		switch (index) {
		    case 0 ->
			SapphinizerBlockEntity.this.progress = value;
		    case 1 ->
			SapphinizerBlockEntity.this.maxProgress = value;
		}
	    }

	    @Override
	    public int size() {
		return 2;
	    }
	};
    }

    @Override

    public DefaultedList<ItemStack> getItems() {
	return inventory;
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
	return this.pos;
    }

    @Override
    public Text getDisplayName() {
	return Text.translatable("block.train.sapphinizer");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
	return new SapphinizerScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    public void onBlockReplaced(BlockPos pos, BlockState state) {
	ItemScatterer.spawn(world, pos, (this));
	super.onBlockReplaced(pos, state);
    }

    @Override
    protected void writeData(WriteView view) {
	super.writeData(view);
	Inventories.writeData(view, inventory);
	view.putInt("sapphinizer.progress", progress);
	view.putInt("sapphinizer.maxProgress", maxProgress);
    }

    @Override
    protected void readData(ReadView view) {
	Inventories.readData(view, inventory);
	progress = view.getInt("sapphinizer.progress", 0);
	progress = view.getInt("sapphinizer.maxProgress", 0);
	super.readData(view);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
	if (hasRecipe()) {
	    increaseCraftingProfress();
	    markDirty(world, pos, state);
	    if (hasCraftingFinished()) {
		craftItem();
		resetProgress();
	    } else {
		resetProgress();
	    }
	}
    }

}
