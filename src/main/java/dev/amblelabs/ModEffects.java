package dev.amblelabs;

import dev.amblelabs.effect.RadiationEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {
    public static MobEffect RADIATION;

    public static void register() {
        RADIATION = Registry.register(BuiltInRegistries.MOB_EFFECT, Uranium.of("radiation"), new RadiationEffect());
        Uranium.LOGGER.info("Registered mod effects");
    }
}
