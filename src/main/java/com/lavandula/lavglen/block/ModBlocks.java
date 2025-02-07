package com.lavandula.lavglen.block;

import com.lavandula.lavglen.LavenderGlen;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
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
    public static final Block MYSTWOOD_PLANKS = registerBlock("mystwood_planks",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(LavenderGlen.MOD_ID, "mystwood_planks"))).sounds(BlockSoundGroup.WOOD).strength(2)));

    public static final Block LAVENDER_FLOWER_BLOCK = registerBlock("lavender_flower_block",
            new Block(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK,
                    Identifier.of(LavenderGlen.MOD_ID, "lavender_flower_block"))).sounds(BlockSoundGroup.GRASS)
                    .breakInstantly().noCollision().nonOpaque()));


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
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.LAVENDER_FLOWER_BLOCK);
        });
    }
}
