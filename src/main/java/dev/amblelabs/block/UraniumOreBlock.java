package dev.amblelabs.block;

import dev.amblelabs.radiation.RadiationManager;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;

import java.util.List;

public class UraniumOreBlock extends Block {
    private static final float RADIATION_PER_TICK = 0.1f;
    private static final int RADIUS = 5;

    public UraniumOreBlock(Properties properties) {
        super(properties);
    }

    @Override
    @Deprecated
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        super.randomTick(state, level, pos, random);
        
        // Emit radiation to nearby players
        AABB area = new AABB(pos).inflate(RADIUS);
        List<ServerPlayer> players = level.getEntitiesOfClass(ServerPlayer.class, area);
        
        for (ServerPlayer player : players) {
            RadiationManager.addRadiation(player, RADIATION_PER_TICK);
        }
    }

    @Override
    @Deprecated
    public boolean isRandomlyTicking(BlockState state) {
        return true;
    }
}
