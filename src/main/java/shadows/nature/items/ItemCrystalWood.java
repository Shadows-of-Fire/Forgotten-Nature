package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import shadows.nature.FNBlocks;

public class ItemCrystalWood extends ItemBlock {
	public static String[] names = { "crystalLog", "darkcrystallog", "crystalPlank", "darkCrystalPlank" };

	public ItemCrystalWood(Block i) {
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

	public int getPlacedBlockMetadata(int damage) {
		return damage;
	}

	public IIcon getIconFromDamage(int i) {
		return FNBlocks.crystalWood.getIcon(0, i);
	}
}