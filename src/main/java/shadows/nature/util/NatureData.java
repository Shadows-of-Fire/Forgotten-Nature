package shadows.nature.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;

public class NatureData {
	
	public static final String VERSION = "2.0.0";
	public static final String MODID = "forgottennature";
	public static final String NAME = "Forgotten Nature";
	public static final CreativeTabs TAB = new CreativeTabs(MODID) {

		@Override
		public ItemStack getTabIconItem() {
			return new ItemStack(Blocks.SAPLING);
		}

	};
}
