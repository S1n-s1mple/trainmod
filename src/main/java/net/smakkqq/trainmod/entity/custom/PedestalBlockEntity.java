package net.smakkqq.trainmod.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.text.Text;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.smakkqq.trainmod.entity.ImplementedInventory;
import net.smakkqq.trainmod.entity.ModBlockEntities;
import org.jetbrains.annotations.Nullable;

public class PedestalBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory <BlockPos>{

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
    @Override
    public void OnBlockReplaced(BlockPos pos, BlockState state){
	ItemScatterer.spawn(world, pos, (this));
	super.onBlockReplaced(pos, state);
    }
    

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
	return this.pos;
    }

    @Override
    public Text getDisplayName() {
	return Text.literal("Pedestal");
    }

    @Nullable  
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
	return new PedestalScreenHandler(syncId, playerInventory, player);
    }
    
    
}
