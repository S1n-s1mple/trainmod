package net.smakkqq.trainmod.interfaceMod;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SimpleScreen extends Screen {

    private static final Identifier BACKGROUND_TEXTURE = Identifier.of("train", "textures/gui/easy_mode_changer.png");


    public SimpleScreen() {
	super(Text.literal("Интерфейс - G"));
    }

    @Override
    protected void init() {
	super.init();

	int buttonWidth = 40;
	int buttonHeight = 20;

	this.addDrawableChild(ButtonWidget.builder(Text.literal("S"), button -> {
	    if (this.client != null && this.client.player != null) {
		this.client.player.networkHandler.sendChatCommand("gamemode survival");
		this.close();
	    }
	}).dimensions(this.width / 2 - buttonWidth - 10, this.height / 2 - buttonHeight / 2, buttonWidth, buttonHeight).build());

	this.addDrawableChild(ButtonWidget.builder(Text.literal("C"), button -> {
	    if (this.client != null && this.client.player != null) {
		this.client.player.networkHandler.sendChatCommand("gamemode creative");
		this.close();
	    }
	}).dimensions(this.width / 2 + 10, this.height / 2 - buttonHeight / 2, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
	super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
	this.applyBlur(context);
	this.renderInGameBackground(context);

	context.drawTexture(RenderPipelines.GUI_TEXTURED, BACKGROUND_TEXTURE, this.width / 2 - 98, this.height / 2 - 23, 0.0F, 0.0F, 196, 46, 196, 46);
    }

    @Override
    public boolean shouldCloseOnEsc() {
	return true;
    }
}
