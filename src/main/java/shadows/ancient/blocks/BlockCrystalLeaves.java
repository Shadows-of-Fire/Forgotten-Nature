package shadows.nature.Blocks;

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
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNItems;

public class BlockCrystalLeaves extends BlockLeavesBase {
	@SideOnly(Side.CLIENT)
	private IIcon[] leaveIcons;
	int[] adjacentTreeBlocks;

	public BlockCrystalLeaves() {
		super(Material.leaves, true);
		this.setTickRandomly(true);
		setHardness(0.3F);
		setLightOpacity(0);
		setStepSound(Block.soundTypeGrass);
		setLightLevel(0.9F);
		setBlockName("crystalLeaves");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		if (par2 > 7)
			par2 = par2 - 8;

		int fan = 1;
		if (!Minecraft.isFancyGraphicsEnabled() == true)
			fan = 0;
		if (fan == 0)
			return this.leaveIcons[par2];
		else
			return this.leaveIcons[par2 + 2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.leaveIcons = new IIcon[4];

		this.leaveIcons[1] = par1IconRegister.registerIcon("ForgottenNature:LightCrystalLeavesSolid");
		this.leaveIcons[0] = par1IconRegister.registerIcon("ForgottenNature:DarkCrystalLeavesSolid");
		this.leaveIcons[3] = par1IconRegister.registerIcon("ForgottenNature:LightCrystalLeaves");
		this.leaveIcons[2] = par1IconRegister.registerIcon("ForgottenNature:DarkCrystalLeaves");
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		byte var5 = 1;
		int var6 = var5 + 1;

		if (par1World.checkChunksExist(par2 - var6, par3 - var6, par4 - var6, par2 + var6, par3 + var6, par4 + var6)) {
			for (int var7 = -var5; var7 <= var5; ++var7) {
				for (int var8 = -var5; var8 <= var5; ++var8) {
					for (int var9 = -var5; var9 <= var5; ++var9) {
						Block var10 = par1World.getBlock(par2 + var7, par3 + var8, par4 + var9);

						if (var10 != null) {
							var10.beginLeavesDecay(par1World, par2 + var7, par3 + var8, par4 + var9);
						}
					}
				}
			}
		}
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (!par1World.isRemote) {
			int var6 = par1World.getBlockMetadata(par2, par3, par4);

			if ((var6 & 8) != 0 && (var6 & 4) == 0) {
				byte var7 = 4;
				int var8 = var7 + 1;
				byte var9 = 32;
				int var10 = var9 * var9;
				int var11 = var9 / 2;

				if (this.adjacentTreeBlocks == null) {
					this.adjacentTreeBlocks = new int[var9 * var9 * var9];
				}

				int var12;

				if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8,
						par4 + var8)) {
					int var13;
					int var14;
					int var15;

					for (var12 = -var7; var12 <= var7; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								var15 = Block
										.getIdFromBlock(par1World.getBlock(par2 + var12, par3 + var13, par4 + var14));

								Block block = Block.getBlockById(var15);

								if (block != null && block.canSustainLeaves(par1World, par2 + var12, par3 + var13,
										par4 + var14)) {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14
											+ var11] = 0;
								} else if (block != null
										&& block.isLeaves(par1World, par2 + var12, par3 + var13, par4 + var14)) {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14
											+ var11] = -2;
								} else {
									this.adjacentTreeBlocks[(var12 + var11) * var10 + (var13 + var11) * var9 + var14
											+ var11] = -1;
								}
							}
						}
					}

					for (var12 = 1; var12 <= 4; ++var12) {
						for (var13 = -var7; var13 <= var7; ++var13) {
							for (var14 = -var7; var14 <= var7; ++var14) {
								for (var15 = -var7; var15 <= var7; ++var15) {
									if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9 + var15
											+ var11] == var12 - 1) {
										if (this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9
												+ var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11 - 1) * var10 + (var14 + var11) * var9
													+ var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9
												+ var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11 + 1) * var10 + (var14 + var11) * var9
													+ var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9
												+ var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 - 1) * var9
													+ var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9
												+ var15 + var11] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11 + 1) * var9
													+ var15 + var11] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9
												+ (var15 + var11 - 1)] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9
													+ (var15 + var11 - 1)] = var12;
										}

										if (this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9
												+ var15 + var11 + 1] == -2) {
											this.adjacentTreeBlocks[(var13 + var11) * var10 + (var14 + var11) * var9
													+ var15 + var11 + 1] = var12;
										}
									}
								}
							}
						}
					}
				}

				var12 = this.adjacentTreeBlocks[var11 * var10 + var11 * var9 + var11];

				if (var12 >= 0) {
					par1World.setBlockMetadataWithNotify(par2, par3, par4, var6 & -9, 4);
				} else {
					this.removeLeaves(par1World, par2, par3, par4);
				}
			}
		}
	}

	private void removeLeaves(World par1World, int par2, int par3, int par4) {
		this.dropBlockAsItem(par1World, par2, par3, par4, par1World.getBlockMetadata(par2, par3, par4), 0);
		par1World.setBlockToAir(par2, par3, par4);
	}

	public int quantityDropped(Random par1Random) {
		return par1Random.nextInt(20) == 0 ? 0 : 0;
	}

	public void dropBlockAsItemWithChance(World par1World, int par2, int par3, int par4, int par5, float par6,
			int par7) {
		if (!par1World.isRemote) {
			if ((par5 & 3) == 0 && par1World.rand.nextInt(3) == 0) {
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(FNItems.crystalItem, 1, 4));
			}
			if ((par5 & 3) == 1 && par1World.rand.nextInt(3) == 0) {
				this.dropBlockAsItem(par1World, par2, par3, par4, new ItemStack(FNItems.crystalItem, 1, 1));
			}
		}
	}

	public void harvestBlock(World par1World, EntityPlayer par2EntityPlayer, int par3, int par4, int par5, int par6) {
		super.harvestBlock(par1World, par2EntityPlayer, par3, par4, par5, par6);
	}

	public int damageDropped(int par1) {
		return par1 & 3;
	}

	@Override
	public void beginLeavesDecay(World world, int x, int y, int z) {
		world.setBlockMetadataWithNotify(x, y, z, world.getBlockMetadata(x, y, z) | 8, 4);
	}

	public boolean isLeaves(World world, int x, int y, int z) {
		return true;
	}

	public void onEntityWalking(World par1World, int par2, int par3, int par4, Entity par5Entity) {
		super.onEntityWalking(par1World, par2, par3, par4, par5Entity);
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		list.add(new ItemStack(i, 1, 0));
		list.add(new ItemStack(i, 1, 1));
	}
}
