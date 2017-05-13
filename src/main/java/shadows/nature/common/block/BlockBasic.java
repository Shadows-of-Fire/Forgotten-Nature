package shadows.nature.common.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockBasic extends Block implements IHasModelLocation{

	private final Item itemblock;
	
	public BlockBasic(String name, Material material, float hardness, float resist, @Nullable Item item) {
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
		NatureBlocks.add(this);
	}

	@Override
	public void registerModels() {
		NatureUtil.sMRL(itemblock, 0, "inventory");
	}
	
	

}
