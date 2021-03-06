package com.matthyfamily.betadrive.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.options.GameOptions;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(MinecraftClient.class)
public interface MinecraftClientMixin {
    @Accessor("options")
    GameOptions getGameOptions();
}
