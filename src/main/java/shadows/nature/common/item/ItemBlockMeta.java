package shadows.nature.common.item;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemBlockMeta extends ItemBlock {

	public ItemBlockMeta(Block block) {
		super(block);
	}

	@Override
	public int getMetadata(int damage) {
		return damage;
	}

	@Override
    public String getUnlocalizedName(ItemStack stack)
    {
        return "item." + getUnlocalizedName() + stack.getMetadata();
    }
}