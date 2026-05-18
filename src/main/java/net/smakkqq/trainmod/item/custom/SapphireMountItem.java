package net.smakkqq.trainmod.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

public class SapphireMountItem extends Item {

    public SapphireMountItem(Settings settings) {
	super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
	if (user.getWorld().isClient) {
	    return ActionResult.SUCCESS;
	}

	user.startRiding(entity, true);

	if (!user.getAbilities().creativeMode) {
	    stack.decrement(1);
	}

	return ActionResult.SUCCESS;
    }
}
