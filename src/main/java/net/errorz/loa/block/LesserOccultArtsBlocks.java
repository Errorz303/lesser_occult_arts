package net.errorz.loa.block;

import net.errorz.loa.LesserOccultArts;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;

public class LesserOccultArtsBlocks {

    public static final Block COVENANT_STONE_BLOCK = registerBlock("covenant_stone_block",
            new CovenantStoneBlock(FabricBlockSettings.of(Material.STONE).strength(4f).requiresTool()));














    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(LesserOccultArts.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registry.ITEM, new Identifier(LesserOccultArts.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        LesserOccultArts.LOGGER.debug("Registering ModBlocks for " + LesserOccultArts.MOD_ID);
    }
}
