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

public class ItemTorch extends ItemBlock {
	Block currentBlock;

	public ItemTorch(Block i) {
		super(i);
		setMaxDamage(0);
		setHasSubtypes(true);
		currentBlock = i;
	}

	public IIcon getIconFromDamage(int i) {
		return currentBlock.getIcon(0, i);
	}

	public int getMetadata(int i) {
		return i;
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(int ii, CreativeTabs tabs, List list) {
		list.add(new ItemStack(Item.getItemById(ii), 1, 0));
	}
}
