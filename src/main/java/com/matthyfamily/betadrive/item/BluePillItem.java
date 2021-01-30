package com.matthyfamily.betadrive.item;

import com.matthyfamily.betadrive.Betadrive;
import com.matthyfamily.betadrive.player.AndroidPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class BluePillItem extends Item {
    public BluePillItem(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        Betadrive.cfg.unBecomeAndroid(new AndroidPlayer(playerEntity));
        RedPillItem.getHud().clear();
        return TypedActionResult.consume(playerEntity.getStackInHand(hand));
    }
}
