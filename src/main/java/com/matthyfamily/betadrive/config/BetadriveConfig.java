package com.matthyfamily.betadrive.config;

import com.matthyfamily.betadrive.player.AndroidPlayer;
import net.minecraft.client.MinecraftClient;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class BetadriveConfig extends ConfigFile {
    public void becomeAndroid(AndroidPlayer ap) {
        if(!isExistant()) {
            create();
        }
        try {
            if(!read().toJSONString().contains(ap.getName())) {
                append(ap.getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void unBecomeAndroid(AndroidPlayer ap) {
        if(!isExistant()) {
            create();
        }
        try {
            if(!read().toJSONString().contains(ap.getName())) {
                String rep = read().toJSONString().replace(",\"" + ap.getName() + "\"", "");
                overwrite();
                Files.write(Paths.get(getPath() + ".json"), Arrays.asList(rep.split("\n")));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public AndroidPlayer getAPFromIGN(String name) {
        return new AndroidPlayer(MinecraftClient.getInstance().getServer().getPlayerManager().getPlayer(name));
    }
}
