package net.smakkqq.trainmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.component.ModDataComponentTypes;
import net.smakkqq.trainmod.effect.ArmourEffectHendler;
import net.smakkqq.trainmod.effect.ModEffects;
import net.smakkqq.trainmod.item.ModItemGroups;
import net.smakkqq.trainmod.item.ModItems;
import net.smakkqq.trainmod.sound.ModSound;
import net.smakkqq.trainmod.utill.HammerUsageEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Train implements ModInitializer {

    public static final String MOD_ID = "train";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
	ModDataComponentTypes.registerModItems();
	ModSound.registerSounds();
	ModItemGroups.registerItemsGroups();
	ModEffects.registerEffect();

	ModItems.registerModItems();
	ModBlocks.registerModBlocks();

	FuelRegistryEvents.BUILD.register((builder, context) -> {
	    builder.add(ModItems.FUEL, 60 * 20);
	});

	PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	ServerTickEvents.END_SERVER_TICK.register(new ArmourEffectHendler());

	AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
	    if (entity instanceof SkeletonEntity skeletonEntity && player.getMainHandStack().getItem() == Items.BONE) {
		    player.sendMessage(Text.literal("Friendly fire"), true);
		    player.getMainHandStack().decrement(1);
		    skeletonEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.GLOWING, 500, 6));
	    }
	    return ActionResult.PASS;
	});
    }
}
