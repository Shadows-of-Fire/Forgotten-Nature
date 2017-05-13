package shadows.nature.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.IHasModelLocation;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockBasic extends Block implements IHasModelLocation {


	public BlockBasic(String name, Material material, float hardness, float resist, boolean customItemBlock) {
		super(material);
		setRegistryName(name);
		setUnlocalizedName(NatureData.MODID + "." + name);
		setHardness(hardness);
		setResistance(resist);
		setCreativeTab(NatureData.TAB);
		GameRegistry.register(this);
		if (!customItemBlock) GameRegistry.register(new ItemBlock(this).setRegistryName(getRegistryName()));
		NatureBlocks.add(this);
	}

	@Override
	public void registerModels() {
		NatureUtil.sMRL(this, 0, "inventory");
	}

}
