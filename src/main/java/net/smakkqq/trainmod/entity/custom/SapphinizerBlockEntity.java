package net.smakkqq.trainmod.entity.custom;

import java.util.Optional;
import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ImplementedInventory;
import net.smakkqq.trainmod.entity.ModBlockEntities;
import net.smakkqq.trainmod.interfaceMod.SapphinizerScreenHandler;
import net.smakkqq.trainmod.recipe.ModRecipes;
import net.smakkqq.trainmod.recipe.SapphinizerRecipe;
import net.smakkqq.trainmod.recipe.SapphinizerRecipeInput;
import org.jetbrains.annotations.Nullable;

public class SapphinizerBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(2, ItemStack.EMPTY);

    private static final int INPUT_SLOT = 0;
    private static final int OUTPUT_SLOT = 1;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 72;

    public SapphinizerBlockEntity(BlockPos pos, BlockState state) {
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

    @Nullable
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
	maxProgress = view.getInt("sapphinizer.maxProgress", 0);
	super.readData(view);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
	if (hasRecipe()) {
	    increaseCraftingProgress();
	    markDirty(world, pos, state);
	    if (hasCraftingFinished()) {
		craftItem();
		resetProgress();
	    } else {
		resetProgress();
	    }
	}

    }

    private void resetProgress() {
	this.progress = 0;
	this.maxProgress = 72;
    }

    private void craftItem() {
	Optional<RecipeEntry<SapphinizerRecipe>> recipe = getCurrentRecipe();

	ItemStack output = recipe.get().value().output();
	this.removeStack(INPUT_SLOT, 1);
	this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(), this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private boolean hasCraftingFinished() {
	return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
	this.progress++;
    }

    private boolean hasRecipe() {
	Optional<RecipeEntry<SapphinizerRecipe>> recipe = getCurrentRecipe();

	if (recipe.isEmpty()) {
	    return false;
	}

	ItemStack output = recipe.get().value().output();
	return canInsertAmountIntoOutputSlot(output.getCount()) && canInsertItemIntoOutputSlot(output);
    }

    private Optional<RecipeEntry<SapphinizerRecipe>> getCurrentRecipe() {
	return ((ServerWorld) this.getWorld()).getRecipeManager()
		.getFirstMatch(ModRecipes.SAPPHINIZER_TYPE, new SapphinizerRecipeInput(inventory.get(INPUT_SLOT)), this.getWorld());
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
	return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
	int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
	int currentCount = this.getStack(OUTPUT_SLOT).getCount();

	return maxCount >= currentCount + count;
    }

}
