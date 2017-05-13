package shadows.nature.common.block;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.item.ItemBlockMeta;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockMetaLeaves extends BlockBasic {

	public BlockMetaLeaves(String name) {
		super(name, Material.LEAVES, 0.2F, 0.0F, true);
		setDefaultState(blockState.getBaseState().withProperty(NatureData.TYPE_1, NatureData.TREE_TYPES_1.values()[0]));
		setSoundType(SoundType.PLANT);
		GameRegistry.register(new ItemBlockMeta(this).setRegistryName(getRegistryName()));

	}

	@Override
	public void registerModels() {
		for (int i = 0; i < NatureData.TYPE_1.getAllowedValues().size(); i++) {
			NatureUtil.sMRL(this, i, "type=" + NatureData.TREE_TYPES_1.values()[i].getName());
		}
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state){
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i < NatureData.TYPE_1.getAllowedValues().size(); i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(NatureData.TYPE_1).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(NatureData.TYPE_1, NatureData.TREE_TYPES_1.values()[meta]);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, new IProperty[] { NatureData.TYPE_1 });
	}
}
