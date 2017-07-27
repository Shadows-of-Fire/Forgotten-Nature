package shadows.nature.common.block;

import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import shadows.nature.util.NatureData;
import shadows.nature.util.NatureUtil;

public class BlockEnumLog<E extends Enum<E> & IStringSerializable> extends BlockEnum<E> {

	static final PropertyEnum<Axis> AXIS = NatureData.AXIS;

	public BlockEnumLog(String name, Class<E> enumClass) {
		super(name, Material.WOOD, SoundType.WOOD, 2.0F, 1.0F, enumClass);
		if (enumClass.getEnumConstants().length > 5)
			throw new ArrayIndexOutOfBoundsException("A BlockEnumLog has attempted to be constructed with an enum class with more than 5 constants!");
		this.setDefaultState(getBlockState().getBaseState().withProperty(property, types[0]).withProperty(AXIS, Axis.Y));
	}

	@Override
	protected BlockStateContainer createStateContainer() {
		System.out.println(property);
		System.out.println(AXIS);
		return new BlockStateContainer(this, property, AXIS);
	}

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		if (worldIn.isAreaLoaded(pos.add(-5, -5, -5), pos.add(5, 5, 5))) {
			for (BlockPos blockpos : BlockPos.getAllInBox(pos.add(-4, -4, -4), pos.add(4, 4, 4))) {
				IBlockState iblockstate = worldIn.getBlockState(blockpos);

				if (iblockstate.getBlock().isLeaves(iblockstate, worldIn, blockpos)) {
					iblockstate.getBlock().beginLeavesDecay(iblockstate, worldIn, blockpos);
				}
			}
		}
	}

	@Override
	public boolean canSustainLeaves(IBlockState state, IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public boolean isWood(IBlockAccess world, BlockPos pos) {
		return true;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(property, types[meta % 5]).withProperty(AXIS, Axis.values()[meta / 5]);
	}

	@Override
	public IBlockState getStateForPlacement(World world, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer, EnumHand hand) {
		return this.getDefaultState().withProperty(property, types[meta]).withProperty(AXIS, facing.getAxis());
	}

	@Override
	public int damageDropped(IBlockState state) {
		return state.getValue(property).ordinal();
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		int i = state.getValue(property).ordinal(); // 0-4
		i += (state.getValue(AXIS).ordinal() * 5); // 0-14
		return i;
	}

	@Override
	public void registerModels() {
		for (int i = 0; i < types.length; i++) {
			NatureUtil.sMRL(this, i, AXIS.getName() + "=" + EnumAxis.Y.getName() + "," + property.getName() + "=" + types[i].getName());
		}
	}

}
