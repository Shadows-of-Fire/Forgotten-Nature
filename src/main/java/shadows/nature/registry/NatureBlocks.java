package shadows.nature.registry;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import shadows.nature.common.block.BlockBasic;

public class NatureBlocks {
	
	private static List<Block> NATURE_REGISTRY = new ArrayList<Block>();

	
	public static final Block TEST_DUMMY = new BlockBasic("test", Material.ANVIL, 0, 0, null);
	
	
	public static List<Block> getBlocks(){
		return NATURE_REGISTRY;
	}
	
	public static void add(Block block){
		NATURE_REGISTRY.add(block);
	}
	
}
