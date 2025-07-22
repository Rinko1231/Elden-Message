package com.meteor.eldenmessage.client.screen;

import com.meteor.eldenmessage.lib.LibMisc;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

public class ButtonConfirm extends Button {

    public static final ResourceLocation WIDGETS_LOCATION = ResourceLocation.fromNamespaceAndPath(LibMisc.MOD_ID, "textures/gui/confirmicon.png");

    protected ButtonConfirm(int x, int y, int width, int height, Component message, OnPress onPress, CreateNarration createNarration) {
        super(x, y, width, height, message, onPress, createNarration);
    }


    @Override
    public void renderButton(PoseStack p_93676_, int p_93677_, int p_93678_, float p_93679_) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderTexture(0, WIDGETS_LOCATION);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, this.alpha);
        int i = this.active ? 0 : 1;
        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        this.blit(p_93676_, this.x, this.y, i * 32, 0, 32, 32);
    }

}
