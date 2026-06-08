package net.smakkqq.trainmod.interfaceMod;

import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;
import net.smakkqq.trainmod.interfaceMod.ModScreenHandlers;

public class PedestalScreenHandler extends ScreenHandler {

    private final Inventory inventory;

    public PedestalScreenHandler(int syncId, PlayerInventory playerInventory, PlayerEntity player, BlockPos pos) {
	super(syncId, playerInventory, playerInventory.player.getInventory().getBlockEntity(pos));
    }

    public PedestalScreenHandler(int syncId, PlayerInventory playerInventory, PlayerEntity player, BlockEntity blockEntity) {
	super(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, syncId);
	this.inventory = ((Inventory) blockEntity);

	this.addSlot(new Slot(inventory, 0, 80, 35) {
	    @Override
	    public int getMaxItemCount() {
		return 1;

	    }
	});

	addPlayerInventory(playerInventory);
	addPlayerHotBar(playerInventory);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
    }

    @Override
    public boolean canUse(PlayerEntity player) {
	return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory) {
	for (int i = 0; i < 3; i++) {
	    for (int j = 0; j < 9; j++) {
		this.addSlot(new Slot(playerInventory, i + j*9 + 9, 8 + j * 18, 84 + i * 18));
	    }
	}
    }

    private void addPlayerHotBar(PlayerInventory playerInventory) {
	for (int i = 0; i < 9; i++) {
	    this.addSlot(new Slot(playerInventory, i, i * 18, 142));
	}

    }

}
