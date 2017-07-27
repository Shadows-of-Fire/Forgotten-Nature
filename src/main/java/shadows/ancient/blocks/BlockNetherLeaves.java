package shadows.nature.Blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLeavesBase;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;

public class BlockNetherLeaves extends BlockLeavesBase implements IShearable {
	@SideOnly(Side.CLIENT)
	private IIcon[] leaveIcons;

	int ItemFruitID;

	public BlockNetherLeaves() {
		super(Material.leaves, true);
		setTickRandomly(true);
		setHardness(0.2F);
		setLightOpacity(1);
		setStepSound(Block.soundTypeGrass);
		setBlockName("netherLeaves");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par2 > 7)
			par2 = par2 - 8;

		int fan = 1;
		if (Minecraft.isFancyGraphicsEnabled() == true)
			fan = 0;
		if (fan == 0)
			return this.leaveIcons[par2];
		else
			return this.leaveIcons[par2 + 2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.leaveIcons = new IIcon[4];

		this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:NetherAshLeaves");
		this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:NetherBlazeLeaves");
		this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:NetherAshLeavesSolid");
		this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:NetherBlazeLeavesSolid");
	}

	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block blk) {
		byte var5 = 1;
		int var6 = var5 + 1;

		if (par1World.checkChunksExist(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6)) {
			for (int var7 = -var5; var7 <= var5; ++var7) {
				for (int var8 = -var5; var8 <= var5; ++var8) {
					for (int var9 = -var5; var9 <= var5; ++var9) {
						Block block = par1World.getBlock(par2 + var7, par3 + var8, par4 + var9);

						if (block.isLeaves(par1World, par2 + var7, par3 + var8, par4 + var9)) {
							block.beginLeavesDecay(par1World, par2 + var7, par3 + var8, par4 + var9);
						}
					}
				}
			}
		}
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (!world.isRemote) {
			int l = world.getBlockMetadata(i, j, k);
			if ((l & 8) != 0) {
				byte var7 = 4;
				int var8 = var7 + 1;
				byte var9 = 32;
				int var10 = var9 * var9;
				int var11 = var9 / 2;
				if (this.adjacentTreeBlocks == null) {
					this.adjacentTreeBlocks = new int[var9 * var9 * var9];
				}
				int var12;
				if (world.checkChunksExist(i - var8, j - var8, k - var8, i + var8, j + var8, k + var8)) {
					int var13;
					int var14;
					int var15;
					for (var12 = -var7; var12 <= var7; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								var15 = Block.getIdFromBlock(world.getBlock(i + var12, j + var13, k + var14));

								Block block = Block.getBlockById(var15);

								if (block != null && block.canSustainLeaves(world, i + var12, j + var13, k + var14)) {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
								} else if (block != null && block.isLeaves(world, i + var12, j + var13, k + var14)) {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
								} else {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
								}
							}
						}
					}
					for (var12 = 1; var12 <= 4; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								for (var15 = -var7; var15 <= var7; ++var15) {
									if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11] == var12 - 1) {
										if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9 + var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + (var15 + var11 - 1)] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15 + var11 + 1] = var12;
										}
									}
								}
							}
						}
					}
				}
				var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];
				if (var12 >= 0) {
					world.setBlockMetadataWithNotify(i, j, k, l & -9, 4);
				} else {
					this.removeLeaves(world, i, j, k);
				}
			}
		}
	}

	private void removeLeaves(World world, int i, int j, int k) {
		dropBlockAsItem(world, i, j, k, world.getBlockMetadata(i, j, k), 0);
		world.setBlockToAir(i, j, k);
	}

	public int quantityDropped(Random random) {
		return random.nextInt(20) != 0 ? 0 : 0;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		l = l & 7;
		if (world.rand.nextInt(14) == 0) {
			if (l == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling3, 1, 3)); // nether
																							// ash
			}
			if (l == 1) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling3, 1, 4)); // nether
																							// blaze
			}
		}
	}

	/**
	 * Called when the player destroys a block with an item that can harvest it.
	 * (i, j, k) are the coordinates of the block and l is the block's
	 * subtype/damage.
	 */
	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	public int damageDropped(int i) {
		return i & 7;
	}

	public void onEntityWalking(World world, int i, int j, int k, Entity entity) {
		super.onEntityWalking(world, i, j, k, entity);
	}

	int adjacentTreeBlocks[];

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	public boolean isLeaves(World world, int x, int y, int z) {
		return true;
	}

	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
		float dis = 1.0F;
		double var7 = (double) ((float) par2 + dis / par1World.rand.nextInt(11));
		double var9 = (double) ((float) par3 + dis / par1World.rand.nextInt(11));
		double var11 = (double) ((float) par4 + dis / par1World.rand.nextInt(11));

		if (var6 == 1) {
			par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("flame", var7, var9, var11, 0.0D, 0.0D, 0.0D);
		} else if (var6 == 0) {
			par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
			par1World.spawnParticle("smoke", var7, var9, var11, 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 3));
		return ret;
	}

	@Override
	public Item getItemDropped(int metadata, Random random, int fortune) {
		return Item.getItemFromBlock(this);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		list.add(new ItemStack(i, 1, 0));
		list.add(new ItemStack(i, 1, 1));
	}

}
