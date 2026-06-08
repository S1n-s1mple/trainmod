package net.smakkqq.trainmod.entity.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemDisplayContext;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.smakkqq.trainmod.entity.custom.PedestalBlockEntity;

public class PedestalBlockEntityRenderer implements BlockEntityRenderer<PedestalBlockEntity> {

    public PedestalBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(PedestalBlockEntity entity, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertex, int light, int overlay, Vec3d cameraPos) {
	ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
	ItemStack stack = entity.getStack(0);

	matrixStack.push();
	matrixStack.translate(0.5f, 1.25f, 0.5);
	matrixStack.scale(0.5f, 0.5f, 0.5f);
	matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(entity.getRenderRotation()));

	itemRenderer.renderItem(stack, ItemDisplayContext.GUI,
		getLightLevel(entity.getWorld(), entity.getPos()),
		OverlayTexture.DEFAULT_UV, matrixStack, vertex, entity.getWorld(), 1);
	matrixStack.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
	int bLight = world.getLightLevel(LightType.BLOCK, pos);
	int sLight = world.getLightLevel(LightType.SKY, pos);
	return LightmapTextureManager.pack(bLight, sLight);
    }
}
