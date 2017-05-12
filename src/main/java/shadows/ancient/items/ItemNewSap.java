package shadows.nature.Items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class ItemNewSap extends ItemBlock {
	Block blk;
	public static final String[] names1 = new String[] { "desertironwoodsapling", "cherrysappling", "redmaplesapling",
			"angeloaksapling", "yellowmaplesapling", "jacarandasapling", "applesapling", "eucalyptussapling",
			"sequoiasapling", "figsapling", "cypresssapling", "dummy", "joshuasapling", "swampwillowsapling",
			"deciduoubushling", "evergreenbushling" };
	public static final String[] names2 = new String[] { "palmsapling", "desertwillowsapling", "cedarsapling",
			"ginkgosapling", "poplarsapling", "beechsapling", "walnutsapling", "dummy", "widtopeucalyptussapling",
			"bukkitsapling", "bananasapling", "orangesapling", "peachsapling", "lemonsapling", "blueberrybushling",
			"raspberrysapling" };
	public static final String[] names3 = new String[] { "huckleberrybushling", "blackberrybushling", "crystalsapling",
			"netherashsapling", "netherblazesapling", "nethermushroom" };

	public ItemNewSap(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		blk = i;
	}

	public String getUnlocalizedName(ItemStack p1) {
		if (blk == FNBlocks.fNSapling1)
			return super.getUnlocalizedName() + "." + names1[p1.getItemDamage()];
		else if (blk == FNBlocks.fNSapling2)
			return super.getUnlocalizedName() + "." + names2[p1.getItemDamage()];
		else
			return super.getUnlocalizedName() + "." + names3[p1.getItemDamage()];
	}

	public IIcon getIconFromDamage(int i) {
		if (blk == FNBlocks.fNSapling1) {
			return FNBlocks.fNSapling1.getIcon(0, i);
		} else if (blk == FNBlocks.fNSapling2) {
			return FNBlocks.fNSapling2.getIcon(0, i);
		} else
			return FNBlocks.fNSapling3.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item i, CreativeTabs tabs, List list) {
		if (blk == FNBlocks.fNSapling1) {
			for (int j = 0; j < 16; j++) {
				if (j != 11)
					list.add(new ItemStack(i, 1, j));
			}
		} else if (blk == FNBlocks.fNSapling2) {
			for (int j = 0; j < 16; j++) {
				if (j != 7)
					list.add(new ItemStack(i, 1, j));
			}
		} else {
			for (int j = 0; j < 6; j++) {
				list.add(new ItemStack(i, 1, j));
			}
		}
	}
}
