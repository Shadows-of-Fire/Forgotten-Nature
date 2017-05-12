package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNBlocks;

public class BlockCrystalBlock extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] crystalIcons;

	public BlockCrystalBlock() {
		super(Material.rock);
		this.setTickRandomly(true);
		setHardness(2.0F);
		setStepSound(Block.soundTypeGlass);
		setLightLevel(1.0F);
		setBlockName("crystalBlock");
	}

	@SideOnly(Side.CLIENT)
	public int getRenderBlockPass() {
		return 1;
	}

	@SideOnly(Side.CLIENT)
	public boolean shouldSideBeRendered(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_,
			int p_149646_5_) {
		Block block = p_149646_1_.getBlock(p_149646_2_, p_149646_3_, p_149646_4_);
		return block == this ? false
				: super.shouldSideBeRendered(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.crystalIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.crystalIcons = new IIcon[4];

		this.crystalIcons[0] = par1IconRegister.registerIcon("ForgottenNature:LightCrystalBlock");
		this.crystalIcons[1] = par1IconRegister.registerIcon("ForgottenNature:DarkCrystalBlock");
		this.crystalIcons[2] = par1IconRegister.registerIcon("ForgottenNature:LightBrickCrystalBlock");
		this.crystalIcons[3] = par1IconRegister.registerIcon("ForgottenNature:DarkBrickCrystalBlock");
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		Block id;
		int met = par1World.getBlockMetadata(par2, par3, par4);
		if (!par1World.isRemote && met < 2) {
			if (met == 0) {
				for (int var6 = 0; var6 < 4; ++var6) {
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					id = par1World.getBlock(var7, var8, var9);
					if ((id == Blocks.grass || id == Blocks.stone)
							&& par1World.getBlock(var7, var8 + 1, var9) == Blocks.air) {
						par1World.setBlock(var7, var8 + 1, var9, FNBlocks.crystalStone, 0, 2);
					}
				}
			} else {
				for (int var6 = 0; var6 < 4; ++var6) {
					int var7 = par2 + par5Random.nextInt(3) - 1;
					int var8 = par3 + par5Random.nextInt(5) - 3;
					int var9 = par4 + par5Random.nextInt(3) - 1;
					id = par1World.getBlock(var7, var8, var9);
					if ((id == Blocks.grass || id == Blocks.stone)
							&& par1World.getBlock(var7, var8 + 1, var9) == Blocks.air) {
						par1World.setBlock(var7, var8 + 1, var9, FNBlocks.crystalStone, 1, 2);
					}
				}
			}
		}
	}

	public Item getItemDropped(int par1, Random par2, int par3) {
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		for (int j = 0; j < 4; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}
}
