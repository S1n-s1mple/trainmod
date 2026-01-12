package net.smakkqq.trainmod.component;

import java.util.function.UnaryOperator;
import net.minecraft.component.ComponentType;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.smakkqq.trainmod.Train;

public class ModDataComponentTypes {

    public static final ComponentType<BlockPos> COORDINATES = register("coordinates", blockPosBuilder -> blockPosBuilder.codec(BlockPos.CODEC));

    public static final ComponentType<Block> BLOCK = register("block", builder -> builder.codec(Registries.BLOCK.getCodec()));

    private static <T> ComponentType<T> register(String name, UnaryOperator<ComponentType.Builder<T>> builderUnaryOperator) {
	return Registry.register(
		Registries.DATA_COMPONENT_TYPE,
		Identifier.of(Train.MOD_ID, name),
		builderUnaryOperator.apply(ComponentType.builder()).build());
    }

    public static void registerModItems() {
	Train.LOGGER.info("Registering Data Component Types for:" + Train.MOD_ID);
    }
}
