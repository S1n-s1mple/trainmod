package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.animation.Animation;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.util.math.MathHelper;

public class CapibaraModel extends EntityModel<CapibaraRenderState> {

    private final Animation idlingAnimation;
    private final Animation walkingAnimation;

    private final ModelPart Capibara;
    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart earL;
    private final ModelPart earR;
    private final ModelPart legFR;
    private final ModelPart legBL;
    private final ModelPart legFL;
    private final ModelPart tail;
    private final ModelPart legBR;

    public CapibaraModel(ModelPart root) {
	super(root);
	this.Capibara = root.getChild("Capibara");
	this.body = this.Capibara.getChild("body");
	this.head = this.body.getChild("head");
	this.earL = this.head.getChild("earL");
	this.earR = this.head.getChild("earR");
	this.legFR = this.body.getChild("legFR");
	this.legBL = this.body.getChild("legBL");
	this.legFL = this.body.getChild("legFL");
	this.tail = this.body.getChild("tail");
	this.legBR = this.body.getChild("legBR");

	this.idlingAnimation = CapibaraAnimation.ANIM_CAPIBARA_IDLE.createAnimation(root);
	this.walkingAnimation = CapibaraAnimation.ANIM_CAPIBARA_WALK.createAnimation(root);
    }

    public static TexturedModelData getTexturedModelData() {
	ModelData modelData = new ModelData();
	ModelPartData modelPartData = modelData.getRoot();
	ModelPartData Capibara = modelPartData.addChild("Capibara", ModelPartBuilder.create(), ModelTransform.of(0.0F, 20.0F, -1.0F, 0.0F, 1.5708F, 0.0F));

	ModelPartData body = Capibara.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-6.0F, -3.0F, -3.0F, 11.0F, 5.0F, 6.0F, new Dilation(0.0F)), ModelTransform.origin(0.0F, 0.0F, 0.0F));

	ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(0, 11).cuboid(-1.0F, -2.0F, -2.0F, 6.0F, 4.0F, 4.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, -3.0F, 0.0F));

	ModelPartData earL = head.addChild("earL", ModelPartBuilder.create(), ModelTransform.origin(0.0F, -2.0F, 2.0F));

	ModelPartData earL_r1 = earL.addChild("earL_r1", ModelPartBuilder.create().uv(20, 15).cuboid(-1.1082F, -1.5119F, -1.0F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.2182F));

	ModelPartData earR = head.addChild("earR", ModelPartBuilder.create(), ModelTransform.origin(-0.25F, -2.0F, -2.0F));

	ModelPartData earR_r1 = earR.addChild("earR_r1", ModelPartBuilder.create().uv(0, 23).cuboid(-1.0541F, -1.7559F, -0.25F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.25F, 0.75F, 0.25F, 0.0F, 0.0F, -0.2182F));

	ModelPartData legFR = body.addChild("legFR", ModelPartBuilder.create().uv(20, 11).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, 2.0F, -2.0F));

	ModelPartData legBL = body.addChild("legBL", ModelPartBuilder.create().uv(8, 19).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, 2.0F, 2.0F));

	ModelPartData legFL = body.addChild("legFL", ModelPartBuilder.create().uv(16, 19).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(4.0F, 2.0F, 2.0F));

	ModelPartData tail = body.addChild("tail", ModelPartBuilder.create().uv(6, 23).cuboid(-1.0F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.origin(-6.0F, -1.0F, 0.0F));

	ModelPartData legBR = body.addChild("legBR", ModelPartBuilder.create().uv(0, 19).cuboid(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.origin(-4.0F, 2.0F, -2.0F));
	return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(CapibaraRenderState state) {
	super.setAngles(state);
	this.setHeadAngels(state.relativeHeadYaw, state.pitch);

	this.idlingAnimation.apply(state.idleAnimationState, state.age, 1F);
	this.walkingAnimation.applyWalking(state.limbSwingAnimationProgress, state.limbSwingAmplitude, 2F, 2.5F);
    }

    private void setHeadAngels(float headYaw, float headPitch) {
	headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
	headPitch = MathHelper.clamp(headPitch, -30.0F, 30.0F);

	this.head.yaw = headYaw * 0.017453292F;
	this.head.pitch = headPitch * 0.017453292F;
    }

}
