package dev.amblelabs.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;

public class RadiationEffect extends MobEffect {
    public RadiationEffect() {
        super(MobEffectCategory.HARMFUL, 0x00FF00);
    }

    @Override
    public boolean applyEffectTick(LivingEntity entity, int amplifier) {
        if (!entity.level().isClientSide) {
            // Apply damage based on amplifier level
            float damage = (amplifier + 1) * 0.5f;
            entity.hurt(entity.damageSources().magic(), damage);
        }
        return true;
    }

    @Override
    public boolean shouldApplyEffectTickThisTick(int duration, int amplifier) {
        // Apply every 40 ticks (2 seconds)
        int frequency = 40 >> amplifier;
        return frequency > 0 && duration % frequency == 0;
    }
}
