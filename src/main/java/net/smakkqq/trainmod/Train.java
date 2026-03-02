package net.smakkqq.trainmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.fabricmc.fabric.api.event.player.PlayerBlockBreakEvents;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.fabricmc.fabric.api.registry.FuelRegistryEvents;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.mob.SkeletonEntity;
import net.minecraft.item.Items;
import net.minecraft.potion.Potions;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.GameMode;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.component.ModDataComponentTypes;
import net.smakkqq.trainmod.effect.ArmourEffectHendler;
import net.smakkqq.trainmod.effect.ModEffects;
import net.smakkqq.trainmod.enchantment.ModEnchantmentEffects;
import net.smakkqq.trainmod.enchantment.ModEnchantments;
import net.smakkqq.trainmod.item.ModItemGroups;
import net.smakkqq.trainmod.item.ModItems;
import net.smakkqq.trainmod.potion.ModPotions;
import net.smakkqq.trainmod.sound.ModSound;
import net.smakkqq.trainmod.utill.HammerUsageEvent;
import net.smakkqq.trainmod.world.gen.ModWorldGeneration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Train implements ModInitializer {

    public static final String MOD_ID = "train";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
	ModItemGroups.registerItemsGroups();
	ModWorldGeneration.generateModWorldGen();
	ModDataComponentTypes.registerModItems();
	ModSound.registerSounds();
	ModEffects.registerEffect();
	ModItems.registerModItems();
	ModBlocks.registerModBlocks();
	ModPotions.registerPotions();
	ModEnchantmentEffects.registerEffect();
	ModEnchantments.registerEnchantments();

	FuelRegistryEvents.BUILD.register((builder, context) -> {
	    builder.add(ModItems.FUEL, 60 * 20);
	});
	
	CompostingChanceRegistry.INSTANCE.add(ModItems.RICE, 0.2f);
	CompostingChanceRegistry.INSTANCE.add(ModItems.BLUEBERRY, 0.1f);
	
	PlayerBlockBreakEvents.BEFORE.register(new HammerUsageEvent());

	ServerTickEvents.END_SERVER_TICK.register(new ArmourEffectHendler());

	AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
	    if (entity instanceof SkeletonEntity skeletonEntity && player.getMainHandStack().getItem() == Items.BONE) {
		player.sendMessage(Text.literal("Friendly fire"), true);
		player.getMainHandStack().decrement(1);
		skeletonEntity.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 500, 6));
	    }
	    return ActionResult.PASS;
	});

	FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> builder.registerPotionRecipe(Potions.AWKWARD, Items.STRING, ModPotions.SPIDER_LEGS_POTION));

	CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
	    dispatcher.register(CommandManager.literal("c")
		    .requires(source -> source.hasPermissionLevel(2))
		    .executes(context -> {
			ServerPlayerEntity player = context.getSource().getPlayer();
			if (player != null) {
			    player.changeGameMode(GameMode.CREATIVE);
			    context.getSource().sendFeedback(() -> Text.literal("Switched to Creative mode"), false);
			    return 1;
			} else {
			    context.getSource().sendError(Text.literal("Only players can use this command"));
			    return 0;
			}
		    })
	    );

	    dispatcher.register(CommandManager.literal("s")
		    .requires(source -> source.hasPermissionLevel(2))
		    .executes(context -> {
			ServerPlayerEntity player = context.getSource().getPlayer();
			if (player != null) {
			    player.changeGameMode(GameMode.SURVIVAL);
			    context.getSource().sendFeedback(() -> Text.literal("Switched to Survival mode"), false);
			    return 1;
			} else {
			    context.getSource().sendError(Text.literal("Only players can use this command"));
			    return 0;
			}
		    })
	    );
	});
    }
}
