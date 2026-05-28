package ngcsonsplash.fabricaeexnihilo.modules;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ToolMaterials;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlock;
import ngcsonsplash.fabricaeexnihilo.modules.barrels.BarrelBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.base.EnchantableBlockItem;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlock;
import ngcsonsplash.fabricaeexnihilo.modules.crucibles.CrucibleBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestedLeavesBlock;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestedLeavesItem;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestingLeavesBlock;
import ngcsonsplash.fabricaeexnihilo.modules.infested.InfestingLeavesBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.other.EndCakeBlock;
import ngcsonsplash.fabricaeexnihilo.modules.sieves.SieveBlock;
import ngcsonsplash.fabricaeexnihilo.modules.sieves.SieveBlockEntity;
import ngcsonsplash.fabricaeexnihilo.modules.strainer.StrainerBlock;
import ngcsonsplash.fabricaeexnihilo.modules.strainer.StrainerBlockEntity;

import java.util.LinkedHashMap;
import java.util.Map;

import static ngcsonsplash.fabricaeexnihilo.FabricaeExNihilo.id;


public final class ModBlocks {
    public static final Map<Identifier, BarrelBlock> BARRELS = new LinkedHashMap<>();
    public static final Map<Identifier, CrucibleBlock> CRUCIBLES = new LinkedHashMap<>();
    public static final Map<Identifier, Block> CRUSHED = new LinkedHashMap<>();
    public static final EndCakeBlock END_CAKE = new EndCakeBlock(AbstractBlock.Settings.copy(Blocks.CAKE));
    public static final Map<Identifier, InfestedLeavesBlock> INFESTED_LEAVES = new LinkedHashMap<>();
    public static final AbstractBlock.Settings INFESTED_LEAVES_SETTINGS = AbstractBlock.Settings.create().mapColor(MapColor.WHITE).nonOpaque().suffocates((state, world, pos) -> false).allowsSpawning((state, world, pos, type) -> type == EntityType.OCELOT || type == EntityType.PARROT).strength(0.2F).ticksRandomly().sounds(BlockSoundGroup.GRASS);
    public static final InfestingLeavesBlock INFESTING_LEAVES = new InfestingLeavesBlock(INFESTED_LEAVES_SETTINGS);
    public static final Map<Identifier, SieveBlock> SIEVES = new LinkedHashMap<>();
    public static final Map<Identifier, StrainerBlock> STRAINERS = new LinkedHashMap<>();

    public static void registerBlockEntities() {
        Registry.register(Registries.BLOCK_ENTITY_TYPE, SieveBlockEntity.BLOCK_ENTITY_ID, SieveBlockEntity.TYPE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, CrucibleBlockEntity.BLOCK_ENTITY_ID, CrucibleBlockEntity.TYPE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, StrainerBlockEntity.BLOCK_ENTITY_ID, StrainerBlockEntity.TYPE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, BarrelBlockEntity.BLOCK_ENTITY_ID, BarrelBlockEntity.TYPE);
        Registry.register(Registries.BLOCK_ENTITY_TYPE, InfestingLeavesBlockEntity.BLOCK_ENTITY_ID, InfestingLeavesBlockEntity.TYPE);
    }

    public static void registerBlockItems() {
        SIEVES.forEach((identifier, block) -> Registry.register(Registries.ITEM, identifier, new BlockItem(block, ModItems.BASE_SETTINGS)));
        CRUCIBLES.forEach((identifier, block) -> {
            var enchantability = block.getDefaultMapColor() == MapColor.STONE_GRAY
                ? ToolMaterials.STONE.getEnchantability()
                : ToolMaterials.WOOD.getEnchantability();
            Registry.register(Registries.ITEM, identifier, new EnchantableBlockItem(block, ModItems.BASE_SETTINGS, enchantability));
        });
        BARRELS.forEach((identifier, block) -> {
            var enchantability = block.getDefaultMapColor() == MapColor.STONE_GRAY
                ? ToolMaterials.STONE.getEnchantability()
                : ToolMaterials.WOOD.getEnchantability();
            Registry.register(Registries.ITEM, identifier, new EnchantableBlockItem(block, ModItems.BASE_SETTINGS, enchantability));
        });
        CRUSHED.forEach((identifier, block) -> Registry.register(Registries.ITEM, identifier, new BlockItem(block, ModItems.BASE_SETTINGS)));
        STRAINERS.forEach((identifier, block) -> Registry.register(Registries.ITEM, identifier, new BlockItem(block, ModItems.BASE_SETTINGS)));
        INFESTED_LEAVES.forEach((identifier, block) -> Registry.register(Registries.ITEM, identifier, new InfestedLeavesItem(block, ModItems.BASE_SETTINGS)));
    }

    public static void registerBlocks() {
        SIEVES.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        CRUCIBLES.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        BARRELS.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        CRUSHED.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        INFESTED_LEAVES.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        STRAINERS.forEach((identifier, block) -> Registry.register(Registries.BLOCK, identifier, block));
        Registry.register(Registries.BLOCK, id("infesting_leaves"), INFESTING_LEAVES);
        Registry.register(Registries.BLOCK, id("end_cake"), END_CAKE);

        ModFluids.registerFluidBlocks();
    }

}
