package dev.amblelabs.entity;

import dev.amblelabs.ModEntities;
import dev.amblelabs.power.PowerArmorManager;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class PowerArmorEntity extends Mob {
    
    public PowerArmorEntity(EntityType<? extends PowerArmorEntity> type, Level level) {
        super(type, level);
        this.setNoAi(true);
    }

    public PowerArmorEntity(Level level) {
        this(ModEntities.POWER_ARMOR, level);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
            .add(Attributes.MAX_HEALTH, 100.0)
            .add(Attributes.MOVEMENT_SPEED, 0.0)
            .add(Attributes.KNOCKBACK_RESISTANCE, 1.0);
    }

    @Override
    protected void registerGoals() {
        // No AI goals - this entity doesn't move on its own
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (!this.level().isClientSide) {
            // Enter power armor mode
            PowerArmorManager.enterPowerArmor(player);
            this.discard(); // Remove entity from world
            return InteractionResult.SUCCESS;
        }
        return InteractionResult.CONSUME;
    }

    @Override
    public boolean isPushable() {
        return false;
    }
}
