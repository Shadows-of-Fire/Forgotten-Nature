package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class ItemOre extends ItemBlock {
	public static final String[] names1 = new String[] { "barite", "bertrandite", "erythrite", "molybdenite", "stibnite", "monazite", "feldspar", "fluorite", "halite", "pentlandite", "petalite", "pyrite" };
	public static final String[] names2 = new String[] { "bauxite", "galena", "chromite", "malachite", "pyrolusite", "PGMore", "sulfur", "tantalite", "ilmenite", "tungsten", "uranium", "sphalerite", "tin" };

	public ItemOre(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		if (Block.getBlockFromItem(this) == FNBlocks.newOres1)
			return super.getUnlocalizedName() + "." + names1[p1.getItemDamage()];
		else
			return super.getUnlocalizedName() + "." + names2[p1.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		if (Block.getBlockFromItem(this) == FNBlocks.newOres1)
			return FNBlocks.newOres1.getIcon(0, i);
		else
			return FNBlocks.newOres2.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}
}
