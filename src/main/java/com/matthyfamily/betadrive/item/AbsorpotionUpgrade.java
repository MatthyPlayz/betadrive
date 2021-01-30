package com.matthyfamily.betadrive.item;


import com.matthyfamily.betadrive.player.AndroidPlayer;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

import static com.matthyfamily.betadrive.Betadrive.cfg;

public class AbsorpotionUpgrade extends Item {

    public AbsorpotionUpgrade(Settings settings) {
        super(settings);
    }
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity playerEntity, Hand hand) {
        try {
            if(!cfg.isExistant()) {
                cfg.create();
            }
            if(cfg.read().toJSONString().contains(new AndroidPlayer(playerEntity).getName())) {
                playerEntity.setAbsorptionAmount(4);
                playerEntity.sendMessage(Text.of("You feel... empowered. Although it just feels temporary."), true);
            } else {
                playerEntity.sendMessage(Text.of("It did nothing... maybe you aren't an Android?"), true);
            }
            return TypedActionResult.consume(playerEntity.getStackInHand(hand));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return TypedActionResult.fail(playerEntity.getStackInHand(hand));
    }
}
