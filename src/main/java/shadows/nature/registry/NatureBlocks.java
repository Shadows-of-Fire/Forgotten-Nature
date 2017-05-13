package shadows.nature.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import shadows.nature.common.block.BlockMetaLeaves;

public class NatureBlocks {

	private static List<Block> NATURE_REGISTRY = new ArrayList<Block>();

	public static final Block LEAF_1 = new BlockMetaLeaves("leaf");

	public static List<Block> getBlocks() {
		return NATURE_REGISTRY;
	}

	public static void add(Block block) {
		NATURE_REGISTRY.add(block);
	}

}
