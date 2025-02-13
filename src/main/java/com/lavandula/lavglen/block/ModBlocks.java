package com.lavandula.lavglen.block;

import com.lavandula.lavglen.LavenderGlen;
import com.lavandula.lavglen.world.tree.ModSaplingGenerators;
import net.fabricmc.fabric.api.block.v1.FabricBlock;
import net.fabricmc.fabric.api.block.v1.FabricBlockState;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;


public class ModBlocks {




    // Tree stuff registration
    public static final Block MYSTWOOD_LOG = registerBlock("mystwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_log")))));
    public static final Block MYSTWOOD_WOOD = registerBlock("mystwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_wood")))));
    public static final Block STRIPPED_MYSTWOOD_LOG = registerBlock("stripped_mystwood_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_LOG)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "stripped_mystwood_log")))));
    public static final Block STRIPPED_MYSTWOOD_WOOD = registerBlock("stripped_mystwood_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.STRIPPED_OAK_WOOD)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "stripped_mystwood_wood")))));

    // Wood set - tree stuff



    public static final Block MYSTWOOD_PLANKS = registerBlock("mystwood_planks",
           new Block(AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_planks")))));


    public static final Block MYSTWOOD_STAIRS = registerBlock("mystwood_stairs",
            new StairsBlock(ModBlocks.MYSTWOOD_PLANKS.getDefaultState(), AbstractBlock.Settings.copy(Blocks.OAK_PLANKS)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_stairs")))));


    public static final Block MYSTWOOD_SLAB = registerBlock("mystwood_slab",
            new SlabBlock(AbstractBlock.Settings.copy(Blocks.OAK_SLAB)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_slab")))));




    public static final Block MYSTWOOD_LEAVES = registerBlock("mystwood_leaves",
            new LeavesBlock(AbstractBlock.Settings.copy(Blocks.OAK_LEAVES)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_leaves")))));

////ERROR TO BE COMPLETED LATER Sapling registration
    public static final Block MYSTWOOD_SAPLING = registerBlock("mystwood_sapling",
            new SaplingBlock(ModSaplingGenerators.MYSTWOOD, AbstractBlock.Settings.copy(Blocks.OAK_SAPLING)
                    .registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(LavenderGlen.MOD_ID, "mystwood_sapling")))));


//flower registration
    public static final Block LAVENDER_FLOWER_BLOCK = registerBlock("lavender_flower_block",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(LavenderGlen.MOD_ID, "lavender_flower_block"))).sounds(BlockSoundGroup.GRASS)
                    .breakInstantly().noCollision().nonOpaque()));

//Helper methods
    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(LavenderGlen.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(LavenderGlen.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(LavenderGlen.MOD_ID, name)))));

    }

    public static void registerModBlocks() {
        LavenderGlen.LOGGER.info("Registering Mod Blocks for " + LavenderGlen.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_PLANKS);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_LOG);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_WOOD);
            fabricItemGroupEntries.add(ModBlocks.STRIPPED_MYSTWOOD_LOG);
            fabricItemGroupEntries.add(ModBlocks.STRIPPED_MYSTWOOD_WOOD);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_SLAB);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_STAIRS);

        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.LAVENDER_FLOWER_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_LEAVES);
            fabricItemGroupEntries.add(ModBlocks.MYSTWOOD_SAPLING);

        });
    }
}
