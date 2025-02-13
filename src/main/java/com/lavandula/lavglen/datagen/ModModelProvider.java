package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;
import net.minecraft.client.data.TexturedModel;
import net.minecraft.data.family.BlockFamily;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.MYSTWOOD_PLANKS)
                .slab(ModBlocks.MYSTWOOD_SLAB)
                .stairs(ModBlocks.MYSTWOOD_STAIRS);


        new BlockFamily.Builder(ModBlocks.MYSTWOOD_PLANKS)
                .slab(ModBlocks.MYSTWOOD_SLAB)
                .stairs(ModBlocks.MYSTWOOD_STAIRS);




        blockStateModelGenerator.registerLog(ModBlocks.MYSTWOOD_LOG).log(ModBlocks.MYSTWOOD_LOG).wood(ModBlocks.MYSTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MYSTWOOD_LOG).log(ModBlocks.STRIPPED_MYSTWOOD_LOG).wood(ModBlocks.STRIPPED_MYSTWOOD_WOOD);

        blockStateModelGenerator.registerTintableCross(ModBlocks.LAVENDER_FLOWER_BLOCK, BlockStateModelGenerator.CrossType.NOT_TINTED );
        blockStateModelGenerator.registerSingleton(ModBlocks.MYSTWOOD_LEAVES, TexturedModel.LEAVES);
        blockStateModelGenerator.registerTintableCrossBlockState(ModBlocks.MYSTWOOD_SAPLING, BlockStateModelGenerator.CrossType.NOT_TINTED);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModBlocks.MYSTWOOD_SAPLING.asItem(), Models.GENERATED);

    }
}