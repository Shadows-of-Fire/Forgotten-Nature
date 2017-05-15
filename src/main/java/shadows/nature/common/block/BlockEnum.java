package shadows.nature.common.block;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.common.item.ItemBlockMeta;
import shadows.nature.registry.NatureBlocks;
import shadows.nature.util.NatureUtil;

//I stole this from nut
public class BlockEnum<E extends Enum<E> & IStringSerializable> extends BlockBasic {

	protected final E[] types;
	protected final Predicate<E> valueFilter;
	protected final PropertyEnum<E> property;
	protected final BlockStateContainer realStateContainer;

	public BlockEnum(String name, Material material, SoundType sound, float hardness, float resistance,
			Class<E> enumClass, String propName, Predicate<E> valueFilter) {
		super(name, material, hardness, resistance, true, false);
		this.setSoundType(sound);
		this.types = enumClass.getEnumConstants();
		this.valueFilter = valueFilter;
		this.property = PropertyEnum.create(propName, enumClass, valueFilter);
		this.realStateContainer = createStateContainer();
		this.setDefaultState(getBlockState().getBaseState());
		GameRegistry.register(this);
		GameRegistry.register(getItemBlock());
		NatureBlocks.add(this);
	}

	public BlockEnum(String name, Material material, SoundType sound, float hardness, float resistance,
			Class<E> enumClass, String propName) {
		this(name, material, sound, hardness, resistance, enumClass, propName, Predicates.<E>alwaysTrue());
	}

	public BlockEnum(String name, Material material, SoundType sound, float hardness, float resistance,
			Class<E> enumClass) {
		this(name, material, sound, hardness, resistance, enumClass, "type");
	}

	/**
	 * 
	 * @return An {@link ItemBlock} to register for this BlockEnum
	 */
	protected Item getItemBlock() {
		return new ItemBlockMeta(this);
	}

	@Override
	public void registerModels() {
		for (int i = 0; i < types.length; i++) {
			NatureUtil.sMRL(this, i, property.getName() + "=" + types[i].getName());
		}
	}

	@Override
	protected final BlockStateContainer createBlockState() {
		return new BlockStateContainer.Builder(this).build(); // Blank to avoid
																// crashes
	}

	@Override
	public final BlockStateContainer getBlockState() {
		return realStateContainer;
	}

	@Override
	public IBlockState getStateFromMeta(int meta) {
		return getDefaultState().withProperty(property, types[meta]);
	}

	@Override
	public int getMetaFromState(IBlockState state) {
		return state.getValue(property).ordinal();
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, NonNullList<ItemStack> subBlocks) {
		for (E type : types)
			if (valueFilter.apply(type))
				subBlocks.add(new ItemStack(item, 1, type.ordinal()));
	}

	protected BlockStateContainer createStateContainer() {
		return new BlockStateContainer.Builder(this).add(property).build();
	}

	public E[] getTypes() {
		return types;
	}

	public PropertyEnum<E> getProperty() {
		return property;
	}

	public BlockStateContainer getRealStateContainer() {
		return realStateContainer;
	}

}
