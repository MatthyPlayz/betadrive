package com.matthyfamily.betadrive;

import com.matthyfamily.betadrive.config.BetadriveConfig;
import com.matthyfamily.betadrive.item.BetadriveItems;
import com.matthyfamily.betadrive.player.AndroidPlayer;
import net.fabricmc.api.ModInitializer;

public class Betadrive implements ModInitializer {
    private AndroidPlayer you;
    public static BetadriveConfig cfg = new BetadriveConfig();
    @Override
    public void onInitialize() {
        BetadriveItems.init();
    }
    public AndroidPlayer getAP() {
        return this.you;
    }
    public void setAP(AndroidPlayer ap) {
        this.you = ap;
    }
}
