package shadows.nature.common.item;

import net.minecraft.item.ItemFood;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.registry.NatureItems;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class ItemFoodBasic extends ItemFood implements IHasModelLocation {

	private final String variant;

	public ItemFoodBasic(String name, int am, float sat, boolean wolf) {
		super(am, sat, wolf);
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setCreativeTab(NatureData.TAB);
		GameRegistry.register(this);
		NatureItems.add(this);
		variant = name;
	}

	public ItemFoodBasic(String name, int am, float sat) {
		this(name, am, sat, false);
	}

	public ItemFoodBasic(String name, int am) {
		this(name, am, 0.6F);
	}

	@Override
	public void registerModels() {
		NatureUtil.sMRLF(this, variant);
	}

}
