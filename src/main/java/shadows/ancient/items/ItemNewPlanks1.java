package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import shadows.ancient.FNBlocks;

public class ItemNewPlanks1 extends ItemBlock {
	public static final String[] names = new String[] { "brownplank", "purpleplank", "darkredplank", "darkyellowplank",
			"peachplank", "orangeplank", "brightwoodplank", "redwoodplank", "dummy", "brightyellowplank",
			"oldwoodplank", "bambooplank", "driedbambooplank", "netherblazeplank", "netherashplank" };

	public ItemNewPlanks1(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public int getMetadata(int i) {
		return i;
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.newPlanks1.getIcon(0, i);
	}
}