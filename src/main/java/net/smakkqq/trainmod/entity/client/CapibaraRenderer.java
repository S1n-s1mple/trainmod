package net.smakkqq.trainmod.entity.client;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import net.smakkqq.trainmod.entity.custom.CapibaraEntity;
import net.smakkqq.trainmod.entity.custom.CapibaraTypes;
import net.smakkqq.trainmod.utill.createIdentifier;
import static net.smakkqq.trainmod.utill.createIdentifier.createIdentifier;

public class CapibaraRenderer extends MobEntityRenderer<CapibaraEntity, CapibaraRenderState, CapibaraModel> {

    private static final Map<CapibaraTypes, Identifier> LOCATION_BY_VARIANTS
	    = Util.make(Maps.newEnumMap(CapibaraTypes.class), map -> {
		map.put(CapibaraTypes.DEFAULT, createIdentifier("textures/entity/capibara/capibara.png"));
		map.put(CapibaraTypes.WHITE, createIdentifier("textures/entity/capibara/capibara_white.png"));
	    });

    public CapibaraRenderer(EntityRendererFactory.Context context) {
	super(context, new CapibaraModel(context.getPart(CapibaraModel.CAPIBARA)), 0.28f);
    }

    @Override
    public Identifier getTexture(CapibaraRenderState state) {
	return LOCATION_BY_VARIANTS.get(state.type);
    }

    @Override
    public void render(CapibaraRenderState state, MatrixStack matrixStack, VertexConsumerProvider vertex, int i) {
	if (state.baby) {
	    matrixStack.scale(0.5F, 0.5F, 0.5F);
	} else {
	    matrixStack.scale(1F, 1F, 1F);
	}
	super.render(state, matrixStack, vertex, i);
    }

    @Override
    public CapibaraRenderState createRenderState() {
	return new CapibaraRenderState();
    }

    @Override
    public void updateRenderState(CapibaraEntity livingEntity, CapibaraRenderState livingEntityRenderState, float f) {
	super.updateRenderState(livingEntity, livingEntityRenderState, f);
	livingEntityRenderState.idleAnimationState.copyFrom(livingEntity.idleAnimationState);
	livingEntityRenderState.type = livingEntity.getTypess();
    }
}
