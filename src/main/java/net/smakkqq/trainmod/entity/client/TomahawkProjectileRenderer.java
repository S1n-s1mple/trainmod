package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.smakkqq.trainmod.entity.custom.TomahawkProjectileEntity;
import net.smakkqq.trainmod.utill.createIdentifier;
import static net.smakkqq.trainmod.utill.createIdentifier.createIdentifier;

public class TomahawkProjectileRenderer extends EntityRenderer<TomahawkProjectileEntity, EntityRenderState> {

    protected TomahawkProjectileModel model;

    public TomahawkProjectileRenderer(EntityRendererFactory.Context ctx) {
	super(ctx);
	this.model = new TomahawkProjectileModel(ctx.getPart(TomahawkProjectileModel.TOMAHAWK));
    }

    @Override
    public void render(EntityRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertex, int light) {
	matrixStack.push();

	VertexConsumer vertexConsumer = ItemRenderer.getItemGlintConsumer(
		vertex, this.model.getLayer(createIdentifier("textures/entity/tomahawk/tomahawk.png")), false, false);
	this.model.render(matrixStack, vertexConsumer, light, OverlayTexture.DEFAULT_UV);

	matrixStack.pop();
	super.render(state, matrixStack, vertex, light);
    }

    @Override
    public EntityRenderState createRenderState() {
	return new EntityRenderState();
    }
}
