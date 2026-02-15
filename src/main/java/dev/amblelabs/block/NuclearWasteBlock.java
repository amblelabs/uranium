package dev.amblelabs.block;

import dev.amblelabs.radiation.RadiationManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class NuclearWasteBlock extends Block {
    private static final float RADIATION_PER_TICK = 0.5f;
    private static final int RADIUS = 3;

    public NuclearWasteBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        super.stepOn(level, pos, state, entity);
        
        if (!level.isClientSide && entity instanceof ServerPlayer player) {
            RadiationManager.addRadiation(player, RADIATION_PER_TICK * 2);
        }
    }

    @Override
    @Deprecated
    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer player) {
            RadiationManager.addRadiation(player, RADIATION_PER_TICK);
        }
    }
}
