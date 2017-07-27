package shadows.nature.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class BlockNewStairs extends BlockStairs {
	private static final int[][] field = new int[][] { { 2, 6 }, { 3, 7 }, { 2, 3 }, { 6, 7 }, { 0, 4 }, { 1, 5 }, { 0, 1 }, { 4, 5 } };
	private boolean bool1;
	private int i2;
	private static final String __OBFID = "CL_00000314";
	private Block block;

	public BlockNewStairs(Block block1, int i1) {
		super(block1, i1);
		this.setHardness(2.0F);
		this.setResistance(5F / 3.0F);
		this.setStepSound(block1.stepSound);
		this.setLightOpacity(255);
		block = block1;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		if (block == FNBlocks.crystalWood || block == FNBlocks.crystalBlock)
			return 1;
		else
			return 0;
	}

	public boolean isOpaqueCube() {
		return false;
	}
}