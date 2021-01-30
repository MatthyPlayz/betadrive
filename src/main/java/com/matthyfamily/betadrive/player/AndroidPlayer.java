package com.matthyfamily.betadrive.player;

import net.minecraft.entity.player.PlayerEntity;

public class AndroidPlayer {
    private PlayerEntity player;
    private boolean isAndroid;
    private String name;
    public AndroidPlayer(PlayerEntity playerEntity) {
        this.player = playerEntity;
        this.isAndroid = true;
        this.name = player.getName().asString();
    }
    public boolean isAndroid() {
        return this.isAndroid;
    }
    public PlayerEntity getPlayer() {
        return this.player;
    }
    public String getName() {
        return player.getName().asString();
    }
}
