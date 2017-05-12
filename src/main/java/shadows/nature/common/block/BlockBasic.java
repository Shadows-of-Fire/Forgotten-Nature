package shadows.nature.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.util.NatureData;

public class BlockBasic extends Block {

	private final Item itemblock;

	public BlockBasic(String name, Material material, float hardness, float resist, Item item) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setHardness(hardness);
		setResistance(resist);
		setCreativeTab(NatureData.TAB);
		GameRegistry.register(this);
		if (item == null)
			item = new ItemBlock(this).setRegistryName(getRegistryName());
		GameRegistry.register(item);
		itemblock = item;
	}

}
