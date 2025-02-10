package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MYSTWOOD_PLANKS);

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.LAVENDER_FLOWER_BLOCK);

        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTWOOD_LOG)
                .add(ModBlocks.MYSTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_MYSTWOOD_LOG)
                .add(ModBlocks.STRIPPED_MYSTWOOD_WOOD);


        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.MYSTWOOD_SLAB);

//        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
//                .add(ModBlocks.MYSTWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.MYSTWOOD_LEAVES);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MYSTWOOD_SAPLING);
    }
}
