package net.smakkqq.trainmod.utill;

import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class createIdentifier {
    public static Identifier createIdentifier(String name){
	return Identifier.of(Train.MOD_ID, name);
    }
}
