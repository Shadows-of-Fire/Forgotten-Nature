package shadows.nature.common.block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.item.ItemBlockMeta;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockFruitBush extends BlockBasic implements IGrowable, IShearable {

	public BlockFruitBush() {
		super("bush", Material.LEAVES, 0.2F, 0.0F, true);
		setTickRandomly(true);
		setDefaultState(blockState.getBaseState().withProperty(NatureData.BUSHES, NatureData.BushSet.BLACKBERRY)
				.withProperty(NatureData.FRUIT, false));
		setSoundType(SoundType.PLANT);
		GameRegistry.register(new ItemBlockMeta(this));
	}

	@Override
	public void registerModels() {
		for (int i = 0; i < NatureData.BUSHES.getAllowedValues().size(); i++) {
			NatureUtil.sMRL(this, i, "fruit=false," + "type=" + NatureData.BushSet.values()[i].getName());
		}
	}

	@Override
	public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand,
			EnumFacing facing, float hitX, float hitY, float hitZ) {
		if (hand != EnumHand.MAIN_HAND || !player.getHeldItem(hand).isEmpty())
			return false;
		else if (state.getValue(NatureData.FRUIT)) {
			spawnAsEntity(world, pos.up(), state.getValue(NatureData.BUSHES).getHarvest());
			world.setBlockState(pos, state.withProperty(NatureData.FRUIT, false));
			return true;
		}
		return false;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(NatureData.BUSHES).ordinal();
	}

	@Override
	public boolean isLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public int tickRate(World world) {
		return 100;
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextBoolean() && canGrow(world, pos, state, false))
			grow(world, rand, pos, state);
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
		for (int i = 0; i < NatureData.BushSet.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(NatureData.BUSHES).ordinal() + (state.getValue(NatureData.FRUIT) ? 6 : 0);
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(NatureData.BUSHES, NatureData.BushSet.values()[meta % 6])
				.withProperty(NatureData.FRUIT, meta >= 6);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, NatureData.BUSHES, NatureData.FRUIT);
	}

	@Override
	public List<ItemStack> getDrops(IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		List<ItemStack> k = new ArrayList<ItemStack>();
		if (state.getValue(NatureData.FRUIT))
			k.add(state.getValue(NatureData.BUSHES).getHarvest());
		if (ThreadLocalRandom.current().nextInt(5) == 0)
			k.add(new ItemStack(NatureBlocks.BUSHLING, 1, damageDropped(state)));
		return k;
	}

	@Override
	public List<ItemStack> onSheared(ItemStack item, IBlockAccess world, BlockPos pos, int fortune) {
		IBlockState state = world.getBlockState(pos);
		List<ItemStack> k = getDrops(world, pos, state, fortune);
		k.add(new ItemStack(state.getBlock(), 1, damageDropped(state)));
		if (ThreadLocalRandom.current().nextInt(15) == 0) {
			k.clear();
			k.add(new ItemStack(NatureBlocks.BUSHLING, 1, damageDropped(state)));
		}
		return k;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
		return !state.getValue(NatureData.BUSHES).getHarvest().isEmpty() && !state.getValue(NatureData.FRUIT);
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		return canGrow(world, pos, state, false);
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		world.setBlockState(pos, state.withProperty(NatureData.FRUIT, true));
	}

}
