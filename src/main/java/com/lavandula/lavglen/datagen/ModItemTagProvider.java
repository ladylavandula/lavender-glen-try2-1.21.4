package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PLANKS)
                .add(ModBlocks.MYSTWOOD_PLANKS.asItem());

        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS)
                .add(ModBlocks.LAVENDER_FLOWER_BLOCK.asItem());

        getOrCreateTagBuilder(ItemTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTWOOD_LOG.asItem())
                .add(ModBlocks.MYSTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MYSTWOOD_WOOD.asItem())
                .add(ModBlocks.STRIPPED_MYSTWOOD_LOG.asItem());

        getOrCreateTagBuilder(ItemTags.LEAVES)
                .add(ModBlocks.MYSTWOOD_LEAVES.asItem());

        getOrCreateTagBuilder(ItemTags.SAPLINGS)
                .add(ModBlocks.MYSTWOOD_SAPLING.asItem());

        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS)
                .add(ModBlocks.MYSTWOOD_SLAB.asItem());

//        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS)
//                .add(ModBlocks.MYSTWOOD_STAIRS.asItem());


    }
}
