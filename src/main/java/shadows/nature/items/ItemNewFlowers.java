package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class ItemNewFlowers extends ItemBlock {
	public static final String[] names = new String[] { "alliumDrumstick", "bachelorsbutton", "billybuttons",
			"delphiniumbelladonna", "fernfloweryarrow", "gerberadaisy", "hydrangea", "redrover", "snapdragon",
			"starofbethlehem" };

	public ItemNewFlowers(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	public String getUnlocalizedName(ItemStack p1) {
		return super.getUnlocalizedName() + "." + names[p1.getItemDamage()];
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int i) {
		return FNBlocks.fNFlowers.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i & 15;
	}

	public int getPlacedBlockMetadata(int damage) {
		return damage;
	}
}
