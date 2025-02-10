package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.MYSTWOOD_PLANKS);
        addDrop(ModBlocks.LAVENDER_FLOWER_BLOCK);
        addDrop(ModBlocks.MYSTWOOD_LOG);
        addDrop(ModBlocks.MYSTWOOD_WOOD);
        addDrop(ModBlocks.STRIPPED_MYSTWOOD_LOG);
        addDrop(ModBlocks.STRIPPED_MYSTWOOD_WOOD);
        addDrop(ModBlocks.MYSTWOOD_SAPLING);
        addDrop(ModBlocks.MYSTWOOD_LEAVES); // need to add the sapling, sticks, etc, later.

        addDrop(ModBlocks.MYSTWOOD_SLAB);


//        addDrop(ModBlocks.MYSTWOOD_STAIRS);

    }
}