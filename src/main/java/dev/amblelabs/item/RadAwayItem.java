package dev.amblelabs.item;

import dev.amblelabs.radiation.RadiationManager;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RadAwayItem extends Item {
    public RadAwayItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            float currentRads = RadiationManager.getRadiation(serverPlayer);
            float reduction = 25.0f;
            RadiationManager.addRadiation(serverPlayer, -reduction);
            
            player.displayClientMessage(Component.literal("Radiation reduced by " + reduction + " rads"), true);
            
            if (!player.isCreative()) {
                stack.shrink(1);
            }
        }
        
        return InteractionResultHolder.success(stack);
    }
}
