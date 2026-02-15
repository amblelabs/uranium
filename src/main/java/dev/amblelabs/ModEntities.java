package dev.amblelabs;

import dev.amblelabs.entity.GhoulEntity;
import dev.amblelabs.entity.PowerArmorEntity;
import dev.amblelabs.entity.projectile.BulletEntity;
import dev.amblelabs.entity.projectile.LaserEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {
    public static EntityType<PowerArmorEntity> POWER_ARMOR;
    public static EntityType<GhoulEntity> GHOUL;
    public static EntityType<BulletEntity> BULLET;
    public static EntityType<LaserEntity> LASER;

    public static void register() {
        POWER_ARMOR = Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("power_armor"),
            EntityType.Builder.of((EntityType.EntityFactory<PowerArmorEntity>) PowerArmorEntity::new, MobCategory.MISC)
                .sized(0.6f, 1.8f)
                .clientTrackingRange(10)
                .build("power_armor"));

        GHOUL = Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("ghoul"),
            EntityType.Builder.of((EntityType.EntityFactory<GhoulEntity>) GhoulEntity::new, MobCategory.MONSTER)
                .sized(0.6f, 1.95f)
                .clientTrackingRange(8)
                .build("ghoul"));

        BULLET = Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("bullet"),
            EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                .sized(0.25f, 0.25f)
                .clientTrackingRange(4)
                .updateInterval(10)
                .build("bullet"));

        LASER = Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("laser"),
            EntityType.Builder.<LaserEntity>of(LaserEntity::new, MobCategory.MISC)
                .sized(0.25f, 0.25f)
                .clientTrackingRange(4)
                .updateInterval(10)
                .build("laser"));
        
        // Register attributes for living entities
        FabricDefaultAttributeRegistry.register(POWER_ARMOR, PowerArmorEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(GHOUL, GhoulEntity.createAttributes());
        
        Uranium.LOGGER.info("Registered mod entities");
    }
}
