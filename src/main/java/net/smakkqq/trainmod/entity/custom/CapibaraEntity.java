package net.smakkqq.trainmod.entity.custom;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.Util;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ModEntities;
import net.smakkqq.trainmod.item.ModItems;

public class CapibaraEntity extends AnimalEntity {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    private static final TrackedData<Integer> TYPE_VARIANT = DataTracker.registerData(CapibaraEntity.class, TrackedDataHandlerRegistry.INTEGER);

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

    public static DefaultAttributeContainer.Builder createAtributes() {
	return MobEntity.createMobAttributes()
		.add(EntityAttributes.MAX_HEALTH, 24)
		.add(EntityAttributes.MOVEMENT_SPEED, 0.3)
		.add(EntityAttributes.ATTACK_DAMAGE, 3)
		.add(EntityAttributes.ATTACK_KNOCKBACK, 5)
		.add(EntityAttributes.FOLLOW_RANGE, 16)
		.add(EntityAttributes.TEMPT_RANGE, 16);
    }

    private void setupAnimationStates() {
	if (this.idleAnimationTimeout <= 0) {
	    this.idleAnimationTimeout = 40;
	    this.idleAnimationState.start(this.age);
	} else {
	    --this.idleAnimationTimeout;
	}
    }

    @Override
    public void tick() {
	super.tick();
	if (this.getWorld().isClient()) {
	    this.setupAnimationStates();
	}
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
	return stack.isOf(ModItems.RICE);
    }

    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
	CapibaraEntity baby = ModEntities.CAPIBARA.create(world, SpawnReason.BREEDING);
	CapibaraTypes type = Util.getRandom(CapibaraTypes.values(), this.random);
	if (baby != null) {
	    baby.setType(type);
	}
	return baby;
    }

    //TYPES
    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
	super.initDataTracker(builder);
	builder.add(TYPE_VARIANT, 0);
    }

}
