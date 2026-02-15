package dev.amblelabs;

import dev.amblelabs.block.NuclearWasteBlock;
import dev.amblelabs.block.UraniumOreBlock;
import dev.amblelabs.block.VaultDoorBlock;
import dev.amblelabs.block.VaultSteelBlock;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final Block VAULT_STEEL_BLOCK = new VaultSteelBlock(
        BlockBehaviour.Properties.of()
            .strength(5.0f, 6.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL)
    );

    public static final Block VAULT_DOOR = new VaultDoorBlock(
        BlockBehaviour.Properties.of()
            .strength(5.0f, 6.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL)
            .noOcclusion()
    );

    public static final Block NUCLEAR_WASTE = new NuclearWasteBlock(
        BlockBehaviour.Properties.of()
            .strength(2.0f)
            .sound(SoundType.SLIME_BLOCK)
            .lightLevel(state -> 7)
    );

    public static final Block URANIUM_ORE = new UraniumOreBlock(
        BlockBehaviour.Properties.of()
            .strength(3.0f)
            .requiresCorrectToolForDrops()
            .lightLevel(state -> 3)
    );

    public static void register() {
        Registry.register(BuiltInRegistries.BLOCK, Uranium.of("vault_steel_block"), VAULT_STEEL_BLOCK);
        Registry.register(BuiltInRegistries.BLOCK, Uranium.of("vault_door"), VAULT_DOOR);
        Registry.register(BuiltInRegistries.BLOCK, Uranium.of("nuclear_waste"), NUCLEAR_WASTE);
        Registry.register(BuiltInRegistries.BLOCK, Uranium.of("uranium_ore"), URANIUM_ORE);
        
        Uranium.LOGGER.info("Registered mod blocks");
    }
}
