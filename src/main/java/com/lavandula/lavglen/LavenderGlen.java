package com.lavandula.lavglen;

import com.lavandula.lavglen.block.ModBlocks;
import com.lavandula.lavglen.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.fabricmc.fabric.api.registry.StrippableBlockRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LavenderGlen implements ModInitializer {
	public static final String MOD_ID = "lavglen";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();

		StrippableBlockRegistry.register(ModBlocks.MYSTWOOD_LOG, ModBlocks.STRIPPED_MYSTWOOD_LOG);
		StrippableBlockRegistry.register(ModBlocks.MYSTWOOD_WOOD, ModBlocks.STRIPPED_MYSTWOOD_WOOD);

		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MYSTWOOD_LOG, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.STRIPPED_MYSTWOOD_WOOD, 5, 5);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_PLANKS, 5, 20);
		FlammableBlockRegistry.getDefaultInstance().add(ModBlocks.MYSTWOOD_LEAVES, 30, 60);


		ModWorldGeneration.generateModWorldGen();
	}
}