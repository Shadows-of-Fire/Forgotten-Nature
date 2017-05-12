package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.nature.FNItems;
import shadows.nature.ForgottenNature;

public class BlockNewLogs2 extends Block {
	@SideOnly(Side.CLIENT)
	private IIcon[] logIcons;
	private static int renderId;

	public BlockNewLogs2() {
		super(Material.wood);
		setHardness(2.0F);
		setStepSound(Block.soundTypeWood);
		setBlockName("FNLogs2");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int i, int j) {
		return (i == 1 || i == 0) && (j % 2 == 0) ? logIcons[0]
				: ((i == 5 || i == 4) && (j % 2 == 1) ? logIcons[0]
						: ((j == 0 || j == 1) ? logIcons[1]
								: ((j == 2 || j == 3) ? logIcons[2]
										: ((j == 4 || j == 5) ? logIcons[3]
												: ((j == 6 || j == 7) ? logIcons[4]
														: ((j == 8 || j == 9) ? logIcons[5] : logIcons[8]))))));
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.logIcons = new IIcon[9];

		this.logIcons[0] = par1IconRegister.registerIcon("ForgottenNature:LogCrossSection");
		this.logIcons[1] = par1IconRegister.registerIcon("ForgottenNature:LogDesertWillow");
		this.logIcons[2] = par1IconRegister.registerIcon("ForgottenNature:LogCedar");
		this.logIcons[3] = par1IconRegister.registerIcon("ForgottenNature:LogGinkgo");
		this.logIcons[4] = par1IconRegister.registerIcon("ForgottenNature:LogBeech");
		this.logIcons[5] = par1IconRegister.registerIcon("ForgottenNature:LogWalnut");
		// 6 is not in use
		// 7 is not in use
		this.logIcons[8] = par1IconRegister.registerIcon("ForgottenNature:LogWTEucalyptus");
	}

	public int quantityDropped(Random random) {
		return 1;
	}

	public Item getItemDropped(int par1, Random par2, int par3) {
		return Item.getItemFromBlock(this);
	}

	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
		super.harvestBlock(world, entityplayer, i, j, k, l);
		int ai[] = { i, j + 1, k };
		Boolean boolean1 = Boolean.valueOf(true);
		Boolean isAxe = false;
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped != null && (equipped.getItem() == Items.golden_axe || equipped.getItem() == Items.iron_axe
				|| equipped.getItem() == Items.diamond_axe || equipped.getItem() == FNItems.dcAxeItem
				|| equipped.getItem() == FNItems.cAxeItem || equipped.getItem() == FNItems.oAxeItem))
			isAxe = true;

		if (isAxe && world.getBlock(ai[0], ai[1], ai[2]) == this && ForgottenNature.lumberjack == true) {
			for (int i1 = -1; i1 <= 1; i1++) {
				for (int k1 = -1; k1 <= 0; k1++) {
					for (int i2 = -1; i2 <= 1; i2++) {
						if ((i1 + i != i || k1 + j != j || i2 + k != k)
								&& world.getBlock(i1 + i, k1 + j, i2 + k) == this) {
							boolean1 = Boolean.valueOf(false);
						}
					}
				}
			}

			if (boolean1.booleanValue()) {
				int ai1[][] = new int[ForgottenNature.lumberjackPower][3];
				Boolean boolean2 = Boolean.valueOf(false);
				ai1[0][0] = i;
				ai1[0][1] = j + 1;
				ai1[0][2] = k;
				int j2 = 1;

				do {
					for (int l2 = 0; l2 < ai1.length && ai1[l2] != null; l2++) {
						for (int k3 = -1; k3 <= 1; k3++) {
							for (int i4 = -1; i4 <= 1; i4++) {
								for (int j4 = -1; j4 <= 1; j4++) {
									if (world.getBlock(ai1[l2][0] + k3, ai1[l2][1] + i4, ai1[l2][2] + j4) != this) {
										continue;
									}

									Boolean boolean3 = Boolean.valueOf(false);

									for (int k4 = 0; k4 < ai1.length; k4++) {
										if (ai1[k4][1] <= 0 || ai1[k4][1] >= 150) {
											continue;
										}

										int i5 = ai1[l2][0];
										int k5 = ai1[l2][1];
										int i6 = ai1[l2][2];
										int j6 = k3 + i5;
										int k6 = i4 + k5;
										int l6 = j4 + i6;
										int ai2[] = { j6, k6, l6 };

										if (ai2[0] != ai1[k4][0] || ai2[1] != ai1[k4][1] || ai2[2] != ai1[k4][2]) {
											continue;
										}

										boolean3 = Boolean.valueOf(true);
										break;
									}

									if (!boolean3.booleanValue() && j2 < ai1.length) {
										int l4 = ai1[l2][0];
										int j5 = ai1[l2][1];
										int l5 = ai1[l2][2];
										ai1[j2][0] = k3 + l4;
										ai1[j2][1] = i4 + j5;
										ai1[j2][2] = j4 + l5;
										boolean2 = Boolean.valueOf(true);
										j2++;
									}
								}
							}
						}
					}

					if (!boolean2.booleanValue()) {
						break;
					}

					boolean2 = Boolean.valueOf(false);
				} while (true);

				int met;
				for (int i3 = 0; i3 < ai1.length; i3++) {
					met = world.getBlockMetadata(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
					if (ai1[i3][1] > 0 && ai1[i3][1] < ForgottenNature.lumberjackPower
							&& world.getBlock(ai1[i3][0], ai1[i3][1], ai1[i3][2]) == this) {
						if (met % 2 == 0)
							dropBlockAsItem(world, i, j + 1, k, new ItemStack(this, 1, met));
						else
							dropBlockAsItem(world, i, j + 1, k, new ItemStack(this, 1, met - 1));
						world.setBlockToAir(ai1[i3][0], ai1[i3][1], ai1[i3][2]);
						if (equipped.getItemDamage() + 1 <= equipped.getMaxDamage() && ForgottenNature.lumberjackDamage
								&& !entityplayer.capabilities.isCreativeMode)
							equipped.setItemDamage(equipped.getItemDamage() + 1);
					}
				}
			}
		}
	}

	public void breakBlock(World par1World, int par2, int par3, int par4, int par5, int par6) {
		byte var7 = 4;
		int var8 = var7 + 1;

		if (par1World.checkChunksExist(par2 - var8, par3 - var8, par4 - var8, par2 + var8, par3 + var8, par4 + var8)) {
			for (int var9 = -var7; var9 <= var7; ++var9) {
				for (int var10 = -var7; var10 <= var7; ++var10) {
					for (int var11 = -var7; var11 <= var7; ++var11) {
						int var12 = Block.getIdFromBlock(par1World.getBlock(par2 + var9, par3 + var10, par4 + var11));

						if (Block.getBlockById(var12) != null) {
							Block.getBlockById(var12).beginLeavesDecay(par1World, par2 + var9, par3 + var10,
									par4 + var11);
						}
					}
				}
			}
		}
	}

	public void onBlockClicked(World world, int i, int j, int k, EntityPlayer entityplayer) {
		int met = world.getBlockMetadata(i, j, k) & 15;

		if (met == 13 || met == 12) {
			world.setBlockMetadataWithNotify(i, j, k, met - 2, 4);
			dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.nutsItems, 1, 3));
		}
	}

	public int damageDropped(int i) {
		if (i % 2 == 1)
			return i - 1;
		else
			return i;
	}

	public boolean canSustainLeaves(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	public boolean isWood(IBlockAccess world, int x, int y, int z) {
		return true;
	}

	public static void setRenderId(int renderIdReceived) {
		renderId = renderIdReceived;
	}

	@Override
	public int getRenderType() {
		return this.renderId;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs tabs, List list) {
		list.add(new ItemStack(i, 1, 0));
		list.add(new ItemStack(i, 1, 2));
		list.add(new ItemStack(i, 1, 4));
		list.add(new ItemStack(i, 1, 6));
		list.add(new ItemStack(i, 1, 8));
		list.add(new ItemStack(i, 1, 14));
	}

}