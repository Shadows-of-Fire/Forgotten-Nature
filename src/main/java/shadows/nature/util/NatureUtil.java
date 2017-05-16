package shadows.nature.util;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class NatureUtil {

	public static Block getBlock(String regname) {
		return ForgeRegistries.BLOCKS.getValue(new ResourceLocation(regname));
	}

	public static Item getItem(String regname) {
		return ForgeRegistries.ITEMS.getValue(new ResourceLocation(regname));
	}

	/**
	 * Sets a custom ModelResourceLocation for this item.
	 * 
	 * @param item
	 *            An item.
	 * @param meta
	 *            The meta of the {@link ItemStack}.
	 * @param variant
	 *            The {@link IBlockState} variant to use.
	 */
	public static void sMRL(Item item, int meta, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName(), variant));
	}
	
	public static void sMRL(Item item, String suffix, int meta, String variant) {
		ModelLoader.setCustomModelResourceLocation(item, meta,
				new ModelResourceLocation(item.getRegistryName() + suffix, variant));
	}

	/**
	 * Sets a custom ModelResourceLocation for this block's ItemBlock
	 * 
	 * @param block
	 *            A block.
	 * @param meta
	 *            The meta of the ItemBlock.
	 * @param variant
	 *            The {@link IBlockState} variant to use.
	 */
	public static void sMRL(Block block, int meta, String variant) {
		sMRL(Item.getItemFromBlock(block), meta, variant);
	}
	
	/**
	 * Sets a custom ModelResourceLocation for this block's ItemBlock
	 * 
	 * @param block
	 *            A block.
	 * @param suffix  
	 *            A string to append to this block's Registry Name.
	 *          
	 * @param meta
	 *            The meta of the ItemBlock.
	 * @param variant
	 *            The {@link IBlockState} variant to use.
	 */
	public static void sMRL(Block block, String suffix, int meta, String variant) {
		sMRL(Item.getItemFromBlock(block), suffix, meta, variant);
	}

	public static void sMRL(Item item, int meta) {
		sMRL(item, meta, "inventory");
	}

	public static void sMRL(Item item) {
		sMRL(item, 0, "inventory");
	}

	public static void sMRLF(Item food, String variant) {
		ModelLoader.setCustomModelResourceLocation(food, 0,
				new ModelResourceLocation(new ResourceLocation(NatureData.MODID, "food"), "type=" + variant));
	}

}
