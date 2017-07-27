package shadows.nature.Items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemNewLogs3 extends ItemBlock {
	public static final String[] names = new String[] { "bukkitlog", "bananalog", "orangelog", "peachlog", "lemonlog", "*bukkitlog", "*bananalog", "*orangelog", "*peachlog", "*lemonlog", "bukkitlog*", "bananalog*", "oranglog*", "peachlog*", "lemonlog*" };

	public ItemNewLogs3(Block i) {
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
}