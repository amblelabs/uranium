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
    public static final EntityType<PowerArmorEntity> POWER_ARMOR = EntityType.Builder.of(
        (EntityType.EntityFactory<PowerArmorEntity>) PowerArmorEntity::new,
        MobCategory.MISC
    )
        .sized(0.6f, 1.8f)
        .clientTrackingRange(10)
        .build("power_armor");

    public static final EntityType<GhoulEntity> GHOUL = EntityType.Builder.of(
        (EntityType.EntityFactory<GhoulEntity>) GhoulEntity::new,
        MobCategory.MONSTER
    )
        .sized(0.6f, 1.95f)
        .clientTrackingRange(8)
        .build("ghoul");

    public static final EntityType<BulletEntity> BULLET = EntityType.Builder.<BulletEntity>of(
        BulletEntity::new,
        MobCategory.MISC
    )
        .sized(0.25f, 0.25f)
        .clientTrackingRange(4)
        .updateInterval(10)
        .build("bullet");

    public static final EntityType<LaserEntity> LASER = EntityType.Builder.<LaserEntity>of(
        LaserEntity::new,
        MobCategory.MISC
    )
        .sized(0.25f, 0.25f)
        .clientTrackingRange(4)
        .updateInterval(10)
        .build("laser");

    public static void register() {
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("power_armor"), POWER_ARMOR);
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("ghoul"), GHOUL);
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("bullet"), BULLET);
        Registry.register(BuiltInRegistries.ENTITY_TYPE, Uranium.of("laser"), LASER);
        
        // Register attributes for living entities
        FabricDefaultAttributeRegistry.register(POWER_ARMOR, PowerArmorEntity.createAttributes());
        FabricDefaultAttributeRegistry.register(GHOUL, GhoulEntity.createAttributes());
        
        Uranium.LOGGER.info("Registered mod entities");
    }
}
