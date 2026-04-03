package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.AnimationState;
import net.smakkqq.trainmod.entity.custom.CapibaraTypes;

public class CapibaraRenderState extends LivingEntityRenderState{
    public final AnimationState idleAnimationState = new AnimationState();
    public CapibaraTypes type;
}
