package shadows.nature.util;

import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;

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

	public static final PropertyEnum<TREE_TYPES_1> TYPE_1 = PropertyEnum.create("type", TREE_TYPES_1.class);

	public static enum TREE_TYPES_1 implements IStringSerializable {
		RED_MAPLE("red_maple"),
		ANGEL_OAK("angel_oak"),
		YELLOW_MAPLE("yellow_maple"),
		JACARANDA("jacaranda"),
		CYPRESS("cypress"),
		DESERT_IRONWOOD("desert_ironwood"),
		EUCALYPTUS("eucalyptus"),
		SEQUIOA("sequoia"),
		JOSHUA("joshua"),
		SWAMP_WILLOW("swamp_willow"),
		PALM("palm"),
		DESERT_WILLOW("desert_willow"),
		POPLAR("poplar"),
		BEECH("beech"),
		CEDAR("cedar"),
		WIDE_TOP_EUCALYPTUS("wide_top_euc");

		final String name;

		TREE_TYPES_1(String name) {
			this.name = name;
		}

		@Override
		public String getName() {
			return name;
		}

	}
	// GINKGO("ginkgo"),
	// WALNUT("walnut"),
	// BUKKIT("bukkit"), <- this one isn't special but it's the 16th tree so it
	// wont be on the other id
	// BANANA("banana"),
	// ORANGE("orange"),
	// LEMON("lemon")'
	// NETHER_ASH("nether_ash"),
	// NETHER_BLAZE("nether_blaze"),
	// CRYSTAL("crystal"),
	// DARK_CRYSTAL("dark_crystal"),
	// PINK_CHERRY("pink_cherry"),
	// WHITE_CHERRY("white_cherry"),
	// APPLE("apple"),
	// FIG("fig"),

}
