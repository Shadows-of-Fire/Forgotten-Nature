package shadows.nature.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.registry.ModRegistry;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockBasic extends Block implements IHasModelLocation {

	public BlockBasic(String name, Material material, float hardness, float resist, boolean customItemBlock, boolean addToList) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setHardness(hardness);
		setResistance(resist);
		setCreativeTab(NatureData.TAB);
		if (addToList)
			ModRegistry.BLOCKS.add(this);
		if (!customItemBlock)
			ModRegistry.ITEMS.add(new ItemBlock(this).setRegistryName(getRegistryName()));
	}

	public BlockBasic(String name, Material material, float hardness, float resist, boolean customItemBlock) {
		this(name, material, hardness, resist, customItemBlock, true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerModels() {
		NatureUtil.sMRL(this, 0, "inventory");
	}

}
