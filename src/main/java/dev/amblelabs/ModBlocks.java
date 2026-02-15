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
    public static Block VAULT_STEEL_BLOCK;
    public static Block VAULT_DOOR;
    public static Block NUCLEAR_WASTE;
    public static Block URANIUM_ORE;

    public static void register() {
        VAULT_STEEL_BLOCK = Registry.register(BuiltInRegistries.BLOCK, Uranium.of("vault_steel_block"),
            new VaultSteelBlock(BlockBehaviour.Properties.of()
                .strength(5.0f, 6.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)));

        VAULT_DOOR = Registry.register(BuiltInRegistries.BLOCK, Uranium.of("vault_door"),
            new VaultDoorBlock(BlockBehaviour.Properties.of()
                .strength(5.0f, 6.0f)
                .requiresCorrectToolForDrops()
                .sound(SoundType.METAL)
                .noOcclusion()));

        NUCLEAR_WASTE = Registry.register(BuiltInRegistries.BLOCK, Uranium.of("nuclear_waste"),
            new NuclearWasteBlock(BlockBehaviour.Properties.of()
                .strength(2.0f)
                .sound(SoundType.SLIME_BLOCK)
                .lightLevel(state -> 7)));

        URANIUM_ORE = Registry.register(BuiltInRegistries.BLOCK, Uranium.of("uranium_ore"),
            new UraniumOreBlock(BlockBehaviour.Properties.of()
                .strength(3.0f)
                .requiresCorrectToolForDrops()
                .lightLevel(state -> 3)));
        
        Uranium.LOGGER.info("Registered mod blocks");
    }
}
