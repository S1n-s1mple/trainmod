package net.smakkqq.trainmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.smakkqq.trainmod.item.ModItems;

public class CapibaraEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public CapibaraEntity(EntityType<? extends AnimalEntity> entityType, World world) {
	super(entityType, world);
    }

    @Override
    protected void initGoals() {
	this.goalSelector.add(0, new SwimGoal(this));
	this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
	this.goalSelector.add(2, new TemptGoal(this, 1.25D, Ingredient.ofItem(ModItems.RICE), false));
	this.goalSelector.add(3, new FollowParentGoal(this, 1.1D));
	this.goalSelector.add(4, new WanderAroundFarGoal(this, 1.0D));
	this.goalSelector.add(5, new LookAtEntityGoal(this, PlayerEntity.class, 4.0F));
	this.goalSelector.add(6, new LookAroundGoal(this));
    }

    public static DefaultAttributeContainer.Builder createAtributes(){
	return MobEntity.createMobAttributes()
		.add(EntityAttributes.MAX_HEALTH, 24)
		.add(EntityAttributes.MOVEMENT_SPEED, 0.3)
		.add(EntityAttributes.ATTACK_DAMAGE, 3)
		.add(EntityAttributes.ATTACK_KNOCKBACK, 5)
		.add(EntityAttributes.FOLLOW_RANGE, 16)
		.add(EntityAttributes.TEMPT_RANGE, 16);
	
    }
    
    @Override
    public boolean isBreedingItem(ItemStack stack) {
	return false;
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
	return null;
    }

}
