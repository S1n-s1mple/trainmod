package net.smakkqq.trainmod.GraphicalUserInterface.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.world.GameMode;

public class CreativeProcedure {
        public static boolean eventResult = true;
    public static void execute(Entity entity){
	if(entity == null){
	    return;
	}
	if(entity instanceof PlayerEntity ply && ply.getGameMode() == GameMode.SURVIVAL){
	    if(entity instanceof ServerPlayerEntity player){
		player.changeGameMode(GameMode.CREATIVE);
	    }
	}
    }
}
