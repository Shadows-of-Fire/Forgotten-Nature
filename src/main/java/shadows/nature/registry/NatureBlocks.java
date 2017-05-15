package shadows.nature.registry;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.block.Block;
import shadows.nature.common.block.BlockEnumLog;
import shadows.nature.common.block.BlockMetaLeaves;
import shadows.nature.util.NatureData;

public class NatureBlocks {

	private static List<Block> NATURE_REGISTRY = new ArrayList<Block>();

	public static final Block LEAF_1 = new BlockMetaLeaves("leaf");
	public static final Block LOG_1 = new BlockEnumLog<NatureData.LogSet1>("log1", NatureData.LogSet1.class);
	public static final Block LOG_2 = new BlockEnumLog<NatureData.LogSet2>("log2", NatureData.LogSet2.class);
	public static final Block LOG_3 = new BlockEnumLog<NatureData.LogSet3>("log3", NatureData.LogSet3.class);
	public static final Block LOG_4 = new BlockEnumLog<NatureData.LogSet4>("log4", NatureData.LogSet4.class);

	public static List<Block> getBlocks() {
		return NATURE_REGISTRY;
	}

	public static void add(Block block) {
		NATURE_REGISTRY.add(block);
	}

}
