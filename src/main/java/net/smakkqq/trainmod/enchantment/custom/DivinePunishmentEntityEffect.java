package net.smakkqq.trainmod.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;
import net.smakkqq.trainmod.Train;

import java.util.Timer;
import java.util.TimerTask;

public class DivinePunishmentEntityEffect implements EnchantmentEntityEffect {
    public static final MapCodec<DivinePunishmentEntityEffect> CODEC = MapCodec.unit(new DivinePunishmentEntityEffect());

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        Train.LOGGER.info("DivinePunishment triggered: attacker={}, wearer={}", user, context.owner());

        if (!(user instanceof LivingEntity attacker)) {
            Train.LOGGER.warn("Attacker is not a LivingEntity: {}", user);
            return;
        }

        // Apply levitation for 5 seconds (100 ticks) with amplifier based on level
        attacker.addStatusEffect(new StatusEffectInstance(
                StatusEffects.LEVITATION,
                100,                 // duration in ticks
                level - 1,           // amplifier (level 1 gives amplifier 0)
                false,               // ambient
                true,                // show particles
                true                 // show icon
        ));
        Train.LOGGER.info("Levitation applied to attacker: {}", attacker);

        // Schedule the slam after 5 seconds (5000 ms)
        world.getServer().execute(() -> {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    // Ensure we are back on the server thread before modifying velocity
                    world.getServer().execute(() -> {
                        if (attacker.isAlive()) {
                            double yVelocity = -5.0 * level;  // slam strength
                            attacker.setVelocity(0, yVelocity, 0);
                            attacker.velocityModified = true;
                            Train.LOGGER.info("Slammed attacker: {}", attacker);
                        }
                    });
                }
            }, 5000);
        });
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}