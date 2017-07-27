package shadows.nature.common.world.feature;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;

public class Bush extends WorldGenAbstractTree {

	private final IBlockState log;
	private final IBlockState leaf;

	public Bush(IBlockState log, IBlockState leaf, boolean notify) {
		super(notify);
		this.log = log;
		this.leaf = leaf;
	}

	@Override
	public boolean generate(World world, Random rand, BlockPos pos) {
		this.setBlockAndNotifyAdequately(world, pos, log);
		for (int i = 0; i < 4; i++) {
			EnumFacing face = EnumFacing.HORIZONTALS[i];
			EnumFacing face2 = EnumFacing.HORIZONTALS[i + 1 == 4 ? 0 : i + 1];
			for (int k = -1; k < 2; k++) {
				this.checkAndLeaf(world, pos.offset(face).offset(face2, k));
				if (k == 0)
					this.checkAndLeaf(world, pos.offset(face, 2));
			}
			this.checkAndLeaf(world, pos.offset(face).up());
		}
		this.checkAndLeaf(world, pos.up());
		return true;
	}

	private void checkAndLeaf(World world, BlockPos pos) {
		if (this.isReplaceable(world, pos))
			this.setBlockAndNotifyAdequately(world, pos, leaf);
	}

	@Override
	public boolean isReplaceable(World world, BlockPos pos) {
		IBlockState state = world.getBlockState(pos);
		return state.getBlock().isAir(state, world, pos) || state.getBlock().isLeaves(state, world, pos) || state.getBlock().isReplaceable(world, pos);
	}

}
