package shadows.nature.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class ItemBasic extends Item implements IHasModelLocation {

	public ItemBasic(String name) {
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setCreativeTab(NatureData.TAB);
		GameRegistry.register(this);
	}

	@Override
	public void registerModels() {
		NatureUtil.sMRL(this);

	}

}
