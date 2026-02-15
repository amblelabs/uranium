package dev.amblelabs;

import dev.amblelabs.effect.RadiationEffect;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;

public class ModEffects {
    public static final MobEffect RADIATION = new RadiationEffect();

    public static void register() {
        Registry.register(BuiltInRegistries.MOB_EFFECT, Uranium.of("radiation"), RADIATION);
        Uranium.LOGGER.info("Registered mod effects");
    }
}
