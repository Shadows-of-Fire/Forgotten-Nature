package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import shadows.ancient.FNBlocks;

public class ItemNewGlass extends ItemBlock {
	public static final String[] names = new String[] { "blacklattice", "wide3x3", "ramedwide3x3", "3x3", "framed3x3",
			"doublediamond", "pinwheel", "2x2", "framed2x2", "diamondlattice", "doublelattice", "squarelattice",
			"peakingwindow", "circle", "doubledoor", "2x1" };

	public ItemNewGlass(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.FNGlass.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}
}