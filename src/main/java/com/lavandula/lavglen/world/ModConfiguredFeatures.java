package com.lavandula.lavglen.world;

import com.lavandula.lavglen.LavenderGlen;
import com.lavandula.lavglen.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;


public class ModConfiguredFeatures {

    public static final RegistryKey<ConfiguredFeature<?, ?>> MYSTWOOD_KEY = registerKey("mystwood");
    public static final RegistryKey<ConfiguredFeature<?, ?>> LAVENDER_KEY = registerKey("lavender");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {


        register(context, MYSTWOOD_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.MYSTWOOD_LOG),
                new StraightTrunkPlacer(4, 2, 0),

                BlockStateProvider.of(ModBlocks.MYSTWOOD_LEAVES),
                new BlobFoliagePlacer(ConstantIntProvider.create(3), ConstantIntProvider.create(0), 2),

                new TwoLayersFeatureSize(1, 0, 2)).build());

        register(context, LAVENDER_KEY, Feature.FLOWER,
                new RandomPatchFeatureConfig(
                        96, 6, 2, PlacedFeatures.createEntry(Feature.SIMPLE_BLOCK, new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.LAVENDER_FLOWER_BLOCK)))));

    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(LavenderGlen.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
