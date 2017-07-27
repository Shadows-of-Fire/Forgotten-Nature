package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.FNItems;

public class BlockGrapeTomCabPine extends BlockFlower {
	@SideOnly(Side.CLIENT)
	private IIcon[] cropIcons;

	private Item seed;
	private Item food;
	private static int ID = Block.getIdFromBlock(FNBlocks.grapeTomCabPine);

	public BlockGrapeTomCabPine() {
		super(ID);
		this.seed = FNItems.newSeedItems;
		this.food = FNItems.FNFoodItems;
		this.setTickRandomly(true);
		this.setBlockBounds(0.1F, 0.0F, 0.1F, 0.9F, 0.5F, 0.9F);
		setHardness(0.0F);
		setStepSound(Block.soundTypeGrass);
		setBlockName("newCrops5");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.cropIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.cropIcons = new IIcon[16];

		for (int i = 0; i < this.cropIcons.length; ++i) {
			if (i < 4)
				this.cropIcons[i] = par1IconRegister.registerIcon("ForgottenNature:Tomato_" + i);
			else if (i > 3 && i < 8)
				this.cropIcons[i] = par1IconRegister.registerIcon("ForgottenNature:Cabbage_" + (i - 4));
			else if (i > 7 && i < 12)
				this.cropIcons[i] = par1IconRegister.registerIcon("ForgottenNature:Pineapple_" + (i - 8));
			else if (i > 11)
				this.cropIcons[i] = par1IconRegister.registerIcon("ForgottenNature:Grapes_" + (i - 12));
		}
	}

	protected boolean canThisPlantGrowOnThisBlockID(Block par1) {
		return par1 == Blocks.farmland || par1 == this;
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3, float par4, float par5) {
		int full;
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		int met = world.getBlockMetadata(i, j, k);
		if (equipped != null && (equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15)) // if
																										// bone
																										// meal
		{
			full = 0;
			if (met < 3)
				full = 3;
			else if (met > 3 && met < 7)
				full = 7;
			else if (met > 7 && met < 11)
				full = 11;
			else if (met > 11)
				full = 15;
			else
				return false;
			world.setBlockMetadataWithNotify(i, j, k, full, 3);
			equipped.stackSize -= 1;
		} else if ((met == 13 || met == 15) && !world.isRemote) {
			world.setBlockMetadataWithNotify(i, j, k, met - 1, 3);
			dropBlockAsItem(world, i, j, k, new ItemStack(food, 1, 14));// grapes
		}
		return true;
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		super.updateTick(par1World, par2, par3, par4, par5Random);

		if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9) {
			int var6 = par1World.getBlockMetadata(par2, par3, par4);

			if (var6 < 14 && par1World.getBlock(par2, par3 - 1, par4) == this) {
				par1World.setBlock(par2, par3, par4, Blocks.air, 0, 3);
			}

			if (par5Random.nextInt(10) == 0 && par1World.getBlock(par2, par3 - 1, par4) == Blocks.dirt && par1World.getBlock(par2, par3 + 1, par4) == Blocks.air && (var6 == 12 || var6 == 13)) {
				par1World.setBlock(par2, par3 + 1, par4, this, 14, 3);
			}

			if (var6 < 3 || var6 > 3 && var6 < 7 || var6 > 7 && var6 < 11 || var6 == 12 || var6 == 14) {
				float var7 = this.getGrowthRate(par1World, par2, par3, par4);

				if (par5Random.nextInt((int) (25.0F / var7) + 1) == 0) {
					++var6;
					par1World.setBlock(par2, par3, par4, this, var6, 3);
				}
			}
		}
	}

	/**
	 * Gets the growth rate for the crop. Setup to encourage rows by halving
	 * growth rate if there is diagonals, crops on different sides that aren't
	 * opposing, and by adding growth for every crop next to this one (and for
	 * crop below this one). Args: x, y, z
	 */
	private float getGrowthRate(World par1World, int par2, int par3, int par4) {
		float var5 = 1.0F;
		Block var6 = par1World.getBlock(par2, par3, par4 - 1);
		Block var7 = par1World.getBlock(par2, par3, par4 + 1);
		Block var8 = par1World.getBlock(par2 - 1, par3, par4);
		Block var9 = par1World.getBlock(par2 + 1, par3, par4);
		Block var10 = par1World.getBlock(par2 - 1, par3, par4 - 1);
		Block var11 = par1World.getBlock(par2 + 1, par3, par4 - 1);
		Block var12 = par1World.getBlock(par2 + 1, par3, par4 + 1);
		Block var13 = par1World.getBlock(par2 - 1, par3, par4 + 1);
		boolean var14 = var8 == this || var9 == this;
		boolean var15 = var6 == this || var7 == this;
		boolean var16 = var10 == this || var11 == this || var12 == this || var13 == this;

		for (int var17 = par2 - 1; var17 <= par2 + 1; ++var17) {
			for (int var18 = par4 - 1; var18 <= par4 + 1; ++var18) {
				Block var19 = par1World.getBlock(var17, par3 - 1, var18);
				float var20 = 0.0F;

				if (var19 == Blocks.farmland) {
					var20 = 1.0F;

					if (par1World.getBlockMetadata(var17, par3 - 1, var18) > 0) {
						var20 = 2.0F;
					}
				}

				if (var17 != par2 || var18 != par4) {
					var20 /= 3.0F;
				}

				var5 += var20;
			}
		}

		if (var16 || var14 && var15) {
			var5 /= 2.0F;
		}

		return var5;
	}

	public int getRenderType() {
		return 1;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int met, float par6, int par7) {
		super.dropBlockAsItemWithChance(world, i, j, k, met, par6, par7);
		met = met & 15;
		if (met == 3) {
			dropBlockAsItem(world, i, j, k, new ItemStack(food, 1, 11));// tomato
		} else if (met == 7) {
			dropBlockAsItem(world, i, j, k, new ItemStack(food, 1, 12));// cabbage
		} else if (met == 11) {
			dropBlockAsItem(world, i, j, k, new ItemStack(food, 1, 13));// pineapple
		} else if (met == 15 || met == 13) {
			dropBlockAsItem(world, i, j, k, new ItemStack(food, 1, 14));// grapes
		}

		for (int n = 0; n < 5; n++) {
			if ((met == 3) && (world.rand.nextInt(3) == 0)) {
				dropBlockAsItem(world, i, j, k, new ItemStack(seed, 1, 4));// tomatoes
			} else if ((met == 7) && (world.rand.nextInt(3) == 0)) {
				dropBlockAsItem(world, i, j, k, new ItemStack(seed, 1, 5));// cabbage
			} else if ((met == 11) && (world.rand.nextInt(3) == 0)) {
				dropBlockAsItem(world, i, j, k, new ItemStack(seed, 1, 6));// pineapple
			} else if ((met == 15 || met == 13) && (world.rand.nextInt(3) == 0)) {
				dropBlockAsItem(world, i, j, k, new ItemStack(seed, 1, 7));// grapes
			}
		}
	}

	public int quantityDropped(Random par1Random) {
		return 0;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs tabs, List list) {
		list.remove(new ItemStack(this, 1, 0));
	}
}