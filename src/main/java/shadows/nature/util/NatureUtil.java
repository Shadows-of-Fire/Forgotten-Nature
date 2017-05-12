package shadows.nature.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NatureUtil {

	public static Block getBlock(String regname) {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(regname));
	}

	public static Item getItem(String regname) {
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(regname));
	}
	
}
