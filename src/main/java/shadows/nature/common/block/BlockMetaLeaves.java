package shadows.nature.common.block;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.item.ItemBlockMeta;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockMetaLeaves extends BlockBasic implements IShearable {

	public BlockMetaLeaves(String name) {
		super(name, Material.LEAVES, 0.2F, 0.0F, true);
		setDefaultState(blockState.getBaseState().withProperty(NatureData.LEAVES, NatureData.LeafSet.values()[0]));
		setSoundType(SoundType.PLANT);
		GameRegistry.register(new ItemBlockMeta(this));
	}

	@Override
	public void registerModels() {
		for (int i = 0; i < NatureData.LeafSet.values().length; i++) {
			NatureUtil.sMRL(this, i, "type=" + NatureData.LeafSet.values()[i].getName());
		}
	}

	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return Blocks.LEAVES.getBlockLayer();
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i < NatureData.LEAVES.getAllowedValues().size(); i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(NatureData.LEAVES).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(NatureData.LEAVES, NatureData.LeafSet.values()[meta]);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, NatureData.LEAVES);
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		return Arrays.asList(ItemStack.EMPTY);
		// TODO add saplings
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		IBlockState state = world.getBlockState(pos);
		return Arrays.asList(new ItemStack(state.getBlock(), 1, state.getValue(NatureData.LEAVES).ordinal()));
		// TODO see above
	}
}
