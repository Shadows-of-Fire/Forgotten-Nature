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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.IShearable;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.FNItems;

public class BlockNewLeaves extends BlockLeavesBase implements IShearable {
	int adjacentTreeBlocks[];
	@SideOnly(Side.CLIENT)
	private IIcon[] leaveIcons;
	boolean figFruit;
	Block fruit;
	int maxMet;
	int leafInd;

	public BlockNewLeaves(boolean k, Block l, int maxMeta, int leafIndex) {
		super(Material.leaves, true);
		setTickRandomly(true);
		figFruit = k;
		fruit = l;
		maxMet = maxMeta;
		leafInd = leafIndex;
		setHardness(0.2F);
		setLightOpacity(1);
		setStepSound(Block.soundTypeGrass);
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
			return this.leaveIcons[par2 + 8];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.leaveIcons = new IIcon[16];

		if (leafInd == 0) {
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:RedMapleLeaves");
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:AngelLeaves");
			this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:YellowMapleLeaves");
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:JacarandaLeaves");
			this.leaveIcons[4] = par1IconRegister.registerIcon("ForgottenNature:FigLeaves");
			this.leaveIcons[5] = par1IconRegister.registerIcon("ForgottenNature:CypressLeaves");
			this.leaveIcons[6] = par1IconRegister.registerIcon("ForgottenNature:DesertIronwoodLeaves");
			this.leaveIcons[7] = par1IconRegister.registerIcon("ForgottenNature:EucalyptusLeaves");
			this.leaveIcons[8] = par1IconRegister.registerIcon("ForgottenNature:RedMapleLeavesSolid");
			this.leaveIcons[9] = par1IconRegister.registerIcon("ForgottenNature:AngelLeavesSolid");
			this.leaveIcons[10] = par1IconRegister.registerIcon("ForgottenNature:YellowMapleLeavesSolid");
			this.leaveIcons[11] = par1IconRegister.registerIcon("ForgottenNature:JacarandaLeavesSolid");
			this.leaveIcons[12] = par1IconRegister.registerIcon("ForgottenNature:FigLeavesSolid");
			this.leaveIcons[13] = par1IconRegister.registerIcon("ForgottenNature:CypressLeavesSolid");
			this.leaveIcons[14] = par1IconRegister.registerIcon("ForgottenNature:DesertIronwoodLeavesSolid");
			this.leaveIcons[15] = par1IconRegister.registerIcon("ForgottenNature:EucalyptusLeavesSolid");
		} else if (leafInd == 1) {
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:SequoiaLeaves");
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:CherryPinkLeaves");
			this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:CherryWhiteLeaves");
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:AppleLeaves");
			this.leaveIcons[4] = par1IconRegister.registerIcon("ForgottenNature:AppleBudLeaves");
			this.leaveIcons[5] = par1IconRegister.registerIcon("ForgottenNature:AppleFruitLeaves");
			// this.leaveIcons[6] =
			this.leaveIcons[7] = par1IconRegister.registerIcon("ForgottenNature:JoshuaLeaves");
			this.leaveIcons[8] = par1IconRegister.registerIcon("ForgottenNature:SequoiaLeavesSolid");
			this.leaveIcons[9] = par1IconRegister.registerIcon("ForgottenNature:CherryPinkLeavesSolid");
			this.leaveIcons[10] = par1IconRegister.registerIcon("ForgottenNature:CherryWhiteLeavesSolid");
			this.leaveIcons[11] = par1IconRegister.registerIcon("ForgottenNature:AppleLeavesSolid");
			this.leaveIcons[12] = par1IconRegister.registerIcon("ForgottenNature:AppleBudLeavesSolid");
			this.leaveIcons[13] = par1IconRegister.registerIcon("ForgottenNature:AppleFruitLeavesSolid");
			// this.leaveIcons[14] =
			this.leaveIcons[15] = par1IconRegister.registerIcon("ForgottenNature:JoshuaLeavesSolid");
		} else if (leafInd == 2) {
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:SwampWillowLeaves");
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeaves");
			this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:EvergreenBushLeaves");
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:PalmLeaves");
			this.leaveIcons[4] = par1IconRegister.registerIcon("ForgottenNature:DesertWillowLeaves");
			this.leaveIcons[5] = par1IconRegister.registerIcon("ForgottenNature:CedarLeaves");
			this.leaveIcons[6] = par1IconRegister.registerIcon("ForgottenNature:GinkgoLeaves");
			this.leaveIcons[7] = par1IconRegister.registerIcon("ForgottenNature:PoplarLeaves");
			this.leaveIcons[8] = par1IconRegister.registerIcon("ForgottenNature:SwampWillowLeavesSolid");
			this.leaveIcons[9] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeavesSolid");
			this.leaveIcons[10] = par1IconRegister.registerIcon("ForgottenNature:EvergreenBushLeavesSolid");
			this.leaveIcons[11] = par1IconRegister.registerIcon("ForgottenNature:PalmLeavesSolid");
			this.leaveIcons[12] = par1IconRegister.registerIcon("ForgottenNature:DesertWillowLeavesSolid");
			this.leaveIcons[13] = par1IconRegister.registerIcon("ForgottenNature:CedarLeavesSolid");
			this.leaveIcons[14] = par1IconRegister.registerIcon("ForgottenNature:GinkgoLeavesSolid");
			this.leaveIcons[15] = par1IconRegister.registerIcon("ForgottenNature:PoplarLeavesSolid");
		} else if (leafInd == 3) {
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:WalnutLeaves");
			// this.leaveIcons[2] =
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:wTEucalyptusLeaves");
			this.leaveIcons[4] = par1IconRegister.registerIcon("ForgottenNature:BukkitLeaves");
			this.leaveIcons[5] = par1IconRegister.registerIcon("ForgottenNature:BananaLeaves");
			this.leaveIcons[6] = par1IconRegister.registerIcon("ForgottenNature:OrangeLeaves");
			this.leaveIcons[7] = par1IconRegister.registerIcon("ForgottenNature:PeachLeaves");
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:BeechLeaves");
			this.leaveIcons[9] = par1IconRegister.registerIcon("ForgottenNature:WalnutLeavesSolid");
			// this.leaveIcons[10] =
			this.leaveIcons[11] = par1IconRegister.registerIcon("ForgottenNature:wTEucalyptusLeavesSolid");
			this.leaveIcons[12] = par1IconRegister.registerIcon("ForgottenNature:BukkitLeavesSolid");
			this.leaveIcons[13] = par1IconRegister.registerIcon("ForgottenNature:BananaLeavesSolid");
			this.leaveIcons[14] = par1IconRegister.registerIcon("ForgottenNature:OrangeLeavesSolid");
			this.leaveIcons[15] = par1IconRegister.registerIcon("ForgottenNature:PeachLeavesSolid");
			this.leaveIcons[8] = par1IconRegister.registerIcon("ForgottenNature:BeechLeavesSolid");
		} else if (leafInd == 4) {
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:LemonLeaves");
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeaves");
			this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:BlueberryFruitLeaves");
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeaves");
			this.leaveIcons[4] = par1IconRegister.registerIcon("ForgottenNature:RaspberryFruitLeaves");
			this.leaveIcons[5] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeaves");
			this.leaveIcons[6] = par1IconRegister.registerIcon("ForgottenNature:BlackberryFruitLeaves");
			this.leaveIcons[7] = par1IconRegister.registerIcon("ForgottenNature:CherryFruitLeaves");
			this.leaveIcons[8] = par1IconRegister.registerIcon("ForgottenNature:LemonLeavesSolid");
			this.leaveIcons[9] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeavesSolid");
			this.leaveIcons[10] = par1IconRegister.registerIcon("ForgottenNature:BlueberryFruitLeavesSolid");
			this.leaveIcons[11] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeavesSolid");
			this.leaveIcons[12] = par1IconRegister.registerIcon("ForgottenNature:RaspberryFruitLeavesSolid");
			this.leaveIcons[13] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeavesSolid");
			this.leaveIcons[14] = par1IconRegister.registerIcon("ForgottenNature:BlackberryFruitLeavesSolid");
			this.leaveIcons[15] = par1IconRegister.registerIcon("ForgottenNature:CherryFruitLeavesSolid");
		} else if (leafInd == 5) {
			this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeaves");
			this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:HuckleberryFruitLeaves");
			this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:DeciduousBushLeavesSolid");
			this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:HuckleberryFruitLeavesSolid");
		}
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

	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
		if (!world.isRemote) {
			int met = world.getBlockMetadata(i, j, k) & 7;
			if (leafInd == 1 && met == 5) // if apple on leaf
			{
				world.setBlock(i, j, k, this, 3, 3);// change to no apple leaf
				dropBlockAsItem(world, i, j, k, new ItemStack(Items.apple, 1, 0));// drop
																					// apple
			} else if (leafInd == 4) {
				Item ItemFruit = FNItems.fruitItems;
				if (met == 2) {
					world.setBlock(i, j, k, this, 1, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 7)); // blue
				}

				if (met == 4) {
					world.setBlock(i, j, k, this, 3, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 8)); // black
				}

				if (met == 6) {
					world.setBlock(i, j, k, this, 5, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 5)); // rasp
				}

				if (met == 7) {
					world.setBlock(i, j, k, FNBlocks.newLeaves2, 1, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(ItemFruit, 1, 4)); // cherry
				}
			} else if (leafInd == 5) {
				if ((world.getBlockMetadata(i, j, k) & 7) == 1) {
					world.setBlock(i, j, k, this, 0, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.fruitItems, 1, 6));
				}
			}
		}
	}

	public void updateTick(World world, int i, int j, int k, Random random) {
		if (!world.isRemote) {
			int l = world.getBlockMetadata(i, j, k);
			if (figFruit && world.getBlockLightValue(i, j + 1, k) >= 9) {
				if (world.getBlock(i, j - 1, k) == Blocks.air && (world.getBlock(i, j + 1, k) == Blocks.log || world.getBlock(i, j + 1, k) == Blocks.log2)) {
					if ((l & 7) == 4 && random.nextInt(150) == 0) {
						world.setBlock(i, j - 1, k, fruit, 2, 3);
					}
				}
			} else if (leafInd == 1 && world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(4) == 0) {
				if (l == 4 && random.nextInt(20) == 0)// apple bud
				{
					world.setBlock(i, j, k, this, 5, 3);
				}
				if (l == 3 && random.nextInt(20) == 0)// apple leaf
				{
					world.setBlock(i, j, k, this, 4, 3);
				}
				if (l == 5 && random.nextInt(20) == 0)// apple
				{
					world.setBlock(i, j, k, this, 3, 3);
					dropBlockAsItem(world, i, j, k, new ItemStack(Items.apple, 1, 0));
				}
				if (l == 1 && random.nextInt(35) == 0)// cherry
				{
					world.setBlock(i, j, k, FNBlocks.newLeaves5, 7, 3);
				}
			} else if (leafInd == 2 && world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(4) == 0) {
				if (world.isAirBlock(i, j - 1, k)) {
					if ((l & 7) == 3 && random.nextInt(35) == 0) {
						world.setBlock(i, j - 1, k, fruit, 3, 3); // palm
					}
					if ((l & 7) == 6 && random.nextInt(100) == 0) {
						world.setBlock(i, j - 1, k, fruit, 4, 3); // ginkgo
					}
				}
			} else if (leafInd == 3 && world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(4) == 0) {
				int ffruit = 0;
				if (world.isAirBlock(i, j - 1, k)) {
					for (int x = -1; x <= 1; x++) {
						for (int y = -1; y <= 1; y++) {
							if ((world.getBlockMetadata(i + x, j, k + y) & 7) == 1 && (world.getBlock(i + x, j, k + y)) == FNBlocks.newLogs3) {
								ffruit = 1;
							}
						}
					}

					if ((l & 7) == 1 && random.nextInt(100) == 0) {
						world.setBlock(i, j - 1, k, fruit, 0, 3); // walnut
					}

					if ((l & 7) == 5 && random.nextInt(35) == 0 && ffruit == 1) {
						world.setBlock(i, j - 1, k, fruit, 1, 3); // banana
					}

					ffruit = 0;
					if ((l & 7) == 6 && random.nextInt(70) == 0) {
						world.setBlock(i, j - 1, k, fruit, 5, 3); // orange
					}

					if ((l & 7) == 7 && random.nextInt(70) == 0) {
						world.setBlock(i, j - 1, k, fruit, 6, 3); // peach
					}
				}
			} else if (leafInd == 4 && world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(6) == 0) {
				if (world.isAirBlock(i, j - 1, k)) {
					if ((l & 7) == 0 && random.nextInt(70) == 0) {
						world.setBlock(i, j - 1, k, FNBlocks.newFruit, 7, 3);
					}
				}
				if (((l & 7) == 1 || (l & 7) == 3 || (l & 7) == 5) && random.nextInt(30) == 0) {
					world.setBlock(i, j, k, this, (l & 7) + 1, 3);
				}
			} else if (leafInd == 5 && world.getBlockLightValue(i, j + 1, k) >= 9 && random.nextInt(4) == 0) {
				if ((l & 7) == 0 && random.nextInt(35) == 0) {
					world.setBlock(i, j, k, this, 1, 3);
				}
			}

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

					for (var12 = -var7; var12 <= var7; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								Block block = world.getBlock(i + var12, j + var13, k + var14);

								if (!block.canSustainLeaves(world, i + var12, j + var13, k + var14)) {
									if (block.isLeaves(world, i + var12, j + var13, k + var14)) {
										this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -2;
									} else {
										this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = -1;
									}
								} else {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14 + var11] = 0;
								}
							}
						}
					}

					for (var12 = 1; var12 <= 4; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								for (int var15 = -var7; var15 <= var7; ++var15) {
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

	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
		if (p_149734_1_.canLightningStrikeAt(p_149734_2_, p_149734_3_ + 1, p_149734_4_) && !World.doesBlockHaveSolidTopSurface(p_149734_1_, p_149734_2_, p_149734_3_ - 1, p_149734_4_) && p_149734_5_.nextInt(15) == 1) {
			double d0 = (double) ((float) p_149734_2_ + p_149734_5_.nextFloat());
			double d1 = (double) p_149734_3_ - 0.05D;
			double d2 = (double) ((float) p_149734_4_ + p_149734_5_.nextFloat());
			p_149734_1_.spawnParticle("dripWater", d0, d1, d2, 0.0D, 0.0D, 0.0D);
		}
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		if (leafInd == 0 && world.rand.nextInt(14) < 1) {
			if ((l & 7) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 2)); // red
																							// maple
			}
			if ((l & 7) == 1 && world.rand.nextInt(14) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 3)); // angel
																							// oak
			}
			if ((l & 7) == 2) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 4)); // yellow
																							// maple
			}
			if ((l & 7) == 3) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 5)); // jacaranda
			}
			if ((l & 7) == 4 && world.rand.nextInt(14) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 9)); // fig
			}
			if ((l & 7) == 5) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 10)); // cypress
			}
			if ((l & 7) == 6) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 0)); // desert
																							// tree
			}
			if ((l & 7) == 7) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 7)); // eucalyptus
			}
		}

		else if (leafInd == 1 && world.rand.nextInt(14) < 1) {
			if ((l & 7) == 0 && world.rand.nextInt(10) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 8)); // sequoia
			}
			if ((l & 7) == 1 | (l & 7) == 2) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 1)); // cherry
			}
			if ((l & 7) == 3 | (l & 7) == 4 | (l & 7) == 5) // apple
			{
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 6));

				if (world.rand.nextInt(20) == 0) {
					dropBlockAsItem(world, i, j, k, new ItemStack(Items.apple, 1, 0));
				}
			}
			if ((l & 7) == 6) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 11)); // acacia
			}
			if ((l & 7) == 7) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 12)); // Joshua
			}
		}

		else if (leafInd == 2 && world.rand.nextInt(7) < 1) {
			if ((l & 7) == 0 && world.rand.nextInt(15) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 13)); // willow
			}

			if ((l & 7) == 1) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 14)); // decBush
			}

			if ((l & 7) == 2) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 15)); // everBush
			}

			if ((l & 7) == 3) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 0)); // palm
			}

			if ((l & 7) == 4 && world.rand.nextInt(4) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 1)); // dWillow
			}

			if ((l & 7) == 5 && world.rand.nextInt(4) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 2)); // cedar
			}

			if ((l & 7) == 6 && world.rand.nextInt(5) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 3)); // ginkgo
			}

			if ((l & 7) == 7 && world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 4)); // poplar
			}
		} else if (leafInd == 3 && world.rand.nextInt(9) < 1) {
			if ((l & 7) == 0 && world.rand.nextInt(20) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 5)); // beech
			}

			if ((l & 7) == 1 && world.rand.nextInt(20) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 6)); // walnut
			}

			// if ((l & 7) == 2)
			// {
			// dropBlockAsItem(world, i, j, k, new
			// ItemStack(FNBlocks.fNSapling2, 1, 7)); //cocoa
			// }

			if ((l & 7) == 3 && world.rand.nextInt(9) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 8)); // wTEucalyptus
			}

			if ((l & 7) == 4 && world.rand.nextInt(10) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 9)); // bukkit
			}

			if ((l & 7) == 5) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 10)); // banana
			}

			if ((l & 7) == 6) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 11)); // orange
			}

			if ((l & 7) == 7) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 12)); // peach
			}
		} else if (leafInd == 4 && world.rand.nextInt(7) < 1) {
			if ((l & 7) == 0 && world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 13)); // lemon
			}
			if ((l & 7) == 1 || (l & 7) == 2) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 14)); // blueberry
			}
			if ((l & 7) == 3 || (l & 7) == 4) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling2, 1, 15)); // raspberry
			}
			if ((l & 7) == 5 || (l & 7) == 6) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling3, 1, 1)); // blackberry
			}
			if ((l & 7) == 7 && world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling1, 1, 1)); // cherry
			}
		} else if (leafInd == 5 && world.rand.nextInt(7) < 1) {
			if ((l & 7) == 0 || (l & 7) == 1) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNBlocks.fNSapling3, 1, 0)); // huckleberry
			}
		}
	}

	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	public int damageDropped(int i) {
		return i & 7;
	}

	public void onEntityWalking(World world, int i, int j, int k, Entity entity) {
		super.onEntityWalking(world, i, j, k, entity);
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		int i2 = world.getBlockMetadata(x, y, z);

		if ((i2 & 8) == 0) {
			world.setBlockMetadataWithNotify(x, y, z, i2 | 8, 4);
		}
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	public boolean isLeaves(World world, int x, int y, int z) {
		return true;
	}

	@Override
	public boolean isShearable(ItemStack item, IBlockAccess world, int x, int y, int z) {
		return true;
	}

	@Override
	public ArrayList<ItemStack> onSheared(ItemStack item, IBlockAccess world, int x, int y, int z, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();
		ret.add(new ItemStack(this, 1, world.getBlockMetadata(x, y, z) & 7));
		return ret;
	}

	///////// ??????????????////////////
	protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
	}

	protected int func_150123_b(int p_150123_1_) {
		return 20;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p2, List list) {
		for (int j = 0; j < maxMet + 1; j++) {
			if ((leafInd != 1 || j != 6) && (leafInd != 3 || j != 2) && (leafInd != 5 || j == 0 || j == 1))
				list.add(new ItemStack(i, 1, j));
		}
	}
}
