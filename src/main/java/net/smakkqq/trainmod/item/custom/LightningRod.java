package net.smakkqq.trainmod.item.custom;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class LightningRod extends Item {

    public LightningRod(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        if (world.isClient) {
            return ActionResult.PASS;
        }

        Vec3d lookVec = user.getRotationVec(1.0f);
        
        Vec3d playerPos = user.getPos();
        
        Vec3d targetPos = playerPos.add(lookVec.multiply(10));

        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
        lightningBolt.setPosition(targetPos.x ,targetPos.y , targetPos.z);
        world.spawnEntity(lightningBolt);

        return ActionResult.SUCCESS;
    }
}

//        BlockPos frontOfPlayer = user.getBlockPos().offset(user.getHorizontalFacing(), 10);
//
//        LightningEntity lightningBolt = new LightningEntity(EntityType.LIGHTNING_BOLT, world);
//        lightningBolt.setPosition(frontOfPlayer.toCenterPos());
//        world.spawnEntity(lightningBolt);