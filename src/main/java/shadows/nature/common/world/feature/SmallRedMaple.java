package shadows.nature.common.world.feature;

import java.util.Random;

import net.minecraft.block.BlockLog;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;
import shadows.nature.util.NatureData.TREE_TYPES_1;

public class SmallRedMaple implements INatureFeature{

	private static final IBlockState logX = Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.X);
	private static final IBlockState logY = Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Y);
	private static final IBlockState logZ = Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.Z);
	private static final IBlockState leaf = NatureBlocks.LEAF_1.getDefaultState().withProperty(NatureData.TYPE_1, TREE_TYPES_1.RED_MAPLE);
	
	private static final IBlockState getLogByAxis(EnumFacing face){
		return Blocks.LOG.getDefaultState().withProperty(BlockLog.LOG_AXIS, EnumAxis.fromFacingAxis(face.getAxis()));
	}
	
	public SmallRedMaple(World world, BlockPos pos){
		if(canGenerate(world, pos)) create(world, pos);
	}
	
	@Override
	public boolean canGenerate(World world, BlockPos pos) {
		return true;
	}

	@Override
	public void create(World world, BlockPos pos){
		
		int k = world.rand.nextInt(4);
		EnumFacing face = EnumFacing.HORIZONTALS[k];
		EnumFacing face2 = EnumFacing.HORIZONTALS[k - 1 == -1 ? 4 : k];
		
		NatureUtil.sBS(world, pos, logY);
		pos = pos.up();
		
		NatureUtil.sBS(world, pos, logY);
		pos = pos.up();
		
		NatureUtil.sBS(world, pos, logY);
		for(int i = 1; i <= 3; i++){ NatureUtil.sBS(world, pos.offset(face, i).offset(face2), leaf);}
		NatureUtil.sBS(world, pos.offset(face, 2), leaf);
		NatureUtil.sBS(world, pos.offset(face, 2).offset(face2, 2), leaf);
		pos = pos.up();
		
		NatureUtil.sBS(world, pos, logY);
		NatureUtil.sBS(world, pos.offset(face.getOpposite()), getLogByAxis(face));
		NatureUtil.sBS(world, pos.offset(face.getOpposite(), 2), leaf);
		for(int i = 1; i <= 3; i++){
			for(int j = -1; j <= 1; j++){
				NatureUtil.sBS(world, pos.offset(face, i).offset(face2, j), leaf);
			}
		}
		NatureUtil.sBS(world, pos.offset(face.getOpposite()).offset(face2.getOpposite()), leaf);
		
	}

}
