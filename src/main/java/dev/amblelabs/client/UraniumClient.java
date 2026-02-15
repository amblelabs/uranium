package dev.amblelabs.client;

import dev.amblelabs.Uranium;
import dev.amblelabs.client.overlays.DevelopmentHud;
import dev.amblelabs.client.overlays.PowerArmorHud;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.hud.HudElementRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.hud.VanillaHudElements;

public class UraniumClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerHudRenderers();
    }

    private static void registerHudRenderers() {
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Uranium.of("power_armor_hud"), PowerArmorHud::render);
        HudElementRegistry.attachElementBefore(VanillaHudElements.CHAT, Uranium.of("development_hud"), DevelopmentHud::render);
    }
}
