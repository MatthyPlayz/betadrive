package com.matthyfamily.betadrive.item;

import com.matthyfamily.betadrive.Betadrive;
import com.matthyfamily.betadrive.hud.HUD;
import com.matthyfamily.betadrive.player.AndroidPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class RedPillItem extends Item {
    public RedPillItem(Settings settings) {
        super(settings);
    }
    private static HUD hud;
    public static HUD getHud() {
        return hud;
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        Betadrive.cfg.becomeAndroid(new AndroidPlayer(playerEntity));
        hud = new HUD(true, world);
        return TypedActionResult.consume(playerEntity.getStackInHand(hand));
    }
}
