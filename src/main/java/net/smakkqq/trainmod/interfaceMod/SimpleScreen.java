package net.smakkqq.trainmod.interfaceMod;

import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class SimpleScreen extends Screen {

    private static final Identifier BACKGROUND_TEXTURE = Identifier.of("train", "textures/gui/easy_mode_changer.png");
    private static final int BACKGROUND_WIDTH = 196;
    private static final int BACKGROUND_HEIGHT = 46;

    public SimpleScreen() {
	super(Text.literal("Интерфейс - G"));
    }

    @Override
    protected void init() {
	super.init();

	int buttonWidth = 36;
	int buttonHeight = 20;
	int centerX = this.width / 2;
	int topRowY = this.height / 2 - 19;
	int bottomRowY = this.height / 2 + 3;

	// Режимы игры
	this.addDrawableChild(ButtonWidget.builder(Text.literal("S"), button -> {
	    if (this.client != null && this.client.player != null) {
		this.client.player.networkHandler.sendChatCommand("gamemode survival");
		this.close();
	    }
	}).dimensions(centerX - buttonWidth - 4, topRowY, buttonWidth, buttonHeight).build());

	this.addDrawableChild(ButtonWidget.builder(Text.literal("C"), button -> {
	    if (this.client != null && this.client.player != null) {
		this.client.player.networkHandler.sendChatCommand("gamemode creative");
		this.close();
	    }
	}).dimensions(centerX + 4, topRowY, buttonWidth, buttonHeight).build());


	int totalDimWidth = buttonWidth * 3 + 4 * 2;
	int dimStartX = centerX - totalDimWidth / 2;

	// Шверворлд
	this.addDrawableChild(ButtonWidget.builder(Text.literal("O"), button -> {
	    if (this.client != null && this.client.player != null) {
		var player = this.client.player;
		player.networkHandler.sendChatCommand("execute in minecraft:overworld run spreadplayers ~ ~ 0 1 false @s");
		player.sendMessage(Text.literal("Телепортирован в Оверворлд на координаты "
			+ (int) player.getX() + " " + (int) player.getY() + " " + (int) player.getZ()), false);
		this.close();
	    }
	}).dimensions(dimStartX, bottomRowY, buttonWidth, buttonHeight).build());

	// Незер
	this.addDrawableChild(ButtonWidget.builder(Text.literal("N"), button -> {
	    if (this.client != null && this.client.player != null) {
		var player = this.client.player;
		player.networkHandler.sendChatCommand("execute in minecraft:the_nether run spreadplayers ~ ~ 0 1 under 126 false @s");
		player.sendMessage(Text.literal("Телепортирован в Незер на координаты "
			+ (int) player.getX() + " " + (int) player.getY() + " " + (int) player.getZ()), false);
		this.close();
	    }
	}).dimensions(dimStartX + buttonWidth + 4, bottomRowY, buttonWidth, buttonHeight).build());

	// Энд
	this.addDrawableChild(ButtonWidget.builder(Text.literal("E"), button -> {
	    if (this.client != null && this.client.player != null) {
		this.client.player.networkHandler.sendChatCommand("execute in minecraft:the_end run tp @s 0 50 0");
		this.client.player.sendMessage(Text.literal("Телепортирован в Энд на платформу (0, 50, 0)"), false);
		this.close();
	    }
	}).dimensions(dimStartX + (buttonWidth + 4) * 2, bottomRowY, buttonWidth, buttonHeight).build());
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
	super.render(context, mouseX, mouseY, delta);
    }

    @Override
    public void renderBackground(DrawContext context, int mouseX, int mouseY, float delta) {
	this.applyBlur(context);
	this.renderInGameBackground(context);

	context.drawTexture(
		RenderPipelines.GUI_TEXTURED,
		BACKGROUND_TEXTURE,
		this.width / 2 - BACKGROUND_WIDTH / 2,
		this.height / 2 - BACKGROUND_HEIGHT / 2,
		0.0F, 0.0F,
		BACKGROUND_WIDTH, BACKGROUND_HEIGHT,
		BACKGROUND_WIDTH, BACKGROUND_HEIGHT
	);
    }

    @Override
    public boolean shouldCloseOnEsc() {
	return true;
    }
}
