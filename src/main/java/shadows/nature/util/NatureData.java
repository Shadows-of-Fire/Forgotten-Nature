package shadows.nature.util;

import javax.annotation.Nullable;

import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.IStringSerializable;
import shadows.nature.registry.NatureItems;

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

	public static final PropertyEnum<LeafSet> LEAVES = PropertyEnum.create("type", LeafSet.class);
	public static final PropertyEnum<Axis> AXIS = PropertyEnum.create("axis", Axis.class);
	public static final PropertyEnum<BushSet> BUSHES = PropertyEnum.create("type", BushSet.class);
	public static final PropertyBool FRUIT = PropertyBool.create("fruit");

	public static enum LeafSet implements IStringSerializable {
		RED_MAPLE,
		ANGEL_OAK,
		YELLOW_MAPLE,
		JACARANDA,
		CYPRESS,
		DESERT_IRONWOOD,
		EUCALYPTUS,
		SEQUOIA,
		JOSHUA,
		SWAMP_WILLOW,
		PALM,
		DESERT_WILLOW,
		POPLAR,
		BEECH,
		CEDAR,
		BUKKIT;

		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}

	}

	// GINKGO,
	// WALNUT,
	// BANANA,
	// ORANGE,
	// LEMON'
	// NETHER_ASH,
	// NETHER_BLAZE,
	// CRYSTAL,
	// DARK_CRYSTAL,
	// PINK_CHERRY,
	// WHITE_CHERRY,
	// APPLE,
	// FIG,
	public static enum LogSet1 implements IStringSerializable {
		BANANA,
		BEECH,
		BUKKIT,
		CEDAR,
		CHERRY;

		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}

	}

	public static enum LogSet2 implements IStringSerializable {
		DESERT_IRONWOOD,
		DESERT_WILLOW,
		EUCALYPTUS,
		GINKGO,
		JOSHUA;
		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}

	}

	public static enum LogSet3 implements IStringSerializable {
		LEMON,
		ORANGE,
		PALM,
		PEACH,
		SEQUOIA;

		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}

	}

	public static enum LogSet4 implements IStringSerializable {
		SWAMP_WILLOW,
		WALNUT;

		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}
	}

	public static enum BushSet implements IStringSerializable {
		BLACKBERRY(NatureItems.BLACKBERRY),
		BLUEBERRY(NatureItems.BLUEBERRY),
		DECIDUOUS(null),
		EVERGREEN(null),
		HUCKLEBERRY(NatureItems.HUCKLEBERRY),
		RASPBERRY(NatureItems.RASPBERRY);

		private Item item;

		BushSet(@Nullable Item harvest) {
			item = harvest;
		}

		public ItemStack getHarvest() {
			return item == null ? ItemStack.EMPTY : new ItemStack(item);
		}

		@Override
		public String getName() {
			return this.toString().toLowerCase();
		}

	}

}
