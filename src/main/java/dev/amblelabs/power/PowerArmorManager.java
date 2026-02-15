package dev.amblelabs.power;

import dev.amblelabs.ModEntities;
import dev.amblelabs.entity.PowerArmorEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PowerArmorManager {
    private static final Map<UUID, Boolean> POWER_ARMOR_MODE = new HashMap<>();
    private static final int EFFECT_DURATION = 20; // 1 second, reapplied continuously

    public static void enterPowerArmor(Player player) {
        POWER_ARMOR_MODE.put(player.getUUID(), true);
        player.displayClientMessage(Component.literal("Power Armor Activated"), true);
    }

    public static void exitPowerArmor(Player player) {
        POWER_ARMOR_MODE.remove(player.getUUID());
        
        // Spawn power armor entity at player's position
        PowerArmorEntity armorEntity = new PowerArmorEntity(player.level());
        armorEntity.setPos(player.getX(), player.getY(), player.getZ());
        player.level().addFreshEntity(armorEntity);
        
        player.displayClientMessage(Component.literal("Power Armor Deactivated"), true);
    }

    public static boolean isInPowerArmor(Player player) {
        return POWER_ARMOR_MODE.getOrDefault(player.getUUID(), false);
    }

    public static void tick(Player player) {
        if (isInPowerArmor(player)) {
            // Apply power armor effects
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, EFFECT_DURATION, 2, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, EFFECT_DURATION, 0, false, false));
            player.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, EFFECT_DURATION, 1, false, false));
            
            // Check for exit condition (sneaking + use)
            if (player.isShiftKeyDown() && player.swinging) {
                exitPowerArmor(player);
            }
        }
    }
}
