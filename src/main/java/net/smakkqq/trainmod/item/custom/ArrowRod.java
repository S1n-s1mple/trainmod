package net.smakkqq.trainmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class ArrowRod extends Item {

    public ArrowRod(Item.Settings settings) {
        super(settings);

    }

    
    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }
        Vec3d lookVec = user.getRotationVec(1.0f);
        Vec3d origin = user.getEyePos();
        
        ArrowEntity arrow = new ArrowEntity(EntityType.ARROW, world);
        arrow.setPos(origin.x ,origin.y , origin.z);
        
        arrow.setOwner(user);
        
        double speed = 1.5f;
        arrow.setVelocity(lookVec.x * speed, lookVec.y * speed, lookVec.z * speed);
        
        world.spawnEntity(arrow);
        
        return ActionResult.SUCCESS;
    }
}
