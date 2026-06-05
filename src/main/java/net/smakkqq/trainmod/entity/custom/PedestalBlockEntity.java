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
import net.smakkqq.trainmod.entity.ModBlockEntities;

public class PedestalBlockEntity extends BlockEntity implements ImplementedInventory {

    private final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);
    private float rotation = 0;

    public PedestalBlockEntity(BlockPos pos, BlockState state) {
	super(ModBlockEntities.PEDESTAL_BE, pos, state);
    }

    public DefaultedList<ItemStack> getItems() {
	return inventory;
    }
    
    public float getRenderRotation(){
	rotation += 0.5f;
	if(rotation >= 360){
	    rotation = 0;
	}
	return rotation;
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
