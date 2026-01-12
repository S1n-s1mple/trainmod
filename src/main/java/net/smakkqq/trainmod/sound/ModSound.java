package net.smakkqq.trainmod.sound;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;

public class ModSound {

    public static SoundEvent CHISEL_USE = registerSoundEvent("chisel_use");
    public static SoundEvent MAGIC_BLOCK_BREAK = registerSoundEvent("magic_block_break");
    public static SoundEvent MAGIC_BLOCK_HIT = registerSoundEvent("magic_block_hit");
    public static SoundEvent MAGIC_BLOCK_FALL = registerSoundEvent("magic_block_fall");
    public static SoundEvent MAGIC_BLOCK_PLACE = registerSoundEvent("magic_block_place");
    public static SoundEvent MAGIC_BLOCK_STEP = registerSoundEvent("magic_block_step");

    public static final BlockSoundGroup MAGIC_BLOCK_SOUNDS = new BlockSoundGroup(1.0f, 1.0f,
	    MAGIC_BLOCK_BREAK,
	    MAGIC_BLOCK_HIT,
	    MAGIC_BLOCK_FALL,
	    MAGIC_BLOCK_PLACE,
	    MAGIC_BLOCK_STEP);

    private static SoundEvent registerSoundEvent(String name) {
	Identifier id = Identifier.of(Train.MOD_ID, name);
	return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }

    public static void registerModItems() {
	Train.LOGGER.info("Registering my Mod Items for:" + Train.MOD_ID);
    }
}
