package net.smakkqq.trainmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class FireRod extends Item {

    public FireRod(Settings settings) {
        super(settings);

    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }
        Vec3d lookVec = user.getRotationVec(1.0f);
        Vec3d origin = user.getEyePos();
        
        FireballEntity fireball = new FireballEntity(EntityType.FIREBALL, world);
        fireball.setPos(origin.x ,origin.y , origin.z);
        
        fireball.setOwner(user);
        
        double speed = 1.5f;
        fireball.setVelocity(lookVec.x * speed, lookVec.y * speed, lookVec.z * speed);
        
        world.spawnEntity(fireball);
        
        return ActionResult.SUCCESS;
    }
}
