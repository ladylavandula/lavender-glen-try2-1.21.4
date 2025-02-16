package com.lavandula.lavglen.datagen;

import com.jcraft.jorbis.Block;
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

        //Flowers

        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS)
                .add(ModBlocks.LAVENDER_FLOWER_BLOCK);

        getOrCreateTagBuilder(BlockTags.FLOWERS)
                .add(ModBlocks.LAVENDER_FLOWER_BLOCK);

        // Tree Stuff
        getOrCreateTagBuilder(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MYSTWOOD_LOG)
                .add(ModBlocks.MYSTWOOD_WOOD)
                .add(ModBlocks.STRIPPED_MYSTWOOD_LOG)
                .add(ModBlocks.STRIPPED_MYSTWOOD_WOOD);

        getOrCreateTagBuilder(BlockTags.LEAVES)
                .add(ModBlocks.MYSTWOOD_LEAVES);

        getOrCreateTagBuilder(BlockTags.SAPLINGS)
                .add(ModBlocks.MYSTWOOD_SAPLING);

        //Woodset

        getOrCreateTagBuilder(BlockTags.PLANKS)
                .add(ModBlocks.MYSTWOOD_PLANKS);

        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS)
                .add(ModBlocks.MYSTWOOD_SLAB);

        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS)
                .add(ModBlocks.MYSTWOOD_STAIRS);

        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES)
                .add(ModBlocks.MYSTWOOD_FENCE);

        getOrCreateTagBuilder(BlockTags.FENCE_GATES)
                .add(ModBlocks.MYSTWOOD_FENCE_GATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS)
                .add(ModBlocks.MYSTWOOD_DOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_TRAPDOORS)
                .add(ModBlocks.MYSTWOOD_TRAPDOOR);

        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES)
                .add(ModBlocks.MYSTWOOD_PRESSURE_PLATE);

        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS)
                .add(ModBlocks.MYSTWOOD_BUTTON);




    }
}
