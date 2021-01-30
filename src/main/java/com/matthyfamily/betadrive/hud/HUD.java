package com.matthyfamily.betadrive.hud;

import com.matthyfamily.betadrive.Betadrive;
import com.matthyfamily.betadrive.player.AndroidPlayer;
import com.mojang.blaze3d.systems.RenderSystem;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class HUD {
    private boolean ic;
    private MinecraftClient client;
    private int cyclesDone = 0;
    private World world;
    private int initial;
    private boolean cleared;
    public HUD(boolean isCONVERTING, World worlda) {
        this.initial = (int) worlda.getTime();
        this.ic = isCONVERTING;
        this.world = worlda;
        client = MinecraftClient.getInstance();
        HudRenderCallback.EVENT.register((__, ___) -> this.render());
    }

    public void clear() {
        cleared = true;
    }
    public void unclear() {
        cleared = false;
    }
    private void render() {
        try {
            if(Betadrive.cfg.read().toJSONString().contains(new AndroidPlayer(client.player).getName()) && (!(cleared))) {
                cyclesDone = (int) world.getTime() - initial;
                final PlayerEntity player = client.player;
                final InGameHud inGameHud = client.inGameHud;
                final TextRenderer textRenderer = client.textRenderer;
                final MatrixStack matrixStack = new MatrixStack();
                if(ic && !(cyclesDone == 400)) {
                    System.out.println(cyclesDone);
                    if(cyclesDone > 0  && cyclesDone < 160){
                            RenderSystem.enableBlend();
                            textRenderer.draw(matrixStack, "BIOLOGICAL PRESENCE DETECTED.", 36, 50, 0xA9E2FB);
                            textRenderer.draw(matrixStack, "RELEASING NANOBOTS TO CONVERT BIOLOGICAL PERSENCE", 36, 60, 0xA9E2FB);
                            textRenderer.draw(matrixStack, "TO ANDROID.", 36, 70, 0xA9E2FB);
                    } else if(cyclesDone > 160 && cyclesDone < 280){
                            textRenderer.draw(matrixStack, "CONVERTING ALL BODY PARTS...", 36, 50, 0xA9E2FB);
                            textRenderer.draw(matrixStack, "...done.", 36, 60, 0xA9E2FB);
                    } else if(cyclesDone > 280 && cyclesDone < 340){
                            textRenderer.draw(matrixStack, "CONVERSION PROCESSING", 36, 50, 0xA9E2FB);
                            textRenderer.draw(matrixStack, "BRAIN CONVERTING TO PROCESSING UNIT..", 36, 60, 0xA9E2FB);
                    } else if(cyclesDone > 340 && cyclesDone < 400) {
                        textRenderer.draw(matrixStack, "...done.", 36, 50, 0xA9E2FB);
                        textRenderer.draw(matrixStack, ".Body conversion complete.", 36, 60, 0xA9E2FB);
                        client.player.updateHealth(0);
                        ic = false;
                    } else if(cyclesDone > 340) {
                        client.player.updateHealth(20);
                    }
                } else {
                    if (player == null) return;
                    RenderSystem.enableBlend();
                    String averageSpeed = String.valueOf((1000 * player.getMovementSpeed()));
                    textRenderer.draw(matrixStack, "[XP==" + player.totalExperience + "] " + "[KPH==" + averageSpeed + "]", 12, 12, 0xA9E2FB);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
