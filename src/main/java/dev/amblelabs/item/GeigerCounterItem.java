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

public class GeigerCounterItem extends Item {
    public GeigerCounterItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        if (!level.isClientSide && player instanceof ServerPlayer serverPlayer) {
            float radiation = RadiationManager.getRadiation(serverPlayer);
            player.displayClientMessage(
                Component.literal(String.format("Radiation Level: %.1f rads", radiation)), 
                true
            );
        }
        return InteractionResultHolder.success(player.getItemInHand(hand));
    }
}
