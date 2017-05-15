package shadows.nature.common.world.gen;

import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenTrees;

public class TreeRedMaple extends WorldGenTrees {

	/** The minimum height of a generated tree. */
	private final int minTreeHeight;
	/** True if this tree should grow Vines. */
	private final boolean vinesGrow;
	/** The metadata value of the wood to use in tree generation. */
	private final IBlockState metaWood;
	/** The metadata value of the leaves to use in tree generation. */
	private final IBlockState metaLeaves;

	public TreeRedMaple(boolean notify, int minHeight, IBlockState log, IBlockState leaf, boolean vines) {
		super(notify);
		this.minTreeHeight = minHeight;
		this.metaWood = log;
		this.metaLeaves = leaf;
		this.vinesGrow = vines;
	}
}
