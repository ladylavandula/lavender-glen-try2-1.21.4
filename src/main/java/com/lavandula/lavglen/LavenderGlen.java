package com.lavandula.lavglen;

import com.lavandula.lavglen.block.ModBlocks;
import com.lavandula.lavglen.world.ModConfiguredFeatures;
import com.lavandula.lavglen.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.fabricmc.fabric.api.event.player.UseItemCallback;
import net.fabricmc.fabric.api.registry.CompostingChanceRegistry;
import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LavenderGlen implements ModInitializer {
	public static final String MOD_ID = "lavglen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();

		ModWorldGeneration.generateModWorldGen();

		//Making things compostable at percent chance (0.3f =30%)
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.MYSTWOOD_LEAVES.asItem(), 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.MYSTWOOD_SAPLING.asItem(), 0.3f);
		CompostingChanceRegistry.INSTANCE.add(ModBlocks.LAVENDER_FLOWER_BLOCK.asItem(), 0.65f);

		StrippableBlockRegistry.register(ModBlocks.MYSTWOOD_LOG, ModBlocks.STRIPPED_MYSTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.MYSTWOOD_WOOD, ModBlocks.STRIPPED_MYSTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MYSTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MYSTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_LEAVES, 30, 60);




	}
}


