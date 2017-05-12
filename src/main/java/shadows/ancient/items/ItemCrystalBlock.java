package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import shadows.ancient.FNBlocks;

public class ItemCrystalBlock extends ItemBlock {
	public static final String[] names = new String[] { "focuscrystal", "darkfocuscrystal", "crystalbricks",
			"darkcrystalbricks" };

	public ItemCrystalBlock(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.crystalBlock.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}
}