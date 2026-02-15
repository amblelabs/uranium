package dev.amblelabs;

import dev.amblelabs.item.*;
import dev.amblelabs.item.weapon.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tiers;

public class ModItems {
    // Materials
    public static Item URANIUM_INGOT;
    public static Item STEEL_INGOT;
    
    // Ammo
    public static Item AMMO;
    public static Item FUSION_CELL;
    
    // Consumables
    public static Item RADAWAY;
    public static Item GEIGER_COUNTER;
    
    // Melee Weapons
    public static Item COMBAT_KNIFE;
    public static Item BASEBALL_BAT;
    public static Item SUPER_SLEDGE;
    
    // Ranged Weapons
    public static Item PIPE_PISTOL;
    public static Item LASER_RIFLE;
    
    // Spawn Eggs
    public static Item POWER_ARMOR_SPAWN_EGG;
    public static Item GHOUL_SPAWN_EGG;
    
    // Block Items
    public static Item VAULT_STEEL_BLOCK;
    public static Item VAULT_DOOR;
    public static Item NUCLEAR_WASTE;
    public static Item URANIUM_ORE;

    public static void register() {
        // Materials
        URANIUM_INGOT = Registry.register(BuiltInRegistries.ITEM, Uranium.of("uranium_ingot"), new UraniumIngotItem(new Item.Properties()));
        STEEL_INGOT = Registry.register(BuiltInRegistries.ITEM, Uranium.of("steel_ingot"), new SteelIngotItem(new Item.Properties()));
        
        // Ammo
        AMMO = Registry.register(BuiltInRegistries.ITEM, Uranium.of("ammo"), new AmmoItem(new Item.Properties()));
        FUSION_CELL = Registry.register(BuiltInRegistries.ITEM, Uranium.of("fusion_cell"), new FusionCellItem(new Item.Properties()));
        
        // Consumables
        RADAWAY = Registry.register(BuiltInRegistries.ITEM, Uranium.of("radaway"), new RadAwayItem(new Item.Properties().stacksTo(16)));
        GEIGER_COUNTER = Registry.register(BuiltInRegistries.ITEM, Uranium.of("geiger_counter"), new GeigerCounterItem(new Item.Properties().stacksTo(1)));
        
        // Melee Weapons
        COMBAT_KNIFE = Registry.register(BuiltInRegistries.ITEM, Uranium.of("combat_knife"), 
            new CombatKnifeItem(Tiers.IRON, new Item.Properties().attributes(CombatKnifeItem.createAttributes(Tiers.IRON, 2, -2.0f))));
        
        BASEBALL_BAT = Registry.register(BuiltInRegistries.ITEM, Uranium.of("baseball_bat"), 
            new BaseballBatItem(Tiers.WOOD, new Item.Properties().attributes(BaseballBatItem.createAttributes(Tiers.WOOD, 4, -2.6f))));
        
        SUPER_SLEDGE = Registry.register(BuiltInRegistries.ITEM, Uranium.of("super_sledge"), 
            new SuperSledgeItem(Tiers.DIAMOND, new Item.Properties().attributes(SuperSledgeItem.createAttributes(Tiers.DIAMOND, 8, -3.2f))));
        
        // Ranged Weapons
        PIPE_PISTOL = Registry.register(BuiltInRegistries.ITEM, Uranium.of("pipe_pistol"), new PipePistolItem(new Item.Properties().durability(250)));
        LASER_RIFLE = Registry.register(BuiltInRegistries.ITEM, Uranium.of("laser_rifle"), new LaserRifleItem(new Item.Properties().durability(500)));
        
        // Spawn Eggs
        POWER_ARMOR_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, Uranium.of("power_armor_spawn_egg"), 
            new SpawnEggItem(ModEntities.POWER_ARMOR, 0x808080, 0x404040, new Item.Properties()));
        
        GHOUL_SPAWN_EGG = Registry.register(BuiltInRegistries.ITEM, Uranium.of("ghoul_spawn_egg"), 
            new SpawnEggItem(ModEntities.GHOUL, 0x8B7355, 0x556B2F, new Item.Properties()));
        
        // Block Items
        VAULT_STEEL_BLOCK = Registry.register(BuiltInRegistries.ITEM, Uranium.of("vault_steel_block"), new BlockItem(ModBlocks.VAULT_STEEL_BLOCK, new Item.Properties()));
        VAULT_DOOR = Registry.register(BuiltInRegistries.ITEM, Uranium.of("vault_door"), new BlockItem(ModBlocks.VAULT_DOOR, new Item.Properties()));
        NUCLEAR_WASTE = Registry.register(BuiltInRegistries.ITEM, Uranium.of("nuclear_waste"), new BlockItem(ModBlocks.NUCLEAR_WASTE, new Item.Properties()));
        URANIUM_ORE = Registry.register(BuiltInRegistries.ITEM, Uranium.of("uranium_ore"), new BlockItem(ModBlocks.URANIUM_ORE, new Item.Properties()));
        
        Uranium.LOGGER.info("Registered mod items");
    }
}
