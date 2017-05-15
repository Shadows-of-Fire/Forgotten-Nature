package shadows.nature.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NatureUtil {

	public static Block getBlock(String regname) {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(regname));
	}

	public static Item getItem(String regname) {
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(regname));
	}

	public static void sMRL(Block block, int meta, String variant) {
		// System.out.println("Setting model resource location for Block: " +
		// block.getRegistryName() + " with variant string " + variant + " and
		// declaring " + block.getClass().toString());
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
				new ModelResourceLocation(block.getRegistryName(), variant));
	}

	public static void sMRL(Item item, int meta, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), variant));
	}
}
