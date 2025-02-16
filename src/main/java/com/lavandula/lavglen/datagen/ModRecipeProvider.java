package com.lavandula.lavglen.datagen;

import com.lavandula.lavglen.LavenderGlen;
import com.lavandula.lavglen.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.family.BlockFamily;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.List;

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

                //Flower
                createShapeless(RecipeCategory.MISC, Items.PURPLE_DYE,2)
                        .input(ModBlocks.LAVENDER_FLOWER_BLOCK)
                        .criterion(hasItem(ModBlocks.LAVENDER_FLOWER_BLOCK), conditionsFromItem(ModBlocks.LAVENDER_FLOWER_BLOCK))
                        .offerTo(exporter);

                //WoodStuff

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTWOOD_PLANKS, 4)
                        .input(ModBlocks.MYSTWOOD_LOG)
                        .criterion(hasItem(ModBlocks.MYSTWOOD_LOG), conditionsFromItem(ModBlocks.MYSTWOOD_LOG))
                        .offerTo(exporter);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTWOOD_PLANKS, 4)
                        .input(ModBlocks.MYSTWOOD_WOOD)
                        .criterion(hasItem(ModBlocks.MYSTWOOD_WOOD), conditionsFromItem(ModBlocks.MYSTWOOD_WOOD))
                        .offerTo(exporter, String.valueOf(Identifier.of(LavenderGlen.MOD_ID, "mystwood_planks_from_mystwood_wood")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTWOOD_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_MYSTWOOD_LOG)
                        .criterion(hasItem(ModBlocks.STRIPPED_MYSTWOOD_LOG), conditionsFromItem(ModBlocks.STRIPPED_MYSTWOOD_LOG))
                        .offerTo(exporter, String.valueOf(Identifier.of(LavenderGlen.MOD_ID, "mystwood_planks_from_stripped_mystwood_log")));

                createShapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTWOOD_PLANKS, 4)
                        .input(ModBlocks.STRIPPED_MYSTWOOD_WOOD)
                        .criterion(hasItem(ModBlocks.STRIPPED_MYSTWOOD_WOOD), conditionsFromItem(ModBlocks.STRIPPED_MYSTWOOD_WOOD))
                        .offerTo(exporter, String.valueOf(Identifier.of(LavenderGlen.MOD_ID, "mystwood_planks_from_stripped_mystwood_wood")));



                createStairsRecipe(ModBlocks.MYSTWOOD_STAIRS, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createSlabRecipe(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MYSTWOOD_SLAB, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has_planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createFenceRecipe(ModBlocks.MYSTWOOD_FENCE, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                                .offerTo(exporter);

                createFenceGateRecipe(ModBlocks.MYSTWOOD_FENCE_GATE, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createDoorRecipe(ModBlocks.MYSTWOOD_DOOR, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createTrapdoorRecipe(ModBlocks.MYSTWOOD_TRAPDOOR, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createPressurePlateRecipe(RecipeCategory.REDSTONE,ModBlocks.MYSTWOOD_PRESSURE_PLATE, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                        .criterion("has planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);

                createButtonRecipe(ModBlocks.MYSTWOOD_BUTTON, Ingredient.ofItem(ModBlocks.MYSTWOOD_PLANKS))
                    .criterion("has_planks", conditionsFromItem(ModBlocks.MYSTWOOD_PLANKS))
                        .offerTo(exporter);



            }
        };
    }




    @Override
    public String getName() {
        return "ModRecipeProvider";
    }
}
