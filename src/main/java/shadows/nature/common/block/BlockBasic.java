package shadows.nature.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockBasic extends Block implements IHasModelLocation {

	public BlockBasic(String name, Material material, float hardness, float resist, boolean customItemBlock,
			boolean addToList) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setHardness(hardness);
		setResistance(resist);
		setCreativeTab(NatureData.TAB);
		if (addToList)
			GameRegistry.register(this);
		if (!customItemBlock)
			GameRegistry.register(new ItemBlock(this).setRegistryName(getRegistryName()));
		if (addToList)
			NatureBlocks.add(this);
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
