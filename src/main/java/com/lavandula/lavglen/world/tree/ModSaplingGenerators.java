package com.lavandula.lavglen.world.tree;

import com.lavandula.lavglen.LavenderGlen;
import com.lavandula.lavglen.world.ModConfiguredFeatures;
import net.minecraft.block.SaplingGenerator;

import java.util.Optional;

public class ModSaplingGenerators {
    public static final SaplingGenerator MYSTWOOD = new SaplingGenerator(LavenderGlen.MOD_ID + ":mystwood",
            Optional.empty(), Optional.of(ModConfiguredFeatures.MYSTWOOD_KEY), Optional.empty());
}
