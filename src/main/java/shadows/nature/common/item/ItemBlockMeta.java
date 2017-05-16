package shadows.nature.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock /* Does not implement IHasModelLocation as it's handled by the block. */ {

	public ItemBlockMeta(Block block) {
		super(block);
		setHasSubtypes(true);
		setMaxDamage(0);
		setRegistryName(block.getRegistryName());
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		return "item." + getUnlocalizedName() + "." + stack.getMetadata();
	}
}