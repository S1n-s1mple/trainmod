package net.smakkqq.trainmod.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.smakkqq.trainmod.entity.ImplementedInventory;

public class PedestalBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
	super(pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
	return inventory;
    }

    @Override
    protected void writeData(WriteView view) {
	super.writeData(view);
	Inventories.writeData(view, inventory);
    }
    
    @Override
    protected void readData(ReadView view) {
	super.readData(view);
	Inventories.readData(view, inventory);
    }
}
