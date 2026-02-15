package dev.amblelabs;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModItemGroups {
    public static final ResourceKey<CreativeModeTab> URANIUM_GROUP = ResourceKey.create(
        Registries.CREATIVE_MODE_TAB,
        Uranium.of("uranium")
    );

    public static final CreativeModeTab URANIUM_TAB = FabricItemGroup.builder()
        .icon(() -> new ItemStack(ModItems.URANIUM_INGOT))
        .title(Component.translatable("itemGroup.uranium.uranium"))
        .build();

    public static void register() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, URANIUM_GROUP, URANIUM_TAB);
        
        ItemGroupEvents.modifyEntriesEvent(URANIUM_GROUP).register(content -> {
            // Materials
            content.accept(ModItems.URANIUM_INGOT);
            content.accept(ModItems.STEEL_INGOT);
            
            // Consumables
            content.accept(ModItems.RADAWAY);
            content.accept(ModItems.GEIGER_COUNTER);
            
            // Ammo
            content.accept(ModItems.AMMO);
            content.accept(ModItems.FUSION_CELL);
            
            // Melee Weapons
            content.accept(ModItems.COMBAT_KNIFE);
            content.accept(ModItems.BASEBALL_BAT);
            content.accept(ModItems.SUPER_SLEDGE);
            
            // Ranged Weapons
            content.accept(ModItems.PIPE_PISTOL);
            content.accept(ModItems.LASER_RIFLE);
            
            // Blocks
            content.accept(ModItems.VAULT_STEEL_BLOCK);
            content.accept(ModItems.VAULT_DOOR);
            content.accept(ModItems.NUCLEAR_WASTE);
            content.accept(ModItems.URANIUM_ORE);
            
            // Spawn Eggs
            content.accept(ModItems.POWER_ARMOR_SPAWN_EGG);
            content.accept(ModItems.GHOUL_SPAWN_EGG);
        });
        
        Uranium.LOGGER.info("Registered mod item groups");
    }
}
