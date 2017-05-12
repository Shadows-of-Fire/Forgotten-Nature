package shadows.nature.Blocks;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import shadows.ancient.FNBlocks;
import shadows.ancient.FNItems;
import shadows.ancient.gen.genCrystalMushroom;

public class BlockCrystalMushroom extends BlockFlower {
	@SideOnly(Side.CLIENT)
	private IIcon[] mushroomIcons;
	private static int ID = Block.getIdFromBlock(FNBlocks.mushroomCrystal);

	public BlockCrystalMushroom() {
		super(ID);
		float var3 = 0.2F;
		setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
		setTickRandomly(true);
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.mushroomIcons[par2];
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister) {
		this.mushroomIcons = new IIcon[1];

		this.mushroomIcons[0] = par1IconRegister.registerIcon("forgottennature:CrystalMushroom");
	}

	public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		if (par5Random.nextInt(25) == 0) {
			byte var6 = 4;
			int var7 = 5;
			int var8;
			int var9;
			int var10;

			for (var8 = par2 - var6; var8 <= par2 + var6; ++var8) {
				for (var9 = par4 - var6; var9 <= par4 + var6; ++var9) {
					for (var10 = par3 - 1; var10 <= par3 + 1; ++var10) {
						if (par1World.getBlock(var8, var10, var9) == this) {
							--var7;

							if (var7 <= 0) {
								return;
							}
						}
					}
				}
			}

			var8 = par2 + par5Random.nextInt(3) - 1;
			var9 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
			var10 = par4 + par5Random.nextInt(3) - 1;

			for (int var11 = 0; var11 < 4; ++var11) {
				if (par1World.isAirBlock(var8, var9, var10) && this.canBlockStay(par1World, var8, var9, var10)) {
					par2 = var8;
					par3 = var9;
					par4 = var10;
				}

				var8 = par2 + par5Random.nextInt(3) - 1;
				var9 = par3 + par5Random.nextInt(2) - par5Random.nextInt(2);
				var10 = par4 + par5Random.nextInt(3) - 1;
			}

			if (par1World.isAirBlock(var8, var9, var10) && this.canBlockStay(par1World, var8, var9, var10)) {
				par1World.setBlock(var8, var9, var10, this, 0, 3);
			}
		}
	}

	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return super.canPlaceBlockAt(par1World, par2, par3, par4) && this.canBlockStay(par1World, par2, par3, par4);
	}

	public boolean canBlockStay(World par1World, int par2, int par3, int par4) {
		if (par3 >= 0 && par3 < 256) {
			int var5 = Block.getIdFromBlock(par1World.getBlock(par2, par3 - 1, par4));
			Block soil = Block.getBlockById(var5);
			return (soil != null && soil.canSustainPlant(par1World, par2, par3 - 1, par4, ForgeDirection.UP, this));
		} else {
			return false;
		}
	}

	public boolean onBlockActivated(World world, int i, int j, int k, EntityPlayer entityplayer, int par2, float par3,
			float par4, float par5) {
		genCrystalMushroom var7 = new genCrystalMushroom(0);
		ItemStack equipped = entityplayer.getCurrentEquippedItem();
		if (equipped == null) {
			return false;
		}
		if ((equipped.getItem() == Items.dye) && (equipped.getItemDamage() == 15)) // if
																					// bone
																					// meal
		{
			var7.generate(world, world.rand, i, j, k);
			equipped.stackSize -= 1;
		}
		return false;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public void dropBlockAsItemWithChance(World world, int i, int j, int k, int l, float f, int i1) {
		super.dropBlockAsItemWithChance(world, i, j, k, l, f, i1);
		for (int n = 0; n < 3; n++) {
			if (world.rand.nextInt(2) == 0) {
				dropBlockAsItem(world, i, j, k, new ItemStack(FNItems.crystalItem, 1, 1)); // crystal
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item i, CreativeTabs p_149666_2_, List list) {
		for (int j = 0; j < 1; j++) {
			list.add(new ItemStack(i, 1, j));
		}
	}
}
