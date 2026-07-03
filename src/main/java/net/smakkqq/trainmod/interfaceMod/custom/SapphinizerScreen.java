package net.smakkqq.trainmod.interfaceMod.custom;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.smakkqq.trainmod.Train;
import net.smakkqq.trainmod.interfaceMod.SapphinizerScreenHandler;

public class SapphinizerScreen extends HandledScreen<SapphinizerScreenHandler> {

    public static final Identifier GUI_TEXTURE = Identifier.of(Train.MOD_ID, "textures/gui/pedestal/sapphinizer_gui.png");
    public static final Identifier ARROW_TEXTURE = Identifier.of(Train.MOD_ID, "textures/gui/pedestal/arrow_progress.png");

    public SapphinizerScreen(SapphinizerScreenHandler handler, PlayerInventory inventory, Text title) {
	super(handler, inventory, title);
    }

    @Override
    protected void drawBackground(DrawContext context, float deltaTicks, int mouseX, int mouseY) {
	int x = (width - backgroundWidth) / 2;
	int y = (height - backgroundHeight) / 2;

	context.drawTexture(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, backgroundWidth, backgroundHeight, 256, 242);
	
	renderProgressArrow(context, x, y);
    }
    
    //@@@@@@@@@@@@@@@@@@@@@@@@@@@@
    private void renderProgressArrow(DrawContext context, int x, int y){
	
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
	super.render(context, mouseX, mouseY, delta);
	drawMouseoverTooltip(context, mouseX, mouseY);
    }

}
