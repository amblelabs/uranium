package dev.amblelabs.radiation;

import dev.amblelabs.ModEffects;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class RadiationManager {
    private static final Map<UUID, Float> RADIATION_LEVELS = new HashMap<>();
    private static final float MAX_RADIATION = 100.0f;
    private static final float DECAY_RATE = 0.1f; // Radiation decreases by this amount per tick

    public static void addRadiation(ServerPlayer player, float amount) {
        UUID uuid = player.getUUID();
        float current = RADIATION_LEVELS.getOrDefault(uuid, 0.0f);
        float newLevel = Math.max(0, Math.min(MAX_RADIATION, current + amount));
        RADIATION_LEVELS.put(uuid, newLevel);
        
        if (amount > 0) {
            player.displayClientMessage(Component.literal(String.format("Radiation: +%.1f rads", amount)), true);
        }
    }

    public static float getRadiation(ServerPlayer player) {
        return RADIATION_LEVELS.getOrDefault(player.getUUID(), 0.0f);
    }

    public static void setRadiation(ServerPlayer player, float level) {
        RADIATION_LEVELS.put(player.getUUID(), Math.max(0, Math.min(MAX_RADIATION, level)));
    }

    public static void tick(ServerPlayer player) {
        float radiation = getRadiation(player);
        
        if (radiation > 0) {
            // Slowly decay radiation
            float newLevel = radiation - DECAY_RATE / 20.0f; // Per tick
            setRadiation(player, newLevel);
            
            // Apply effects based on radiation level
            if (radiation >= 75.0f) {
                // Critical: Rapid health drain, blindness
                player.addEffect(new MobEffectInstance(ModEffects.RADIATION, 40, 3, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WITHER, 40, 2, false, false));
            } else if (radiation >= 50.0f) {
                // High: Wither-like damage, mining fatigue
                player.addEffect(new MobEffectInstance(ModEffects.RADIATION, 40, 2, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 40, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 1, false, false));
            } else if (radiation >= 25.0f) {
                // Medium: Weakness, slowness
                player.addEffect(new MobEffectInstance(ModEffects.RADIATION, 40, 1, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 40, 0, false, false));
            } else if (radiation >= 10.0f) {
                // Low: Slight nausea, hunger drain
                player.addEffect(new MobEffectInstance(ModEffects.RADIATION, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 40, 0, false, false));
                player.addEffect(new MobEffectInstance(MobEffects.HUNGER, 40, 0, false, false));
            }
        }
    }

    public static void onPlayerSleep(ServerPlayer player) {
        // Reduce radiation when sleeping
        float current = getRadiation(player);
        setRadiation(player, current * 0.5f); // Reduce by 50%
        player.displayClientMessage(Component.literal("Radiation reduced from sleeping"), false);
    }
}
