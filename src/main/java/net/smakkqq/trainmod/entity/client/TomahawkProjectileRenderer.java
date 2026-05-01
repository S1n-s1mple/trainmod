package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.RotationAxis;
import net.smakkqq.trainmod.entity.custom.TomahawkProjectileEntity;
import static net.smakkqq.trainmod.utill.createIdentifier.createIdentifier;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity, TomahawkProjectileRendererState> {

    protected TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererFactory.Context ctx) {
	super(ctx);
	this.model = new TomahawkProjectileModel(ctx.getPart(TomahawkProjectileModel.TOMAHAWK));
    }

    @Override
    public void render(TomahawkProjectileRendererState state, MatrixStack matrixStack, VertexConsumerProvider vertex, int light) {
	matrixStack.push();

//	if (!state.inGround) {
//	matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(state.age * 25f));
//	matrixStack.multiply(RotationAxis.POSITIVE_X.rotationDegrees(state.age * 25f));
//	}

	VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
		vertex, this.model.getLayer(createIdentifier("textures/entity/tomahawk/tomahawk.png")), false, false);
	this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

	matrixStack.pop();
	super.render(state, matrixStack, vertex, light);
    }

    @Override
    public TomahawkProjectileRendererState createRenderState() {
	return new TomahawkProjectileRendererState();
    }
    
    @Override
    public void updateRenderState(TomahawkProjectileEntity entity, TomahawkProjectileRendererState state, float tickDelta){
	
	super.updateRenderState(entity, state, tickDelta);
	
	state.inGround = entity.isTomahawkInGround();
	state.age = entity.age + tickDelta;
    }
}
