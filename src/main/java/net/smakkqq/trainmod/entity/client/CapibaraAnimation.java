package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.render.entity.animation.AnimationDefinition;
import net.minecraft.client.render.entity.animation.AnimationHelper;
import net.minecraft.client.render.entity.animation.Keyframe;
import net.minecraft.client.render.entity.animation.Transformation;

// Save this class in your mod and generate all required imports
/**
 * Made with Blockbench 5.0.7 Exported for Minecraft version 1.19 or later with
 * Yarn mappings
 *
 * @author Author
 */
public class CapibaraAnimation {

    public static final AnimationDefinition ANIM_CAPIBARA_IDLE = AnimationDefinition.Builder.create(1.5F).looping()
	    .addBoneAnimation("Capibara", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, -0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createRotationalVector(-14.9491F, -1.0809F, -7.3965F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createRotationalVector(9.9531F, 0.868F, -7.4435F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 5.5556F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.75F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.1667F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 4.4444F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .build();

    public static final AnimationDefinition ANIM_CAPIBARA_WALK = AnimationDefinition.Builder.create(1.0F).looping()
	    .addBoneAnimation("Capibara", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, -0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -2.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("earL", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(-14.9491F, -1.0809F, -7.3965F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("earR", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(9.9531F, 0.868F, -7.4435F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBR", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFR", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBL", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -15.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 17.5F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFL", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 12.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -17.5F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.1F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("tail", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.2917F, AnimationHelper.createRotationalVector(0.0F, -2.5F, 5.5556F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 10.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.7917F, AnimationHelper.createRotationalVector(0.0F, 5.0F, 4.4444F), Transformation.Interpolations.CUBIC),
		    new Keyframe(1.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .build();

    public static final AnimationDefinition ANIM_CAPIBARA_ATTACK = AnimationDefinition.Builder.create(0.5F)
	    .addBoneAnimation("Capibara", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("Capibara", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("body", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createRotationalVector(0.0F, 0.0F, 4.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("body", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(1.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(1.0F, -0.5F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("head", new Transformation(Transformation.Targets.ROTATE,
		    new Keyframe(0.0F, AnimationHelper.createRotationalVector(0.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.125F, AnimationHelper.createRotationalVector(6.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createRotationalVector(-1.0F, 0.0F, -12.5F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.4167F, AnimationHelper.createRotationalVector(-0.9397F, 0.342F, 7.4972F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("head", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.LINEAR),
		    new Keyframe(0.3333F, AnimationHelper.createTranslationalVector(1.0F, 1.0F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBR", new Transformation(Transformation.Targets.SCALE,
		    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFR", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 0.75F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, 0.75F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, 0.5F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legBL", new Transformation(Transformation.Targets.SCALE,
		    new Keyframe(0.0F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createScalingVector(1.0F, 1.0F, 1.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createScalingVector(1.0F, 1.2F, 1.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .addBoneAnimation("legFL", new Transformation(Transformation.Targets.MOVE_ORIGIN,
		    new Keyframe(0.0F, AnimationHelper.createTranslationalVector(-1.0F, 0.75F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.25F, AnimationHelper.createTranslationalVector(0.0F, 0.0F, 0.0F), Transformation.Interpolations.CUBIC),
		    new Keyframe(0.5F, AnimationHelper.createTranslationalVector(-1.0F, 0.75F, 0.0F), Transformation.Interpolations.CUBIC)
	    ))
	    .build();
}
