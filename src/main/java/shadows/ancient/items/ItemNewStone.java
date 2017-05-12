package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import shadows.ancient.FNBlocks;

public class ItemNewStone extends ItemBlock {
	public static final String[] names = new String[] { "chert", "granite", "gneiss", "hornfels", "marble",
			"granitebricks", "gneissbricks", "hornfelsbricks", "marblebricks", "titanstone" };

	public ItemNewStone(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.newStones.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}
}