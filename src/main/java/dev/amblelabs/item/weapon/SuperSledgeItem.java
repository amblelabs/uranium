package dev.amblelabs.item.weapon;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.phys.Vec3;

public class SuperSledgeItem extends SwordItem {
    public SuperSledgeItem(Tier tier, Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Apply strong knockback
        Vec3 direction = target.position().subtract(attacker.position()).normalize();
        target.setDeltaMovement(direction.x * 1.5, 0.5, direction.z * 1.5);
        return super.hurtEnemy(stack, target, attacker);
    }
}
