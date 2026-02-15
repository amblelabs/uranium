package dev.amblelabs.item.weapon;

import dev.amblelabs.ModItems;
import dev.amblelabs.entity.projectile.BulletEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class PipePistolItem extends Item {
    public PipePistolItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            // Check for ammo
            if (player.isCreative() || player.getInventory().contains(new ItemStack(ModItems.AMMO))) {
                // Consume ammo
                if (!player.isCreative()) {
                    for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                        ItemStack invStack = player.getInventory().getItem(i);
                        if (invStack.is(ModItems.AMMO)) {
                            invStack.shrink(1);
                            break;
                        }
                    }
                }
                
                // Fire bullet
                BulletEntity bullet = new BulletEntity(level, player);
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.0F, 1.0F);
                level.addFreshEntity(bullet);
                
                level.playSound(null, player.getX(), player.getY(), player.getZ(), 
                    SoundEvents.GENERIC_EXPLODE, SoundSource.PLAYERS, 0.5F, 1.0F);
                
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            }
        }
        
        return InteractionResultHolder.success(stack);
    }
}
