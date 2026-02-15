package dev.amblelabs;

import dev.amblelabs.item.*;
import dev.amblelabs.item.weapon.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;

public class ModItems {
    // Materials
    public static final Item URANIUM_INGOT = new UraniumIngotItem(new Item.Properties());
    public static final Item STEEL_INGOT = new SteelIngotItem(new Item.Properties());
    
    // Ammo
    public static final Item AMMO = new AmmoItem(new Item.Properties());
    public static final Item FUSION_CELL = new FusionCellItem(new Item.Properties());
    
    // Consumables
    public static final Item RADAWAY = new RadAwayItem(new Item.Properties().stacksTo(16));
    public static final Item GEIGER_COUNTER = new GeigerCounterItem(new Item.Properties().stacksTo(1));
    
    // Melee Weapons
    public static final Item COMBAT_KNIFE = new CombatKnifeItem(
        Tiers.IRON,
        new Item.Properties().attributes(CombatKnifeItem.createAttributes(Tiers.IRON, 2, -2.0f))
    );
    
    public static final Item BASEBALL_BAT = new BaseballBatItem(
        Tiers.WOOD,
        new Item.Properties().attributes(BaseballBatItem.createAttributes(Tiers.WOOD, 4, -2.6f))
    );
    
    public static final Item SUPER_SLEDGE = new SuperSledgeItem(
        Tiers.DIAMOND,
        new Item.Properties().attributes(SuperSledgeItem.createAttributes(Tiers.DIAMOND, 8, -3.2f))
    );
    
    // Ranged Weapons
    public static final Item PIPE_PISTOL = new PipePistolItem(new Item.Properties().durability(250));
    public static final Item LASER_RIFLE = new LaserRifleItem(new Item.Properties().durability(500));
    
    // Spawn Eggs
    public static final Item POWER_ARMOR_SPAWN_EGG = new SpawnEggItem(
        ModEntities.POWER_ARMOR,
        0x808080,
        0x404040,
        new Item.Properties()
    );
    
    public static final Item GHOUL_SPAWN_EGG = new SpawnEggItem(
        ModEntities.GHOUL,
        0x8B7355,
        0x556B2F,
        new Item.Properties()
    );
    
    // Block Items
    public static final Item VAULT_STEEL_BLOCK = new BlockItem(ModBlocks.VAULT_STEEL_BLOCK, new Item.Properties());
    public static final Item VAULT_DOOR = new BlockItem(ModBlocks.VAULT_DOOR, new Item.Properties());
    public static final Item NUCLEAR_WASTE = new BlockItem(ModBlocks.NUCLEAR_WASTE, new Item.Properties());
    public static final Item URANIUM_ORE = new BlockItem(ModBlocks.URANIUM_ORE, new Item.Properties());

    public static void register() {
        // Materials
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("uranium_ingot"), URANIUM_INGOT);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("steel_ingot"), STEEL_INGOT);
        
        // Ammo
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("ammo"), AMMO);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("fusion_cell"), FUSION_CELL);
        
        // Consumables
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("radaway"), RADAWAY);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("geiger_counter"), GEIGER_COUNTER);
        
        // Melee Weapons
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("combat_knife"), COMBAT_KNIFE);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("baseball_bat"), BASEBALL_BAT);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("super_sledge"), SUPER_SLEDGE);
        
        // Ranged Weapons
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("pipe_pistol"), PIPE_PISTOL);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("laser_rifle"), LASER_RIFLE);
        
        // Spawn Eggs
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("power_armor_spawn_egg"), POWER_ARMOR_SPAWN_EGG);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("ghoul_spawn_egg"), GHOUL_SPAWN_EGG);
        
        // Block Items
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("vault_steel_block"), VAULT_STEEL_BLOCK);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("vault_door"), VAULT_DOOR);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("nuclear_waste"), NUCLEAR_WASTE);
        Registry.register(BuiltInRegistries.ITEM, Uranium.of("uranium_ore"), URANIUM_ORE);
        
        Uranium.LOGGER.info("Registered mod items");
    }
}
