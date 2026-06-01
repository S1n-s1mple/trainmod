package net.smakkqq.trainmod.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.block.ModBlocks;
import net.smakkqq.trainmod.entity.custom.PedestalBlockEntity;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE = Registry.register(
	    Registries.BLOCK_ENTITY_TYPE,
	    Identifier.of(Train.MOD_ID, "pedestal_be"),
	    FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build(null));
}
