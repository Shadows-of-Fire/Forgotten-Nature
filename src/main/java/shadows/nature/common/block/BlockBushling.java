package shadows.nature.common.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.IGrowable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.fml.common.registry.GameRegistry;
import shadows.nature.common.item.ItemBlockMeta;
import shadows.nature.common.world.gen.BushGenerator;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureData.BushSet;
import shadows.nature.util.NatureUtil;

public class BlockBushling extends BlockBasic implements IGrowable, IPlantable {

	public static final AxisAlignedBB BUSH_AABB = new AxisAlignedBB(.25, 0, .25, .75, 0.5625, .75);
	public static final AxisAlignedBB BIG_BUSH_AABB = new AxisAlignedBB(.125, 0, .125, .875, 0.625, .875);
	
	public BlockBushling() {
		super("bushling", Material.PLANTS, 0, 0, true);
		setSoundType(SoundType.PLANT);
		setTickRandomly(true);
		setDefaultState(blockState.getBaseState().withProperty(NatureData.BUSHES, BushSet.BLACKBERRY));
		GameRegistry.register(new ItemBlockMeta(this));
	}

	@Override
	public void registerModels() {
		for (int i = 0; i < NatureData.BUSHES.getAllowedValues().size(); i++) {
			NatureUtil.sMRL(this, "_inv", i, "type=" + NatureData.BushSet.values()[i].getName());
		}
	}

	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isNormalCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return NULL_AABB;
    }
	
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        int k = state.getValue(NatureData.BUSHES).ordinal();
        if(k == 2 | k == 3){
        	return BIG_BUSH_AABB;
        }
        return BUSH_AABB;
    }

	@Override
	public boolean canGrow(World world, BlockPos pos, IBlockState state, boolean isClient) {
		boolean[] bools = { false, false, false, false };
		for (int i = 0; i < 4; i++) {
			if (BushGenerator.BUSHGENS[state.getValue(NatureData.BUSHES).ordinal()].isReplaceable(world,
					pos.offset(EnumFacing.HORIZONTALS[i])))
				bools[i] = true;
		}
		return bools[0] && bools[1] && bools[2] && bools[3];
	}

	@Override
	public boolean canUseBonemeal(World world, Random rand, BlockPos pos, IBlockState state) {
		return canGrow(world, pos, state, false);
	}

	@Override
	public void grow(World world, Random rand, BlockPos pos, IBlockState state) {
		BushGenerator.BUSHGENS[state.getValue(NatureData.BUSHES).ordinal()].generate(world, rand, pos);

	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(NatureData.BUSHES).ordinal();
	}

	@Override
	public void updateTick(World world, BlockPos pos, IBlockState state, Random rand) {
		if (rand.nextInt(35) == 0 && canGrow(world, pos, state, false))
			grow(world, rand, pos, state);
	}

	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.CUTOUT;
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> list) {
		for (int i = 0; i < NatureData.BushSet.values().length; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(NatureData.BUSHES).ordinal();
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(NatureData.BUSHES, NatureData.BushSet.values()[meta]);
	}

	@Override
	public BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, NatureData.BUSHES);
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, BlockPos pos) {
		return EnumPlantType.Plains;
	}

	@Override
	public IBlockState getPlant(IBlockAccess world, BlockPos pos) {
		return getDefaultState();
	}

}
