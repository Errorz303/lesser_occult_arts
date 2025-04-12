package net.errorz.loa.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.World;

public class CovenantStoneBlock extends Block {
    public CovenantStoneBlock(AbstractBlock.Settings settings) {
        super(settings);
    }






    public VoxelShape getOutlineShape(BlockState state, World world, BlockPos pos, ShapeContext context) {
        return createCuboidShape(4.0, 0.0, 4.0, 16.0, 48.0, 16.0);
    }

}
