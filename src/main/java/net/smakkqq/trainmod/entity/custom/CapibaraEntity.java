package net.smakkqq.trainmod.entity.custom;

import net.minecraft.util.math.BlockPos;

import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AnimalMateGoal;
import net.minecraft.entity.ai.goal.EscapeDangerGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAroundGoal;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.ai.goal.WanderAroundFarGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.tag.BiomeTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.Util;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ModEntities;
import net.smakkqq.trainmod.item.ModItems;
import org.jetbrains.annotations.Nullable;

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
	this.goalSelector.add(0, new EscapeDangerGoal(this, 2.0));
	this.goalSelector.add(1, new AnimalMateGoal(this, 1.15D));
	this.goalSelector.add(2, new TemptGoal(this, 0.75D, Ingredient.ofItem(ModItems.RICE), false));
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

    public CapibaraTypes getTypess() {
	return CapibaraTypes.byId(this.getTypeVariant() & 255); // & 255 - конвертация, ограничение
    }

    private int getTypeVariant() {
	return this.dataTracker.get(TYPE_VARIANT);
    }

    private void setType(CapibaraTypes type) {
	this.dataTracker.set(TYPE_VARIANT, type.getId() & 255);
    }

    @Override
    public void writeData(WriteView view) {
	super.writeData(view);
	view.putInt("Variant", this.getTypeVariant());
    }

    @Override
    public void readData(ReadView view) {
	super.readData(view);
	this.dataTracker.set(TYPE_VARIANT, view.getInt("Variant", 0));
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, EntityData entityData) {
	boolean isColdBiome = world.getBiome(BlockPos.ofFloored(this.getPos())).isIn(BiomeTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);
	CapibaraTypes type = CapibaraTypes.byId(isColdBiome ? 1 : 0);
	setType(type);
	return super.initialize(world, difficulty, spawnReason, entityData);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
	return SoundEvents.ENTITY_SNIFFER_HAPPY;

    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource damage) {
	return SoundEvents.ENTITY_SNIFFER_HURT;
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
	return SoundEvents.ENTITY_SNIFFER_DEATH;

    }
}
