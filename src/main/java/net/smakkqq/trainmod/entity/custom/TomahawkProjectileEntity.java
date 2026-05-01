package net.smakkqq.trainmod.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.ModEntities;
import net.smakkqq.trainmod.item.ModItems;

public class TomahawkProjectileEntity extends PersistentProjectileEntity {

    public TomahawkProjectileEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
	super(entityType, world);
    }

    public TomahawkProjectileEntity(PlayerEntity user, World world) {
	super(ModEntities.TOMAHAWK, user, world, new ItemStack(ModItems.TOMAHAWK), null);
    }

    @Override
    protected ItemStack getDefaultItemStack() {
	return new ItemStack(ModItems.TOMAHAWK);
    }

    @Override
    protected SoundEvent getHitSound() {
	return SoundEvents.BLOCK_CHAIN_HIT;
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
	super.onEntityHit(entityHitResult);
	Entity entity = entityHitResult.getEntity();
	if (!this.getWorld().isClient()) {
	    entity.damage((ServerWorld) this.getWorld(), this.getDamageSources().thrown(this, this.getOwner()), 4);
	}
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
	super.onBlockHit(blockHitResult);
    }
    
    public boolean  isTomahawkInGround(){
	return this.isInGround();
    }
}
