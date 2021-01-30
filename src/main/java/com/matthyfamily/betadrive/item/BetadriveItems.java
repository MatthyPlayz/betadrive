package com.matthyfamily.betadrive.item;

import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BetadriveItems {
    public static void init() {
        Registry.register(Registry.ITEM, new Identifier("betadrive", "red_pill"), new RedPillItem(new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("betadrive", "blue_pill"), new BluePillItem(new Item.Settings()));
        Registry.register(Registry.ITEM, new Identifier("betadrive", "absorption_upgrade"), new AbsorpotionUpgrade(new Item.Settings()));

    }
}
