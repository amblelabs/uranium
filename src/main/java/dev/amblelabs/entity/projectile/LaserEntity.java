package dev.amblelabs.entity.projectile;

import dev.amblelabs.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;

public class LaserEntity extends ThrowableProjectile {
    private static final float DAMAGE = 8.0f;

    public LaserEntity(EntityType<? extends LaserEntity> type, Level level) {
        super(type, level);
    }

    public LaserEntity(Level level, LivingEntity shooter) {
        super(ModEntities.LASER, shooter, level);
    }

    @Override
    protected void onHit(HitResult result) {
        super.onHit(result);
        if (!this.level().isClientSide) {
            this.discard();
        }
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        super.onHitEntity(result);
        if (!this.level().isClientSide && result.getEntity() instanceof LivingEntity target) {
            target.hurt(this.damageSources().thrown(this, this.getOwner()), DAMAGE);
            target.setRemainingFireTicks(100); // Set on fire
        }
    }

    @Override
    protected void defineSynchedData() {
    }
}
