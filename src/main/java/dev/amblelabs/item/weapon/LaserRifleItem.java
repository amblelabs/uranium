package dev.amblelabs.item.weapon;

import dev.amblelabs.ModItems;
import dev.amblelabs.entity.projectile.LaserEntity;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class LaserRifleItem extends Item {
    public LaserRifleItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!level.isClientSide) {
            // Check for fusion cells
            if (player.isCreative() || player.getInventory().contains(new ItemStack(ModItems.FUSION_CELL))) {
                // Consume fusion cell
                if (!player.isCreative()) {
                    for (int i = 0; i < player.getInventory().getContainerSize(); i++) {
                        ItemStack invStack = player.getInventory().getItem(i);
                        if (invStack.is(ModItems.FUSION_CELL)) {
                            invStack.shrink(1);
                            break;
                        }
                    }
                }
                
                // Fire laser
                LaserEntity laser = new LaserEntity(level, player);
                laser.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 3.5F, 0.5F);
                level.addFreshEntity(laser);
                
                level.playSound(null, player.getX(), player.getY(), player.getZ(), 
                    SoundEvents.BEACON_POWER_SELECT, SoundSource.PLAYERS, 0.5F, 2.0F);
                
                stack.hurtAndBreak(1, player, p -> p.broadcastBreakEvent(hand));
            }
        }
        
        return InteractionResultHolder.success(stack);
    }
}
