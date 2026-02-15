package dev.amblelabs.entity;

import dev.amblelabs.ModEntities;
import dev.amblelabs.radiation.RadiationManager;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class GhoulEntity extends Monster {
    private final boolean isFeral;

    public GhoulEntity(EntityType<? extends GhoulEntity> type, Level level) {
        this(type, level, false);
    }

    public GhoulEntity(EntityType<? extends GhoulEntity> type, Level level, boolean feral) {
        super(type, level);
        this.isFeral = feral;
    }

    public GhoulEntity(Level level, boolean feral) {
        this(ModEntities.GHOUL, level, feral);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes()
            .add(Attributes.MAX_HEALTH, 25.0)
            .add(Attributes.MOVEMENT_SPEED, 0.3)
            .add(Attributes.ATTACK_DAMAGE, 4.0)
            .add(Attributes.FOLLOW_RANGE, 35.0);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 0.8));
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
        
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(net.minecraft.world.entity.Entity target) {
        boolean result = super.doHurtTarget(target);
        
        // Add radiation damage
        if (result && target instanceof ServerPlayer player) {
            float radiationDamage = isFeral ? 5.0f : 2.5f;
            RadiationManager.addRadiation(player, radiationDamage);
        }
        
        return result;
    }

    public boolean isFeral() {
        return isFeral;
    }
}
