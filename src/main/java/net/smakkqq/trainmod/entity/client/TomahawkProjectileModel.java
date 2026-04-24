package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.model.Dilation;
import net.minecraft.client.model.ModelData;
import net.minecraft.client.model.ModelPart;
import net.minecraft.client.model.ModelPartBuilder;
import net.minecraft.client.model.ModelPartData;
import net.minecraft.client.model.ModelTransform;
import net.minecraft.client.model.TexturedModelData;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.render.entity.state.ProjectileEntityRenderState;
import net.minecraft.entity.Entity;
import static net.smakkqq.trainmod.utill.createIdentifier.createIdentifier;

public class TomahawkProjectileModel extends EntityModel<ProjectileEntityRenderState> {

    public static final EntityModelLayer TOMAHAWK = new EntityModelLayer(createIdentifier("tomahawk"), "main");

    private final ModelPart tomahawk;

    public TomahawkProjectileModel(ModelPart root) {
	super(root);
	this.tomahawk = root.getChild("tomahawk");
    }

    public static TexturedModelData createBodyLayer() {
	ModelData modelData = new ModelData();
	ModelPartData modelPartData = modelData.getRoot();

	ModelPartData tomahawk = modelPartData.addChild("tomahawk", ModelPartBuilder.create(), ModelTransform.origin(0.0F, 16.5F, 0.0F));

	ModelPartData cube_r1 = tomahawk.addChild("cube_r1", ModelPartBuilder.create().uv(8, 7).cuboid(1.5F, 2.5F, -0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -4.0F, 0.0F, -1.5708F, 0.0F));

	ModelPartData cube_r2 = tomahawk.addChild("cube_r2", ModelPartBuilder.create().uv(7, 9).cuboid(0.5F, -1.5F, -0.5F, 2.0F, 5.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, -5.0F, 0.0F, -1.5708F, 0.0F));

	ModelPartData cube_r3 = tomahawk.addChild("cube_r3", ModelPartBuilder.create().uv(3, 10).cuboid(-2.5F, -1.5F, -0.5F, 1.0F, 4.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 5.0F, 0.0F, -1.5708F, 0.0F));

	ModelPartData cube_r4 = tomahawk.addChild("cube_r4", ModelPartBuilder.create().uv(1, 4).cuboid(-2.5F, -1.5F, 0.0F, 5.0F, 3.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -7.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

	ModelPartData cube_r5 = tomahawk.addChild("cube_r5", ModelPartBuilder.create().uv(18, 1).cuboid(-0.5F, -9.0F, -0.5F, 1.0F, 18.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -1.5F, 0.0F, 0.0F, -0.7854F, 0.0F));

	return TexturedModelData.of(modelData, 32, 32);
    }
}
