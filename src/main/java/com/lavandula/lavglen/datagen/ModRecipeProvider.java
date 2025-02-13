package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {

            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                new BlockFamily.Builder(ModBlocks.MYSTWOOD_PLANKS)
                        .slab(ModBlocks.MYSTWOOD_SLAB);



                offerShapelessRecipe(
                        ModBlocks.MYSTWOOD_PLANKS,
                        ModBlocks.MYSTWOOD_LOG,
                        "planks",
                        4);
                offerShapelessRecipe(
                        ModBlocks.MYSTWOOD_PLANKS,
                        ModBlocks.MYSTWOOD_WOOD,
                        "planks",
                        4);




                offerSlabRecipe(
                        RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.MYSTWOOD_SLAB,
                        ModBlocks.MYSTWOOD_PLANKS
                );




//              I need to have the stairs recipe, but not until the wood is generated in the world so that I can use create recipe instead of offer bc create has validation


            }
        };
    }




    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
