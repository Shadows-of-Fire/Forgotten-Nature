package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;
import shadows.nature.FNItems;

public class BlockCrystalStone extends BlockFlower {
	@SideOnly(Side.CLIENT)
	static IIcon[] cStoneIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.crystalStone);

	public BlockCrystalStone() {
		super(ID);
		float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
		setHardness(0.5F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(0.9F);
		setBlockName("crystalStone");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.cStoneIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.cStoneIcons = new IIcon[2];

		this.cStoneIcons[0] = par1IconRegister.registerIcon("ForgottenNature:LightCrystalFlower");
		this.cStoneIcons[1] = par1IconRegister.registerIcon("ForgottenNature:DarkCrystalFlower");
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	protected boolean canThisPlantGrowOnThisBlockID(Block par1) {
		return par1 == Blocks.grass || par1 == Blocks.stone;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		for (int n = 0; n < 3; n++) {
			if ((l & 3) == 0 && world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.crystalItem, 1, 1)); // crystal
			}

			if ((l & 3) == 1 && world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.crystalItem, 1, 4)); // blackCrystal
			}
		}
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		return this.canThisPlantGrowOnThisBlockID(par1World.getBlock(par2, par3 - 1, par4));
	}

	public int damageDropped(int i) {
		return i & 3;
	}

	public int getRenderType() {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		list.add(new ItemStack(i, 1, 0));
		list.add(new ItemStack(i, 1, 1));
	}
}
