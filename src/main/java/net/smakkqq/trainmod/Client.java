package net.smakkqq.trainmod;

import net.fabricmc.api.ClientModInitializer;
import net.smakkqq.trainmod.tooltip.ModToolTips;

public class Client implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
       ModToolTips.registerModTooltips();
    }
    
    
}
