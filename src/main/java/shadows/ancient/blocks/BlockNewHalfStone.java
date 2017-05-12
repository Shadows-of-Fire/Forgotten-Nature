package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class BlockNewHalfStone extends BlockSlab {
	/** The type of tree this slab came from. */
	public static final String[] rockType = new String[] { "granite", "gneiss", "hornfels", "marble", "granitebricks",
			"gneissbricks", "hornfelsbricks", "marblebricks" };

	@SideOnly(Side.CLIENT)
	private IIcon[] hStoneIcons;
	public boolean solid;

	public BlockNewHalfStone(boolean par2) {
		super(par2, Material.rock);
		setLightOpacity(0);
		setHardness(2.0F);
		setResistance(5F);
		setStepSound(Block.soundTypeStone);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par2 > 7)
			par2 = par2 - 8;

		return this.hStoneIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.hStoneIcons = new IIcon[8];

		this.hStoneIcons[0] = par1IconRegister.registerIcon("ForgottenNature:StoneGranite");
		this.hStoneIcons[1] = par1IconRegister.registerIcon("ForgottenNature:StoneGneiss");
		this.hStoneIcons[2] = par1IconRegister.registerIcon("ForgottenNature:StoneHornfels");
		this.hStoneIcons[3] = par1IconRegister.registerIcon("ForgottenNature:StoneMarble");
		this.hStoneIcons[4] = par1IconRegister.registerIcon("ForgottenNature:BricksGranite");
		this.hStoneIcons[5] = par1IconRegister.registerIcon("ForgottenNature:BricksGneiss");
		this.hStoneIcons[6] = par1IconRegister.registerIcon("ForgottenNature:BricksHornfels");
		this.hStoneIcons[7] = par1IconRegister.registerIcon("ForgottenNature:BricksMarble");
	}

	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int met) {
		return Item.getItemFromBlock(FNBlocks.newHalfStone);
	}

	protected ItemStack createStackedBlock(int met) {
		return new ItemStack(Item.getItemFromBlock(this), 1, met & 7);
	}

	public String func_150002_b(int par1) {
		if (par1 < 0 || par1 >= rockType.length) {
			par1 = 0;
		}

		return super.getUnlocalizedName() + "." + rockType[par1];
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item par1, CreativeTabs par2CreativeTabs, List par3List) {
		if (par1 != Item.getItemFromBlock(FNBlocks.newDoubleHalfStone)) {
			for (int j = 0; j < 8; ++j) {
				par3List.add(new ItemStack(par1, 1, j));
			}
		}
	}
}
