package net.smakkqq.trainmod.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TomahawkItem extends Item {

    public TomahawkItem(Settings settings) {
	super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
	ItemStack itemStack = user.getStackInHand(hand);
	world.playSound(null, user.getX(), user.getY(), user.getZ(),
		SoundEvents.ITEM_TRIDENT_THROW, SoundCategory.NEUTRAL, 0.5f, 0.4f / (world.getRandom().nextFloat() * 0.4f + 0.8f));
	return ActionResult.SUCCESS;
    }
}
