package net.smakkqq.trainmod.world.tree;

import java.util.Optional;
import net.minecraft.block.SaplingGenerator;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.world.ModTreeConfiguredFeatures;

public class ModSaplingGenerators {

    public static final SaplingGenerator JACARANDA = new SaplingGenerator(
	    Train.MOD_ID + ":jacaranda",
	    Optional.empty(),
	    Optional.of(ModTreeConfiguredFeatures.TREES_JACARANDA),
	    Optional.empty()
    );

}
