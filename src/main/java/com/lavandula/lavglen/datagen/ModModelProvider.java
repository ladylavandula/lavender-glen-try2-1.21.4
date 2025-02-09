package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.TexturedModel;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.MYSTWOOD_PLANKS);
        blockStateModelGenerator.registerLog(ModBlocks.MYSTWOOD_LOG).log(ModBlocks.MYSTWOOD_LOG).wood(ModBlocks.MYSTWOOD_WOOD);
        blockStateModelGenerator.registerLog(ModBlocks.STRIPPED_MYSTWOOD_LOG).log(ModBlocks.STRIPPED_MYSTWOOD_LOG).wood(ModBlocks.STRIPPED_MYSTWOOD_WOOD);

        blockStateModelGenerator.registerTintableCross(ModBlocks.LAVENDER_FLOWER_BLOCK, BlockStateModelGenerator.CrossType.NOT_TINTED );
        blockStateModelGenerator.registerSingleton(ModBlocks.MYSTWOOD_LEAVES, TexturedModel.LEAVES);


    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}